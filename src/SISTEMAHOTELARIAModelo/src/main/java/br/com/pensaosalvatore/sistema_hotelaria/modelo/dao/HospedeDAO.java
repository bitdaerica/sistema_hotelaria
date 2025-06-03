package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Hospede;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    // Inserir hóspede (Pessoa + Hospede)
    public void inserir(Hospede h) throws SQLException {
        try {
            connection.setAutoCommit(false);

            // Inserir Pessoa
            PessoaDAO pessoaDAO = new PessoaDAO(connection, new EnderecoDAO(connection));
            int idPessoa = pessoaDAO.inserir(h);
            h.setId(idPessoa);

            String sql = "INSERT INTO HOSPEDE (ID, NACIONALIDADE, PROFISSAO, DATA_CADASTRO) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, h.getId());
                pstm.setString(2, h.getNacionalidade());
                pstm.setString(3, h.getProfissao());
                if (h.getDataCadastro() != null) {
                    pstm.setDate(4, Date.valueOf(h.getDataCadastro()));
                } else {
                    pstm.setNull(4, java.sql.Types.DATE);
                }

                pstm.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    // Alterar hóspede (Pessoa + Hospede)
    public void alterar(Hospede h) throws SQLException {
        PreparedStatement pstm = null;
        try {
            connection.setAutoCommit(false);

            // Atualiza Pessoa
            PessoaDAO pessoaDAO = new PessoaDAO(connection, null);
            pessoaDAO.alterar(h);

            String sql = "UPDATE HOSPEDE SET NACIONALIDADE = ?, PROFISSAO = ?, DATA_CADASTRO = ? WHERE ID = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, h.getNacionalidade());
            pstm.setString(2, h.getProfissao());
            if (h.getDataCadastro() != null) {
                pstm.setDate(3, Date.valueOf(h.getDataCadastro())); // índice 3 para dataCadastro
            } else {
                pstm.setNull(3, java.sql.Types.DATE);
            }
            pstm.setInt(4, h.getId()); // índice 4 para id

            pstm.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            if (pstm != null) {
                pstm.close();
            }
            connection.setAutoCommit(true);
        }
    }

    // Buscar hóspede por ID (com join em Pessoa)
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

    // Listar todos os hóspedes
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

    // Listar hóspedes por nome (LIKE)
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

    // Excluir hóspede (HOSPEDE + PESSOA)
    public void excluir(int id) throws SQLException {
        PreparedStatement pstm = null;
        try {
            connection.setAutoCommit(false);

            String sql = "DELETE FROM HOSPEDE WHERE ID = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();

            PessoaDAO pessoaDAO = new PessoaDAO(connection, null);
            pessoaDAO.excluir(id);

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            if (pstm != null) {
                pstm.close();
            }
            connection.setAutoCommit(true);
        }
    }

    // Método auxiliar para mapear ResultSet para Hospede
    private Hospede mapearHospede(ResultSet rs) throws SQLException {
        Hospede h = new Hospede();

        h.setId(rs.getInt("ID"));
        h.setNome(rs.getString("NOME"));
        h.setGenero(rs.getString("GENERO"));

        Date dataNascimentoSQL = rs.getDate("DATA_NASCIMENTO");
        if (dataNascimentoSQL != null) {
            h.setDataNascimento(dataNascimentoSQL.toLocalDate());
        } else {
            h.setDataNascimento(null);
        }

        h.setCpf(rs.getString("CPF"));
        h.setEmail(rs.getString("EMAIL"));
        h.setFixo(rs.getString("FIXO"));
        h.setCelular(rs.getString("CELULAR"));

        Object whatsappObj = rs.getObject("WHATSAPP");
        h.setWhatsapp(whatsappObj != null ? rs.getBoolean("WHATSAPP") : null);

        h.setObservacoes(rs.getString("OBSERVACOES"));
        h.setNacionalidade(rs.getString("NACIONALIDADE"));
        h.setProfissao(rs.getString("PROFISSAO"));

        Date dataCadastroSQL = rs.getDate("DATA_CADASTRO");
        if (dataCadastroSQL != null) {
            h.setDataCadastro(dataCadastroSQL.toLocalDate());
        } else {
            h.setDataCadastro(null);
        }

        return h;
    }
}