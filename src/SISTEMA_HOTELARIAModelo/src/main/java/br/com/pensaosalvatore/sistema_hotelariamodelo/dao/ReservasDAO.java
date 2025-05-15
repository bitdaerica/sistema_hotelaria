

package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.Reservas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author 202412170006
 */
public class ReservasDAO {
    public void inserir(Reservas status) throws Exception {
        //Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Conexão com o MySQL banco de dados **hotel**
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel", "root", "");
        
        //Prepara o comando que quer executar
        PreparedStatement comando =
            con.prepareStatement("insert into reservas(nome, descricao) values (1,2)");
        
        //Substitui os valores dos sinais de interrogação
        comando.setString(1, status.getNome());
        comando.setString(2, status.getDescricao());
        
        
        //Executa o comando
        comando.executeUpdate();
        
        
        //Fecha a conexão
        con.close();
    }
    
    public void alterar(Reservas status) throws Exception {
        //Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Conexão com o MySQL banco de dados **hotel**
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel", "root", "");
        
        //Prepara o comando que quer executar
        PreparedStatement comando =
            con.prepareStatement("update reservas set nome = ?, descricao = ?, where id = ?");
        
        //Substitui os valores dos sinais de interrogação
        comando.setString(1, status.getNome());
        comando.setString(2, status.getDescricao());
        
        
        //Executa o comando
        comando.executeUpdate();
        
        
        //Fecha a conexão
        con.close();    
    }
     
    public Reservas selecionar (int id) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel", "root", "");
        
        PreparedStatement comando =
                con.prepareStatement("select from cursos where id = ? ");
        
        comando.setInt(1, id);
        
        ResultSet rs = comando.executeQuery();
        
        if (rs.next()){
            Reservas status = new Reservas();
            status.setId(rs.getInt("id"));
            status.setNome(rs.getString("nome"));
            status.setDescricao(rs.getString("descricao"));
            
            return status;
        } else {
            return null;
        }
    }
    
    public List <Reservas> listar() throws Exception {
        return null;
    }
    
    public List <Reservas> listar(String nome) throws Exception{
        return null;
    }
    
    public void excluir(int id) throws Exception{}


    
}
