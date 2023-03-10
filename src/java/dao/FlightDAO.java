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

/**
 *
 * @author khami
 */

public class FlightDAO {

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM Flights";
        try {
            ResultSet rs = DBContext.executeQuery(sql);
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setFlightID(rs.getInt("flightID"));
                flight.setRouteID(rs.getInt("routeID"));
                flight.setDepartureTime(rs.getDate("departureTime"));
                flight.setDuration(rs.getInt("duration"));
                flight.setCapacity(rs.getInt("capacity"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }

    public Flight getFlightById(int id) {
        Flight flight = null;
        String sql = "SELECT * FROM Flights WHERE flightID = ?";
        try {
            ResultSet rs = DBContext.executeQuery(sql, id);
            if (rs.next()) {
                flight = new Flight();
                flight.setFlightID(rs.getInt("flightID"));
                flight.setRouteID(rs.getInt("routeID"));
                flight.setDepartureTime(rs.getDate("departureTime"));
                flight.setDuration(rs.getInt("duration"));
                flight.setCapacity(rs.getInt("capacity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flight;
    }

    public boolean addFlight(Flight flight) {
        String sql = "INSERT INTO Flights (routeID, departureTime, duration, capacity) VALUES (?, ?, ?, ?)";
        return DBContext.executeUpdate(sql, flight.getRouteID(), flight.getDepartureTime(),
                flight.getDuration(), flight.getCapacity());
    }

    public boolean updateFlight(Flight flight) {
        String sql = "UPDATE Flights SET routeID = ?, departureTime = ?, duration = ?, capacity = ? WHERE flightID = ?";
        return DBContext.executeUpdate(sql, flight.getRouteID(), flight.getDepartureTime(),
                flight.getDuration(), flight.getCapacity(), flight.getFlightID());
    }

    public boolean deleteFlight(int id) {
        String sql = "DELETE FROM Flights WHERE flightID = ?";
        return DBContext.executeUpdate(sql, id);
    }

    public List<Flight> searchFlights(int routeID, Date departureTime) {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM Flights WHERE routeID = ? AND departureTime >= ?";
        try {
            ResultSet rs = DBContext.executeQuery(sql, routeID, departureTime);
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setFlightID(rs.getInt("flightID"));
                flight.setRouteID(rs.getInt("routeID"));
                flight.setDepartureTime(rs.getDate("departureTime"));
                flight.setDuration(rs.getInt("duration"));
                flight.setCapacity(rs.getInt("capacity"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }
}
