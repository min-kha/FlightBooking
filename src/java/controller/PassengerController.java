/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import beans.PassengerInfo;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khami
 */
@WebServlet(name = "InfomationController", urlPatterns = {"/information"})
public class PassengerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("user/information.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int numPassengers = Integer.parseInt(request.getParameter("numPassengers"));
        int bookingID = Integer.parseInt(request.getParameter("bookingID"));
        List<PassengerInfo> passengerInfos = new ArrayList<>();
        for (int i = 1; i <= numPassengers; i++) {
            String fullName = request.getParameter("fullName_" + i);
            String email = request.getParameter("email_" + i);
            String phoneNumber = request.getParameter("phoneNumber_" + i);
            String address = request.getParameter("address_" + i);
            String passportNumber = request.getParameter("passportNumber_" + i);
            LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth_" + i));

            PassengerInfo passengerInfo = new PassengerInfo(bookingID, fullName, email, phoneNumber, address, passportNumber, Date.valueOf(dateOfBirth));
            passengerInfos.add(passengerInfo);
        }
        HttpSession session = request.getSession();
        session.setAttribute("passengerInfos", passengerInfos);
        request.setAttribute("numPassengers", numPassengers);
        request.getRequestDispatcher("/user/confirmation.jsp").forward(request, response);
    }
}
