/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import beans.Ticket;
import db.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khami
 */
public class TicketDAO extends DBContext {

    private final Connection connection;

    public TicketDAO() throws SQLException, ClassNotFoundException {
        connection = DBContext.getConnection();
    }

    public List<Ticket> getTiketsByUserID(int userID) {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "select UserID, PassengerID, FullName, City1.CityName, City2.CityName, DepartureTime, TicketType, Price, IsPaid from PassengerInfo\n"
                + " join Booking on PassengerInfo.BookingID = Booking.BookingID\n"
                + " join Flight on Flight.FlightID = Booking.FlightID\n"
                + " join Route on Flight.RouteID = Route.RouteID\n"
                + " join City City1 on Route.DepartureCityID = City1.CityID\n"
                + " join City City2 on Route.ArrivalCityID = City2.CityID "
                + " Where userID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = super.executeQuery(sql, userID);
            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setUserID(rs.getInt("UserID"));
                ticket.setPassengerID(rs.getInt("PassengerID"));
                ticket.setFullName(rs.getString("FullName"));
                ticket.setFrom(rs.getString(4));
                ticket.setTo(rs.getString(5));
                ticket.setTime(rs.getTimestamp("DepartureTime"));
                ticket.setType(rs.getString("TicketType"));
                ticket.setPrice(rs.getFloat("Price"));
                ticket.setIsPaid(rs.getBoolean("IsPaid"));
                tickets.add(ticket);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tickets;
    }

    public void deleteTicket(int passengerID) throws SQLException {
        PreparedStatement statement = null;
        try {
            // Get a connection
            connection.setAutoCommit(false);

            // Delete the ticket from PassengerInfo and Booking tables
            String deletePassengerInfoSql = "DELETE FROM PassengerInfo WHERE PassengerID = ?";
            statement = connection.prepareStatement(deletePassengerInfoSql);
            statement.setInt(1, passengerID);
            statement.executeUpdate();

            // TODO: Xóa booking khi không còn passenger nào trong booking
//            String deleteBookingSql = "DELETE FROM Booking WHERE... = ?";
//            statement = connection.prepareStatement(deleteBookingSql);
//            statement.setInt(1, passengerID);
//            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        }
    }
}
