/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author khami
 */
public class DBContext {

    private final static String URL = "jdbc:sqlserver://MINHKHA\\MINHKHA:1433;databaseName=FlightBookingDB";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";
    private static PreparedStatement preparedStatement;
    public static ResultSet rs;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private static PreparedStatement getStatement(String sql, Object... args) {
        try {
            preparedStatement = getConnection().prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            return preparedStatement;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            preparedStatement = getStatement(sql, args);
            assert preparedStatement != null;
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean executeUpdate(String sql, Object... args) {
        try {
            preparedStatement = getStatement(sql, args);
            assert preparedStatement != null;
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
