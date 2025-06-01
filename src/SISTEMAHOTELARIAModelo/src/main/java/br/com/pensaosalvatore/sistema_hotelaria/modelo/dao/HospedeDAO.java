package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.HospedeDTO;
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

    private final Conexao connectionFactory = new Conexao();

    public void inserirHospede(HospedeDTO h) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            // Inserir primeiro na tabela PESSOA
            PessoaDAO dao = new PessoaDAO();
            dao.inserirPessoa(h);

            String sql = "INSERT INTO HOSPEDE (ID, NACIONALIDADE, PROFISSAO, DATA_CADASTRO) VALUES (?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, h.getId());
            pstm.setString(2, h.getNacionalidade());
            pstm.setString(3, h.getProfissao());
            pstm.setDate(4, new java.sql.Date(h.getDataCadastro().getTime()));

            pstm.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            if (conn != null) conn.rollback();
            throw e;
        } finally {
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
    }

    public void alterarHospede(HospedeDTO h) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            // Alterar dados na tabela PESSOA
            PessoaDAO dao = new PessoaDAO();
            dao.alterarPessoa(h);

            String sql = "UPDATE HOSPEDE SET NACIONALIDADE = ?, PROFISSAO = ?, DATA_CADASTRO = ? WHERE ID = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, h.getNacionalidade());
            pstm.setString(2, h.getProfissao());
            pstm.setDate(3, new java.sql.Date(h.getDataCadastro().getTime()));
            pstm.setInt(4, h.getId());

            pstm.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            if (conn != null) conn.rollback();
            throw e;
        } finally {
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
    }

    public HospedeDTO selecionarPorId(int id) throws SQLException {
        String sql = """
            SELECT h.ID, h.NACIONALIDADE, h.PROFISSAO, h.DATA_CADASTRO,
                   p.NOME, p.GENERO, p.DATA_NASCIMENTO, p.CPF, p.EMAIL,
                   p.FIXO, p.CELULAR, p.WHATSAPP, p.OBSERVACOES
            FROM HOSPEDE h
            INNER JOIN PESSOA p ON h.ID = p.ID
            WHERE h.ID = ?
            """;

        try (Connection conn = connectionFactory.conectaBD();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);

            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    HospedeDTO h = new HospedeDTO();
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

                    // Você pode buscar o endereço com EnderecoDAO aqui, se desejar

                    return h;
                }
            }
        }
        return null;
    }

    public List<HospedeDTO> listarTodos() throws SQLException {
        List<HospedeDTO> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = """
                SELECT h.ID, h.NACIONALIDADE, h.PROFISSAO, h.DATA_CADASTRO,
                       p.NOME, p.GENERO, p.DATA_NASCIMENTO, p.CPF, p.EMAIL,
                       p.FIXO, p.CELULAR, p.WHATSAPP, p.OBSERVACOES
                FROM HOSPEDE h
                INNER JOIN PESSOA p ON h.ID = p.ID
                """;

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                HospedeDTO h = new HospedeDTO();
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

                lista.add(h);
            }
        } finally {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
        return lista;
    }

    public List<HospedeDTO> listarPorNome(String nome) throws SQLException {
        List<HospedeDTO> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = """
                SELECT h.ID, h.NACIONALIDADE, h.PROFISSAO, h.DATA_CADASTRO,
                       p.NOME, p.GENERO, p.DATA_NASCIMENTO, p.CPF, p.EMAIL,
                       p.FIXO, p.CELULAR, p.WHATSAPP, p.OBSERVACOES
                FROM HOSPEDE h
                INNER JOIN PESSOA p ON h.ID = p.ID
                WHERE p.NOME LIKE ?
                """;

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, "%" + nome + "%");

            rs = pstm.executeQuery();

            while (rs.next()) {
                HospedeDTO h = new HospedeDTO();
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

                lista.add(h);
            }
        } finally {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
        return lista;
    }

    public void excluirHospede(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sql = "DELETE FROM HOSPEDE WHERE ID = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();

            // Excluir também da tabela PESSOA
            PessoaDAO dao = new PessoaDAO();
            dao.excluirPessoa(id);

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) conn.rollback();
            throw e;
        } finally {
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
    }
}