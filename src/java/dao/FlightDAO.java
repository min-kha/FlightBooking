/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.Flight;
import db.DBContext;
import java.sql.Timestamp;

/**
 *
 * @author khami
 */
public class FlightDAO {

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM Flight";
        try {
            ResultSet rs = DBContext.executeQuery(sql);
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setFlightID(rs.getInt("flightID"));
                flight.setRouteID(rs.getInt("routeID"));
                flight.setDepartureTime(rs.getTimestamp("departureTime"));
                flight.setDuration(rs.getInt("duration"));
                flight.setCapacity(rs.getInt("capacity"));
                flight.setTicketType(rs.getString("ticketType"));
                flight.setPrice(rs.getFloat("price"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }

    public Flight getFlightById(int id) {
        Flight flight = null;
        String sql = "SELECT * FROM Flight WHERE flightID = ?";
        try {
            ResultSet rs = DBContext.executeQuery(sql, id);
            if (rs.next()) {
                flight = new Flight();
                flight.setFlightID(rs.getInt("flightID"));
                flight.setRouteID(rs.getInt("routeID"));
                flight.setDepartureTime(rs.getTimestamp("departureTime"));
                flight.setDuration(rs.getInt("duration"));
                flight.setCapacity(rs.getInt("capacity"));
                flight.setTicketType(rs.getString("ticketType"));
                flight.setPrice(rs.getFloat("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;
    }

    public boolean addFlight(Flight flight) {
        String sql = "INSERT INTO Flight (routeID, departureTime, duration, capacity, ticketType, price) VALUES (?, ?, ?, ?, ?, ?)";
        return DBContext.executeUpdate(sql, flight.getRouteID(), flight.getDepartureTime(),
                flight.getDuration(), flight.getCapacity(), flight.getTicketType(), flight.getPrice());
    }

    public boolean updateFlight(Flight flight) {
        String sql = "UPDATE Flight SET routeID = ?, departureTime = ?, duration = ?, capacity = ?, ticketType = ?, price = ? WHERE flightID = ?";
        return DBContext.executeUpdate(sql, flight.getRouteID(), flight.getDepartureTime(),
                flight.getDuration(), flight.getCapacity(), flight.getTicketType(), flight.getPrice(), flight.getFlightID());
    }

    public boolean deleteFlight(int id) {
        String sql = "DELETE FROM Flight WHERE flightID = ?";
        return DBContext.executeUpdate(sql, id);
    }

    public List<Flight> searchFlights(int routeID, Date departureTime) {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM Flight WHERE routeID = ? AND departureTime >= ?";
        try {
            Timestamp timestamp = new Timestamp(departureTime.getTime());
            ResultSet rs = DBContext.executeQuery(sql, routeID, timestamp);
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setFlightID(rs.getInt("flightID"));
                flight.setRouteID(rs.getInt("routeID"));
                flight.setDepartureTime(rs.getTimestamp("departureTime"));
                flight.setDuration(rs.getInt("duration"));
                flight.setCapacity(rs.getInt("capacity"));
                flight.setTicketType(rs.getString("ticketType"));
                flight.setPrice(rs.getFloat("price"));
                flights.add(flight);
                System.out.println("==>" + flight.toString());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }

    public List<Flight> getFlightsByRouteID(int routeID) {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM Flight WHERE routeID = ?";
        try {
            ResultSet rs = DBContext.executeQuery(sql, routeID);
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setFlightID(rs.getInt("flightID"));
                flight.setRouteID(rs.getInt("routeID"));
                flight.setDepartureTime(rs.getTimestamp("departureTime"));
                flight.setDuration(rs.getInt("duration"));
                flight.setCapacity(rs.getInt("capacity"));
                flight.setTicketType(rs.getString("ticketType"));
                flight.setPrice(rs.getFloat("price"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }
}
