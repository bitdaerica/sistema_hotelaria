package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Estado;
import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.PessoaDTO;
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
 */
public class PessoaDAO {

    private final ConnectionFactoryDAO connectionFactory = new ConnectionFactoryDAO();

    public void inserirPessoa(PessoaDTO p) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sqlEndereco = "INSERT INTO ENDERECO (RUA, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO, CEP) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, p.getRua());
            pstm.setString(2, p.getNumero());
            pstm.setString(3, p.getComplemento());
            pstm.setString(4, p.getBairro());
            pstm.setString(5, p.getCidade());
            pstm.setString(6, p.getEstado().name());
            pstm.setString(7, p.getCep());
            pstm.executeUpdate();

            rs = pstm.getGeneratedKeys();
            int idEndereco = 0;

            if (rs.next()) {
                idEndereco = rs.getInt(1);
            }

            pstm.close();

            rs.close();

            String sqlPessoa = "INSERT INTO PESSOA (EMAIL, FIXO, CELULAR, WHATSAPP, OBSERVACOES, ID_ENDERECO) VALUES (?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, p.getEmail());
            pstm.setString(2, p.getFixo());
            pstm.setString(3, p.getCelular());
            pstm.setBoolean(4, p.getWhatsapp());
            pstm.setString(5, p.getObservacoes());
            pstm.setInt(6, idEndereco);

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

        
    public void atualizar(PessoaDTO pessoa) throws SQLException {
        String sql = "UPDATE pessoa SET email=?, fixo=?, celular=?, whatsapp=?, observacoes=?, idEndereco=?, rua=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, cep=? WHERE idPessoa=?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, pessoa.getEmail());
            pstm.setString(2, pessoa.getFixo());
            pstm.setString(3, pessoa.getCelular());
            pstm.setBoolean(4, pessoa.getWhatsapp());
            pstm.setString(5, pessoa.getObservacoes());
            pstm.setInt(6, pessoa.getIdEndereco());
            pstm.setString(7, pessoa.getRua());
            pstm.setString(8, pessoa.getNumero());
            pstm.setString(9, pessoa.getComplemento());
            pstm.setString(10, pessoa.getBairro());
            pstm.setString(11, pessoa.getCidade());
            pstm.setString(12, pessoa.getEstado().toString());
            pstm.setString(13, pessoa.getCep());
            pstm.setInt(14, pessoa.getIdPessoa());

            pstm.executeUpdate();
        }
    }

    
   public PessoaDTO buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM pessoa WHERE idPessoa = ?";
        PessoaDTO pessoa = null;

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    pessoa = new PessoaDTO();
                    pessoa.setIdPessoa(rs.getInt("idPessoa"));
                    pessoa.setEmail(rs.getString("email"));
                    pessoa.setFixo(rs.getString("fixo"));
                    pessoa.setCelular(rs.getString("celular"));
                    pessoa.setWhatsapp(rs.getBoolean("whatsapp"));
                    pessoa.setObservacoes(rs.getString("observacoes"));
                    pessoa.setIdEndereco(rs.getInt("idEndereco"));
                    pessoa.setRua(rs.getString("rua"));
                    pessoa.setNumero(rs.getString("numero"));
                    pessoa.setComplemento(rs.getString("complemento"));
                    pessoa.setBairro(rs.getString("bairro"));
                    pessoa.setCidade(rs.getString("cidade"));
                    pessoa.setEstado(Estado.valueOf(rs.getString("estado"))); // Estado enum
                    pessoa.setCep(rs.getString("cep"));
                }
            }
        }
        return pessoa;
    }
    
    public List<PessoaDTO> listarTodos() throws SQLException {
        List<PessoaDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";

        try (PreparedStatement pstm = conn.prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                PessoaDTO pessoa = new PessoaDTO();
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setFixo(rs.getString("fixo"));
                pessoa.setCelular(rs.getString("celular"));
                pessoa.setWhatsapp(rs.getBoolean("whatsapp"));
                pessoa.setObservacoes(rs.getString("observacoes"));
                pessoa.setIdEndereco(rs.getInt("idEndereco"));
                pessoa.setRua(rs.getString("rua"));
                pessoa.setNumero(rs.getString("numero"));
                pessoa.setComplemento(rs.getString("complemento"));
                pessoa.setBairro(rs.getString("bairro"));
                pessoa.setCidade(rs.getString("cidade"));
                pessoa.setEstado(Estado.valueOf(rs.getString("estado")));
                pessoa.setCep(rs.getString("cep"));

                lista.add(pessoa);
            }
        }
        return lista;
    }
    
     public void excluirPessoa(int idPessoa) throws SQLException {
        String sql = "DELETE FROM pessoa WHERE idPessoa = ?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }
    }

}
