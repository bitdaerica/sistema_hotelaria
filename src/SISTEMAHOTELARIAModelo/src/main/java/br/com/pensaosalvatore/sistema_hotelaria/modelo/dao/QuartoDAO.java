package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Quarto;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Érica_Almeida
 */
public class QuartoDAO {

    private final Connection connection;

    public QuartoDAO(Connection connection) {
        this.connection = connection;
    }

    
    // Inserir quarto
    public void inserir(Quarto q) throws SQLException {
        String sql = "INSERT INTO quartos (numero, tipo, valor, descricao) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, q.getNumero());
            pstm.setString(2, q.getTipo());
            pstm.setBigDecimal(3, q.getValor());
            pstm.setString(4, q.getDescricao());
            pstm.executeUpdate();
        }
    }

    // Alterar quarto
    public void alterar(Quarto q) throws SQLException {
        String sql = "UPDATE quartos SET numero = ? , tipo = ? , valor = ?, descricao = ? WHERE ID = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, q.getNumero());
            pstm.setString(2, q.getTipo());
            pstm.setBigDecimal(3, q.getValor());
            pstm.setString(4, q.getDescricao());
            pstm.setInt(5, q.getId());
            pstm.executeUpdate();
        }
    }

    // Excluir quarto
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM quartos WHERE ID = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }
    }

    // Buscar quarto por ID
    public Quarto selecionarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM quartos WHERE ID = ?";
        Quarto quarto = null;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    quarto = new Quarto(
                            rs.getInt("ID"),
                            rs.getInt("numero"),
                           rs.getString("tipo"),
                            rs.getBigDecimal("valor"),
                            rs.getString("descricao")
                    );
                }
            }
        }
        return quarto;
    }

    // Listar todos os quartos
    public List<Quarto> listarTodos() throws SQLException {
        List<Quarto> lista = new ArrayList<>();
        String sql = "SELECT * FROM quartos";

        try (PreparedStatement pstm = connection.prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                Quarto quarto = new Quarto(
                        rs.getInt("ID"),
                            rs.getInt("numero"),
                           rs.getString("tipo"),
                            rs.getBigDecimal("valor"),
                            rs.getString("descricao")
                );
                lista.add(quarto);
            }
        }
        return lista;
    }

    // Buscar quarto por número
    public Quarto buscarPorNumero(int numero) throws SQLException {
        String sql = "SELECT * FROM quartos WHERE NUMERO = ?";
        Quarto quarto = null;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, numero);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    quarto = new Quarto(
                            rs.getInt("ID"),
                            rs.getInt("numero"),
                           rs.getString("tipo"),
                            rs.getBigDecimal("valor"),
                            rs.getString("descricao")
                    );
                }
            }
        }
        return quarto;
    }

    

    // Buscar quartos por faixa de valor
    public List<Quarto> buscarPorFaixaDeValor(BigDecimal valorMin, BigDecimal valorMax) throws SQLException {
        List<Quarto> lista = new ArrayList<>();
        String sql = "SELECT * FROM quartos WHERE VALOR BETWEEN ? AND ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setBigDecimal(1, valorMin);
            pstm.setBigDecimal(2, valorMax);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    Quarto quarto = new Quarto(
                            rs.getInt("ID"),
                            rs.getInt("numero"),
                           rs.getString("tipo"),
                            rs.getBigDecimal("valor"),
                            rs.getString("descricao")
                    );
                    lista.add(quarto);
                }
            }
        }
        return lista;
    }
}
