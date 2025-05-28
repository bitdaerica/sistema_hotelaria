package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.TipoQuarto;
import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.QuartoDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Érica_Almeida
 */
public class QuartoDAO {

    private final ConnectionFactoryDAO connectionFactory = new ConnectionFactoryDAO();

    public void inserirQuarto(QuartoDTO q) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();

            String sql = "INSERT INTO QUARTO (NUMERO, TIPO, VALOR, DESCRICAO) VALUES (?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, q.getNumero());
            pstm.setString(2, q.getTipo().toString());
            pstm.setBigDecimal(3, q.getValor());
            pstm.setString(4, q.getDescricao());

            pstm.executeUpdate();

        } finally {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void alterarQuarto(QuartoDTO q) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();

            String sql = "UPDATE QUARTO SET NUMERO = ?, TIPO = ?, VALOR = ?, DESCRICAO = ? WHERE ID = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, q.getNumero());
            pstm.setString(2, q.getTipo().toString());
            pstm.setBigDecimal(3, q.getValor());
            pstm.setString(4, q.getDescricao());
            pstm.setInt(5, q.getId());

            pstm.executeUpdate();

        } finally {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void excluirQuarto(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();

            String sql = "DELETE FROM QUARTO WHERE ID = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.executeUpdate();

        } finally {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public QuartoDTO selecionarPorId(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        QuartoDTO quarto = null;

        try {
            conn = connectionFactory.conectaBD();

            String sql = "SELECT * FROM QUARTO WHERE ID = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            rs = pstm.executeQuery();

            if (rs.next()) {
                quarto = new QuartoDTO();
                quarto.setId(rs.getInt("ID"));
                quarto.setNumero(rs.getInt("NUMERO"));
                quarto.setTipo(TipoQuarto.valueOf(rs.getString("TIPO")));
                quarto.setValor(rs.getBigDecimal("VALOR"));
                quarto.setDescricao(rs.getString("DESCRICAO"));
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
        return quarto;
    }

    public List<QuartoDTO> listarTodos() throws SQLException {
        List<QuartoDTO> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();

            String sql = "SELECT * FROM QUARTO";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                QuartoDTO quarto = new QuartoDTO();

                quarto.setId(rs.getInt("ID"));
                quarto.setNumero(rs.getInt("NUMERO"));
                quarto.setTipo(TipoQuarto.valueOf(rs.getString("TIPO")));
                quarto.setValor(rs.getBigDecimal("VALOR"));
                quarto.setDescricao(rs.getString("DESCRICAO"));

                lista.add(quarto);
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
}

