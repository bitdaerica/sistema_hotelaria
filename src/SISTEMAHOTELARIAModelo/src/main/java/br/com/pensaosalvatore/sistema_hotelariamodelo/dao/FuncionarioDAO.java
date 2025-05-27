package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.CargoFuncionario;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.DepartamentoFuncionario;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.StatusFuncionario;
import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 202412170006
 */
public class FuncionarioDAO {

    private final ConnectionFactoryDAO connectionFactory = new ConnectionFactoryDAO();

    public void inserirFuncionario(FuncionarioDTO f) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sqlEndereco = "INSERT INTO ENDERECO (RUA, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO, CEP) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, f.getRua());
            pstm.setString(2, f.getNumero());
            pstm.setString(3, f.getComplemento());
            pstm.setString(4, f.getBairro());
            pstm.setString(5, f.getCidade());
            pstm.setString(6, f.getEstado().name()); 
            pstm.setString(7, f.getCep());
            pstm.executeUpdate();

            rs = pstm.getGeneratedKeys();
            int idEndereco = 0;

            if (rs.next()) {
                idEndereco = rs.getInt(1);
            }

            pstm.close();

            rs.close();

            String sqlPessoa = "INSERT INTO PESSOA (EMAIL, FIXO, CELULAR, WHATSAPP, OBSERVACOES, ID_ENDERECO) VALUES (?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, f.getEmail());
            pstm.setString(2, f.getFixo());
            pstm.setString(3, f.getCelular());
            pstm.setBoolean(4, f.getWhatsapp());
            pstm.setString(5, f.getObservacoes());
            pstm.setInt(6, idEndereco);
            pstm.executeUpdate();

            rs = pstm.getGeneratedKeys();
            int idPessoa = 0;

            if (rs.next()) {
                idPessoa = rs.getInt(1);
            }

            pstm.close();

            rs.close();

            String sqlFuncionario = "INSERT INTO FUNCIONARIO (NOME, SOBRENOME, DATA_NASCIMENTO, GENERO, CPF, RG, NATURALIDADE,"
                    + "ESTADO_CIVIL, FOTO, NOME_MAE, NOME_PAI, MATRICULA, CARGO, DEPARTAMENTO, DATA_ADMISSAO, JORNADA_TRABALHO, "
                    + "REGIME_CONTRATACAO, STATUS_FUNCIONARIO, SALARIO_BASE, NUMERO_PIS, CTPS, HISTORICO, COMENTARIO_GESTAO, NOME_USUARIO,"
                    + " SENHA, GRAUDEACESSO, ID_PESSOA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(sqlFuncionario);

            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getSobrenome());
            pstm.setDate(3, new java.sql.Date(f.getDatadenascimento().getTime()));
            pstm.setString(4, f.getGenero().name());
            pstm.setString(5, f.getCpf());
            pstm.setString(6, f.getRg());
            pstm.setString(7, f.getNaturalidade());
            pstm.setString(8, f.getEstadocivil().name());
            pstm.setString(9, f.getFoto());
            pstm.setString(10, f.getNomedamae());
            pstm.setString(11, f.getNomedopai());
            pstm.setString(12, f.getCargo().name());
            pstm.setString(13, f.getDepartamento().name());
            pstm.setDate(14, new java.sql.Date(f.getDatadeadmissao().getTime()));
            pstm.setInt(15, f.getJornadadetrabalho());
            pstm.setString(16, f.getRegimedecontratacao().name());
            pstm.setString(17, f.getStatus().name());
            pstm.setBigDecimal(18, f.getSalariobase());
            pstm.setString(19, f.getNumerodopis());
            pstm.setString(20, f.getCtps());
            pstm.setString(21, f.getHistorico());
            pstm.setString(22, f.getComentariosdagestao());
            pstm.setString(23, f.getNomeusuario());
            pstm.setString(24, f.getSenha());
            pstm.setString(25, f.getGraudeacesso().toString());
            pstm.setInt(26, idPessoa);

            pstm.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public void alterarFuncionario(FuncionarioDTO f) throws SQLException {

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sqlEndereco = "UPDATE ENDERECO SET RUA =  ?, NUMERO =  ?, COMPLEMENTO =  ?, BAIRRO =  ?, CIDADE =  ?, ESTADO =  ?, CEP = ? WHERE  ID = ?";
            pstm = conn.prepareStatement(sqlEndereco);
            pstm.setString(1, f.getRua());
            pstm.setString(2, f.getNumero());
            pstm.setString(3, f.getComplemento());
            pstm.setString(4, f.getBairro());
            pstm.setString(5, f.getCidade());
            pstm.setString(6, f.getEstado().name());
            pstm.setString(7, f.getCep());
            pstm.setInt(8, f.getIdEndereco());

            pstm.executeUpdate();

            pstm.close();

            String sqlPessoa = "UPDATE PESSOA SET EMAIL = ?, FIXO = ?, CELULAR = ?, WHATSAPP = ?, OBSERVACOES = ?, WHERE ID = ?";
            pstm = conn.prepareStatement(sqlPessoa);
            pstm.setString(1, f.getEmail());
            pstm.setString(2, f.getFixo());
            pstm.setString(3, f.getCelular());
            pstm.setBoolean(4, f.getWhatsapp());
            pstm.setString(5, f.getObservacoes());
            pstm.setInt(6, f.getIdPessoa());

            pstm.executeUpdate();

            pstm.close();

            String sqlFuncionario = "UPDATE FUNCIONARIO SET NOME = ?, SOBRENOME = ?, DATA_NASCIMENTO = ?, GENERO = ?, CPF = ?, RG = ?, NATURALIDADE = ?, ESTADO_CIVIL = ?, FOTO = ?, NOME_MAE = ?, NOME_PAI = ?, MATRICULA = ?, CARGO = ?, DEPARTAMENTO = ?, DATA_ADMISSAO = ?, JORNADA_TRABALHO = ?, REGIME_CONTRATACAO = ?, STATUS_FUNCIONARIO = ?, SALARIO_BASE = ?, NUMERO_PIS = ?, CTPS = ?, HISTORICO = ?, COMENTARIO_GESTAO = ?, NOME_USUARIO = ?, SENHA = ?, GRAUDEACESSO = ? WHERE ID = ?";
            pstm = conn.prepareStatement(sqlFuncionario);

            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getSobrenome());
            pstm.setDate(3, new java.sql.Date(f.getDatadenascimento().getTime()));
            pstm.setString(4, f.getGenero().name());
            pstm.setString(5, f.getCpf());
            pstm.setString(6, f.getRg());
            pstm.setString(7, f.getNaturalidade());
            pstm.setString(8, f.getEstadocivil().name());
            pstm.setString(9, f.getFoto());
            pstm.setString(10, f.getNomedamae());
            pstm.setString(11, f.getNomedopai());
            pstm.setString(12, f.getCargo().name());
            pstm.setString(13, f.getDepartamento().name());
            pstm.setDate(14, new java.sql.Date(f.getDatadeadmissao().getTime()));
            pstm.setInt(15, f.getJornadadetrabalho());
            pstm.setString(16, f.getRegimedecontratacao().name());
            pstm.setString(17, f.getStatus().name());
            pstm.setBigDecimal(18, f.getSalariobase());
            pstm.setString(19, f.getNumerodopis());
            pstm.setString(20, f.getCtps());
            pstm.setString(21, f.getHistorico());
            pstm.setString(22, f.getComentariosdagestao());
            pstm.setString(23, f.getNomeusuario());
            pstm.setString(24, f.getSenha());
            pstm.setString(25, f.getGraudeacesso().toString());
            pstm.setInt(26, f.getIdFuncionario());

            pstm.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public FuncionarioDTO selecionarPorId(int idFuncionario) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        FuncionarioDTO funcionario = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = "SELECT * FROM FUNCIONARIO WHERE ID = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idFuncionario);
            rs = pstm.executeQuery();

            if (rs.next()) {
                funcionario = new FuncionarioDTO();
                funcionario.setIdFuncionario(rs.getInt("ID"));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setSobrenome(rs.getString("SOBRENOME"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setRg(rs.getString("RG"));
                funcionario.setCargo(CargoFuncionario.valueOf(rs.getString("CARGO")));
                funcionario.setDepartamento(DepartamentoFuncionario.valueOf(rs.getString("DEPARTAMENTO")));
                funcionario.setStatus(StatusFuncionario.valueOf(rs.getString("STATUS_FUNCIONARIO")));
                
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return funcionario;
    }

    public List<FuncionarioDTO> listarTodos() throws SQLException {
        List<FuncionarioDTO> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = "SELECT * FROM FUNCIONARIO";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FuncionarioDTO funcionario = new FuncionarioDTO();
                funcionario.setIdFuncionario(rs.getInt("ID"));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setSobrenome(rs.getString("SOBRENOME"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setRg(rs.getString("RG"));
                funcionario.setCargo(CargoFuncionario.valueOf(rs.getString("CARGO")));
                funcionario.setDepartamento(DepartamentoFuncionario.valueOf(rs.getString("DEPARTAMENTO")));
                funcionario.setStatus(StatusFuncionario.valueOf(rs.getString("STATUS_FUNCIONARIO")));
                

                lista.add(funcionario);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return lista;
    }

    public List<FuncionarioDTO> listarPorNome(String nome) throws SQLException {
        List<FuncionarioDTO> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = "SELECT * FROM FUNCIONARIO WHERE NOME LIKE ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();

            while (rs.next()) {
                FuncionarioDTO funcionario = new FuncionarioDTO();
                funcionario.setIdFuncionario(rs.getInt("ID"));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setSobrenome(rs.getString("SOBRENOME"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setRg(rs.getString("RG"));
                funcionario.setCargo(CargoFuncionario.valueOf(rs.getString("CARGO")));
                funcionario.setDepartamento(DepartamentoFuncionario.valueOf(rs.getString("DEPARTAMENTO")));
                funcionario.setStatus(StatusFuncionario.valueOf(rs.getString("STATUS_FUNCIONARIO")));
                

                lista.add(funcionario);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return lista;
    }

    public void excluirFuncionario(int idFuncionario) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sql = "DELETE FROM FUNCIONARIO WHERE IdFuncionario = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idFuncionario);
            pstm.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

}
