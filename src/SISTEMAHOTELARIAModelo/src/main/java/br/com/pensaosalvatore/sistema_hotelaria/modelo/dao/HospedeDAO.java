package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Hospede;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        this.connection = connection;
    }

    // Inserir hóspede (Pessoa + Hospede)
    public void inserir(Hospede h) throws SQLException {
        try {
            connection.setAutoCommit(false);

            // Inserir Pessoa
            PessoaDAO pessoaDAO = new PessoaDAO(connection, new EnderecoDAO(connection));
            int idPessoa = pessoaDAO.inserir(h);
            h.setId(idPessoa);

            String sql = "INSERT INTO hospedes (nacionalidade, profissao, data_cadastro, id_pessoas) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, h.getNacionalidade());
                pstm.setString(2, h.getProfissao());
                if (h.getData_cadastro() != null) {
                    pstm.setDate(3, Date.valueOf(h.getData_cadastro()));
                } else {
                    pstm.setNull(3, java.sql.Types.DATE);
                }
                pstm.setInt(4, h.getId());

                pstm.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    // Alterar hóspede (Pessoa + Hospede)
    public void alterar(Hospede h) throws SQLException {
        PreparedStatement pstm = null;
        try {
            connection.setAutoCommit(false);

            // Atualiza Pessoa
            PessoaDAO pessoaDAO = new PessoaDAO(connection, null);
            pessoaDAO.alterar(h);

            String sql = "UPDATE hospedes SET nacionalidade = ? , profissao = ? , data_cadastro = ? WHERE ID = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, h.getNacionalidade());
            pstm.setString(2, h.getProfissao());
            if (h.getData_cadastro() != null) {
                pstm.setDate(3, Date.valueOf(h.getData_cadastro())); // índice 3 para dataCadastro
            } else {
                pstm.setNull(3, java.sql.Types.DATE);
            }
            pstm.setInt(4, h.getId()); // índice 4 para id

            pstm.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            if (pstm != null) {
                pstm.close();
            }
            connection.setAutoCommit(true);
        }
    }

    // Buscar hóspede por ID (com join em Pessoa)
    public Hospede selecionarPorId(int id) throws SQLException {
        String sql = """
            SELECT h.id, h.nacionalidade, h.profissao, h.data_cadastro,
                   p.nome, p.genero, p.data_nascimento, p.cpf, p.email,
                   p.fixo, p.celular, p.whatsapp, p.observacoes
            FROM hospedes h
            INNER JOIN pessoas p ON h.id = p.id
            WHERE h.id = ?
            """;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }
        }
        return null;
    }

    // Listar todos os hóspedes
    public List<Hospede> listarTodos() throws SQLException {
        List<Hospede> lista = new ArrayList<>();

        String sql = """
            SELECT h.id, h.nacionalidade, h.profissao, h.data_cadastro,
                   p.nome, p.genero, p.data_nascimento, p.cpf, p.email,
                   p.fixo, p.celular, p.whatsapp, p.observacoes
            FROM hospedes h
            INNER JOIN pessoas p ON h.id = p.id
            """;

        try (PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                lista.add(mapear(rs));
            }
        }
        return lista;
    }

    // Listar hóspedes por nome (LIKE)
    public List<Hospede> listarPorNome(String nome) throws SQLException {
        List<Hospede> lista = new ArrayList<>();

        String sql = """
            SELECT h.id, h.nacionalidade, h.profissao, h.data_cadastro,
                   p.nome, p.genero, p.data_nascimento, p.cpf, p.email,
                   p.fixo, p.celular, p.whatsapp, p.observacoes
            FROM hospedes h
            INNER JOIN pessoas p ON h.id = p.id
            WHERE p.nome LIKE ?
            """;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, "%" + nome + "%");
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapear(rs));
                }
            }
        }
        return lista;
    }

    // Excluir hóspede (HOSPEDE + PESSOA)
    public void excluir(int id) throws SQLException {
        PreparedStatement pstm = null;
        try {
            connection.setAutoCommit(false);

            String sql = "DELETE FROM hospedes WHERE ID = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();

            PessoaDAO pessoaDAO = new PessoaDAO(connection, null);
            pessoaDAO.excluir(id);

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            if (pstm != null) {
                pstm.close();
            }
            connection.setAutoCommit(true);
        }
    }

    // Método auxiliar para mapear ResultSet para Hospede
    private Hospede mapear(ResultSet rs) throws SQLException {
        Hospede h = new Hospede();

        h.setId(rs.getInt("id"));
        h.setNome(rs.getString("nome"));
        h.setGenero(rs.getString("genero"));

        Date data_nascimentoSQL = rs.getDate("data_nascimento");
        if (data_nascimentoSQL != null) {
            h.setData_nascimento(data_nascimentoSQL.toLocalDate());
        } else {
            h.setData_nascimento(null);
        }

        h.setCpf(rs.getString("cpf"));
        h.setEmail(rs.getString("email"));
        h.setFixo(rs.getString("fixo"));
        h.setCelular(rs.getString("celular"));

        Object whatsappObj = rs.getObject("whatsapp");
        h.setWhatsapp(whatsappObj != null ? rs.getBoolean("whatsapp") : null);

        h.setObservacoes(rs.getString("observacoes"));
        h.setNacionalidade(rs.getString("nacionalidade"));
        h.setProfissao(rs.getString("profissao"));

        Date data_cadastroSQL = rs.getDate("data_cadastro");
        if (data_cadastroSQL != null) {
            h.setData_cadastro(data_cadastroSQL.toLocalDate());
        } else {
            h.setData_cadastro(null);
        }

        return h;
    }
}