/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.Quarto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author 202412170006
 */
public class QuartoDAO {
    public void inserir(Quarto tipo) throws Exception {
        //Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Conexão com o MySQL banco de dados **hotel**
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel", "root", "");
        
        //Prepara o comando que quer executar
        PreparedStatement comando =
            con.prepareStatement("insert into quartos(nome, descricao) values (1,2)");
        
        //Substitui os valores dos sinais de interrogação
        comando.setString(1, tipo.getNome());
        comando.setString(2, tipo.getDescricao());
        
        
        //Executa o comando
        comando.executeUpdate();
        
        
        //Fecha a conexão
        con.close();
    }
    
    public void alterar(Quarto tipo) throws Exception {}
     
    public Quarto selecionar (int id) throws Exception {
        return null;
    }
    
    public List <Quarto> listar() throws Exception {
        return null;
    }
    
    public List <Quarto> listar(String nome) throws Exception{
        return null;
    }
    
    public void excluir(int id) throws Exception{}
        
}
