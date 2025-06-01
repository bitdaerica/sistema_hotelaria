package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dtoo.HospedeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) Create-Retrive-Update-Delete (CRUD)
 *
 * @author 202412170006
 */
public class HospedeDAO {

    private final ConnectionFactoryDAO connectionFactory = new ConnectionFactoryDAO();

    public void inserirHospede(HospedeDTO h) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            //chamando pessoa par fazer inserir a pessoa primeira
            PessoaDAO dao = new PessoaDAO();

            dao.inserirPessoa(h);

            String sqlHospede = "INSERT INTO HOSPEDE_FISICO ()"
                    + " VALUES()";

            pstm = conn.prepareStatement(sqlHospede);

            pstm.setString(1, h.getNome());
            pstm.setString(4, h.getGenero().name());
            pstm.setString(5, h.getCpf());
            pstm.setString(10, h.getProfissao());
            pstm.setInt(29, h.getId());

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

    public void alterarHospede(HospedeDTO h) throws SQLException {

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            PessoaDAO dao = new PessoaDAO();
            dao.alterarPessoa(h);

            String sqlHospede = "UPDATE HOSPEDE SET NOME =  ?, SOBRENOME =  ?, DATA_NASCIMENTO =  ?, GENERO =  ?, CPF =  ?, RG =  ?, NATURALIDADE =  ?, ESTADO_CIVIL =  ?, FOTO =  ?, PROFISSAO =  ?, STATUS_HOSPEDE =  ?, TIPO_DOC =  ?, NUMERO_DOC =  ?, ORGAO_EMISSOR =  ?, DATA_EMISSAO =  ?, DATA_CADASTRO =  ?, PREFERENCIA_CONTATO =  ?, PREFERENCIA_QUARTO =  ?, PREFERENCIA_ANDAR =  ?, ULTIMA_VISITA =  ?, PREFERENCIA_CAMA =  ?, ITENS_ESPECIAIS =  ?, INTERESSES =  ?, NOTAS_INTERNAS =  ?, EMPRESA_VINCULADA =  ?, CNPJ =  ?, CARGO =  ?, RESPONSAVEL_FATURAMENTO =  ? WHERE ID =  ?";
            pstm = conn.prepareStatement(sqlHospede);

            pstm.setString(1, h.getNome());
            pstm.setString(4, h.getGenero().name());
            pstm.setString(5, h.getCpf());
            pstm.setString(10, h.getProfissao());
            pstm.setInt(29, h.getId());

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

    public HospedeDTO selecionarPorId(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        HospedeDTO hospede = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = "SELECT * FROM HOSPEDE WHERE ID = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                hospede = new HospedeDTO();
                hospede.setId(rs.getInt("ID"));
                hospede.setNome(rs.getString("NOME"));
                hospede.setCpf(rs.getString("CPF"));
                hospede.setProfissao(rs.getString("PROFISSAO"));
                

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
        return hospede;
    }
    
    public List<HospedeDTO> listarTodos() throws SQLException {
        List<HospedeDTO> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = "SELECT * FROM hospede";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                HospedeDTO hospede = new HospedeDTO();
                hospede.setId(rs.getInt("ID"));
                hospede.setNome(rs.getString("NOME"));
                hospede.setCpf(rs.getString("CPF"));
                

                lista.add(hospede);
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

    public List<HospedeDTO> listarPorNome(String nome) throws SQLException {
        List<HospedeDTO> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = "SELECT * FROM HOSPEDE WHERE NOME LIKE ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();

            while (rs.next()) {
                HospedeDTO hospede = new HospedeDTO();
                hospede.setId(rs.getInt("ID"));
                hospede.setNome(rs.getString("NOME"));
                hospede.setCpf(rs.getString("CPF"));
                hospede.setProfissao(rs.getString("PROFISSAO"));

                lista.add(hospede);

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

     public void excluirHospede(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sql = "DELETE FROM hospede WHERE Id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();

            //chamando pessoadao para excluir usuario em pessoa tbm
            PessoaDAO dao = new PessoaDAO();
            dao.excluirPessoa(id);
            
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