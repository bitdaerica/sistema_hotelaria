package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Érica_Almeida
 *
 */
public class EnderecoDAO {

    private final Connection connection;

    public EnderecoDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Endereco endereco) throws SQLException {
        if (endereco == null) {
            throw new IllegalArgumentException("Endereço não pode ser nulo.");
        }
        String sql = "INSERT INTO enderecos (rua, numero, bairro, cidade, estado, cep, complemento) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, endereco.getRua());
            pstm.setString(2, endereco.getNumero());
            pstm.setString(3, endereco.getBairro());
            pstm.setString(4, endereco.getCidade());
            pstm.setString(5, endereco.getEstado());
            pstm.setString(6, endereco.getCep());
            pstm.setString(7, endereco.getComplemento());

            int affectedRows = pstm.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        endereco.setId(generatedKeys.getInt(1));
                    }
                }
            } else {
                throw new SQLException("Falha ao inserir endereço!");
            }
        }
    }

    public void atualizar(Endereco endereco) throws SQLException {
        String sql = "UPDATE enderecos SET rua = ? , numero = ? , bairro = ? , cidade = ? , estado = ? , cep = ? , complemento = ? WHERE id=?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {

            pstm.setString(1, endereco.getRua());
            pstm.setString(2, endereco.getNumero());
            pstm.setString(3, endereco.getBairro());
            pstm.setString(4, endereco.getCidade());
            pstm.setString(5, endereco.getEstado());
            pstm.setString(6, endereco.getCep());
            pstm.setString(7, endereco.getComplemento());
            pstm.setInt(8, endereco.getId());

            int linhasAfetadas = pstm.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao atualizar, endereço com ID " + endereco.getId() + " não encontrado.");
            }
        }
    }

    public List<Endereco> listar() throws SQLException {
        List<Endereco> lista = new ArrayList<>();
        String sql = "SELECT * FROM enderecos";

        try (PreparedStatement pstm = connection.prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                lista.add(montarEndereco(rs));
            }
        }

        return lista;
    }

    public Endereco buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM enderecos WHERE id=?";
        Endereco endereco = null;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);

            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    endereco = montarEndereco(rs);
                }
            }
        }

        return endereco;
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM enderecos WHERE id=?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);

            int linhasAfetadas = pstm.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao deletar, endereço com ID " + id + " não encontrado.");
            }
        }
    }

    private Endereco montarEndereco(ResultSet rs) throws SQLException {
        Endereco endereco = new Endereco();
        endereco.setId(rs.getInt("id"));
        endereco.setRua(rs.getString("rua"));
        endereco.setNumero(rs.getString("numero"));
        endereco.setComplemento(rs.getString("complemento"));
        endereco.setBairro(rs.getString("bairro"));
        endereco.setCidade(rs.getString("cidade"));
        endereco.setEstado(rs.getString("estado"));
        endereco.setCep(rs.getString("cep"));

        

        return endereco;
    }
}
