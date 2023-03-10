/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.RoutePrice;
import db.DBContext;

/**
 *
 * @author khami
 */
public class RoutePriceDAO {

    public List<RoutePrice> getAllRoutePrices() {
        List<RoutePrice> routePrices = new ArrayList<>();
        String sql = "SELECT * FROM RoutePrices";
        try {
            ResultSet rs = DBContext.executeQuery(sql);
            while (rs.next()) {
                RoutePrice routePrice = new RoutePrice();
                routePrice.setRoutePriceID(rs.getInt("routePriceID"));
                routePrice.setRouteID(rs.getInt("routeID"));
                routePrice.setTicketTypeID(rs.getInt("ticketTypeID"));
                routePrice.setPrice(rs.getFloat("price"));
                routePrices.add(routePrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routePrices;
    }

    public RoutePrice getRoutePriceById(int id) {
        RoutePrice routePrice = null;
        String sql = "SELECT * FROM RoutePrices WHERE routePriceID = ?";
        try {
            ResultSet rs = DBContext.executeQuery(sql, id);
            if (rs.next()) {
                routePrice = new RoutePrice();
                routePrice.setRoutePriceID(rs.getInt("routePriceID"));
                routePrice.setRouteID(rs.getInt("routeID"));
                routePrice.setTicketTypeID(rs.getInt("ticketTypeID"));
                routePrice.setPrice(rs.getFloat("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routePrice;
    }

    public boolean addRoutePrice(RoutePrice routePrice) {
        String sql = "INSERT INTO RoutePrices (routeID, ticketTypeID, price) VALUES (?, ?, ?)";
        return DBContext.executeUpdate(sql, routePrice.getRouteID(), routePrice.getTicketTypeID(),
                routePrice.getPrice());
    }

    public boolean updateRoutePrice(RoutePrice routePrice) {
        String sql = "UPDATE RoutePrices SET routeID = ?, ticketTypeID = ?, price = ? WHERE routePriceID = ?";
        return DBContext.executeUpdate(sql, routePrice.getRouteID(), routePrice.getTicketTypeID(),
                routePrice.getPrice(), routePrice.getRoutePriceID());
    }

    public boolean deleteRoutePrice(int id) {
        String sql = "DELETE FROM RoutePrices WHERE routePriceID = ?";
        return DBContext.executeUpdate(sql, id);
    }

    public List<RoutePrice> getRoutePricesByRouteId(int routeId) {
        List<RoutePrice> routePrices = new ArrayList<>();
        String sql = "SELECT * FROM RoutePrices WHERE routeID = ?";
        try {
            ResultSet rs = DBContext.executeQuery(sql, routeId);
            while (rs.next()) {
                RoutePrice routePrice = new RoutePrice();
                routePrice.setRoutePriceID(rs.getInt("routePriceID"));
                routePrice.setRouteID(rs.getInt("routeID"));
                routePrice.setTicketTypeID(rs.getInt("ticketTypeID"));
                routePrice.setPrice(rs.getFloat("price"));
                routePrices.add(routePrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routePrices;
    }

    public RoutePrice getRoutePriceByRouteIdAndTicketTypeId(int routeId, int ticketTypeId) {
        RoutePrice routePrice = null;
        String sql = "SELECT price FROM RoutePrices WHERE routeID = ? AND ticketTypeID = ?";
        try {
            ResultSet rs = DBContext.executeQuery(sql, routeId, ticketTypeId);
            if (rs.next()) {
                routePrice = new RoutePrice();
                routePrice.setRoutePriceID(rs.getInt("routePriceID"));
                routePrice.setRouteID(rs.getInt("routeID"));
                routePrice.setTicketTypeID(rs.getInt("ticketTypeID"));
                routePrice.setPrice(rs.getFloat("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routePrice;
    }

}
