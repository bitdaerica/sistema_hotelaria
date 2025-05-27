package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.ServicoDTO;
import java.math.BigDecimal;
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
            conn.prepareStatement("insert into servicos(codigoservico, nome, categoria, descricao, localpraestacao,"
                    + "tempomedioexecucao, statusservico, precobase, taxasadicionais, formapagamento,"
                    + "custooperacional, desconto, horariosdisponiveis, diassemana, capacidademaxima,"
                    + "antecedenciaminima, funcionarioesponsavel, recursosnecessarios, idadeMinima,"
                    + "acessibilidade, restricoessaude, obersevacoes"
                    + ") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        
        //Substitui os valores dos sinais de interrogação
        comando.setInt(1, s.getCodigoservico());
        comando.setString(2, s.getNome());
        comando.setString(3, s.getCategoria().name());
        comando.setString(4, s.getDescricao());
        comando.setString(5, s.getLocalprestacao());
        comando.setString(6, s.getTempomedioexecucao());
        comando.setString(7, s.getStatusservico().name());
        comando.setBigDecimal(8, s.getPrecobase());
        comando.setBigDecimal(9, s.getTaxasadicionais());
        comando.setString(10, s.getFormapagamento());
        comando.setBigDecimal(11, s.getCustooperacional());
        comando.setBigDecimal(12, s.getDesconto());
        comando.setString(13, s.getHorariosdisponiveis());
        comando.setString(14, s.getDiassemana());
        comando.setInt(15, s.getCapacidademaxima());
        comando.setInt(16, s.getAntecedenciaminima());
        comando.setString(17, s.getFuncionarioresponsavel());
        comando.setString(18, s.getRecursosnecessarios());
        comando.setInt(19, s.getIdademinima());
        comando.setString(20, s.getAcessibilidade());
        comando.setString(21, s.getAcessibilidade());
        comando.setString(22, s.getObservacoes());
        
        
        
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
            conn.prepareStatement("update servicos set codigoservico = ?, nome = ?, categoria = ?, descricao = ?,"
                    + "localprestacao = ?, tempomedioexecucao = ?, statusservico = ?, precobase = ?,"
                    + "taxasadicionais = ?, formapagamento = ?, custooperacional = ?, desconto = ?,"
                    + "funcionarioresponsavel = ?, recursosnecessarios = ?, idademinima = ?, acessibilidade = ?,"
                    + "restricoessaude = ?, observacoes = ? where id = ?");
        
        //Substitui os valores dos sinais de interrogação
    
        comando.setInt(1, s.getCodigoservico());
        comando.setString(2, s.getNome());
        comando.setString(3, s.getCategoria().name());
        comando.setString(4, s.getDescricao());
        comando.setString(5, s.getLocalprestacao());
        comando.setString(6, s.getTempomedioexecucao());
        comando.setString(7, s.getStatusservico().name());
        comando.setBigDecimal(8, s.getPrecobase());
        comando.setBigDecimal(9, s.getTaxasadicionais());
        comando.setString(10, s.getFormapagamento());
        comando.setBigDecimal(11, s.getCustooperacional());
        comando.setBigDecimal(12, s.getDesconto());
        comando.setString(13, s.getHorariosdisponiveis());
        comando.setString(14, s.getDiassemana());
        comando.setInt(15, s.getCapacidademaxima());
        comando.setInt(16, s.getAntecedenciaminima());
        comando.setString(17, s.getFuncionarioresponsavel());
        comando.setString(18, s.getRecursosnecessarios());
        comando.setInt(19, s.getIdademinima());
        comando.setString(20, s.getAcessibilidade());
        comando.setString(21, s.getAcessibilidade());
        comando.setString(22, s.getObservacoes());
        
        
        
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
            s.setIdServico(rs.getInt("idServico"));
            s.setNome(rs.getString("nome"));
            s.setDescricao(rs.getString("descricao"));
            
            return s;
        } else {
            return null;
        }

    }

    public List <ServicoDTO> listar() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel", "root", "");
        
        PreparedStatement comando =
                conn.prepareStatement("delete from cursos where id = ? ");
        return null;
    }
    
    public List <ServicoDTO> listar(String nome) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel", "root", "");
        
        PreparedStatement comando =
                conn.prepareStatement("delete from cursos where id = ? ");
        return null;
    }
    
    public void excluir(int id) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel", "root", "");
        
        PreparedStatement comando =
                conn.prepareStatement("delete from servi where servicos id = ? ");
        
        comando.setInt(1, id);
        
        comando.executeUpdate();
        
        conn.close();
    
    }
    
}