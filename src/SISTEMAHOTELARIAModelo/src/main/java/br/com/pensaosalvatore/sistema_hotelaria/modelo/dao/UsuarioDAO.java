package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Endereco;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Usuario;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.SecurityUtil;

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
        if (connection == null) {
            throw new IllegalArgumentException("Connection não pode ser nula");
        }
        this.connection = connection;
    }

    // Inserir usuário (e pessoa vinculada)
    public void inserir(Usuario usuario) throws SQLException {
        String sqlPessoa = "INSERT INTO pessoas (nome, genero, data_nascimento, cpf, email, fixo, celular, whatsapp, observacoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlEndereco = "INSERT INTO enderecos (rua, numero, complemento, bairro, cidade, estado, cep, id_pessoas) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlUsuario = "INSERT INTO usuarios (id_pessoas, usuario, senha) VALUES (?, ?, ?)";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement pstmtPessoa = connection.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS); PreparedStatement pstmtEndereco = connection.prepareStatement(sqlEndereco); PreparedStatement pstmtUsuario = connection.prepareStatement(sqlUsuario)) {

                // Inserir pessoa
                pstmtPessoa.setString(1, usuario.getNome());
                pstmtPessoa.setString(2, usuario.getGenero());
                pstmtPessoa.setDate(3, Date.valueOf(usuario.getDatanascimento()));
                pstmtPessoa.setString(4, usuario.getCpf());
                pstmtPessoa.setString(5, usuario.getEmail());
                pstmtPessoa.setString(6, usuario.getFixo());
                pstmtPessoa.setString(7, usuario.getCelular());
                pstmtPessoa.setBoolean(8, usuario.getWhatsapp());
                pstmtPessoa.setString(9, usuario.getObservacoes());

                pstmtPessoa.executeUpdate();

                // Obter o ID gerado para a pessoa
                int idPessoa;
                try (ResultSet rs = pstmtPessoa.getGeneratedKeys()) {
                    if (!rs.next()) {
                        throw new SQLException("Falha ao gerar ID de pessoa");
                    }
                    idPessoa = rs.getInt(1);
                }

                // Inserir endereço
                Endereco endereco = usuario.getEndereco();
                pstmtEndereco.setString(1, endereco.getRua());
                pstmtEndereco.setString(2, endereco.getNumero());
                pstmtEndereco.setString(3, endereco.getComplemento());
                pstmtEndereco.setString(4, endereco.getBairro());
                pstmtEndereco.setString(5, endereco.getCidade());
                pstmtEndereco.setString(6, endereco.getEstado());
                pstmtEndereco.setString(7, endereco.getCep());
                pstmtEndereco.setInt(8, idPessoa);
                pstmtEndereco.executeUpdate();

                // Inserir usuário
                pstmtUsuario.setInt(1, idPessoa);
                pstmtUsuario.setString(2, usuario.getUsuario());
                pstmtUsuario.setString(3, SecurityUtil.hashPassword(usuario.getSenha()));

                pstmtUsuario.executeUpdate();

                connection.commit();
            }
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);

        }
    }

    // Alterar usuário
    public void alterar(Usuario usuario) throws SQLException {
        String sqlPessoa = "UPDATE pessoas SET nome = ?, genero = ?, data_nascimento = ?, cpf = ?, email = ?, fixo = ?, celular = ?, whatsapp = ?, observacoes = ? WHERE id = ?";
        String sqlEndereco = "UPDATE enderecos SET rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, cep = ? WHERE id_pessoas = ?";
        String sqlUsuario = "UPDATE usuarios SET usuario = ?, senha = ? WHERE id_pessoas = ?";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement pstmtPessoa = connection.prepareStatement(sqlPessoa); PreparedStatement pstmtEndereco = connection.prepareStatement(sqlEndereco); PreparedStatement pstmtUsuario = connection.prepareStatement(sqlUsuario)) {

                // Atualizar pessoa
                pstmtPessoa.setString(1, usuario.getNome());
                pstmtPessoa.setString(2, usuario.getGenero());
                pstmtPessoa.setDate(3, Date.valueOf(usuario.getDatanascimento()));
                pstmtPessoa.setString(4, usuario.getCpf());
                pstmtPessoa.setString(5, usuario.getEmail());
                pstmtPessoa.setString(6, usuario.getFixo());
                pstmtPessoa.setString(7, usuario.getCelular());
                pstmtPessoa.setBoolean(8, usuario.getWhatsapp());
                pstmtPessoa.setString(9, usuario.getObservacoes());
                pstmtPessoa.setInt(10, usuario.getId());
                pstmtPessoa.executeUpdate();

                // Atualizar endereço
                Endereco endereco = usuario.getEndereco();
                pstmtEndereco.setString(1, endereco.getRua());
                pstmtEndereco.setString(2, endereco.getNumero());
                pstmtEndereco.setString(3, endereco.getComplemento());
                pstmtEndereco.setString(4, endereco.getBairro());
                pstmtEndereco.setString(5, endereco.getCidade());
                pstmtEndereco.setString(6, endereco.getEstado());
                pstmtEndereco.setString(7, endereco.getCep());
                pstmtEndereco.setInt(8, usuario.getId());
                pstmtEndereco.executeUpdate();

                // Atualizar usuário
                pstmtUsuario.setString(1, usuario.getUsuario());
                pstmtUsuario.setString(2, SecurityUtil.hashPassword(usuario.getSenha()));
                pstmtUsuario.setInt(3, usuario.getId());
                pstmtUsuario.executeUpdate();

                connection.commit();
            }
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    // Selecionar usuário por ID
    public Usuario selecionarPorId(int id) throws SQLException {
        String sql = "SELECT p.*, u.usuario, u.senha, e.* FROM pessoas p "
                + "JOIN usuarios u ON p.id = u.id_pessoas "
                + "JOIN enderecos e ON p.id = e.id_pessoas "
                + "WHERE p.id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapearUsuario(rs);
                }
            }
        }
        return null;
    }

    // Listar todos os usuários
    public List<Usuario> listarTodos() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT p.*, u.usuario, u.senha, e.* FROM pessoas p "
                + "JOIN usuarios u ON p.id = u.id_pessoas "
                + "JOIN enderecos e ON p.id = e.id_pessoas";

        try (PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                usuarios.add(mapearUsuario(rs));
            }
        }
        return usuarios;
    }

    // Listar usuários por nome
    public List<Usuario> listarPorNome(String nome) throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT p.*, u.usuario, u.senha, e.* FROM pessoas p "
                + "JOIN usuarios u ON p.id = u.id_pessoas "
                + "JOIN enderecos e ON p.id = e.id_pessoas "
                + "WHERE p.nome LIKE ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    usuarios.add(mapearUsuario(rs));
                }
            }
        }
        return usuarios;
    }

    // Excluir usuário (e a pessoa vinculada)
    public void excluir(int id) throws SQLException {
        String sqlUsuario = "DELETE FROM usuarios WHERE id_pessoas = ?";
        String sqlEndereco = "DELETE FROM enderecos WHERE id_pessoas = ?";
        String sqlPessoa = "DELETE FROM pessoas WHERE id = ?";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement pstmtUsuario = connection.prepareStatement(sqlUsuario); PreparedStatement pstmtEndereco = connection.prepareStatement(sqlEndereco); PreparedStatement pstmtPessoa = connection.prepareStatement(sqlPessoa)) {

                pstmtUsuario.setInt(1, id);
                pstmtUsuario.executeUpdate();

                pstmtEndereco.setInt(1, id);
                pstmtEndereco.executeUpdate();

                pstmtPessoa.setInt(1, id);
                pstmtPessoa.executeUpdate();

                connection.commit();
            }
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    // Verificar login (usuário e senha)
    public boolean existeNoBancoPorUsuarioESenha(Usuario usuario) throws SQLException {
        String sql = "SELECT senha FROM usuario WHERE usuario = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getUsuario());
            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    String senhaHash = rs.getString("senha");
                    return SecurityUtil.verificarSenha(usuario.getSenha(), senhaHash);
                }
                return false;
            }
        }
    }

    // Mapear o resultado SQL para o objeto Usuario
    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setNome(rs.getString("nome"));
        usuario.setGenero(rs.getString("genero"));
        usuario.setDatanascimento(rs.getDate("data_nascimento").toLocalDate());
        usuario.setCpf(rs.getString("cpf"));
        usuario.setEmail(rs.getString("email"));
        usuario.setFixo(rs.getString("fixo"));
        usuario.setCelular(rs.getString("celular"));
        usuario.setWhatsapp(rs.getBoolean("whatsapp"));
        usuario.setObservacoes(rs.getString("observacoes"));
        usuario.setUsuario(rs.getString("usuario"));
        usuario.setSenha(rs.getString("senha"));

        Endereco endereco = new Endereco();
        endereco.setRua(rs.getString("rua"));
        endereco.setNumero(rs.getString("numero"));
        endereco.setComplemento(rs.getString("complemento"));
        endereco.setBairro(rs.getString("bairro"));
        endereco.setCidade(rs.getString("cidade"));
        endereco.setEstado(rs.getString("estado"));
        endereco.setCep(rs.getString("cep"));

        usuario.setEndereco(endereco);

        return usuario;
    }
    
}
