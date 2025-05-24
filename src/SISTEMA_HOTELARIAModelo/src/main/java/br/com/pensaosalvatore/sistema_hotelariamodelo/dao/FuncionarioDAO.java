
package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author 202412170006
 */
public class FuncionarioDAO {
    
    public void inserir(Funcionario f) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306//hotelaria","root","");
        
        PreparedStatement comando = con.prepareStatement("insert into funcionarios (nome, sobrenome, datadenascimento, cpf, rg, estadocivil, naturalidade, genero, nomedamae, nomedopai, cep, rua,complemento, bairro, estado, email, celular, fixo, matricula, datadeadimissao, jornadadetrabalho, regimedecontratacao, status, salariobase, numerodopis, ctps, historico, comentariodagestao, nomeusuario, senha, graudeacesso) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
        
        comando.setString(1, f.getNome());
        comando.setString(2, f.getSobrenome());
        comando.setDate(3, new java.sql.Date(f.getDatadenascimento().getTime()));
        comando.setString(4, f.getCpf());
        comando.setInt(5, f.getRg());
        comando.setString(6, f.getEstadocivil().toString());
        comando.setString(7, f.getNaturalidade());
        comando.setString(8, f.getGenero().toString());
        comando.setString(9, f.getNomedamae());
        comando.setString(10, f.getNomedopai());
        comando.setString(11, f.getCep());
        comando.setString(12, f.getRua());
        comando.setInt(13, f.getNumero());
        comando.setString(14, f.getComplemento());
        comando.setString(15, f.getBairro());
        comando.setString(16, f.getEstado().toString());
        comando.setString(17, f.getEmail());
        comando.setString(18, f.getCelular());
        comando.setString(19, f.getFixo());
        comando.setInt(20, f.getMatricula());
        comando.setDate(21, new java.sql.Date(f.getDatadeadmissao().getTime()));
        comando.setString(22, f.getJornadadetrabalho());
        comando.setString(23, f.getRegimedecontratacao().toString());
        comando.setString(24, f.getStatus().toString());
        comando.setInt(25, f.getSalariobase());
        comando.setString(26, f.getNumerodopis());
        comando.setString(27, f.getCtps());
        comando.setString(28, f.getObservacoesgerais());
        comando.setString(29, f.getHistorico());
        comando.setString(30, f.getComentariosdagestao());
        comando.setString(31, f.getNomeusuario());
        comando.setString(32, f.getSenha());
        comando.setString(33, f.getGraudeacesso().toString());
        
        comando.executeUpdate();
        con.close();
        
        
    }
    


    public void alterar(Funcionario f) throws Exception{
   
        Class.forName("com.mysql.cj.jdbc.Driver");
    
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306//hotelaria","root","");
    
         PreparedStatement comando = con.prepareStatement(
            "update funcionarios set nome =?, sobrenome = ?,"
                    + " datadenascimento = ?, cpf = ?, rg = ?, estadocivil = ?,"
                    + " naturalidade = ?, genero = ?, nomedamae = ?, nomedopai = ?, cep = ?, rua = ?,complemento = ?, bairro =?, estado = ?, email = ?, celular = ?, fixo = ?, matricula = ?, datadeadimissao = ?, jornadadetrabalho = ?, regimedecontratacao = ?, status = ?, salariobase = ?, numerodopis = ?, ctps = ?, historico = ?, comentariodagestao = ?, nomeusuario = ?, senha = ?, graudeacesso = ? where id = ?");
        
         comando.setString(1, f.getNome());
         comando.setString(2, f.getSobrenome());
         comando.setDate(3, new java.sql.Date(f.getDatadenascimento().getTime()));
         comando.setString(4, f.getCpf());
         comando.setInt(5, f.getRg());
        comando.setString(6, f.getEstadocivil().toString());
        comando.setString(7, f.getNaturalidade());
        comando.setString(8, f.getGenero().toString());
        comando.setString(9, f.getNomedamae());
        comando.setString(10, f.getNomedopai());
        comando.setString(11, f.getCep());
        comando.setString(12, f.getRua());
        comando.setInt(13, f.getNumero());
        comando.setString(14, f.getComplemento());
        comando.setString(15, f.getBairro());
        comando.setString(16, f.getEstado().toString());
        comando.setString(17, f.getEmail());
        comando.setString(18, f.getCelular());
        comando.setString(19, f.getFixo());
        comando.setInt(20, f.getMatricula());
        comando.setDate(21, new java.sql.Date(f.getDatadeadmissao().getTime()));
        comando.setString(22, f.getJornadadetrabalho());
        comando.setString(23, f.getRegimedecontratacao().toString());
        comando.setString(24, f.getStatus().toString());
        comando.setInt(25, f.getSalariobase());
        comando.setString(26, f.getNumerodopis());
        comando.setString(27, f.getCtps());
        comando.setString(28, f.getObservacoesgerais());
        comando.setString(29, f.getHistorico());
        comando.setString(30, f.getComentariosdagestao());
        comando.setString(31, f.getNomeusuario());
        comando.setString(32, f.getSenha());
        comando.setString(33, f.getGraudeacesso().toString());
        
        
        comando.executeUpdate();
        
        con .close();
        
      
}

    public Funcionario selecionar(int id) throws Exception{
    
        Class.forName("com.mysql.cj.jdbc.Driver");
    
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotelaria","root","");
    
        PreparedStatement comando = 
            con.prepareStatement("select * from funcionarios where id = ?");
    
        comando.setInt(1, id);
    
        ResultSet rs = comando.executeQuery();
    
        if (rs.next()){
            Funcionario f = new Funcionario();
            f.setId(rs.getInt("id"));
        
        
        
            return f;
        }else{
            return null;
        }  
        
}


}
    
 
    
    
    
   



       