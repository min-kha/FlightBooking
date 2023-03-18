/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.Booking;
import db.DBContext;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khami
 */
public class BookingDAO extends DBContext {

    private final Connection connection;

    public BookingDAO() throws SQLException, ClassNotFoundException  {
        connection = DBContext.getConnection();
    }

    public int addBooking(Booking booking) {
        int bookingID = -1;
        try {
            String query = "INSERT INTO Booking(userID, flightID, bookingTime, isPaid) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, booking.getUserID());
            ps.setInt(2, booking.getFlightID());
            ps.setDate(3, new java.sql.Date(booking.getBookingTime().getTime()));
            ps.setBoolean(4, booking.isIsPaid());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                bookingID = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookingID;
    }

    public void updateBooking(Booking booking) {
        try {
            String query = "UPDATE Booking SET userID = ?, flightID = ?, bookingTime = ?, isPaid = ? "
                    + "WHERE bookingID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, booking.getUserID());
            ps.setInt(2, booking.getFlightID());
            ps.setDate(3, new java.sql.Date(booking.getBookingTime().getTime()));
            ps.setBoolean(4, booking.isIsPaid());
            ps.setInt(5, booking.getBookingID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateBookingToPaired(int bookingID) {
        try {
            String query = "UPDATE Booking SET isPaid = 1 "
                    + "WHERE bookingID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, bookingID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            
            
        }
    }

    public void deleteBookingById(int bookingID) {
        try {
            String query = "DELETE FROM Booking WHERE bookingID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, bookingID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Booking getBookingById(int bookingID) {
        Booking booking = null;
        try {
            String query = "SELECT * FROM Booking WHERE bookingID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, bookingID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                booking = new Booking();
                booking.setBookingID(rs.getInt("bookingID"));
                booking.setUserID(rs.getInt("userID"));
                booking.setFlightID(rs.getInt("flightID"));
                booking.setBookingTime(new java.sql.Date(booking.getBookingTime().getTime()));
                booking.setIsPaid(rs.getBoolean("isPaid"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return booking;
    }

    public List<Booking> getBookingsByUserId(int userID) {
        List<Booking> bookings = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Booking WHERE UserID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setBookingID(rs.getInt("BookingID"));
                booking.setUserID(rs.getInt("UserID"));
                booking.setFlightID(rs.getInt("FlightID"));
                booking.setBookingTime(rs.getDate("BookingTime"));
                booking.setIsPaid(rs.getBoolean("IsPaid"));
                bookings.add(booking);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bookings;
    }

    public List<Booking> getBookingsByFlightId(int flightID) {
        List<Booking> bookings = new ArrayList<>();
        try {
            String query = "SELECT * FROM Booking WHERE flightID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, flightID);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Booking booking = new Booking();
                booking.setBookingID(resultSet.getInt("bookingID"));
                booking.setUserID(resultSet.getInt("userID"));
                booking.setFlightID(resultSet.getInt("flightID"));
                booking.setBookingTime(resultSet.getDate("bookingTime"));
                booking.setIsPaid(resultSet.getBoolean("isPaid"));
                bookings.add(booking);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookings;
    }

    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        try {
            String query = "SELECT * FROM Booking";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setBookingID(rs.getInt("BookingID"));
                booking.setUserID(rs.getInt("UserID"));
                booking.setFlightID(rs.getInt("FlightID"));
                booking.setBookingTime(rs.getDate("BookingTime"));
                booking.setIsPaid(rs.getBoolean("IsPaid"));
                bookings.add(booking);
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bookings;
    }

}
