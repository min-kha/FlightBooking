/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import beans.Ticket;
import beans.Users;
import dao.TicketDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khami
 */
@WebServlet(name = "TicketController", urlPatterns = {"/ticket/*"})
public class TicketController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TicketDAO ticketDAO;

    @Override
    public void init() throws ServletException {
        super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        try {
            ticketDAO = new TicketDAO();
        } catch (SQLException ex) {
            Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI();
        System.out.println("Action(TicketCRUD): " + action);
        final String urlPatterns = "/FlightBooking/ticket";

        try {
            switch (action) {
                case urlPatterns + "/list":
                    listAllTicket(request, response);
                    break;
                case urlPatterns + "/add":
                    addTicket(request, response);
                    break;
                case urlPatterns + "/delete":
                    System.out.println("Delete link!");
                    deleteTicket(request, response);
                    break;
                case urlPatterns + "/get":
                    getTicket(request, response);
                    break;
                case urlPatterns + "/update":
                    updateTicket(request, response);
                    break;
                default:
                    System.out.println("Default link!");
                    listAllTicket(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void listAllTicket(HttpServletRequest request, HttpServletResponse response) {
        try {

            Users user = (Users) (request.getSession().getAttribute("user"));
            int userID = user.getUserID();
            List<Ticket> tickets = ticketDAO.getTiketsByUserID(userID);
            System.out.println("listAllTickets: ==> " + tickets.toString());
            request.setAttribute("tickets", tickets);
            request.getRequestDispatcher("/user/listTicket.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addTicket(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void deleteTicket(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int passengerID = Integer.parseInt(request.getParameter("passengerId"));
        try {
            System.out.println("Delete passengerId: " + passengerID);
            ticketDAO.deleteTicket(passengerID);
        } catch (SQLException ex) {
            Logger.getLogger(TicketController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/ticket");
    }

    private void getTicket(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void updateTicket(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
