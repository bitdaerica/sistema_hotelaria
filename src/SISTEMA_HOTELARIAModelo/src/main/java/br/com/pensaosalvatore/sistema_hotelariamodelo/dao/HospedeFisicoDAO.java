/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.HospedeFisico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *Data Access Object (DAO)
 * Create-Retrive-Update-Delete (CRUD)
 * @author 202412170006
 */
public class HospedeFisicoDAO {
    public void inserir(HospedeFisico h) throws Exception {
        // Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Conexão com o MySQL banco de dados **hotelaria**
        Connection con = DriverManager.getConnection(
                "jdbc:mysql//localhost:3306/hotelaria", "root","");
        
        // Prepara o comando que quer executar DML (Data Manipulation Language)
        PreparedStatement comando = 
                con.prepareStatement("inserir into hospedefisico(nome, sobrenome, genero, cpf, datadenascimento," +
                        "estadocivil, naturalidade, profissao, rg, status, cep, rua, numero, complemento, bairro, estado, email," +
                        "celular, fixo, numerodocumento, tipodocumento, orgaoemissor, datadeemissao, datadecadastro," +
                        "preferenciadecontato, preferenciadeandar, datadaultimavisita, prefereciadecama, itensespeciais," +
                        "interesses, notasinternas, observacoes, cnpj, cargo, responsavelpelofaturamento)" +
                        "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
        // Subistituir os valores dos sinais interrogação
        comando.setString(1, h.getNome());
        comando.setString(2, h.getSobrenome());
        comando.setString(3, h.getGenero().toString());
        comando.setString(4, h.getCpf());
        comando.setDate(5, (Date) h.getDatadenascimento());
        comando.setString(6,h.Estadocivil());
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
        comando.setDate(23, (Date) h.getDatadeemissao());
        comando.setDate(24, (Date) h.getDatadecadastro());
        comando.setString(25, h.getPreferenciadecontato());
        comando.setString(26, h.getPreferenciadeandar().toString());
        comando.setDate(27, (Date) h.getDatadedaultimavisita());
        comando.setString(28, h.getPreferedecama().toString());
        comando.setString(29, h.getItensespeciais());
        comando.setString(30, h.getInteresses());
        comando.setString(31, h.getNotasinternas());
        comando.setString(32, h.getObservacoes());
        comando.setString(33, h.getCnpj());
        comando.setString(34, h.getCargo());
        comando.setString(35, h.getResponsavelpelofaturamento());
        
        // Executa o comando
        comando.executeUpdate();
        
        // Fecha a conexão
        con.close();
    }
        
    public void alterar(HospedeFisico h) throws Exception {
        //Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");
            
        //Conexão com o MySQL banco de dados **hotelaria**
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotelaria", "root", "");
            
        //Prepara o comando DML de consulta comando.setString(1, h.getNome());
        PreparedStatement comando =
                con.prepareStatement(
                "update hospedefisico set nome=?, sobrenome=?, genero=?, cpf=?, datadenascimento=?," +
                        "estadocivil=?, naturalidade=?, profissao=?, rg=?, status=?, cep=?, rua=?, numero=?,"+
                        "complemento=?, bairro=?, estado=?, email=?, celular=?, fixo=?, numerodocumento=?,"+
                        "tipodocumento=?, orgaoemissor=?, datadeemissao=?, datadecadastro=?, preferenciadecontato=?"+
                        "preferenciadecontato=?,preferenciadeandar=?, datadaultimavisita=?, prefereciadecama=?, itensespeciais=?,"+
                        "interesses=?, notasinternas=?, observacoes=?, cnpj=?, cargo=?, responsavelpelofaturamento=? where id=?");
            
        // Subistituir os valores dos sinais de interrogação
        comando.setString(1, h.getNome());
        comando.setString(2, h.getSobrenome());
        comando.setString(3, h.getGenero().toString());
        comando.setString(4, h.getCpf());
        comando.setDate(5, (Date) h.getDatadenascimento());
        comando.setString(6,h.Estadocivil());
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
        comando.setDate(23, (Date) h.getDatadeemissao());
        comando.setDate(24, (Date) h.getDatadecadastro());
        comando.setString(25, h.getPreferenciadecontato());
        comando.setString(26, h.getPreferenciadeandar().toString());
        comando.setDate(27, (Date) h.getDatadedaultimavisita());
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
        con.close();
    }
    
    public HospedeFisico selecionar(int id) throws Exception {
         // Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
         // Conexão com o MySQL banco de dados **hotelaria**
        Connection con = DriverManager.getConnection(
                "jdbc:mysql//localhost:3306/hotelaria", "root","");
        
        // Preparando o comando DML
        PreparedStatement comando =
                con.prepareStatement("select * from hospedesfisicos where id=?");
        
        comando.setInt(1, id);
        
        // Executa o comando e obtem a lista de resulatdo
        ResultSet rs = comando.executeQuery();
        
        if (rs.next()){
            HospedeFisico h = new HospedeFisico();
            h.setId(rs.getInt("id"));
            h.setNome(rs.getString("nome"));
            h.setSobrenome(rs.getString("sobrenome"));
            
            return h;
        }else{
            return null;
        }
    }
    
    public List<HospedeFisico> listar() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
         Connection con = DriverManager.getConnection(
                "jdbc:mysql//localhost:3306/hotelaria", "root","");
         
        // Preparando o comando DML
        PreparedStatement comando =
                con.prepareStatement("select * from hospedesfisicos order by nome");
        
        // Executa o comando e obtem a lista de resulatdo
        ResultSet rs = comando.executeQuery();
        
        List<HospedeFisico> lista = new ArrayList();
        while (rs.next()){
            HospedeFisico h = new HospedeFisico();
            h.setId(rs.getInt("id"));
            h.setNome(rs.getString("nome"));
            h.setSobrenome(rs.getString("sobrenome"));
            
            lista.add(h);
            
        }
        
        con.close();
        
        return lista;
    }
    
    public List<HospedeFisico> listar(String nome) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(
                "jdbc:mysql//localhost:3306/hotelaria", "root","");
        
        // Preparando o comando DML
        PreparedStatement comando =
                con.prepareStatement("select * from hospedesfisicos where nome like? order by nome");
        
        comando.setString(1, nome = "%");
        
        ResultSet rs = comando.executeQuery();
        
        List<HospedeFisico> lista = new ArrayList();
        while (rs.next()){
            HospedeFisico h = new HospedeFisico();
            h.setId(rs.getInt("id"));
            h.setNome(rs.getString("nome"));
            h.setSobrenome(rs.getString("sobrenome"));
            
            lista.add(h);
        }
        
        con.close();
        
        return lista;
    }
    
    public void excluir(int id) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(
                "jdbc:mysql//localhost:3306/hotelaria", "root","");
        
        PreparedStatement comando =
                con.prepareStatement("delete from hospedefisico where id=?");
        
        comando.setInt(1, id);
        
        comando.executeUpdate();
        
        con.close();
    }
}
        
      