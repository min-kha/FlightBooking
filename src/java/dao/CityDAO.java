/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.City;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.DBContext;

/**
 *
 * @author khami
 */
public class CityDAO {

    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT * FROM Cities";
        try {
            ResultSet rs = DBContext.executeQuery(sql);
            while (rs.next()) {
                City city = new City();
                city.setCityID(rs.getInt("cityID"));
                city.setCityName(rs.getString("cityName"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public City getCityById(int id) {
        City city = null;
        String sql = "SELECT * FROM Cities WHERE cityID = ?";
        try {
            ResultSet rs = DBContext.executeQuery(sql, id);
            if (rs.next()) {
                city = new City();
                city.setCityID(rs.getInt("cityID"));
                city.setCityName(rs.getString("cityName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    public boolean addCity(City city) {
        String sql = "INSERT INTO Cities (cityName) VALUES (?)";
        return DBContext.executeUpdate(sql, city.getCityName());
    }

    public boolean updateCity(City city) {
        String sql = "UPDATE Cities SET cityName = ? WHERE cityID = ?";
        return DBContext.executeUpdate(sql, city.getCityName(), city.getCityID());
    }

    public boolean deleteCity(int id) {
        String sql = "DELETE FROM Cities WHERE cityID = ?";
        return DBContext.executeUpdate(sql, id);
    }

}
