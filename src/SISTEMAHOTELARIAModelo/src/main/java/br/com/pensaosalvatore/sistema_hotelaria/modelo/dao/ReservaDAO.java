package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Reserva;
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

    private final Connection connection;

    public ReservaDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Reserva r) throws SQLException {
        String sql = "INSERT INTO reservas (id_hospedes, id_quartos, data_entrada, data_saida, valor, observacoes) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, r.getHospede().getId());
            pstm.setInt(2, r.getQuarto().getId());
            pstm.setDate(3, new Date(r.getData_entrada().getTime()));
            pstm.setDate(4, new Date(r.getData_saida().getTime()));
            pstm.setBigDecimal(5, r.getValor());
            pstm.setString(6, r.getObservacoes());

            pstm.executeUpdate();
        }
    }

    public void alterar(Reserva r) throws SQLException {
        String sql = "UPDATE reservas SET id_hospedes = ?, id_quartos = ?, data_entrada = ? , data_saida = ? , valor = ? , observacoes = ? WHERE id = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, r.getHospede().getId());
            pstm.setInt(2, r.getQuarto().getId());
            pstm.setDate(3, new Date(r.getData_entrada().getTime()));
            pstm.setDate(4, new Date(r.getData_saida().getTime()));
            pstm.setBigDecimal(5, r.getValor());
            pstm.setString(6, r.getObservacoes());
            pstm.setInt(7, r.getId());

            pstm.executeUpdate();
        }
    }

    public Reserva selecionarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM RESERVA WHERE ID = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);

            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    return montarReserva(rs);
                }
            }
        }

        return null;
    }

    public List<Reserva> listarTodas() throws SQLException {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM RESERVA";

        try (PreparedStatement pstm = connection.prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                lista.add(montarReserva(rs));
            }
        }

        return lista;
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM reservas WHERE ID = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            int linhasAfetadas = pstm.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Reserva com ID " + id + " não encontrada.");
            }
        }
    }

    // 🔥 Método privado para montar a Reserva a partir do ResultSet
    private Reserva montarReserva(ResultSet rs) throws SQLException {
        Reserva reserva = new Reserva();

        reserva.setId(rs.getInt("ID"));

        // Carregar Hospede e Quarto usando os respectivos DAOs, passando a mesma conexão
        HospedeDAO hospedeDAO = new HospedeDAO(connection);
        QuartoDAO quartoDAO = new QuartoDAO(connection);

        reserva.setHospede(hospedeDAO.selecionarPorId(rs.getInt("id_hospedes")));
        reserva.setQuarto(quartoDAO.selecionarPorId(rs.getInt("id_quartos")));

        reserva.setData_entrada(rs.getDate("data_entrada"));
        reserva.setData_saida(rs.getDate("data_saida"));
        reserva.setValor(rs.getBigDecimal("valor"));
        reserva.setObservacoes(rs.getString("observacoes"));

        return reserva;
    }
}
