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

            /*
             
pstm.setString(1 NOME
pstm.setString(2 SOBRENOME
pstm.setString(3 DATA_NASCIMENTO
pstm.setString(4 GENERO
pstm.setString(5 CPF
pstm.setString(6 RG
pstm.setString(7 NATURALIDADE
pstm.setString(8 ESTADO_CIVIL
pstm.setString(9 FOTO
pstm.setString(10 PROFISSAO
pstm.setString(11 STATUS_HOSPEDE
pstm.setString(12 TIPO_DOC
pstm.setString(13 NUMERO_DOC
pstm.setString(14 ORGAO_EMISSOR
pstm.setString(15 DATA_EMISSAO
pstm.setString(16 DATA_CADASTRO
pstm.setString(17 PREFERENCIA_CONTATO
pstm.setString(18 PREFERENCIA_QUARTO
pstm.setString(19 PREFERENCIA_ANDAR
pstm.setString(20 ULTIMA_VISITA
pstm.setString(21 PREFERENCIA_CAMA
pstm.setString(22 ITENS_ESPECIAIS
pstm.setString(23 INTERESSES
pstm.setString(24 NOTAS_INTERNAS
pstm.setString(25 EMPRESA_VINCULADA
pstm.setString(26 CNPJ
pstm.setString(27 CARGO
pstm.setString(28 RESPONSAVEL_FATURAMENTO
            pstm.setString(29 ID_PESSOA 
             */
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
