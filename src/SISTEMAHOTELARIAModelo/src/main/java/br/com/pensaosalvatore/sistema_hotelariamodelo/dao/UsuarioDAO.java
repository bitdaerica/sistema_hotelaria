package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.UsuarioDTO;
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

            //chamando pessoadao para inserir usuario em pessoa primeira
            PessoaDAO dao = new PessoaDAO();
            dao.inserirPessoa(u);

            String sqlUsuario = "INSERT INTO USUARIO (ID, SENHA, GRAU_DE_ACESSO) VALUES (?, ?, ?)";
            pstm = conn.prepareStatement(sqlUsuario);

            pstm.setInt(1, u.getId());
            pstm.setString(2, u.getSenha());
            pstm.setString(3, u.getGraudeacesso().name());

            pstm.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public void alterarUsuario(UsuarioDTO u) throws SQLException {

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);
            
            //chamando pessoadao para inserir o usuario em pessoa primeira
            PessoaDAO dao = new PessoaDAO();
            dao.alterarPessoa(u);

            String sqlUsuario = "UPDATE usuario SET senha = ?, graudeacesso = ? WHERE ID = ?";
            pstm = conn.prepareStatement(sqlUsuario);

            pstm.setInt(1, u.getId());
            pstm.setString(2, u.getSenha());
            pstm.setString(3, u.getGraudeacesso().name());

            pstm.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public UsuarioDTO selecionarPorId(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        UsuarioDTO usuario = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = "SELECT * FROM usuario WHERE ID = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                usuario = new UsuarioDTO(0, nome, senha);
                usuario.setId(rs.getInt("ID"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setCpf(rs.getString("CPF"));

            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return usuario;
    }

    public List<UsuarioDTO> listarTodos() throws SQLException {
        List<UsuarioDTO> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = "SELECT * FROM Usuario";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                UsuarioDTO usuario = new UsuarioDTO(0, nome, senha);
                usuario.setId(rs.getInt("ID"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setCpf(rs.getString("CPF"));

                lista.add(usuario);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
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
            String sql = "SELECT * FROM usuario WHERE NOME LIKE ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();

            while (rs.next()) {
                UsuarioDTO usuario = new UsuarioDTO(0, nome, senha);
                usuario.setId(rs.getInt("ID"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setCpf(rs.getString("CPF"));

                lista.add(usuario);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return lista;
    }

    public void excluirUsuario(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sql = "DELETE FROM usuario WHERE Id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();

            //chamando pessoadao para excluir usuario em pessoa tbm
            //PessoaDAO dao = new PessoaDAO();
            //dao.escluirPessoa(id);
            
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

}
