/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.ProdutoDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author 202412170006
 */
public class ProdutoDAO {
    public void inserir(ProdutoDTO p)throws Exception{
        //Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Conexão com o MySQL banco de dados **hotelaria**
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotelaria", "root", "");
        
         
        //Prepara o comando que quer executar DML (Data Manipulation Language)
        PreparedStatement comando =
            con.prepareStatement("insert into cursos(nome, descricao, categoria, marca, codbarra,"
            +"qtdemestoque,  qtdestoqueminimo, qtdestoquemaximo, localizacaonoestoque, precocusto,"
            +"precovenda, desconto, fornecedor, datadefabricacao, datadevalidade, garantia, status,"
            +"observacoes) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        
        //Substitui os valores dos sinais de interrogação
        comando.setString(1, p.getNome());
        comando.setString(2, p.getDescricao());
        comando.setString(3, p.getCategoria().toString());
        comando.setString(4, p.getMarca());
        comando.setInt(5, p.getCodbarra());
        comando.setInt(6, p.getQtdemestoque());
        comando.setInt(7, p.getQtdestoqueminimo());
        comando.setInt(8, p.getQtdestoquemaximo());
        comando.setString(9, p.getLocalizacaonoestoque());
        comando.setBigDecimal(10, p.getPrecocusto());
        comando.setBigDecimal(11, p.getPrecovenda());
        comando.setBigDecimal(12, p.getDesconto());
        comando.setString(13, p.getFornecedor());
        comando.setDate(14, new java.sql.Date(p.getDatadefabricacao().getTime()));
        comando.setDate(15, new java.sql.Date(p.getDatadevalidade().getTime()));
        comando.setDouble(16, p.getGarantia());
        comando.setString(17, p.getStatus().toString());
        comando.setString(18, p.getObservacoes());
        
        //Executa o comando
        comando.executeUpdate();
        
        //Fecha a conexão
        con.close();
    }
    
    public void alterar(ProdutoDTO p)throws Exception{
        //Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Conexão com o MySQL banco de dados **hotelaria**
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotelaria", "root", "");
        
         
        //Prepara o comando que quer executar DML (Data Manipulation Language)
        PreparedStatement comando =
            con.prepareStatement("insert into cursos(nome= ?, descricao= ?, categoria= ?, marca= ?, codbarra= ?,"
            +"qtdemestoque= ?,  qtdestoqueminimo= ?, qtdestoquemaximo= ?, localizacaonoestoque= ?, precocusto= ?,"
            +"precovenda= ?, desconto= ?, fornecedor= ?, datadefabricacao= ?, datadevalidade= ?, garantia= ?, status= ?,observacoes= ? where= ?");
        
        //Substitui os valores dos sinais de interrogação
        comando.setString(1, p.getNome());
        comando.setString(2, p.getDescricao());
        comando.setString(3, p.getCategoria().toString());
        comando.setString(4, p.getMarca());
        comando.setInt(5, p.getCodbarra());
        comando.setInt(6, p.getQtdemestoque());
        comando.setInt(7, p.getQtdestoqueminimo());
        comando.setInt(8, p.getQtdestoquemaximo());
        comando.setString(9, p.getLocalizacaonoestoque());
        comando.setBigDecimal(10, p.getPrecocusto());
        comando.setBigDecimal(11, p.getPrecovenda());
        comando.setBigDecimal(12, p.getDesconto());
        comando.setString(13, p.getFornecedor());
        comando.setDate(14, new java.sql.Date(p.getDatadefabricacao().getTime()));
        comando.setDate(15, new java.sql.Date(p.getDatadevalidade().getTime()));
        comando.setDouble(16, p.getGarantia());
        comando.setString(17, p.getStatus().toString());
        comando.setString(18, p.getObservacoes());
        comando.setInt(19, p.getId());
        
        //Executa o comando
        comando.executeUpdate();
        
        //Fecha a conexão
        con.close();
    }
    
    public ProdutoDTO selecionar(int id)throws Exception{
        //Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Conexão com o MySQL banco de dados **hotelaria**
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotelaria", "root", "");
                
        //Prepara o comando que quer executar DML (Data Manipulation Language)
        PreparedStatement comando =
            con.prepareStatement("select * from produto where id = ?");
            
        comando.setInt(1, id);
        
        //Executa o comando e obtem a lista de resultado
        ResultSet rs  = comando.executeQuery();
        
        if (rs.next()) {
            ProdutoDTO p = new ProdutoDTO();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setDescricao(rs.getString("descricao"));
    
            return p;
        } else {
            return null;
        }
            
    }
    
    public List<ProdutoDTO> listar() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotelaria", "root", ""); 

        //Prepara o comando DML
        PreparedStatement comando = 
            con.prepareStatement("select * from produto order by nome");
        
        //Executa o comando e obtem a lista de resultado
        ResultSet rs = comando.executeQuery();
        
        List<ProdutoDTO> lista = new ArrayList();
        while (rs.next()){
            ProdutoDTO p = new ProdutoDTO();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setDescricao(rs.getString("descricao"));

            lista.add(p);
        }
        
        con.close();
        
        return lista;
    }
    
    public List<ProdutoDTO> listar(String nome) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotelaria", "root", ""); 

        //Prepara o comando DML
        PreparedStatement comando = 
            con.prepareStatement("select * from produto where nome like? order by nome");
        
        comando.setString(1, nome + "%");
        
        ResultSet rs = comando.executeQuery();
        
        List<ProdutoDTO> lista = new ArrayList();
        while (rs.next()){
            ProdutoDTO p = new ProdutoDTO();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setDescricao(rs.getString("descricao"));

            lista.add(p);
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
