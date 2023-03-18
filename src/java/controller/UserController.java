/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import beans.Users;
import dao.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
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
@WebServlet(name = "UserController", urlPatterns = {"/userController/*"})
public class UserController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI();
        System.out.println("Action(UserCRUD): " + action);
        final String urlPatterns = "/FlightBooking/userController";

        try {
            switch (action) {
                case urlPatterns + "/list":
                    listAllUsers(request, response);
                    break;
                case urlPatterns + "/add":
                    listAllUsers(request, response);
                    break;
                case urlPatterns + "/register":
                    registerUser(request, response);
                    break;
                case urlPatterns + "/delete":
                    deleteUser(request, response);
                    break;
                case urlPatterns + "/get":
                    getUser(request, response);
                    break;
                case urlPatterns + "/update":
                    updateUser(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        System.out.println("Entering getUser");

        int userId = Integer.parseInt(request.getParameter("userId"));
        System.out.println("getUser, userId==>" + userId);

        Users user = userDAO.getUserById(userId);
        System.out.println("getUser, employee details==>" + user);

        request.setAttribute("user", user);

    }

    private void listAllUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        System.out.println("Entering listAllUsers");

        List<Users> users = userDAO.getAllUsers();
        System.out.println("Getting listAllUsers");
        System.out.println("listAllUsers: " + users);

        request.setAttribute("users", users);
        redirectToList(request, response);
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phoneNumber");
        Users user = new Users(username, password, fullName, email, phone, address, 1); // 1 is User
        boolean result = userDAO.addUser(user);
        System.out.println("Add: ==>" + user + ": " + result);
        response.sendRedirect(request.getContextPath() + "/login");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            Users user = (Users) request.getSession().getAttribute("user");
            // Lấy thông tin người dùng từ biểu mẫu

            user.setFullName(request.getParameter("fullname"));
            user.setEmail(request.getParameter("email"));
            user.setAddress(request.getParameter("address"));
            user.setPhoneNumber(request.getParameter("phone"));

            // Cập nhật thông tin người dùng trong cơ sở dữ liệu
            userDAO.updateUser(user);
            System.out.println("Update: " + user);
            response.sendRedirect("../profile");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int userID = Integer.parseInt(request.getParameter("userID"));
        boolean result;
        try {
            result = userDAO.deleteUser(userID);
            System.out.println("Is " + userID + " deleted? ==> " + result);
            listAllUsers(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void redirectToList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/listUser.jsp");
        dispatcher.forward(request, response);
    }
}
