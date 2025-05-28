package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Genero;
import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.EnderecoDTO;
import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.PessoaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Érica_Almeida
 */
public class PessoaDAO {

    private final ConnectionFactoryDAO connectionFactory = new ConnectionFactoryDAO();
    private final EnderecoDAO enderecoDAO;

    public PessoaDAO() {
        this.enderecoDAO = new EnderecoDAO();
    }

    public void inserirPessoa(PessoaDTO p) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sqlPessoa = "INSERT INTO PESSOA (nome, genero, datanascimento, cpf, email, fixo, celular, whatsapp,"
                    + " observacoes, endereco_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getGenero().toString());
            pstm.setDate(3, new java.sql.Date(p.getDataNascimento().getTime()));
            pstm.setString(4, p.getCpf());
            pstm.setString(5, p.getEmail());
            pstm.setString(6, p.getFixo());
            pstm.setString(7, p.getCelular());
            pstm.setBoolean(8, p.getWhatsapp());
            pstm.setString(9, p.getObservacoes());
            pstm.setInt(10, p.getEndereco().getId());

            pstm.executeUpdate();

            conn.commit();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                int idPessoa = -1;
                if (rs.next()) {
                    idPessoa = rs.getInt(1); // 1 representa a primeira coluna do resultado
                    p.setId(idPessoa);
                }
            }

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

    public void alterarPessoa(PessoaDTO p) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sqlPessoa = "UPDATE PESSOA SET nome = ?, genero = ?, datanascimento = ?, cpf = ?,"
                    + " email = ?, fixo = ?, celular = ?, whatsapp = ?, observacoes = ?, endereco_id = ? WHERE id = ?";
            pstm = conn.prepareStatement(sqlPessoa);
            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getGenero().toString());
            pstm.setDate(3, new java.sql.Date(p.getDataNascimento().getTime()));
            pstm.setString(4, p.getCpf());
            pstm.setString(5, p.getEmail());
            pstm.setString(6, p.getFixo());
            pstm.setString(7, p.getCelular());
            pstm.setBoolean(8, p.getWhatsapp());
            pstm.setString(9, p.getObservacoes());
            pstm.setInt(10, p.getEndereco().getId());

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

    public PessoaDTO selecionarPorId(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        PessoaDTO pessoa = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = "SELECT * FROM PESSOA WHERE ID = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                pessoa = new PessoaDTO () ;
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setGenero(Genero.valueOf(rs.getString("genero")));
                pessoa.setDataNascimento(rs.getDate("datanascimento"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setFixo(rs.getString("fixo"));
                pessoa.setCelular(rs.getString("celular"));
                pessoa.setWhatsapp(rs.getBoolean("whatsapp"));
                pessoa.setObservacoes(rs.getString("observacoes"));

                int enderecoId = rs.getInt("endereco_id");
                EnderecoDTO endereco = enderecoDAO.buscarPorId(enderecoId);
                pessoa.setEndereco(endereco);
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
        return pessoa;
    }

    public List<PessoaDTO> listarTodos() throws SQLException {
        List<PessoaDTO> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();
            String sql = "SELECT * FROM PESSOA";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                PessoaDTO pessoa = new PessoaDTO();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setGenero(Genero.valueOf(rs.getString("genero")));
                pessoa.setDataNascimento(rs.getDate("datanascimento"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setFixo(rs.getString("fixo"));
                pessoa.setCelular(rs.getString("celular"));
                pessoa.setWhatsapp(rs.getBoolean("whatsapp"));
                pessoa.setObservacoes(rs.getString("observacoes"));

                int enderecoId = rs.getInt("endereco_id");
                EnderecoDTO endereco = enderecoDAO.buscarPorId(enderecoId);
                pessoa.setEndereco(endereco);

                lista.add(pessoa);
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

    public List<PessoaDTO> listarPorNome(String nome) throws SQLException {
        List< PessoaDTO> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();

            String sql = "SELECT * FROM PESSOA WHERE NOME LIKE ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();

            while (rs.next()) {
                PessoaDTO pessoa = new PessoaDTO() {
                };
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setGenero(Genero.valueOf(rs.getString("genero")));
                pessoa.setDataNascimento(rs.getDate("datanascimento"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setFixo(rs.getString("fixo"));
                pessoa.setCelular(rs.getString("celular"));
                pessoa.setWhatsapp(rs.getBoolean("whatsapp"));
                pessoa.setObservacoes(rs.getString("observacoes"));

                int enderecoId = rs.getInt("endereco_id");
                EnderecoDTO endereco = enderecoDAO.buscarPorId(enderecoId);
                pessoa.setEndereco(endereco);

                lista.add(pessoa);
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

    public void excluirPessoa(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();
            conn.setAutoCommit(false);

            String sql = "DELETE FROM PESSOA WHERE Id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
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
