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

/**
 *
 * @author khami
 */
@WebServlet(name = "AdminController", urlPatterns = {"/adminController/*"})
public class AdminController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI();
        System.out.println("Action(admin): " + action);
        final String urlPatterns = "/FlightBooking/adminController";
        request.getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);
        try {
            switch (action) {
                case urlPatterns + "/list":
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
                default:
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
        System.out.println("listAllUsers employees size ==> " + users);

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
//        try {
//            String employeeIds = request.getParameter("employeeIds");
//            StringTokenizer tokenizer = new StringTokenizer(employeeIds, ",");
//
//            while (tokenizer.hasMoreTokens()) {
//                String employeeId = tokenizer.nextElement().toString();
//                System.out.println("User ID to be deleted,  employeeId ==>" + employeeId);
//
//                boolean result = UserDAO.deleteUser(Integer.parseInt(employeeId));
//                System.out.println("is employeeId " + employeeId + " deleted ? " + result);
//            }
//
//            List<User> employees = UserDAO.getAllUsers();
//            System.out.println("insertResult employees ==>" + employees.size());
//
//            request.setAttribute("employees", employees);
//            //request.setAttribute("deleteUser", result+"");
//            redirectToList(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private void redirectToList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/listUser.jsp");
        dispatcher.forward(request, response);
    }
}
