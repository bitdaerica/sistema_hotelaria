
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.HospedeJuridicoDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Érica_Almeida
 */
public class HospedeJuridicoDAO {
    public void inserir(HospedeJuridicoDTO hj) throws Exception{
        //Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Conexão com o MySQL banco de dados **hotelaria**
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotelaria", "root", "");
        
        //Prepara o comando que quer executar DML (Data Manipulation Language)
        PreparedStatement comando =
            con.prepareStatement("inserir into hospedejuridico(razaosocial, cnpj, inscricaoestadual,"
            + "status, tipodecontrato, datadecadastro, obsevacoes, cep, rua, numero, complemento,"
            + "bairro, estado, emailcorporativo, fixo, preferenciadecontato, responsavelpeloofaturamento,"
            + "celular, notasinternas, limetedecredito, interesses) values(?,?,?,?,?,?,?,?,?,?,?,?,?,"
            + "?,?,?,?,?,?,?,?)");
        
        //Substitui os valores dos sinais de interrogacao
        comando.setString(1, hj.getRazaosocial());
        comando.setString(2, hj.getCnpj());
        comando.setString(3, hj.getInscricaoestadual());
        comando.setString(4, hj.getStatus().toString());
        comando.setString(5, hj.getTipodecontrato().toString());
        comando.setDate(6, (Date) hj.getDatadecadastro());
        comando.setString(7, hj.getObsevacoes());
        comando.setString(8, hj.getCep());
        comando.setString(9, hj.getRua());
        comando.setInt(10, hj.getNumero());
        comando.setString(11, hj.getComplemento());
        comando.setString(12, hj.getBairro());
        comando.setString(13, hj.getEstado().toString());
        comando.setString(14, hj.getEmailcorporativo());
        comando.setString(15, hj.getFixo());
        comando.setString(16, hj.getPreferenciadecontato());
        comando.setString(17, hj.getResponsavelpeloofaturamento());
        comando.setString(18, hj.getCelular());
        comando.setString(19, hj.getNotasinternas());        
        comando.setString(20, hj.getLimetedecredito());
        comando.setString(21, hj.getInteresses());
        
        //Executa o comando
        comando.executeUpdate();
        
        //Fecha a conexão
        con.close();   
    }
    
    public void alterar(HospedeJuridicoDTO hj) throws Exception{
        //Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Conexão com o MySQL banco de dados **hotelaria**
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotelaria", "root", "");
        
        //Prepara o comando que quer executar DML (Data Manipulation Language)
        PreparedStatement comando =
            con.prepareStatement("update hospedejuridico set razaosocial=?, cnpj=?, inscricaoestadual=?,"
            + "status=?, tipodecontrato=?, datadecadastro=?, obsevacoes=?, cep=?, rua=?, numero=?, complemento=?,"
            + "bairro=?, estado=?, emailcorporativo=?, fixo=?, preferenciadecontato=?, responsavelpeloofaturamento=?,"
            + "celular=?, notasinternas=?, limetedecredito=?, interesses=? where id=?");
        
        //Substitui os valores dos sinais de interrogacao
        comando.setString(1, hj.getRazaosocial());
        comando.setString(2, hj.getCnpj());
        comando.setString(3, hj.getInscricaoestadual());
        comando.setString(4, hj.getStatus().toString());
        comando.setString(5, hj.getTipodecontrato().toString());
        comando.setDate(6, (Date) hj.getDatadecadastro());
        comando.setString(7, hj.getObsevacoes());
        comando.setString(8, hj.getCep());
        comando.setString(9, hj.getRua());
        comando.setInt(10, hj.getNumero());
        comando.setString(11, hj.getComplemento());
        comando.setString(12, hj.getBairro());
        comando.setString(13, hj.getEstado().toString());
        comando.setString(14, hj.getEmailcorporativo());
        comando.setString(15, hj.getFixo());
        comando.setString(16, hj.getPreferenciadecontato());
        comando.setString(17, hj.getResponsavelpeloofaturamento());
        comando.setString(18, hj.getCelular());
        comando.setString(19, hj.getNotasinternas());        
        comando.setString(20, hj.getLimetedecredito());
        comando.setString(21, hj.getInteresses());
        comando.setInt(22, hj.getId());
        
        //Executa o comando
        comando.executeUpdate();
        
        //Fecha a conexão
        con.close();           
    }
    
    public HospedeJuridicoDTO selecionar(int id) throws Exception{
        //Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Conexão com o MySQL banco de dados **hotelaria**
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotelaria", "root", "");
        
        //Preparando o comando DML
        PreparedStatement comando =
            con.prepareStatement("select * from hospedesjuridicos where id=?");
        
        comando.setInt(1, id);
        
        //Executa o comando e obtem a lista de resultado
        ResultSet rs = comando.executeQuery();
        
        if (rs.next()) {
            HospedeJuridicoDTO hj = new HospedeJuridicoDTO();
            hj.setId(rs.getInt("id"));
            hj.setRazaosocial(rs.getString("razaosocial"));
            hj.setCnpj(rs.getString("cnpj"));
            
            return hj;
        } else {
            return null;
        }
    
    }
    public List<HospedeJuridicoDTO> listar() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotelaria", "root", ""); 

        //Prepara o comando DML
        PreparedStatement comando = 
            con.prepareStatement("select * from hospedesjuridicos   order by razaosocial ");
        
        //Executa o comando e obtem a lista de resultado
        ResultSet rs = comando.executeQuery();

        List<HospedeJuridicoDTO> lista = new ArrayList();
        while (rs.next()){
            HospedeJuridicoDTO hj = new HospedeJuridicoDTO();
            hj.setId(rs.getInt("id"));
            hj.setRazaosocial(rs.getString("razaosocial"));
            hj.setCnpj(rs.getString("cnpj"));

            lista.add(hj);
        }
        
        con.close();

        return lista;
    }

    public List<HospedeJuridicoDTO> listar(String razaosocial) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
 
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotelaria", "root", ""); 

         PreparedStatement comando = 
            con.prepareStatement("select * from hospedesjuridicos where razaosocial like? "
            + "order by razaosocial ");

        comando.setString(1, razaosocial + "%");

        ResultSet rs = comando.executeQuery();

        List<HospedeJuridicoDTO> lista = new ArrayList();
        while (rs.next()){
            HospedeJuridicoDTO hj = new HospedeJuridicoDTO();
            hj.setId(rs.getInt("id"));
            hj.setRazaosocial(rs.getString("razaosocial"));
            hj.setCnpj(rs.getString("cnpj"));

            lista.add(hj);
        }
        
        con.close();

        return lista;
    }

    public void excluir(int id)throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
 
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotelaria", "root", ""); 

         PreparedStatement comando = 
            con.prepareStatement("delete from razaosocial where id =? ");

        comando.setInt(1, id);

        comando.executeUpdate();

        con.close();
    }
}







        

        

    




