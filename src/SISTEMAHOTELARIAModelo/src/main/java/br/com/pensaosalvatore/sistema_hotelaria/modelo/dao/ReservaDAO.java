
package br.com.pensaosalvatore.sistema_hotelaria.modelo.dao;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Érica_Almeida
 */

public class ReservaDAO {
    private Connection connection;

    // Construtor que recebe a conexão com o banco de dados
    public ReservaDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para adicionar uma nova reserva
    public void adicionar(Reserva reserva) throws SQLException {
        String sql = "INSERT INTO reservas (data_entrada, data_saida, valor, observacoes, id_hospedes, id_quartos, id_usuarios) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, Date.valueOf(reserva.getDataentrada()));
            pstmt.setDate(2, Date.valueOf(reserva.getDatasaida()));
            pstmt.setBigDecimal(3, reserva.getValor());
            pstmt.setString(4, reserva.getObservacoes());
            pstmt.setInt(5, reserva.getIdHospedes());
            pstmt.setInt(6, reserva.getIdQuartos());
            pstmt.setInt(7, reserva.getIdUsuarios());
            
            pstmt.executeUpdate();
            
            // Obter o ID gerado
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    reserva.setId(rs.getInt(1));
                }
            }
        }
    }

    // Método para buscar uma reserva por ID
    public Reserva buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM reservas WHERE id = ?";
        Reserva reserva = null;
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    reserva = new Reserva();
                    reserva.setId(rs.getInt("id"));
                    reserva.setDataentrada(rs.getDate("data_entrada").toLocalDate());
                    reserva.setDatasaida(rs.getDate("data_saida").toLocalDate());
                    reserva.setValor(rs.getBigDecimal("valor"));
                    reserva.setObservacoes(rs.getString("observacoes"));
                    reserva.setIdHospedes(rs.getInt("id_hospedes"));
                    reserva.setIdQuartos(rs.getInt("id_quartos"));
                    reserva.setIdUsuarios(rs.getInt("id_usuarios"));
                }
            }
        }
        
        return reserva;
    }

    // Método para listar todas as reservas
    public List<Reserva> listarTodas() throws SQLException {
        String sql = "SELECT * FROM reservas";
        List<Reserva> reservas = new ArrayList<>();
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                reserva.setDataentrada(rs.getDate("data_entrada").toLocalDate());
                reserva.setDatasaida(rs.getDate("data_saida").toLocalDate());
                reserva.setValor(rs.getBigDecimal("valor"));
                reserva.setObservacoes(rs.getString("observacoes"));
                reserva.setIdHospedes(rs.getInt("id_hospedes"));
                reserva.setIdQuartos(rs.getInt("id_quartos"));
                reserva.setIdUsuarios(rs.getInt("id_usuarios"));
                
                reservas.add(reserva);
            }
        }
        
        return reservas;
    }

    // Método para atualizar uma reserva
    public void atualizar(Reserva reserva) throws SQLException {
        String sql = "UPDATE reservas SET data_entrada = ?, data_saida = ?, valor = ?, observacoes = ?, id_hospedes = ?, id_quartos = ?, id_usuarios = ? WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(reserva.getDataentrada()));
            pstmt.setDate(2, Date.valueOf(reserva.getDatasaida()));
            pstmt.setBigDecimal(3, reserva.getValor());
            pstmt.setString(4, reserva.getObservacoes());
            pstmt.setInt(5, reserva.getIdHospedes());
            pstmt.setInt(6, reserva.getIdQuartos());
            pstmt.setInt(7, reserva.getIdUsuarios());
            pstmt.setInt(8, reserva.getId());
            
            pstmt.executeUpdate();
        }
    }

    // Método para remover uma reserva
    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM reservas WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    // Método para buscar reservas por hóspede
    public List<Reserva> buscarPorHospede(int idHospede) throws SQLException {
        String sql = "SELECT * FROM reservas WHERE id_hospedes = ?";
        List<Reserva> reservas = new ArrayList<>();
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idHospede);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Reserva reserva = new Reserva();
                    reserva.setId(rs.getInt("id"));
                    reserva.setDataentrada(rs.getDate("data_entrada").toLocalDate());
                    reserva.setDatasaida(rs.getDate("data_saida").toLocalDate());
                    reserva.setValor(rs.getBigDecimal("valor"));
                    reserva.setObservacoes(rs.getString("observacoes"));
                    reserva.setIdHospedes(rs.getInt("id_hospedes"));
                    reserva.setIdQuartos(rs.getInt("id_quartos"));
                    reserva.setIdUsuarios(rs.getInt("id_usuarios"));
                    
                    reservas.add(reserva);
                }
            }
        }
        
        return reservas;
    }

    // Método para buscar reservas por quarto
    public List<Reserva> buscarPorQuarto(int idQuarto) throws SQLException {
        String sql = "SELECT * FROM reservas WHERE id_quartos = ?";
        List<Reserva> reservas = new ArrayList<>();
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idQuarto);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Reserva reserva = new Reserva();
                    reserva.setId(rs.getInt("id"));
                    reserva.setDataentrada(rs.getDate("data_entrada").toLocalDate());
                    reserva.setDatasaida(rs.getDate("data_saida").toLocalDate());
                    reserva.setValor(rs.getBigDecimal("valor"));
                    reserva.setObservacoes(rs.getString("observacoes"));
                    reserva.setIdHospedes(rs.getInt("id_hospedes"));
                    reserva.setIdQuartos(rs.getInt("id_quartos"));
                    reserva.setIdUsuarios(rs.getInt("id_usuarios"));
                    
                    reservas.add(reserva);
                }
            }
        }
        
        return reservas;
    }
}