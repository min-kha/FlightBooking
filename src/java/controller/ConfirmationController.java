/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import beans.PassengerInfo;
import dao.PassengerInfoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author khami
 */
@WebServlet(name = "Confirmation", urlPatterns = {"/confirmation"})
public class ConfirmationController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

    }

}
