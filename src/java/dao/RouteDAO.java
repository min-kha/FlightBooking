/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.DBContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.Route;

/**
 *
 * @author khami
 */
public class RouteDAO {

    public List<Route> getAllRoutes() {
        List<Route> routes = new ArrayList<>();
        String sql = "SELECT * FROM Route";
        try {
            ResultSet rs = DBContext.executeQuery(sql);
            while (rs.next()) {
                Route route = new Route();
                route.setRouteID(rs.getInt("routeID"));
                route.setDepartureCityID(rs.getInt("departureCityID"));
                route.setArrivalCityID(rs.getInt("arrivalCityID"));
                route.setDistance(rs.getInt("distance"));
                routes.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routes;
    }

    public Route getRouteById(int id) {
        Route route = null;
        String sql = "SELECT * FROM Route WHERE routeID = ?";
        try {
            ResultSet rs = DBContext.executeQuery(sql, id);
            if (rs.next()) {
                route = new Route();
                route.setRouteID(rs.getInt("routeID"));
                route.setDepartureCityID(rs.getInt("departureCityID"));
                route.setArrivalCityID(rs.getInt("arrivalCityID"));
                route.setDistance(rs.getInt("distance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return route;
    }

    public Route getRouteByCity(int departureCityID, int arrivalCityID) {
        Route route = null;
        String sql = "SELECT TOP 1 * FROM Route WHERE departureCityID = ? AND arrivalCityID = ?";
        try {
            ResultSet rs = DBContext.executeQuery(sql, departureCityID, arrivalCityID);
            while (rs.next()) {
                route = new Route();
                route.setRouteID(rs.getInt("routeID"));
                route.setDepartureCityID(rs.getInt("departureCityID"));
                route.setArrivalCityID(rs.getInt("arrivalCityID"));
                route.setDistance(rs.getInt("distance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return route;
    }

    public boolean addRoute(Route route) {
        String sql = "INSERT INTO Route (departureCityID, arrivalCityID, distance) VALUES (?, ?, ?)";
        return DBContext.executeUpdate(sql, route.getDepartureCityID(), route.getArrivalCityID(),
                route.getDistance());
    }

    public boolean updateRoute(Route route) {
        String sql = "UPDATE Route SET departureCityID = ?, arrivalCityID = ?, distance = ? WHERE routeID = ?";
        return DBContext.executeUpdate(sql, route.getDepartureCityID(), route.getArrivalCityID(),
                route.getDistance(), route.getRouteID());
    }

    public boolean deleteRoute(int id) {
        String sql = "DELETE FROM Route WHERE routeID = ?";
        return DBContext.executeUpdate(sql, id);
    }

}
