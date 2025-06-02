package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Pessoa;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Usuario;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Genero;
import java.sql.Connection;
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

            // Inserir Pessoa
            PessoaDAO pessoaDAO = new PessoaDAO(connection, new EnderecoDAO(connection));
            pessoaDAO.inserirPessoa(usuario.getPessoa());

            String sql = "INSERT INTO USUARIO (usuario, senha, pessoa_id) VALUES (?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1, usuario.getUsuario());
                pstm.setString(2, usuario.getSenha());
                pstm.setInt(3, usuario.getPessoa().getId());

                pstm.executeUpdate();

                try (ResultSet rs = pstm.getGeneratedKeys()) {
                    if (rs.next()) {
                        usuario.setId(rs.getInt(1));
                    }
                }
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
        PreparedStatement pstm = null;

        try {
            connection.setAutoCommit(false);

            // Alterar Pessoa
            PessoaDAO pessoaDAO = new PessoaDAO(connection, new EnderecoDAO(connection));
            pessoaDAO.alterarPessoa(usuario.getPessoa());

            String sql = "UPDATE USUARIO SET usuario = ?, senha = ? WHERE id = ?";
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
            if (pstm != null) {
                pstm.close();
            }
            connection.setAutoCommit(true);
        }
    }

    // Selecionar usuário por ID
    public Usuario selecionarPorId(int id) throws SQLException {
        String sql = """
                SELECT u.id, u.usuario, u.senha, u.pessoa_id,
                       p.nome, p.genero, p.data_nascimento, p.cpf, p.email, 
                       p.fixo, p.celular, p.whatsapp, p.observacoes
                FROM USUARIO u
                INNER JOIN PESSOA p ON u.pessoa_id = p.id
                WHERE u.id = ?
                """;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = mapearUsuario(rs);
                    return usuario;
                }
            }
        }
        return null;
    }

    // Listar todos os usuários
    public List<Usuario> listarTodos() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = """
                SELECT u.id, u.usuario, u.senha, u.pessoa_id,
                       p.nome, p.genero, p.data_nascimento, p.cpf, p.email, 
                       p.fixo, p.celular, p.whatsapp, p.observacoes
                FROM USUARIO u
                INNER JOIN PESSOA p ON u.pessoa_id = p.id
                """;

        try (PreparedStatement pstm = connection.prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = mapearUsuario(rs);
                lista.add(usuario);
            }
        }
        return lista;
    }

    // Listar usuários por nome
    public List<Usuario> listarPorNome(String nome) throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = """
                SELECT u.id, u.usuario, u.senha, u.pessoa_id,
                       p.nome, p.genero, p.data_nascimento, p.cpf, p.email, 
                       p.fixo, p.celular, p.whatsapp, p.observacoes
                FROM USUARIO u
                INNER JOIN PESSOA p ON u.pessoa_id = p.id
                WHERE p.nome LIKE ?
                """;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, "%" + nome + "%");
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    Usuario usuario = mapearUsuario(rs);
                    lista.add(usuario);
                }
            }
        }
        return lista;
    }

    // Excluir usuário (e pessoa vinculada)
    public void excluirUsuario(int id) throws SQLException {
        PreparedStatement pstm = null;

        try {
            connection.setAutoCommit(false);

            // Buscar o id da pessoa vinculada
            int pessoaId = 0;
            String buscaPessoa = "SELECT pessoa_id FROM USUARIO WHERE id = ?";
            try (PreparedStatement busca = connection.prepareStatement(buscaPessoa)) {
                busca.setInt(1, id);
                try (ResultSet rs = busca.executeQuery()) {
                    if (rs.next()) {
                        pessoaId = rs.getInt("pessoa_id");
                    }
                }
            }

            // Excluir na tabela USUARIO
            String sql = "DELETE FROM USUARIO WHERE id = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();

            // Excluir na tabela PESSOA
            PessoaDAO pessoaDAO = new PessoaDAO(connection, new EnderecoDAO(connection));
            pessoaDAO.excluirPessoa(pessoaId);

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

    // Verificar se usuário existe no banco (login)
    public boolean existeNoBancoPorUsuarioESenha(Usuario usuarioNovo) throws SQLException {
        String sql = "SELECT 1 FROM USUARIO WHERE usuario = ? AND senha = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, usuarioNovo.getUsuario());
            pstm.setString(2, usuarioNovo.getSenha());

            try (ResultSet rs = pstm.executeQuery()) {
                return rs.next();
            }
        }
    }

    // 🔥 Método auxiliar para mapear resultado para objeto Usuario
    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id"));
        usuario.setUsuario(rs.getString("usuario"));
        usuario.setSenha(rs.getString("senha"));

        Pessoa pessoa = new Pessoa();
        pessoa.setId(rs.getInt("pessoa_id"));
        pessoa.setNome(rs.getString("nome"));
        pessoa.setGenero(Genero.valueOf(rs.getString("genero")));
        pessoa.setDataNascimento(rs.getDate("data_nascimento"));
        pessoa.setCpf(rs.getString("cpf"));
        pessoa.setEmail(rs.getString("email"));
        pessoa.setFixo(rs.getString("fixo"));
        pessoa.setCelular(rs.getString("celular"));
        pessoa.setWhatsapp(rs.getBoolean("whatsapp"));
        pessoa.setObservacoes(rs.getString("observacoes"));

        usuario.setPessoa(pessoa);

        return usuario;
    }
}
