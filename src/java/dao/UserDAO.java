/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.User;
import db.DBContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khami
 */
public class UserDAO {

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        ResultSet rs = DBContext.executeQuery(sql);
        while (rs.next()) {
            User user = new User();
            user.setUserID(rs.getInt("userID"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setFullName(rs.getString("fullName"));
            user.setEmail(rs.getString("email"));
            user.setPhoneNumber(rs.getString("phoneNumber"));
            user.setAddress(rs.getString("address"));
            user.setRole(rs.getInt("role"));
            users.add(user);
        }
        return users;
    }

    public User getUserById(int userID) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM Users WHERE userID = ?";
        ResultSet rs = DBContext.executeQuery(sql, userID);
        if (rs.next()) {
            user = new User();
            user.setUserID(rs.getInt("userID"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setFullName(rs.getString("fullName"));
            user.setEmail(rs.getString("email"));
            user.setPhoneNumber(rs.getString("phoneNumber"));
            user.setAddress(rs.getString("address"));
            user.setRole(rs.getInt("role"));
        }
        return user;
    }

    public boolean addUser(User user) throws SQLException {
        String sql = "INSERT INTO Users(username, password, fullName, email, phoneNumber, address, role) VALUES(?, ?, ?, ?, ?, ?, ?)";
        return DBContext.executeUpdate(sql, user.getUsername(), user.getPassword(), user.getFullName(), user.getEmail(), user.getPhoneNumber(), user.getAddress(), user.getRole());
    }

    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE Users SET username = ?, password = ?, fullName = ?, email = ?, phoneNumber = ?, address = ?, role = ? WHERE userID = ?";
        return DBContext.executeUpdate(sql, user.getUsername(), user.getPassword(), user.getFullName(), user.getEmail(), user.getPhoneNumber(), user.getAddress(), user.getRole(), user.getUserID());
    }

    public boolean deleteUser(int userID) throws SQLException {
        String sql = "DELETE FROM Users WHERE userID = ?";
        return DBContext.executeUpdate(sql, userID);
    }

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM Users WHERE username = ?";
        try {
            ResultSet rs = DBContext.executeQuery(sql, username);
            if (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullName"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getInt("role"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
