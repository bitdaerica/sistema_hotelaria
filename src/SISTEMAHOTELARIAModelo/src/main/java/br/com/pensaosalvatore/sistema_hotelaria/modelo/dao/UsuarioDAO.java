package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Usuario;
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

    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserirUsuario(Usuario usuario) throws SQLException {
        PreparedStatement pstm = null;

        try {
            connection.setAutoCommit(false);

            // Inserir na tabela PESSOA
            PessoaDAO dao = new PessoaDAO(connection, null);
            dao.inserirPessoa(usuario);

            String sql = "INSERT INTO USUARIO (ID, USUARIO, SENHA) VALUES (?, ?, ?)";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, usuario.getId());
            pstm.setString(2, usuario.getUsuario());
            pstm.setString(3, usuario.getSenha());
            pstm.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            if (pstm != null) pstm.close();
            connection.setAutoCommit(true);
        }
    }

    public void alterarUsuario(Usuario usuario) throws SQLException {
        PreparedStatement pstm = null;

        try {
            connection.setAutoCommit(false);

            // Alterar na tabela PESSOA
            PessoaDAO dao = new PessoaDAO(connection, null);
            dao.alterarPessoa(usuario);

            String sql = "UPDATE USUARIO SET USUARIO = ?, SENHA = ? WHERE ID = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, usuario.getUsuario());
            pstm.setString(2, usuario.getSenha());
            pstm.setInt(3, usuario.getId());
            pstm.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            if (pstm != null) pstm.close();
            connection.setAutoCommit(true);
        }
    }

    public Usuario selecionarPorId(int id) throws SQLException {
        String sql = """
            SELECT u.ID, u.USUARIO,
                   p.NOME, p.GENERO, p.DATA_NASCIMENTO, p.CPF, p.EMAIL, p.FIXO, p.CELULAR, p.WHATSAPP, p.OBSERVACOES
            FROM USUARIO u
            INNER JOIN PESSOA p ON u.ID = p.ID
            WHERE u.ID = ?
            """;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
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

    public List<Usuario> listarTodos() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = """
            SELECT u.ID, u.USUARIO,
                   p.NOME, p.GENERO, p.DATA_NASCIMENTO, p.CPF, p.EMAIL, p.FIXO, p.CELULAR, p.WHATSAPP, p.OBSERVACOES
            FROM USUARIO u
            INNER JOIN PESSOA p ON u.ID = p.ID
            """;

        try (PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
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
        }
        return lista;
    }

    public List<Usuario> listarPorNome(String nome) throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = """
            SELECT u.ID, u.USUARIO,
                   p.NOME, p.GENERO, p.DATA_NASCIMENTO, p.CPF, p.EMAIL, p.FIXO, p.CELULAR, p.WHATSAPP, p.OBSERVACOES
            FROM USUARIO u
            INNER JOIN PESSOA p ON u.ID = p.ID
            WHERE p.NOME LIKE ?
            """;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, "%" + nome + "%");
            try (ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {
                    Usuario usuario = new Usuario();
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
            }
        }
        return lista;
    }

    public void excluirUsuario(int id) throws SQLException {
        PreparedStatement pstm = null;

        try {
            connection.setAutoCommit(false);

            String sql = "DELETE FROM USUARIO WHERE ID = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();

            // Excluir também na tabela PESSOA
            PessoaDAO dao = new PessoaDAO(connection, null);
            dao.excluirPessoa(id);

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            if (pstm != null) pstm.close();
            connection.setAutoCommit(true);
        }
    }

    public boolean existeNoBancoPorUsuarioESenha(Usuario usuarioNovo) throws SQLException {
        String sql = "SELECT 1 FROM USUARIO WHERE USUARIO = ? AND SENHA = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, usuarioNovo.getUsuario());
            pstm.setString(2, usuarioNovo.getSenha());

            try (ResultSet rs = pstm.executeQuery()) {
                return rs.next();
            }
        }
    }
}