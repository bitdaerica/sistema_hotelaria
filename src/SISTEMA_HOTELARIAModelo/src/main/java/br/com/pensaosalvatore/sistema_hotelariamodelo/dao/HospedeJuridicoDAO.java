
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.CargoFuncionario;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.DepartamentoFuncionario;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.StatusFuncionario;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.StatusHospede;
import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.FuncionarioDTO;
import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.HospedeJuridicoDTO;
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
public class HospedeJuridicoDAO {

    private final ConnectionFactoryDAO connectionFactory = new ConnectionFactoryDAO();

    public void inserirHospedeJuridico(HospedeJuridicoDTO hj) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sqlEndereco = "INSERT INTO ENDERECO (RUA, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO, CEP) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, hj.getRua());
            pstm.setString(2, hj.getNumero());
            pstm.setString(3, hj.getComplemento());
            pstm.setString(4, hj.getBairro());
            pstm.setString(5, hj.getCidade());
            pstm.setString(6, hj.getEstado().name());
            pstm.setString(7, hj.getCep());

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
            pstm.setString(1, hj.getEmail());
            pstm.setString(2, hj.getFixo());
            pstm.setString(3, hj.getCelular());
            pstm.setBoolean(4, hj.getWhatsapp());
            pstm.setString(5, hj.getObservacoes());
            pstm.setInt(6, idEndereco);
            pstm.executeUpdate();

            rs = pstm.getGeneratedKeys();
            int idPessoa = 0;

            if (rs.next()) {
                idPessoa = rs.getInt(1);
            }

            pstm.close();

            rs.close();

            String sqlHospedeJuridico = "INSERT INTO HOSPEDE_JURIDICO (RAZAO_SOCIAL, CNPJ, INSCRICAO_ESTADUAL, STATUS_EMPRESA, TIPO_CONTRATO,"
                    + " DATA_CADASTRO, PREFERENCIA_CONTATO, RESPONSAVEL_FATURAMENTO, NOTAS_INTERNAS, FORMA_PAGAMENTO, PRAZO_FATURAMENTO,"
                    + " LIMITE_CREDITO, INTERESSES) VALUES(??, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        pstm = conn.prepareStatement(sqlHospedeJuridico);

            pstm.setString(1, hj.getRazaosocial());
pstm.setString(2, hj.getCnpj());
pstm.setString(3, hj.getInscricaoestadual());
pstm.setString(4, hj.getStatus().name());
pstm.setString(5, hj.getTipodecontrato().name());
pstm.setDate(6, new java.sql.Date(hj.getDatadecadastro().getTime()));
pstm.setString(7, hj.getPreferenciadecontato());
pstm.setString(8, hj.getResponsavelpeloofaturamento());
pstm.setString(9, hj.getNotasinternas());
pstm.setString(10, hj.getFormadepagamento().name());
pstm.setString(11, hj.getPrazodefaturamento().name());
pstm.setBigDecimal(12, hj.getLimetedecredito());
pstm.setString(13, hj.getInteresses());



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
     public void alterarHospedeJuridico(HospedeJuridicoDTO hj) throws SQLException {

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);
            
             String sqlEndereco = "UPDATE ENDERECO SET RUA =  ?, NUMERO =  ?, COMPLEMENTO =  ?, BAIRRO =  ?, CIDADE =  ?, ESTADO =  ?, CEP = ? WHERE  ID = ?";
            pstm = conn.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, hj.getRua());
            pstm.setString(2, hj.getNumero());
            pstm.setString(3, hj.getComplemento());
            pstm.setString(4, hj.getBairro());
            pstm.setString(5, hj.getCidade());
            pstm.setString(6, hj.getEstado().name());
            pstm.setString(7, hj.getCep());
            
             pstm.executeUpdate();

            pstm.close();
            
            String sqlPessoa = "UPDATE PESSOA SET EMAIL = ?, FIXO = ?, CELULAR = ?, WHATSAPP = ?, OBSERVACOES = ?, WHERE ID = ?";
            pstm = conn.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, hj.getEmail());
            pstm.setString(2, hj.getFixo());
            pstm.setString(3, hj.getCelular());
            pstm.setBoolean(4, hj.getWhatsapp());
            pstm.setString(5, hj.getObservacoes());
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
     public HospedeJuridicoDTO selecionarPorId(int idHospedeJuridico) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        HospedeJuridicoDTO hospedejuridico = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = "SELECT * FROM HODPEDE_JURIDICO WHERE ID = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idHospedeJuridico);
            rs = pstm.executeQuery();
            
             if (rs.next()) {
                hospedejuridico = new HospedeJuridicoDTO();
                hospedejuridico.setId(rs.getInt("ID"));
                hospedejuridico.setRazaosocial(rs.getString("RAZAO_SOCIAL"));
                hospedejuridico.setCnpj(rs.getString("CNPJ"));
                hospedejuridico.setInscricaoestadual(rs.getString("INSCRICAO_ESTADUAL"));
                hospedejuridico.setStatus(StatusHospede.valueOf(rs.getString("STATUS_HOSPEDE_JURIDICO")));
                
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
        return hospedejuridico;
    }
    public List<HospedeJuridicoDTO> listarTodos() throws SQLException {
        List<HospedeJuridicoDTO> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
         try {
            conn = connectionFactory.conectaBD();
            String sql = "SELECT * FROM HOSPDE_JURIDICO";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
             while (rs.next()) {
                   HospedeJuridicoDTO hospedejuridico = new HospedeJuridicoDTO();
                   hospedejuridico.setId(rs.getInt("ID"));
                   hospedejuridico.setRazaosocial(rs.getString("RAZAO_SOCIAL"));
                   hospedejuridico.setCnpj(rs.getString("CNPJ"));
                   hospedejuridico.setInscricaoestadual(rs.getString("INSCRICAO_ESTADUAL"));
                   hospedejuridico.setStatus(StatusHospede.valueOf(rs.getString("STATUS_HOSPEDE_JURIDICO")));
                
             }
     
     
             }


       
                
             

     

 
       