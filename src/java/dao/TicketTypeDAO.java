/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.TicketType;
import db.DBContext;

/**
 *
 * @author khami
 */
public class TicketTypeDAO {

    public List<TicketType> getAllTicketTypes() {
        List<TicketType> ticketTypes = new ArrayList<>();
        String sql = "SELECT * FROM TicketTypes";
        try {
            ResultSet rs = DBContext.executeQuery(sql);
            while (rs.next()) {
                TicketType ticketType = new TicketType();
                ticketType.setTicketTypeID(rs.getInt("ticketTypeID"));
                ticketType.setTicketTypeName(rs.getString("ticketTypeName"));
                ticketTypes.add(ticketType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticketTypes;
    }

    public TicketType getTicketTypeById(int id) {
        TicketType ticketType = null;
        String sql = "SELECT * FROM TicketTypes WHERE ticketTypeID = ?";
        try {
            ResultSet rs = DBContext.executeQuery(sql, id);
            if (rs.next()) {
                ticketType = new TicketType();
                ticketType.setTicketTypeID(rs.getInt("ticketTypeID"));
                ticketType.setTicketTypeName(rs.getString("ticketTypeName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticketType;
    }

    public boolean addTicketType(TicketType ticketType) {
        String sql = "INSERT INTO TicketTypes (ticketTypeName) VALUES (?)";
        return DBContext.executeUpdate(sql, ticketType.getTicketTypeName());
    }

    public boolean updateTicketType(TicketType ticketType) {
        String sql = "UPDATE TicketTypes SET ticketTypeName = ? WHERE ticketTypeID = ?";
        return DBContext.executeUpdate(sql, ticketType.getTicketTypeName(), ticketType.getTicketTypeID());
    }

    public boolean deleteTicketType(int id) {
        String sql = "DELETE FROM TicketTypes WHERE ticketTypeID = ?";
        return DBContext.executeUpdate(sql, id);
    }
}
