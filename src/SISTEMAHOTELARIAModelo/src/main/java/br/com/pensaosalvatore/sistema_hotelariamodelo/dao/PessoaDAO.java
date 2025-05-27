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
        

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sqlPessoa = "INSERT INTO PESSOA (EMAIL, FIXO, CELULAR, WHATSAPP, OBSERVACOES, ID_ENDERECO) VALUES (?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, p.getEmail());
            pstm.setString(2, p.getFixo());
            pstm.setString(3, p.getCelular());
            pstm.setBoolean(4, p.getWhatsapp());
            pstm.setString(5, p.getObservacoes());

            pstm.executeUpdate();

            conn.commit();
            
            ResultSet rs = pstm.getGeneratedKeys();
            int idPessoa = -1;
            if (rs.next()) {
                idPessoa = rs.getInt(1); // 1 representa a primeira coluna do resultado
                p.setId(idPessoa);
            }
            rs.close();

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

    public void alterarPessoa(PessoaDTO p) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sqlEndereco = "UPDATE ENDERECO SET RUA =  ?, NUMERO =  ?, COMPLEMENTO =  ?, BAIRRO =  ?, CIDADE =  ?, ESTADO =  ?, CEP = ? WHERE  ID = ?";
            pstm = conn.prepareStatement(sqlEndereco);
            pstm.setString(1, p.getRua());
            pstm.setString(2, p.getNumero());
            pstm.setString(3, p.getComplemento());
            pstm.setString(4, p.getBairro());
            pstm.setString(5, p.getCidade());
            pstm.setString(6, p.getEstado().name());
            pstm.setString(7, p.getCep());
            pstm.setInt(8, p.getIdEndereco());

            pstm.executeUpdate();

            pstm.close();

            String sqlPessoa = "UPDATE PESSOA SET EMAIL = ?, FIXO = ?, CELULAR = ?, WHATSAPP = ?, OBSERVACOES = ?, WHERE ID = ?";
            pstm = conn.prepareStatement(sqlPessoa);
            pstm.setString(1, p.getEmail());
            pstm.setString(2, p.getFixo());
            pstm.setString(3, p.getCelular());
           pstm.setBoolean(4, p.getWhatsapp());
            pstm.setString(5, p.getObservacoes());
            pstm.setInt(6, p.getIdPessoa());

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

    public PessoaDTO selecionarPorId(int idPessoa) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        PessoaDTO pessoa = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = "SELECT * FROM PESSOA WHERE ID = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idPessoa);
            rs = pstm.executeQuery();

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
                pessoa.setEstado(Estado.valueOf(rs.getString("estado")));
                pessoa.setCep(rs.getString("cep"));
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
        return pessoa;
    }

    public List<PessoaDTO> listarTodos() throws SQLException {
        List<PessoaDTO> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = "SELECT * FROM PESSOA";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

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

    public List<PessoaDTO> listarPorNome(String nome) throws SQLException {
        List< PessoaDTO> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();

            String sql = "SELECT * FROM PESSOA WHERE NOME LIKE ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();

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

    public void excluirPessoa(int idPessoa) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sql = "DELETE FROM PESSOA WHERE IdPessoa = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idPessoa);
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
}
