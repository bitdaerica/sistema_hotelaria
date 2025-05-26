
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

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

    public void inserirHospedeFisico(HospedeJuridicoDTO hj) throws SQLException {
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

            pstm.setString(1, RAZAO_SOCIAL);
pstm.setString(2, CNPJ);
pstm.setString(3, INSCRICAO_ESTADUAL);
pstm.setString(4, STATUS_EMPRESA);
pstm.setString(5, TIPO_CONTRATO);
pstm.setString(6, DATA_CADASTRO);
pstm.setString(7, PREFERENCIA_CONTATO);
pstm.setString(8, RESPONSAVEL_FATURAMENTO);
pstm.setString(9, NOTAS_INTERNAS);
pstm.setString(10, FORMA_PAGAMENTO);
pstm.setString(11, PRAZO_FATURAMENTO);
pstm.setString(12, LIMITE_CREDITO);
pstm.setString(13, INTERESSES);



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
