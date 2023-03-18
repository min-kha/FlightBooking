/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBContext;
import beans.PassengerInfo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class PassengerInfoDAO extends DBContext {

    public List<PassengerInfo> getPassengerInfosByBookingId(int bookingId) {
        List<PassengerInfo> passengerInfos = new ArrayList<>();
        String sql = "SELECT * FROM PassengerInfo WHERE BookingID = ?";
        try ( Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, bookingId);
            try ( ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    int passengerId = rs.getInt("PassengerID");
                    String fullName = rs.getString("FullName");
                    String email = rs.getString("Email");
                    String phoneNumber = rs.getString("PhoneNumber");
                    String address = rs.getString("Address");
                    String passportNumber = rs.getString("PassportNumber");
                    Date dateOfBirth = rs.getDate("DateOfBirth");
                    PassengerInfo passengerInfo = new PassengerInfo(passengerId, bookingId, fullName, email,
                            phoneNumber, address, passportNumber, dateOfBirth);
                    passengerInfos.add(passengerInfo);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return passengerInfos;
    }

    public boolean addPassengerInfo(PassengerInfo passengerInfo) {
        String sql = "INSERT INTO PassengerInfo(BookingID, FullName, Email, PhoneNumber, Address, PassportNumber, DateOfBirth) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try ( Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, passengerInfo.getBookingID());
            statement.setString(2, passengerInfo.getFullName());
            statement.setString(3, passengerInfo.getEmail());
            statement.setString(4, passengerInfo.getPhoneNumber());
            statement.setString(5, passengerInfo.getAddress());
            statement.setString(6, passengerInfo.getPassportNumber());
            statement.setDate(7, passengerInfo.getDateOfBirth());
            int result = statement.executeUpdate();
            return result > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

}
