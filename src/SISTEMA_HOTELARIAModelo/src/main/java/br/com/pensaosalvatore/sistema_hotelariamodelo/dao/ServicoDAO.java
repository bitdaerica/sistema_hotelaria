package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.Servico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author 202412170006
 */
public class ServicoDAO{
    public void inserir(Servico lavanderia) throws Exception {
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
    

    public void alterar(Servico lavanderia) throws Exception {
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

    public Servico selecionar (int id) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel", "root", "");
        
        PreparedStatement comando =
                con.prepareStatement("select from cursos where id = ? ");
        
        comando.setInt(1, id);
        
        ResultSet rs =comando.executeQuery();
        
        if (rs.next()){
            Servico lavanderia = new Servico();
            lavanderia.setId(rs.getInt("id"));
            lavanderia.setNome(rs.getString("nome"));
            lavanderia.setDescricao(rs.getString("descricao"));
            
            return lavanderia;
        } else {
            return null;
        }

    }

    public List <Servico> listar() throws Exception {
        return null;
    }
    
    public List <Servico> listar(String nome) throws Exception{
        return null;
    }
    
    public void excluir(int id) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel", "root", "");
        
        PreparedStatement comando =
                con.prepareStatement("delete from cursos where id = ? ");
        
        comando.setInt(1, id);
        
        comando.executeUpdate();
        
        con.close();
    
    }
    
}