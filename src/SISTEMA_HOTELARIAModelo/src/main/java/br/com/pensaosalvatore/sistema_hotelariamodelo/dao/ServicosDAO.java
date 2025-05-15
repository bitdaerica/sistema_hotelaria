package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.Servicos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author 202412170006
 */
public class ServicosDAO {
    public void inserir(Servicos lavanderia) throws Exception {}
    public void inserir(Servicos lavanderia) throws Exception {
        //Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Conexão com o MySQL banco de dados **hotel**
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel", "root", "");
        
        //Prepara o comando que quer executar
        PreparedStatement comando =
            con.prepareStatement("insert into servicos(nome, descricao) values (1,2)");
        
        //Substitui os valores dos sinais de interrogação
        comando.setString(1, lavanderia.getNome());
        comando.setString(2, lavanderia.getDescricao());
        
        
        //Executa o comando
        comando.executeUpdate();
        
        
        //Fecha a conexão
        con.close();
    }
    
    public void alterar(Servicos lavanderia) throws Exception {

    public void alterar(Servicos lavanderia) throws Exception {}
                //Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Conexão com o MySQL banco de dados **hotel**
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel", "root", "");
        
        //Prepara o comando que quer executar
        PreparedStatement comando =
            con.prepareStatement("update servicos set nome = ?, descricao = ?, where id = ?");
        
        //Substitui os valores dos sinais de interrogação
        comando.setString(1, lavanderia.getNome());
        comando.setString(2, lavanderia.getDescricao());
        
        
        //Executa o comando
        comando.executeUpdate();
        
        
        //Fecha a conexão
        con.close();
    }

    public Servicos selecionar (int id) throws Exception {
        return null;