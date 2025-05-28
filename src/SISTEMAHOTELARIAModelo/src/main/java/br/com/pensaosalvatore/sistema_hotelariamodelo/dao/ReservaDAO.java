package br.com.pensaosalvatore.sistema_hotelariamodelo.dao;


import br.com.pensaosalvatore.sistema_hotelariamodelo.dto.ReservaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Érica_Almeida
 */
public class ReservaDAO {

    private final ConnectionFactoryDAO connectionFactory = new ConnectionFactoryDAO();

    public void inserirReserva(ReservaDTO r) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();

            String sql = "INSERT INTO RESERVA (HOSPEDE_ID, QUARTO_ID, DATA_ENTRADA, DATA_SAIDA, VALOR, OBSERVACOES) VALUES (?, ?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, r.getHospede().getId());
            pstm.setInt(2, r.getQuarto().getId());
            pstm.setDate(3, new Date(r.getDatadeentrada().getTime()));
            pstm.setDate(4, new Date(r.getDatadesaida().getTime()));
            pstm.setBigDecimal(5, r.getValor());
            pstm.setString(6, r.getObservacoes());

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

    public void alterarReserva(ReservaDTO r) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();

            String sql = "UPDATE RESERVA SET HOSPEDE_ID = ?, QUARTO_ID = ?, DATA_ENTRADA = ?, DATA_SAIDA = ?, VALOR = ?, OBSERVACOES = ? WHERE ID = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, r.getHospede().getId());
            pstm.setInt(2, r.getQuarto().getId());
            pstm.setDate(3, new Date(r.getDatadeentrada().getTime()));
            pstm.setDate(4, new Date(r.getDatadesaida().getTime()));
            pstm.setBigDecimal(5, r.getValor());
            pstm.setString(6, r.getObservacoes());
            pstm.setInt(7, r.getId());

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


    public ReservaDTO selecionarPorId(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        ReservaDTO reserva = null;

        try {
            conn = connectionFactory.conectaBD();

            String sql = "SELECT * FROM RESERVA WHERE ID = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            rs = pstm.executeQuery();

            if (rs.next()) {
                reserva = new ReservaDTO();
                reserva.setId(rs.getInt("ID"));

                // Hospede e Quarto são objetos, então você precisa buscar eles pelos DAOs
                HospedeDAO hospedeDAO = new HospedeDAO();
                QuartoDAO quartoDAO = new QuartoDAO();

                reserva.setHospede(hospedeDAO.selecionarPorId(rs.getInt("HOSPEDE_ID")));
                reserva.setQuarto(quartoDAO.selecionarPorId(rs.getInt("QUARTO_ID")));

                reserva.setDatadeentrada(rs.getDate("DATA_ENTRADA"));
                reserva.setDatadesaida(rs.getDate("DATA_SAIDA"));
                reserva.setValor(rs.getBigDecimal("VALOR"));
                reserva.setObservacoes(rs.getString("OBSERVACOES"));
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
        return reserva;
    }

    public List<ReservaDTO> listarTodas() throws SQLException {
        List<ReservaDTO> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = connectionFactory.conectaBD();

            String sql = "SELECT * FROM RESERVA";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            HospedeDAO hospedeDAO = new HospedeDAO();
            QuartoDAO quartoDAO = new QuartoDAO();

            while (rs.next()) {
                ReservaDTO reserva = new ReservaDTO();

                reserva.setId(rs.getInt("ID"));
                reserva.setHospede(hospedeDAO.selecionarPorId(rs.getInt("HOSPEDE_ID")));
                reserva.setQuarto(quartoDAO.selecionarPorId(rs.getInt("QUARTO_ID")));
                reserva.setDatadeentrada(rs.getDate("DATA_ENTRADA"));
                reserva.setDatadesaida(rs.getDate("DATA_SAIDA"));
                reserva.setValor(rs.getBigDecimal("VALOR"));
                reserva.setObservacoes(rs.getString("OBSERVACOES"));

                lista.add(reserva);
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
    
        public void excluirReserva(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionFactory.conectaBD();

            String sql = "DELETE FROM RESERVA WHERE ID = ?";
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
}
