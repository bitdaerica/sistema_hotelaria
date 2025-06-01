package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Estado;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.EnderecoDTO;
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

    private final ConnectionFactoryDAO connectionFactory = new ConnectionFactoryDAO();

    public EnderecoDAO() {

    }

    public void inserir(EnderecoDTO endereco) throws SQLException {
        String sql = "INSERT INTO ENDERECO (RUA, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO, CEP) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connectionFactory.conectaBD(); PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, endereco.getRua());
            pstm.setString(2, endereco.getNumero());
            pstm.setString(3, endereco.getComplemento());
            pstm.setString(4, endereco.getBairro());
            pstm.setString(5, endereco.getCidade());
            pstm.setString(6, endereco.getEstado().name());
            pstm.setString(7, endereco.getCep());

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

    public void atualizar(EnderecoDTO endereco) throws SQLException {
        String sql = "UPDATE ENDERECO SET RUA=?, NUMERO=?, COMPLEMENTO=?, BAIRRO=?, CIDADE=?, ESTADO=?, CEP=? WHERE id=?";

        try (Connection conn = connectionFactory.conectaBD(); PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, endereco.getRua());
            pstm.setString(2, endereco.getNumero());
            pstm.setString(3, endereco.getComplemento());
            pstm.setString(4, endereco.getBairro());
            pstm.setString(5, endereco.getCidade());
            pstm.setString(6, endereco.getEstado() != null ? endereco.getEstado().name() : null);
            pstm.setString(7, endereco.getCep());
            pstm.setInt(8, endereco.getId());

            int linhasAfetadas = pstm.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao atualizar, endereço com ID " + endereco.getId() + " não encontrado.");
            }
        }
    }

    public List<EnderecoDTO> listar() throws SQLException {
        List<EnderecoDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM ENDERECO";

        try (Connection conn = connectionFactory.conectaBD(); PreparedStatement pstm = conn.prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                lista.add(montarEndereco(rs));
            }
        }

        return lista;
    }

    public EnderecoDTO buscarPorId(int id) throws SQLException {
        EnderecoDTO endereco = null;
        String sql = "SELECT * FROM ENDERECO WHERE id=?";

        try (Connection conn = connectionFactory.conectaBD(); PreparedStatement pstm = conn.prepareStatement(sql)) {

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
        String sql = "DELETE FROM ENDERECO WHERE id=?";

        try (Connection conn = connectionFactory.conectaBD(); PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, id);

            int linhasAfetadas = pstm.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao deletar, endereço com ID " + id + " não encontrado.");
            }
        }
    }

    private EnderecoDTO montarEndereco(ResultSet rs) throws SQLException {
        EnderecoDTO endereco = new EnderecoDTO();
        endereco.setId(rs.getInt("id"));
        endereco.setRua(rs.getString("rua"));
        endereco.setNumero(rs.getString("numero"));
        endereco.setComplemento(rs.getString("complemento"));
        endereco.setBairro(rs.getString("bairro"));
        endereco.setCidade(rs.getString("cidade"));
        endereco.setCep(rs.getString("cep"));

        String estadoStr = rs.getString("estado");
        if (estadoStr != null) {
            endereco.setEstado(Estado.valueOf(estadoStr));
        } else {
            endereco.setEstado(null);
        }

        return endereco;
    }
}
