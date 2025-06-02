package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Genero;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Endereco;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public void inserirPessoa(Pessoa p) throws SQLException {
        String sql = "INSERT INTO PESSOA (nome, genero, datanascimento, cpf, email, fixo, celular, whatsapp, observacoes, endereco_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preencherStatement(pstm, p);
            pstm.executeUpdate();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    p.setId(rs.getInt(1));
                }
            }
        }
    }

    public void alterarPessoa(Pessoa p) throws SQLException {
        String sql = "UPDATE PESSOA SET nome = ?, genero = ?, datanascimento = ?, cpf = ?, email = ?, fixo = ?, celular = ?, "
                + "whatsapp = ?, observacoes = ?, endereco_id = ? WHERE id = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            preencherStatement(pstm, p);
            pstm.setInt(11, p.getId());
            pstm.executeUpdate();
        }
    }

    public Pessoa selecionarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM PESSOA WHERE ID = ?";
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
        String sql = "SELECT * FROM PESSOA";
        List<Pessoa> lista = new ArrayList<>();

        try (PreparedStatement pstm = connection.prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearPessoa(rs));
            }
        }
        return lista;
    }

    public List<Pessoa> listarPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM PESSOA WHERE NOME LIKE ?";
        List<Pessoa> lista = new ArrayList<>();

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, "%" + nome + "%");

            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearPessoa(rs));
                }
            }
        }
        return lista;
    }

    public void excluirPessoa(int id) throws SQLException {
        String sql = "DELETE FROM PESSOA WHERE ID = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }
    }

    // ---------------------- MÉTODOS AUXILIARES ----------------------
    private void preencherStatement(PreparedStatement pstm, Pessoa p) throws SQLException {
        pstm.setString(1, p.getNome());
        pstm.setString(2, p.getGenero() != null ? p.getGenero().toString() : null);

        if (p.getDataNascimento() != null) {
            pstm.setDate(3, new java.sql.Date(p.getDataNascimento().getTime()));
        } else {
            pstm.setNull(3, Types.DATE);
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

        String generoStr = rs.getString("genero");
        pessoa.setGenero(generoStr != null ? Genero.valueOf(generoStr) : null);

        pessoa.setDataNascimento(rs.getDate("datanascimento"));
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
