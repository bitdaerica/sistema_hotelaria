

package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.PessoaDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Érica_Almeida
 */
public class PessoaDAO {

    private final ConnectionFactoryDAO connectionFactory;

    public PessoaDAO() {
        this.connectionFactory = new ConnectionFactoryDAO();
    }

    // Método para inserir uma Pessoa
    public void inserir(PessoaDTO pessoa) throws SQLException {
        String sql = "INSERT INTO pessoa (email, fixo, celular, whatsapp, observacoes, idEndereco, rua, numero, complemento, bairro, cidade, estado, cep) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, pessoa.getEmail());
            pstm.setString(2, pessoa.getFixo());
            pstm.setString(3, pessoa.getCelular());
            pstm.setBoolean(4, pessoa.getWhatsapp());
            pstm.setString(5, pessoa.getObservacoes());
            pstm.setInt(6, pessoa.getIdEndereco());
            pstm.setString(7, pessoa.getRua());
            pstm.setString(8, pessoa.getNumero());
            pstm.setString(9, pessoa.getComplemento());
            pstm.setString(10, pessoa.getBairro());
            pstm.setString(11, pessoa.getCidade());
            pstm.setString(12, pessoa.getEstado().toString());
            pstm.setString(13, pessoa.getCep());

            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao inserir pessoa, nenhuma linha afetada.");
            }

            // Pegar o ID gerado e setar na pessoa DTO
            try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pessoa.setIdPessoa(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Método para buscar pessoa por ID
    public PessoaDTO buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM pessoa WHERE idPessoa = ?";
        PessoaDTO pessoa = null;

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    pessoa = new PessoaDTO();
                    pessoa.setIdPessoa(rs.getInt("idPessoa"));
                    pessoa.setEmail(rs.getString("email"));
                    pessoa.setFixo(rs.getString("fixo"));
                    pessoa.setCelular(rs.getString("celular"));
                    pessoa.setWhatsapp(rs.getBoolean("whatsapp"));
                    pessoa.setObservacoes(rs.getString("observacoes"));
                    pessoa.setIdEndereco(rs.getInt("idEndereco"));
                    pessoa.setRua(rs.getString("rua"));
                    pessoa.setNumero(rs.getString("numero"));
                    pessoa.setComplemento(rs.getString("complemento"));
                    pessoa.setBairro(rs.getString("bairro"));
                    pessoa.setCidade(rs.getString("cidade"));
                    pessoa.setEstado(Estado.valueOf(rs.getString("estado"))); // Estado enum
                    pessoa.setCep(rs.getString("cep"));
                }
            }
        }
        return pessoa;
    }

    // Método para atualizar Pessoa
    public void atualizar(PessoaDTO pessoa) throws SQLException {
        String sql = "UPDATE pessoa SET email=?, fixo=?, celular=?, whatsapp=?, observacoes=?, idEndereco=?, rua=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, cep=? WHERE idPessoa=?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, pessoa.getEmail());
            pstm.setString(2, pessoa.getFixo());
            pstm.setString(3, pessoa.getCelular());
            pstm.setBoolean(4, pessoa.getWhatsapp());
            pstm.setString(5, pessoa.getObservacoes());
            pstm.setInt(6, pessoa.getIdEndereco());
            pstm.setString(7, pessoa.getRua());
            pstm.setString(8, pessoa.getNumero());
            pstm.setString(9, pessoa.getComplemento());
            pstm.setString(10, pessoa.getBairro());
            pstm.setString(11, pessoa.getCidade());
            pstm.setString(12, pessoa.getEstado().toString());
            pstm.setString(13, pessoa.getCep());
            pstm.setInt(14, pessoa.getIdPessoa());

            pstm.executeUpdate();
        }
    }

    // Método para deletar Pessoa
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM pessoa WHERE idPessoa = ?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }
    }

    // Método para listar todas as pessoas
    public List<PessoaDTO> listarTodos() throws SQLException {
        List<PessoaDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";

        try (PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                PessoaDTO pessoa = new PessoaDTO();
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setFixo(rs.getString("fixo"));
                pessoa.setCelular(rs.getString("celular"));
                pessoa.setWhatsapp(rs.getBoolean("whatsapp"));
                pessoa.setObservacoes(rs.getString("observacoes"));
                pessoa.setIdEndereco(rs.getInt("idEndereco"));
                pessoa.setRua(rs.getString("rua"));
                pessoa.setNumero(rs.getString("numero"));
                pessoa.setComplemento(rs.getString("complemento"));
                pessoa.setBairro(rs.getString("bairro"));
                pessoa.setCidade(rs.getString("cidade"));
                pessoa.setEstado(Estado.valueOf(rs.getString("estado")));
                pessoa.setCep(rs.getString("cep"));

                lista.add(pessoa);
            }
        }
        return lista;
    }
}
