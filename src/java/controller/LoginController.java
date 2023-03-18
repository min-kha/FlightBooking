/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import beans.Booking;
import beans.Users;
import dao.BookingDAO;
import dao.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khami
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        UserDAO userDAO = new UserDAO();
        Users user = userDAO.getUser(username, pass);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("role", user.getRole());
            if (user.getRole() == 1) {
                if (request.getSession().getAttribute("flight") != null) {
                    continueBooking(user, request, response);
                }
                response.sendRedirect("home");
            } else if (user.getRole() == 0) {
                response.sendRedirect("adminDashboardController");
            }

        } else {
            response.sendRedirect("login");
        }

    }

    void continueBooking(Users user, HttpServletRequest request, HttpServletResponse response) throws IOException, NumberFormatException, ServletException {
        String userID = user.getUserID() + "";
        String flightID = (String) request.getSession().getAttribute("flightID");
        Booking booking = new Booking(Integer.parseInt(userID), Integer.parseInt(flightID), Date.valueOf(LocalDate.now()), false);
        
        try {
            BookingDAO bookingDAO = new BookingDAO();
            int bookingID = bookingDAO.addBooking(booking);
            int adultsNo = Integer.parseInt((String) request.getSession().getAttribute("adults"));
            
            booking.setBookingID(bookingID);
            request.setAttribute("booking", booking);
            request.getSession().setAttribute("booking", booking);
            System.out.println("SetAttribute 'booking' to Session: " + booking);
            // nhập thông tin từng khách hàng
            
            request.setAttribute("numPassengers", adultsNo);
            request.getRequestDispatcher("user/information.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/login.jsp").forward(request, response);
    }

}
