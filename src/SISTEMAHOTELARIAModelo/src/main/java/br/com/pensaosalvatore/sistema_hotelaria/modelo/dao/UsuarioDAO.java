package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.UsuarioDTO;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 202412170006
 */
public class UsuarioDAO {

    private final ConnectionFactoryDAO connectionFactory = new ConnectionFactoryDAO();

    public void inserirUsuario(UsuarioDTO u) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            // Inserir primeiro na tabela PESSOA
            PessoaDAO dao = new PessoaDAO();
            dao.inserirPessoa(u);

            String sql = "INSERT INTO USUARIO (ID, USUARIO, SENHA) VALUES (?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, u.getId());
            pstm.setString(2, u.getUsuario());
            pstm.setString(3, u.getSenha());

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

    public void alterarUsuario(UsuarioDTO u) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            // Alterar dados na tabela PESSOA
            PessoaDAO dao = new PessoaDAO();
            dao.alterarPessoa(u);

            String sql = "UPDATE USUARIO SET SENHA = ?, USUARIO = ? WHERE ID = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, u.getSenha());
            pstm.setString(2, u.getUsuario());
            pstm.setInt(3, u.getId());

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

    public UsuarioDTO selecionarPorId(int id) throws SQLException {
        String sql = """
            SELECT u.ID, u.USUARIO,
                   p.NOME, p.GENERO, p.DATA_NASCIMENTO, p.CPF, p.EMAIL, p.FIXO, p.CELULAR, p.WHATSAPP, p.OBSERVACOES
            FROM USUARIO u
            INNER JOIN PESSOA p ON u.ID = p.ID
            WHERE u.ID = ?
            """;

        try (Connection conn = connectionFactory.conectaBD();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);

            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    UsuarioDTO usuario = new UsuarioDTO();
                    usuario.setId(rs.getInt("ID"));
                    usuario.setUsuario(rs.getString("USUARIO"));
                    usuario.setNome(rs.getString("NOME"));
                    usuario.setGenero(Genero.valueOf(rs.getString("GENERO")));
                    usuario.setDataNascimento(rs.getDate("DATA_NASCIMENTO"));
                    usuario.setCpf(rs.getString("CPF"));
                    usuario.setEmail(rs.getString("EMAIL"));
                    usuario.setFixo(rs.getString("FIXO"));
                    usuario.setCelular(rs.getString("CELULAR"));
                    usuario.setWhatsapp(rs.getBoolean("WHATSAPP"));
                    usuario.setObservacoes(rs.getString("OBSERVACOES"));
                    return usuario;
                }
            }
        }
        return null;
    }

    public List<UsuarioDTO> listarTodos() throws SQLException {
        List<UsuarioDTO> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = """
                SELECT u.ID, u.USUARIO,
                       p.NOME, p.GENERO, p.DATA_NASCIMENTO, p.CPF, p.EMAIL, p.FIXO, p.CELULAR, p.WHATSAPP, p.OBSERVACOES
                FROM USUARIO u
                INNER JOIN PESSOA p ON u.ID = p.ID
                """;

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                UsuarioDTO usuario = new UsuarioDTO();
                usuario.setId(rs.getInt("ID"));
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setGenero(Genero.valueOf(rs.getString("GENERO")));
                usuario.setDataNascimento(rs.getDate("DATA_NASCIMENTO"));
                usuario.setCpf(rs.getString("CPF"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setFixo(rs.getString("FIXO"));
                usuario.setCelular(rs.getString("CELULAR"));
                usuario.setWhatsapp(rs.getBoolean("WHATSAPP"));
                usuario.setObservacoes(rs.getString("OBSERVACOES"));

                lista.add(usuario);
            }
        } finally {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
        return lista;
    }

    public List<UsuarioDTO> listarPorNome(String nome) throws SQLException {
        List<UsuarioDTO> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = """
                SELECT u.ID, u.USUARIO,
                       p.NOME, p.GENERO, p.DATA_NASCIMENTO, p.CPF, p.EMAIL, p.FIXO, p.CELULAR, p.WHATSAPP, p.OBSERVACOES
                FROM USUARIO u
                INNER JOIN PESSOA p ON u.ID = p.ID
                WHERE p.NOME LIKE ?
                """;

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, "%" + nome + "%");

            rs = pstm.executeQuery();

            while (rs.next()) {
                UsuarioDTO usuario = new UsuarioDTO();
                usuario.setId(rs.getInt("ID"));
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setGenero(Genero.valueOf(rs.getString("GENERO")));
                usuario.setDataNascimento(rs.getDate("DATA_NASCIMENTO"));
                usuario.setCpf(rs.getString("CPF"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setFixo(rs.getString("FIXO"));
                usuario.setCelular(rs.getString("CELULAR"));
                usuario.setWhatsapp(rs.getBoolean("WHATSAPP"));
                usuario.setObservacoes(rs.getString("OBSERVACOES"));

                lista.add(usuario);
            }
        } finally {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
        return lista;
    }

    public void excluirUsuario(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sql = "DELETE FROM USUARIO WHERE ID = ?";
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

    public boolean existeNoBancoPorUsuarioESenha(UsuarioDTO usuarioNovo) throws SQLException {
        String sql = "SELECT 1 FROM USUARIO WHERE USUARIO = ? AND SENHA = ?";

        try (Connection conn = connectionFactory.conectaBD();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, usuarioNovo.getUsuario());
            pstm.setString(2, usuarioNovo.getSenha());

            try (ResultSet rs = pstm.executeQuery()) {
                return rs.next();
            }
        }
    }
}