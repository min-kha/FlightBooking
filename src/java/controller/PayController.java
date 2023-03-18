/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import beans.Booking;
import beans.PassengerInfo;
import dao.BookingDAO;
import dao.PassengerInfoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khami
 */
@WebServlet(name = "PayController", urlPatterns = {"/pay"})
public class PayController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PayController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PayController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Booking booking = (Booking) request.getSession().getAttribute("booking");
            if (booking == null) {
                throw new SQLException("Booking null!");
            }
            new BookingDAO().updateBookingToPaired(booking.getBookingID());
            System.out.println("Paired booking: " + booking);
            PassengerInfoDAO passengerInfoDAO = new PassengerInfoDAO();
            HttpSession session = request.getSession();
            if (session.getAttribute("passengerInfos") != null) {
                System.out.println("Confirmation Controller: " + session.getAttribute("passengerInfos"));
                if (session.getAttribute("passengerInfos") != null) {
                    @SuppressWarnings("unchecked")
                    List<PassengerInfo> passengerInfos = (List<PassengerInfo>) session.getAttribute("passengerInfos");
                    for (PassengerInfo passengerInfo : passengerInfos) {
                        passengerInfoDAO.addPassengerInfo(passengerInfo);
                        System.out.println("added passengerInfo: " + passengerInfo + " info from passengerInfoController");
                    }
                }
            }
            response.sendRedirect("ticket");
        } catch (SQLException ex) {
            Logger.getLogger(PayController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PayController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
