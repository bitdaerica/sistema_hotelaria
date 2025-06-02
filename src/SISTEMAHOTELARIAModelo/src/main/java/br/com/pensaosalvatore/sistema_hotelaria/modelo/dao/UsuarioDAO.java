package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    // Inserir usuário (e pessoa vinculada)
    public void inserirUsuario(Usuario usuario) throws SQLException {
        try {
            connection.setAutoCommit(false);

            // Inserir na tabela PESSOA primeiro
            PessoaDAO pessoaDAO = new PessoaDAO(connection, new EnderecoDAO(connection));
            int idPessoa = pessoaDAO.inserirPessoa(usuario);
            usuario.setId(idPessoa);

            // Inserir na tabela USUARIO
            String sql = "INSERT INTO USUARIO (usuario, senha, pessoa_id) VALUES (?, ?, ?)";
            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1, usuario.getUsuario());
                pstm.setString(2, usuario.getSenha());
                pstm.setInt(3, usuario.getId()); // ID da pessoa (herança)

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

    // Alterar usuário
    public void alterarUsuario(Usuario usuario) throws SQLException {
        try {
            connection.setAutoCommit(false);

            // Alterar dados na tabela PESSOA
            PessoaDAO pessoaDAO = new PessoaDAO(connection, new EnderecoDAO(connection));
            pessoaDAO.alterarPessoa(usuario);

            // Alterar dados na tabela USUARIO
            String sql = "UPDATE USUARIO SET usuario = ?, senha = ? WHERE pessoa_id = ?";
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, usuario.getUsuario());
                pstm.setString(2, usuario.getSenha());
                pstm.setInt(3, usuario.getId());

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

    // Selecionar usuário por ID
    public Usuario selecionarPorId(int id) throws SQLException {
        String sql = """
                SELECT u.usuario, u.senha,
                       p.id, p.nome, p.genero, p.data_nascimento, p.cpf, p.email,
                       p.fixo, p.celular, p.whatsapp, p.observacoes
                FROM USUARIO u
                INNER JOIN PESSOA p ON u.pessoa_id = p.id
                WHERE p.id = ?
                """;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    return mapearUsuario(rs);
                }
            }
        }
        return null;
    }

    // Listar todos os usuários
    public List<Usuario> listarTodos() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = """
                SELECT u.usuario, u.senha,
                       p.id, p.nome, p.genero, p.data_nascimento, p.cpf, p.email,
                       p.fixo, p.celular, p.whatsapp, p.observacoes
                FROM USUARIO u
                INNER JOIN PESSOA p ON u.pessoa_id = p.id
                """;

        try (PreparedStatement pstm = connection.prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearUsuario(rs));
            }
        }
        return lista;
    }

    // Listar usuários por nome
    public List<Usuario> listarPorNome(String nome) throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = """
                SELECT u.usuario, u.senha,
                       p.id, p.nome, p.genero, p.data_nascimento, p.cpf, p.email,
                       p.fixo, p.celular, p.whatsapp, p.observacoes
                FROM USUARIO u
                INNER JOIN PESSOA p ON u.pessoa_id = p.id
                WHERE p.nome LIKE ?
                """;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, "%" + nome + "%");
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearUsuario(rs));
                }
            }
        }
        return lista;
    }

    // Excluir usuário (e a pessoa vinculada)
    public void excluirUsuario(int id) throws SQLException {
        try {
            connection.setAutoCommit(false);

            // Excluir na tabela USUARIO
            String sqlUsuario = "DELETE FROM USUARIO WHERE pessoa_id = ?";
            try (PreparedStatement pstm = connection.prepareStatement(sqlUsuario)) {
                pstm.setInt(1, id);
                pstm.executeUpdate();
            }

            // Excluir na tabela PESSOA
            PessoaDAO pessoaDAO = new PessoaDAO(connection, new EnderecoDAO(connection));
            pessoaDAO.excluirPessoa(id);

            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    // Verificar login (usuário e senha)
    public boolean existeNoBancoPorUsuarioESenha(Usuario usuario) throws SQLException {
        String sql = "SELECT 1 FROM USUARIO WHERE usuario = ? AND senha = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, usuario.getUsuario());
            pstm.setString(2, usuario.getSenha());

            try (ResultSet rs = pstm.executeQuery()) {
                return rs.next();
            }
        }
    }

    // 🔥 Mapear o resultado SQL para o objeto Usuario
    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setUsuario(rs.getString("usuario"));
        usuario.setSenha(rs.getString("senha"));

        usuario.setNome(rs.getString("nome"));
        usuario.setGenero(rs.getString("genero"));

        Date dataSQL = rs.getDate("data_nascimento");
        usuario.setDataNascimento(dataSQL != null ? dataSQL.toLocalDate() : null);

        usuario.setCpf(rs.getString("cpf"));
        usuario.setEmail(rs.getString("email"));
        usuario.setFixo(rs.getString("fixo"));
        usuario.setCelular(rs.getString("celular"));

        Object whatsappObj = rs.getObject("whatsapp");
        usuario.setWhatsapp(whatsappObj != null ? rs.getBoolean("whatsapp") : null);

        usuario.setObservacoes(rs.getString("observacoes"));

        return usuario;
    }
}
