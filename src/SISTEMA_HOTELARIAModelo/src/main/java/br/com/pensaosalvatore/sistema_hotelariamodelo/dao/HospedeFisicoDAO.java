package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.HospedeFisicoDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Data Access Object (DAO) Create-Retrive-Update-Delete (CRUD)
 *
 * @author 202412170006
 */
public class HospedeFisicoDAO {

    Connection conn;
    PreparedStatement pstm;

    public void inserir(HospedeFisicoDTO hf) throws Exception {
        String sql = "insert into HOSPEDE_FISICO (NOME, SOBRENOME, DATA_NASCIMENTO, GENERO, CPF, RG, NATURALIDADE, ESTADO_CIVIL, FOTO,"
                + " PROFISSAO, STATUS_HOSPEDE, TIPO_DOC, NUMERO_DOC, ORGAO_EMISSOR, DATA_EMISSAO, DATA_CADASTRO, PREFERENCIA_CONTATO, "
                + "PREFERENCIA_QUARTO, PREFERENCIA_ANDAR, ULTIMA_VISITA, PREFERENCIA_CAMA, ITENS_ESPECIAIS, INTERESSES, NOTAS_INTERNAS, "
                + "EMPRESA_VINCULADA, CNPJ, CARGO, RESPONSAVEL_FATURAMENTO)"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, hf.getNome());
            pstm.setString(2, hf.getSobrenome());
            pstm.setString(3, hf.getGenero().toString());
            pstm.setString(4, hf.getCpf());
            pstm.setDate(5, new java.sql.Date(hf.getDatadenascimento().getTime()));
            pstm.setString(6, hf.Estadocivil());
            pstm.setString(7, hf.getNaturalidade());
            pstm.setString(8, hf.getProfissao());
            pstm.setInt(9, hf.getRg());
            pstm.setString(10, hf.getStatus().toString());
            pstm.setString(11, hf.getCep());
            pstm.setString(12, hf.getRua());
            pstm.setInt(13, hf.getNumero());
            pstm.setString(14, hf.getComplemento());
            pstm.setString(15, hf.getBairro());
            pstm.setString(16, hf.getEstado().toString());
            pstm.setString(17, hf.getEmail());
            pstm.setString(18, hf.getCelular());
            pstm.setString(19, hf.getFixo());
            pstm.setInt(20, hf.getNumerodocumento());
            pstm.setString(21, hf.getTipodocumento().toString());
            pstm.setString(22, hf.getOrgaoemissor());
            pstm.setDate(23, new java.sql.Date(hf.getDatadeemissao().getTime()));
            pstm.setDate(24, new java.sql.Date(hf.getDatadecadastro().getTime()));
            pstm.setString(25, hf.getPreferenciadecontato());
            pstm.setString(26, hf.getPreferenciadeandar().toString());
            pstm.setDate(27, new java.sql.Date(hf.getDatadedaultimavisita().getTime()));
            pstm.setString(28, hf.getPreferedecama().toString());
            pstm.setString(29, hf.getItensespeciais());
            pstm.setString(30, hf.getInteresses());
            pstm.setString(31, hf.getNotasinternas());
            pstm.setString(32, hf.getObservacoes());
            pstm.setString(33, hf.getCnpj());
            pstm.setString(34, hf.getCargo());
            pstm.setString(35, hf.getResponsavelpelofaturamento());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro){
            
            JOptionPane.showMessageDialog(null, "HospedeFisicoDAO" + erro);
        }
        
        conn.close();
    }

    public void alterar(HospedeFisicoDTO h) throws Exception {
        //Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Conexão com o MySQL banco de dados **hotelaria**
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hotelaria", "root", "");

        //Prepara o comando DML de consulta comando.setString(1, h.getNome());
        PreparedStatement comando
                = conn.prepareStatement(
                        "update hospede_fisico set nome=?, sobrenome=?, genero=?, cpf=?, datadenascimento=?,"
                        + "estadocivil=?, naturalidade=?, profissao=?, rg=?, status=?, cep=?, rua=?, numero=?,"
                        + "complemento=?, bairro=?, estado=?, email=?, celular=?, fixo=?, numerodocumento=?,"
                        + "tipodocumento=?, orgaoemissor=?, datadeemissao=?, datadecadastro=?,"
                        + "preferenciadecontato=?,preferenciadeandar=?, datadaultimavisita=?, prefereciadecama=?, itensespeciais=?,"
                        + "interesses=?, notasinternas=?, observacoes=?, cnpj=?, cargo=?, responsavelpelofaturamento=? where id=?");

        // Subistituir os valores dos sinais de interrogação
        comando.setString(1, h.getNome());
        comando.setString(2, h.getSobrenome());
        comando.setString(3, h.getGenero().toString());
        comando.setString(4, h.getCpf());
        comando.setDate(5, new java.sql.Date(h.getDatadenascimento().getTime()));
        comando.setString(6, h.Estadocivil());
        comando.setString(7, h.getNaturalidade());
        comando.setString(8, h.getProfissao());
        comando.setInt(9, h.getRg());
        comando.setString(10, h.getStatus().toString());
        comando.setString(11, h.getCep());
        comando.setString(12, h.getRua());
        comando.setInt(13, h.getNumero());
        comando.setString(14, h.getComplemento());
        comando.setString(15, h.getBairro());
        comando.setString(16, h.getEstado().toString());
        comando.setString(17, h.getEmail());
        comando.setString(18, h.getCelular());
        comando.setString(19, h.getFixo());
        comando.setInt(20, h.getNumerodocumento());
        comando.setString(21, h.getTipodocumento().toString());
        comando.setString(22, h.getOrgaoemissor());
        comando.setDate(23, new java.sql.Date(h.getDatadeemissao().getTime()));
        comando.setDate(24, new java.sql.Date(h.getDatadecadastro().getTime()));
        comando.setString(25, h.getPreferenciadecontato());
        comando.setString(26, h.getPreferenciadeandar().toString());
        comando.setDate(27, new java.sql.Date(h.getDatadedaultimavisita().getTime()));
        comando.setString(28, h.getPreferedecama().toString());
        comando.setString(29, h.getItensespeciais());
        comando.setString(30, h.getInteresses());
        comando.setString(31, h.getNotasinternas());
        comando.setString(32, h.getObservacoes());
        comando.setString(33, h.getCnpj());
        comando.setString(34, h.getCargo());
        comando.setString(35, h.getResponsavelpelofaturamento());
        comando.setInt(36, h.getId());

        // Executa o comando
        comando.executeUpdate();

        // Fecha a conexão
        conn.close();
    }

    public HospedeFisicoDTO selecionar(int id) throws Exception {
        // Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Conexão com o MySQL banco de dados **hotelaria**
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hotelaria", "root", "");

        // Preparando o comando DML
        PreparedStatement comando
                = con.prepareStatement("select * from hospede_fisico where id=?");

        comando.setInt(1, id);

        // Executa o comando e obtem a lista de resulatdo
        ResultSet rs = comando.executeQuery();

        if (rs.next()) {
            HospedeFisicoDTO hf = new HospedeFisicoDTO();
            hf.setId(rs.getInt("id"));
            hf.setNome(rs.getString("nome"));
            hf.setSobrenome(rs.getString("sobrenome"));

            return hf;
        } else {
            return null;
        }
    }

    public List<HospedeFisicoDTO> listar() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hotelaria", "root", "");

        // Preparando o comando DML
        PreparedStatement comando
                = conn.prepareStatement("select * from hospede_fisico order by nome");

        // Executa o comando e obtem a lista de resulatdo
        ResultSet rs = comando.executeQuery();

        List<HospedeFisicoDTO> lista = new ArrayList();
        while (rs.next()) {
            HospedeFisicoDTO hf = new HospedeFisicoDTO();
            hf.setId(rs.getInt("id"));
            hf.setNome(rs.getString("nome"));
            hf.setSobrenome(rs.getString("sobrenome"));

            lista.add(hf);

        }

        conn.close();

        return lista;
    }

    public List<HospedeFisicoDTO> listar(String nome) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hotelaria", "root", "");

        // Preparando o comando DML
        PreparedStatement comando
                = conn.prepareStatement("select * from hospede_fisico where nome like? order by nome");

        comando.setString(1, "%" + nome + "%");

        ResultSet rs = comando.executeQuery();

        List<HospedeFisicoDTO> lista = new ArrayList();
        while (rs.next()) {
            HospedeFisicoDTO hf = new HospedeFisicoDTO();
            hf.setId(rs.getInt("id"));
            hf.setNome(rs.getString("nome"));
            hf.setSobrenome(rs.getString("sobrenome"));

            lista.add(hf);
        }

        conn.close();

        return lista;
    }

    public void excluir(int id) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hotelaria", "root", "");

        PreparedStatement comando
                = conn.prepareStatement("delete from hospede_fisico where id = ?");

        comando.setInt(1, id);

        comando.executeUpdate();

        conn.close();
    }
}
