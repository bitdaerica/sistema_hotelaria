package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Hospede;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) Create-Retrive-Update-Delete (CRUD)
 *
 * @author 202412170006
 */
public class HospedeDAO {

    private final Connection connection;

    public HospedeDAO(Connection connection) {
        this.connection = connection;
    }

    // ✅ Inserir hóspede
    public void inserirHospede(Hospede h) throws SQLException {
        PreparedStatement pstm = null;

        try {
            connection.setAutoCommit(false);

            // Inserir na tabela PESSOA
            PessoaDAO pessoaDAO = new PessoaDAO(connection, null);
            pessoaDAO.inserirPessoa(h);

            String sql = "INSERT INTO HOSPEDE (ID, NACIONALIDADE, PROFISSAO, DATA_CADASTRO) VALUES (?, ?, ?, ?)";
            pstm = connection.prepareStatement(sql);

            pstm.setInt(1, h.getId());
            pstm.setString(2, h.getNacionalidade());
            pstm.setString(3, h.getProfissao());
            pstm.setDate(4, new java.sql.Date(h.getDataCadastro().getTime()));

            pstm.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            if (pstm != null) pstm.close();
        }
    }

    // ✅ Alterar hóspede
    public void alterarHospede(Hospede h) throws SQLException {
        PreparedStatement pstm = null;

        try {
            connection.setAutoCommit(false);

            // Alterar na tabela PESSOA
            PessoaDAO pessoaDAO = new PessoaDAO(connection, null);
            pessoaDAO.alterarPessoa(h);

            String sql = "UPDATE HOSPEDE SET NACIONALIDADE = ?, PROFISSAO = ?, DATA_CADASTRO = ? WHERE ID = ?";
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, h.getNacionalidade());
            pstm.setString(2, h.getProfissao());
            pstm.setDate(3, new java.sql.Date(h.getDataCadastro().getTime()));
            pstm.setInt(4, h.getId());

            pstm.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            if (pstm != null) pstm.close();
        }
    }

    // ✅ Buscar hóspede por ID
    public Hospede selecionarPorId(int id) throws SQLException {
        String sql = """
            SELECT h.ID, h.NACIONALIDADE, h.PROFISSAO, h.DATA_CADASTRO,
                   p.NOME, p.GENERO, p.DATA_NASCIMENTO, p.CPF, p.EMAIL,
                   p.FIXO, p.CELULAR, p.WHATSAPP, p.OBSERVACOES
            FROM HOSPEDE h
            INNER JOIN PESSOA p ON h.ID = p.ID
            WHERE h.ID = ?
            """;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);

            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    return mapearHospede(rs);
                }
            }
        }
        return null;
    }

    // ✅ Listar todos os hóspedes
    public List<Hospede> listarTodos() throws SQLException {
        List<Hospede> lista = new ArrayList<>();

        String sql = """
            SELECT h.ID, h.NACIONALIDADE, h.PROFISSAO, h.DATA_CADASTRO,
                   p.NOME, p.GENERO, p.DATA_NASCIMENTO, p.CPF, p.EMAIL,
                   p.FIXO, p.CELULAR, p.WHATSAPP, p.OBSERVACOES
            FROM HOSPEDE h
            INNER JOIN PESSOA p ON h.ID = p.ID
            """;

        try (PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearHospede(rs));
            }
        }
        return lista;
    }

    // ✅ Listar hóspedes por nome
    public List<Hospede> listarPorNome(String nome) throws SQLException {
        List<Hospede> lista = new ArrayList<>();

        String sql = """
            SELECT h.ID, h.NACIONALIDADE, h.PROFISSAO, h.DATA_CADASTRO,
                   p.NOME, p.GENERO, p.DATA_NASCIMENTO, p.CPF, p.EMAIL,
                   p.FIXO, p.CELULAR, p.WHATSAPP, p.OBSERVACOES
            FROM HOSPEDE h
            INNER JOIN PESSOA p ON h.ID = p.ID
            WHERE p.NOME LIKE ?
            """;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, "%" + nome + "%");

            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearHospede(rs));
                }
            }
        }
        return lista;
    }

    // ✅ Excluir hóspede
    public void excluirHospede(int id) throws SQLException {
        PreparedStatement pstm = null;

        try {
            connection.setAutoCommit(false);

            String sql = "DELETE FROM HOSPEDE WHERE ID = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();

            // Excluir também na tabela PESSOA
            PessoaDAO pessoaDAO = new PessoaDAO(connection, null);
            pessoaDAO.excluirPessoa(id);

            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            if (pstm != null) pstm.close();
        }
    }

    // 🔸 Método auxiliar para mapear o ResultSet para objeto Hospede
    private Hospede mapearHospede(ResultSet rs) throws SQLException {
        Hospede h = new Hospede();

        h.setId(rs.getInt("ID"));
        h.setNome(rs.getString("NOME"));
        h.setGenero(Genero.valueOf(rs.getString("GENERO")));
        h.setDataNascimento(rs.getDate("DATA_NASCIMENTO"));
        h.setCpf(rs.getString("CPF"));
        h.setEmail(rs.getString("EMAIL"));
        h.setFixo(rs.getString("FIXO"));
        h.setCelular(rs.getString("CELULAR"));
        h.setWhatsapp(rs.getBoolean("WHATSAPP"));
        h.setObservacoes(rs.getString("OBSERVACOES"));

        h.setNacionalidade(rs.getString("NACIONALIDADE"));
        h.setProfissao(rs.getString("PROFISSAO"));
        h.setDataCadastro(rs.getDate("DATA_CADASTRO"));

        return h;
    }
}