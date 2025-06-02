package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.TipoQuarto;
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
    public void inserirQuarto(Quarto q) throws SQLException {
        String sql = "INSERT INTO QUARTO (NUMERO, TIPO, VALOR, DESCRICAO) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, q.getNumero());
            pstm.setString(2, q.getTipo().toString());
            pstm.setBigDecimal(3, q.getValor());
            pstm.setString(4, q.getDescricao());
            pstm.executeUpdate();
        }
    }

    // Alterar quarto
    public void alterarQuarto(Quarto q) throws SQLException {
        String sql = "UPDATE QUARTO SET NUMERO = ?, TIPO = ?, VALOR = ?, DESCRICAO = ? WHERE ID = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, q.getNumero());
            pstm.setString(2, q.getTipo().toString());
            pstm.setBigDecimal(3, q.getValor());
            pstm.setString(4, q.getDescricao());
            pstm.setInt(5, q.getId());
            pstm.executeUpdate();
        }
    }

    // Excluir quarto
    public void excluirQuarto(int id) throws SQLException {
        String sql = "DELETE FROM QUARTO WHERE ID = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }
    }

    // Buscar quarto por ID
    public Quarto selecionarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM QUARTO WHERE ID = ?";
        Quarto quarto = null;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    quarto = new Quarto(
                        rs.getInt("ID"),
                        rs.getInt("NUMERO"),
                        TipoQuarto.valueOf(rs.getString("TIPO")),
                        rs.getBigDecimal("VALOR"),
                        rs.getString("DESCRICAO")
                    );
                }
            }
        }
        return quarto;
    }

    // Listar todos os quartos
    public List<Quarto> listarTodos() throws SQLException {
        List<Quarto> lista = new ArrayList<>();
        String sql = "SELECT * FROM QUARTO";

        try (PreparedStatement pstm = connection.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                Quarto quarto = new Quarto(
                    rs.getInt("ID"),
                    rs.getInt("NUMERO"),
                    TipoQuarto.valueOf(rs.getString("TIPO")),
                    rs.getBigDecimal("VALOR"),
                    rs.getString("DESCRICAO")
                );
                lista.add(quarto);
            }
        }
        return lista;
    }

    // Buscar quarto por número
    public Quarto buscarPorNumero(int numero) throws SQLException {
        String sql = "SELECT * FROM QUARTO WHERE NUMERO = ?";
        Quarto quarto = null;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, numero);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    quarto = new Quarto(
                        rs.getInt("ID"),
                        rs.getInt("NUMERO"),
                        TipoQuarto.valueOf(rs.getString("TIPO")),
                        rs.getBigDecimal("VALOR"),
                        rs.getString("DESCRICAO")
                    );
                }
            }
        }
        return quarto;
    }

    // Buscar quartos por tipo
    public List<Quarto> buscarPorTipo(TipoQuarto tipo) throws SQLException {
        List<Quarto> lista = new ArrayList<>();
        String sql = "SELECT * FROM QUARTO WHERE TIPO = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, tipo.name());
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    Quarto quarto = new Quarto(
                        rs.getInt("ID"),
                        rs.getInt("NUMERO"),
                        TipoQuarto.valueOf(rs.getString("TIPO")),
                        rs.getBigDecimal("VALOR"),
                        rs.getString("DESCRICAO")
                    );
                    lista.add(quarto);
                }
            }
        }
        return lista;
    }

    // Buscar quartos por faixa de valor
    public List<Quarto> buscarPorFaixaDeValor(BigDecimal valorMin, BigDecimal valorMax) throws SQLException {
        List<Quarto> lista = new ArrayList<>();
        String sql = "SELECT * FROM QUARTO WHERE VALOR BETWEEN ? AND ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setBigDecimal(1, valorMin);
            pstm.setBigDecimal(2, valorMax);
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    Quarto quarto = new Quarto(
                        rs.getInt("ID"),
                        rs.getInt("NUMERO"),
                        TipoQuarto.valueOf(rs.getString("TIPO")),
                        rs.getBigDecimal("VALOR"),
                        rs.getString("DESCRICAO")
                    );
                    lista.add(quarto);
                }
            }
        }
        return lista;
    }
}