/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import beans.Users;
import dao.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
                    continueBooking(request, response);
                    return;
                }
                response.sendRedirect("home");
            } else if (user.getRole() == 0) {
                response.sendRedirect(request.getContextPath() + "/adminController");
            }

        } else {
            response.sendRedirect("login");
        }

    }

    void continueBooking(HttpServletRequest request, HttpServletResponse response) throws IOException, NumberFormatException, ServletException {
        String flightID = (String) request.getSession().getAttribute("flightID");
        response.sendRedirect("/FlightBooking/booking?f=" + flightID);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/login.jsp").forward(request, response);
    }

}
