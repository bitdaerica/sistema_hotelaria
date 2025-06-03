package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Endereco;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Pessoa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Érica_Almeida
 */
public class PessoaDAO {

    private final Connection connection;
    private final EnderecoDAO enderecoDAO;

    public PessoaDAO(Connection connection, EnderecoDAO enderecoDAO) {
        this.connection = connection;
        this.enderecoDAO = enderecoDAO;
    }

    public int inserir(Pessoa p) throws SQLException {
        String sql = "INSERT INTO pessoas (nome, genero, data_nascimento, cpf, email, fixo, celular, whatsapp, observacoes, id_enderecos) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preencherStatement(pstm, p);
            pstm.executeUpdate();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // Retorna o ID gerado
                } else {
                    throw new SQLException("Falha ao obter o ID da pessoa.");
                }
            }
        }
    }

    public void alterar(Pessoa p) throws SQLException {
        if (p.getId() <= 0) {
            throw new IllegalArgumentException("ID inválido para atualização.");
        }

        String sql = "UPDATE pessoas SET nome = ?, genero = ?, data_nascimento = ?, cpf = ?, email = ?, fixo = ?, celular = ?, "
                + "whatsapp = ?, observacoes = ?, id_enderecos = ? WHERE id = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            preencherStatement(pstm, p);
            pstm.setInt(11, p.getId());
            pstm.executeUpdate();
        }
    }

    public Pessoa selecionarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM pessoas WHERE ID = ?";
        Pessoa pessoa = null;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    pessoa = mapearPessoa(rs);
                }
            }
        }
        return pessoa;
    }

    public List<Pessoa> listarTodos() throws SQLException {
        String sql = "SELECT * FROM pessoas";
        List<Pessoa> lista = new ArrayList<>();

        try (PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {
            while (rs.next()) {
                lista.add(mapearPessoa(rs));
            }
        }
        return lista;
    }

    public List<Pessoa> listarPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM pessoas WHERE LOWER(NOME) LIKE ?";
        List<Pessoa> lista = new ArrayList<>();

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, "%" + nome.toLowerCase() + "%");

            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearPessoa(rs));
                }
            }
        }
        return lista;
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM pessoas WHERE ID = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }
    }

    private void preencherStatement(PreparedStatement pstm, Pessoa p) throws SQLException {
        pstm.setString(1, p.getNome());
        pstm.setString(2, p.getGenero());

        if (p.getData_nascimento() != null) {
            pstm.setDate(3, Date.valueOf(p.getData_nascimento()));
        } else {
            pstm.setNull(3, Types.DATE);  // Corrigido para evitar exceção
        }

        pstm.setString(4, p.getCpf());
        pstm.setString(5, p.getEmail());
        pstm.setString(6, p.getFixo());
        pstm.setString(7, p.getCelular());

        if (p.getWhatsapp() != null) {
            pstm.setBoolean(8, p.getWhatsapp());
        } else {
            pstm.setNull(8, Types.BOOLEAN);
        }

        pstm.setString(9, p.getObservacoes());

        if (p.getEndereco() != null) {
            pstm.setInt(10, p.getEndereco().getId());
        } else {
            pstm.setNull(10, Types.INTEGER);
        }
    }

    private Pessoa mapearPessoa(ResultSet rs) throws SQLException {
        Pessoa pessoa = new Pessoa();

        pessoa.setId(rs.getInt("id"));
        pessoa.setNome(rs.getString("nome"));
        pessoa.setGenero(rs.getString("genero"));

        Date dataSQL = rs.getDate("data_nascimento");
        if (dataSQL != null) {
            pessoa.setData_nascimento(dataSQL.toLocalDate());
        } else {
            pessoa.setData_nascimento(null);
        }

        pessoa.setCpf(rs.getString("cpf"));
        pessoa.setEmail(rs.getString("email"));
        pessoa.setFixo(rs.getString("fixo"));
        pessoa.setCelular(rs.getString("celular"));

        Object whatsappObj = rs.getObject("whatsapp");
        pessoa.setWhatsapp(whatsappObj != null ? rs.getBoolean("whatsapp") : null);

        pessoa.setObservacoes(rs.getString("observacoes"));

        int enderecoId = rs.getInt("endereco_id");
        if (!rs.wasNull() && enderecoDAO != null) {
            Endereco endereco = enderecoDAO.buscarPorId(enderecoId);
            pessoa.setEndereco(endereco);
        } else {
            pessoa.setEndereco(null);
        }

        return pessoa;
    }

}