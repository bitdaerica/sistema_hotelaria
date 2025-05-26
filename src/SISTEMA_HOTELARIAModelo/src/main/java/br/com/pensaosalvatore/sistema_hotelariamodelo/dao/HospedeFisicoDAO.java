package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.HospedeFisicoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) Create-Retrive-Update-Delete (CRUD)
 *
 * @author 202412170006
 */
public class HospedeFisicoDAO {

    private final ConnectionFactoryDAO connectionFactory = new ConnectionFactoryDAO();

    public void inserirHospedeFisico(HospedeFisicoDTO hf) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sqlEndereco = "INSERT INTO ENDERECO (RUA, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO, CEP) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, hf.getRua());
            pstm.setString(2, hf.getNumero());
            pstm.setString(3, hf.getComplemento());
            pstm.setString(4, hf.getBairro());
            pstm.setString(5, hf.getCidade());
            pstm.setString(6, hf.getEstado().name());
            pstm.setString(7, hf.getCep());

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
            pstm.setString(1, hf.getEmail());
            pstm.setString(2, hf.getFixo());
            pstm.setString(3, hf.getCelular());
            pstm.setBoolean(4, hf.getWhatsapp());
            pstm.setString(5, hf.getObservacoes());
            pstm.setInt(6, idEndereco);
            pstm.executeUpdate();

            rs = pstm.getGeneratedKeys();
            int idPessoa = 0;

            if (rs.next()) {
                idPessoa = rs.getInt(1);
            }

            pstm.close();

            rs.close();

            String sqlHospedeFisico = "INSERT INTO HOSPEDE_FISICO (NOME, SOBRENOME, DATA_NASCIMENTO, GENERO, CPF, RG, NATURALIDADE, ESTADO_CIVIL, FOTO,"
                    + " PROFISSAO, STATUS_HOSPEDE, TIPO_DOC, NUMERO_DOC, ORGAO_EMISSOR, DATA_EMISSAO, DATA_CADASTRO, PREFERENCIA_CONTATO, "
                    + "PREFERENCIA_QUARTO, PREFERENCIA_ANDAR, ULTIMA_VISITA, PREFERENCIA_CAMA, ITENS_ESPECIAIS, INTERESSES, NOTAS_INTERNAS, "
                    + "EMPRESA_VINCULADA, CNPJ, CARGO, RESPONSAVEL_FATURAMENTO, ID_PESSOA)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pstm = conn.prepareStatement(sqlHospedeFisico);

            pstm.setString(1, hf.getNome());
            pstm.setString(2, hf.getSobrenome());
            pstm.setDate(3, new java.sql.Date(hf.getDatadenascimento().getTime()));
            pstm.setString(4, hf.getGenero().name());
            pstm.setString(5, hf.getCpf());
            pstm.setInt(6, hf.getRg());
            pstm.setString(7, hf.getNaturalidade());
            pstm.setString(8, hf.getEstadocivil().name());
            pstm.setString(9, hf.getFoto());
            pstm.setString(10, hf.getProfissao());
            pstm.setString(11, hf.getStatus().name());
            pstm.setString(12, hf.getTipodocumento().name());
            pstm.setInt(13, hf.getNumerodocumento());
            pstm.setString(14, hf.getOrgaoemissor()); 
            pstm.setDate(15, new java.sql.Date (hf.getDatadeemissao().getTime()));
            pstm.setDate(16, new java.sql.Date(hf.getDatadecadastro().getTime())); 
            pstm.setString(17, hf.getPreferenciadecontato());
            pstm.setString(18, hf.getPreferenciadequarto().name());
            pstm.setString(19, hf.getPreferenciadeandar().name());
            pstm.setDate(20, new java.sql.Date (hf.getUltimavisita().getTime()));
            pstm.setString(21, hf.getPreferenciadecama().name());
            pstm.setString(22, hf.getItensespeciais());
            pstm.setString(23, hf.getInteresses());
            pstm.setString(24, hf.getNotasinternas());
            pstm.setString(25, hf.getEmpresavinculada());
            pstm.setString(26, hf.getCnpj());
            pstm.setString(27, hf.getCargo());
            pstm.setString(28, hf.getResponsavelpelofaturamento());
            pstm.setInt(29,  hf.getIdPessoa()); 
            
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

    public void alterarHospedeFisico(HospedeFisicoDTO hf) throws SQLException {

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sqlEndereco = "UPDATE ENDERECO SET RUA =  ?, NUMERO =  ?, COMPLEMENTO =  ?, BAIRRO =  ?, CIDADE =  ?, ESTADO =  ?, CEP = ? WHERE  ID = ?";
            pstm = conn.prepareStatement(sqlEndereco);
            pstm.setString(1, hf.getRua());
            pstm.setString(2, hf.getNumero());
            pstm.setString(3, hf.getComplemento());
            pstm.setString(4, hf.getBairro());
            pstm.setString(5, hf.getCidade());
            pstm.setString(6, hf.getEstado().name());
            pstm.setString(7, hf.getCep());
            pstm.setInt(8, hf.getIdEndereco());

            pstm.executeUpdate();

            pstm.close();

            String sqlPessoa = "UPDATE PESSOA SET EMAIL = ?, FIXO = ?, CELULAR = ?, WHATSAPP = ?, OBSERVACOES = ?, WHERE ID = ?";
            pstm = conn.prepareStatement(sqlPessoa);
            pstm.setString(1, hf.getEmail());
            pstm.setString(2, hf.getFixo());
            pstm.setString(3, hf.getCelular());
            pstm.setBoolean(4, hf.getWhatsapp());
            pstm.setString(5, hf.getObservacoes());
            pstm.setInt(6, hf.getIdPessoa());

            pstm.executeUpdate();

            pstm.close();

            String sqlHospedeFisico = "UPDATE HOSPEDE_FISICO SET NOME =  ?, SOBRENOME =  ?, DATA_NASCIMENTO =  ?, GENERO =  ?, CPF =  ?, RG =  ?, NATURALIDADE =  ?, ESTADO_CIVIL =  ?, FOTO =  ?, PROFISSAO =  ?, STATUS_HOSPEDE =  ?, TIPO_DOC =  ?, NUMERO_DOC =  ?, ORGAO_EMISSOR =  ?, DATA_EMISSAO =  ?, DATA_CADASTRO =  ?, PREFERENCIA_CONTATO =  ?, PREFERENCIA_QUARTO =  ?, PREFERENCIA_ANDAR =  ?, ULTIMA_VISITA =  ?, PREFERENCIA_CAMA =  ?, ITENS_ESPECIAIS =  ?, INTERESSES =  ?, NOTAS_INTERNAS =  ?, EMPRESA_VINCULADA =  ?, CNPJ =  ?, CARGO =  ?, RESPONSAVEL_FATURAMENTO =  ?, WHERE ID =  ?",
            pstm = conn.prepareStatement(sqlHospedeFisico);
        }
