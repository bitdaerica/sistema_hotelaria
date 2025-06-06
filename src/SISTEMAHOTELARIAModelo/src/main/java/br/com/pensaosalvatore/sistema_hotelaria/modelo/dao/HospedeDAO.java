package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Endereco;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Hospede;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) Create-Retrive-Update-Delete (CRUD)
 *
 * @author 202412170006
 */
public class HospedeDAO {

    private final Connection connection;

    public HospedeDAO(Connection connection) {
        if (connection == null) {
            throw new IllegalArgumentException("Connection não pode ser nula");
        }
        this.connection = connection;
    }

    // Inserir hospede (e pessoa vinculada)
    public void inserir(Hospede hospede) throws SQLException {
        String sqlPessoa = "INSERT INTO pessoas (nome, genero, data_nascimento, cpf, email, fixo, celular, whatsapp, observacoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlEndereco = "INSERT INTO enderecos (rua, numero, complemento, bairro, cidade, estado, cep, id_pessoas) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlHospede = "INSERT INTO hospedes (id, nacionalidade, profissao, data_cadastro) VALUES (?, ?, ?, ?)";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement pstmtPessoa = connection.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS); PreparedStatement pstmtEndereco = connection.prepareStatement(sqlEndereco); PreparedStatement pstmtHospede = connection.prepareStatement(sqlHospede)) {

                // Inserir pessoa
                pstmtPessoa.setString(1, hospede.getNome());
                pstmtPessoa.setString(2, hospede.getGenero());
                pstmtPessoa.setDate(3, Date.valueOf(hospede.getDatanascimento()));
                pstmtPessoa.setString(4, hospede.getCpf());
                pstmtPessoa.setString(5, hospede.getEmail());
                pstmtPessoa.setString(6, hospede.getFixo());
                pstmtPessoa.setString(7, hospede.getCelular());
                pstmtPessoa.setBoolean(8, hospede.getWhatsapp());
                pstmtPessoa.setString(9, hospede.getObservacoes());

                pstmtPessoa.executeUpdate();

                // Obter o ID gerado para a pessoa
                int idPessoa;
                try (ResultSet rs = pstmtPessoa.getGeneratedKeys()) {
                    if (!rs.next()) {
                        throw new SQLException("Falha ao gerar ID de pessoa");
                    }
                    idPessoa = rs.getInt(1);
                }

                // Inserir endereço
                Endereco endereco = hospede.getEndereco();
                pstmtEndereco.setString(1, endereco.getRua());
                pstmtEndereco.setString(2, endereco.getNumero());
                pstmtEndereco.setString(3, endereco.getComplemento());
                pstmtEndereco.setString(4, endereco.getBairro());
                pstmtEndereco.setString(5, endereco.getCidade());
                pstmtEndereco.setString(6, endereco.getEstado());
                pstmtEndereco.setString(7, endereco.getCep());
                pstmtEndereco.setInt(8, idPessoa);
                pstmtEndereco.executeUpdate();

                // Inserir hospede
                pstmtHospede.setInt(1, idPessoa);
                pstmtHospede.setString(2, hospede.getNacionalidade());
                pstmtHospede.setString(3, hospede.getProfissao());
                pstmtHospede.setDate(4, Date.valueOf(hospede.getDatacadastro()));

                pstmtHospede.executeUpdate();

                connection.commit();
            }
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);

        }
    }

    // Alterar hospede
    public void alterar(Hospede hospede) throws SQLException {
        String sqlPessoa = "UPDATE pessoas SET nome = ?, genero = ?, data_nascimento = ?, cpf = ?, email = ?, fixo = ?, celular = ?, whatsapp = ?, observacoes = ? WHERE id = ?";
        String sqlEndereco = "UPDATE enderecos SET rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, cep = ? WHERE id_pessoas = ?";
        String sqlHospede = "UPDATE hospedes SET nacionalidade = ?, profissao = ?, data_cadastro = ? WHERE id_pessoas = ?";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement pstmtPessoa = connection.prepareStatement(sqlPessoa); PreparedStatement pstmtEndereco = connection.prepareStatement(sqlEndereco); PreparedStatement pstmtHospede = connection.prepareStatement(sqlHospede)) {

                // Atualizar pessoa
                pstmtPessoa.setString(1, hospede.getNome());
                pstmtPessoa.setString(2, hospede.getGenero());
                pstmtPessoa.setDate(3, Date.valueOf(hospede.getDatanascimento()));
                pstmtPessoa.setString(4, hospede.getCpf());
                pstmtPessoa.setString(5, hospede.getEmail());
                pstmtPessoa.setString(6, hospede.getFixo());
                pstmtPessoa.setString(7, hospede.getCelular());
                pstmtPessoa.setBoolean(8, hospede.getWhatsapp());
                pstmtPessoa.setString(9, hospede.getObservacoes());
                pstmtPessoa.setInt(10, hospede.getId());
                pstmtPessoa.executeUpdate();

                // Atualizar endereço
                Endereco endereco = hospede.getEndereco();
                pstmtEndereco.setString(1, endereco.getRua());
                pstmtEndereco.setString(2, endereco.getNumero());
                pstmtEndereco.setString(3, endereco.getComplemento());
                pstmtEndereco.setString(4, endereco.getBairro());
                pstmtEndereco.setString(5, endereco.getCidade());
                pstmtEndereco.setString(6, endereco.getEstado());
                pstmtEndereco.setString(7, endereco.getCep());
                pstmtEndereco.setInt(8, hospede.getId());
                pstmtEndereco.executeUpdate();

                // Atualizar hospede
                pstmtHospede.setString(1, hospede.getNacionalidade());
                pstmtHospede.setString(2, hospede.getProfissao());
                pstmtHospede.setDate(3, Date.valueOf(hospede.getDatacadastro()));
                pstmtHospede.setInt(4, hospede.getId());
                pstmtHospede.executeUpdate();

                connection.commit();
            }
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    // Selecionar hospede por ID
    public Hospede selecionarPorId(int id) throws SQLException {
        String sql = "SELECT p.*, h.nacionalidade, h.profissao, h.data_cadastro, e.* FROM pessoas p "
                + "JOIN hospedes h ON p.id = h.id "
                + "JOIN enderecos e ON p.id = e.id_pessoas "
                + "WHERE p.id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapearHospede(rs);
                }
            }
        }
        return null;
    }

    // Listar todos os hospedes
    public List<Hospede> listarTodos() throws SQLException {
        List<Hospede> hospedes = new ArrayList<>();
        String sql = "SELECT p.*, h.nacionalidade, h.profissao, h.data_cadastro, e.* FROM pessoas p "
                + "JOIN hospedes h ON p.id = h.id "
                + "JOIN enderecos e ON p.id = e.id_pessoas ";

        try (PreparedStatement pstmt = connection.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                hospedes.add(mapearHospede(rs));
            }
        }
        return hospedes;
    }

    // Listar hospede por nome
    public List<Hospede> listarPorNome(String nome) throws SQLException {
        List<Hospede> hospedes = new ArrayList<>();
        String sql = "SELECT p.*, h.nacionalidade, h.profissao, h.data_cadastro, e.* FROM pessoas p "
                + "JOIN hospedes h ON p.id = h.id "
                + "JOIN enderecos e ON p.id = e.id_pessoas "
                + "WHERE p.nome LIKE ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    hospedes.add(mapearHospede(rs));
                }
            }
        }
        return hospedes;
    }

    // Excluir hospede (e a pessoa vinculada)
    public void excluir(int id) throws SQLException {
        String sqlHospede = "DELETE FROM hospedes WHERE id_pessoas = ?";
        String sqlEndereco = "DELETE FROM enderecos WHERE id_pessoas = ?";
        String sqlPessoa = "DELETE FROM pessoas WHERE id = ?";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement pstmtHospede = connection.prepareStatement(sqlHospede); PreparedStatement pstmtEndereco = connection.prepareStatement(sqlEndereco); PreparedStatement pstmtPessoa = connection.prepareStatement(sqlPessoa)) {

                pstmtHospede.setInt(1, id);
                pstmtHospede.executeUpdate();

                pstmtEndereco.setInt(1, id);
                pstmtEndereco.executeUpdate();

                pstmtPessoa.setInt(1, id);
                pstmtPessoa.executeUpdate();

                connection.commit();
            }
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    

    // Mapear o resultado SQL para o objeto Hospede
    private Hospede mapearHospede(ResultSet rs) throws SQLException {
        Hospede hospede = new Hospede();
        hospede.setId(rs.getInt("id"));
        hospede.setNome(rs.getString("nome"));
        hospede.setGenero(rs.getString("genero"));
        hospede.setDatanascimento(rs.getDate("data_nascimento").toLocalDate());
        hospede.setCpf(rs.getString("cpf"));
        hospede.setEmail(rs.getString("email"));
        hospede.setFixo(rs.getString("fixo"));
        hospede.setCelular(rs.getString("celular"));
        hospede.setWhatsapp(rs.getBoolean("whatsapp"));
        hospede.setObservacoes(rs.getString("observacoes"));
        hospede.setNacionalidade(rs.getString("nacionalidade"));
        hospede.setProfissao(rs.getString("profissao"));
        hospede.setDatacadastro(rs.getDate("data_cadastro").toLocalDate());


        Endereco endereco = new Endereco();
        endereco.setRua(rs.getString("rua"));
        endereco.setNumero(rs.getString("numero"));
        endereco.setComplemento(rs.getString("complemento"));
        endereco.setBairro(rs.getString("bairro"));
        endereco.setCidade(rs.getString("cidade"));
        endereco.setEstado(rs.getString("estado"));
        endereco.setCep(rs.getString("cep"));

        hospede.setEndereco(endereco);

        return hospede;
    }
    
}
