package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.ServicoDTO;
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
    public void inserir(ServicoDTO s) throws Exception {
        //Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Conexão com o MySQL banco de dados **hotel**
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel", "root", "");
        
        //Prepara o comando que quer executar
        PreparedStatement comando =
            conn.prepareStatement("insert into servicos(nome, descricao) values (1,2)");
        
        //Substitui os valores dos sinais de interrogação
        comando.setString(1, s.getNome());
        comando.setString(2, s.getDescricao());
        
        
        //Executa o comando
        comando.executeUpdate();
        
        
        //Fecha a conexão
        conn.close();
    }
    

    public void alterar(ServicoDTO s) throws Exception {
                //Preparando para conectar com Sistema de Gerenciamento de Banco de Dados (SGBD)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Conexão com o MySQL banco de dados **hotel**
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel", "root", "");
        
        //Prepara o comando que quer executar
        PreparedStatement comando =
            conn.prepareStatement("update servicos set nome = ?, descricao = ?, where id = ?");
        
        //Substitui os valores dos sinais de interrogação
        comando.setString(1, s.getNome());
        comando.setString(2, s.getDescricao());
        
        
        //Executa o comando
        comando.executeUpdate();
        
        
        //Fecha a conexão
        conn.close();
    }

    public ServicoDTO selecionar (int id) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel", "root", "");
        
        PreparedStatement comando =
                con.prepareStatement("select from cursos where id = ? ");
        
        comando.setInt(1, id);
        
        ResultSet rs =comando.executeQuery();
        
        if (rs.next()){
            ServicoDTO s = new ServicoDTO();
            s.setId(rs.getInt("id"));
            s.setNome(rs.getString("nome"));
            s.setDescricao(rs.getString("descricao"));
            
            return s;
        } else {
            return null;
        }

    }

    public List <ServicoDTO> listar() throws Exception {
        return null;
    }
    
    public List <ServicoDTO> listar(String nome) throws Exception{
        return null;
    }
    
    public void excluir(int id) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel", "root", "");
        
        PreparedStatement comando =
                conn.prepareStatement("delete from cursos where id = ? ");
        
        comando.setInt(1, id);
        
        comando.executeUpdate();
        
        conn.close();
    
    }
    
}