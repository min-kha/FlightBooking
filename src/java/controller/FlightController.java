/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import beans.Flight;
import dao.FlightDAO;
import dao.RouteDAO;
import jakarta.servlet.ServletConfig;
import java.sql.Timestamp;

/**
 *
 * @author khami
 */
public class FlightController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private FlightDAO flightDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        flightDAO = new FlightDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getRequestURI();
        // /FlightBooking/flight
        action = action.substring("/FlightBooking/flight".length());
        System.out.println("Action(FlightCRUD): " + action);
        try {
            switch (action) {
                case "/list":
                    listFlights(request, response);
                    break;
                case "/showFormForAdd":
                    showFormForAdd(request, response);
                    break;
                case "/showFormForUpdate":
                    showFormForUpdate(request, response);
                    break;
                case "/delete":
                    deleteFlight(request, response);
                    break;
//                case "/search":
//                    searchFlights(request, response);
//                    break;
                default:
                    listFlights(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        try {
            switch (action) {
                case "/add":
                    addFlight(request, response);
                    break;
                case "/update":
                    updateFlight(request, response);
                    break;
                default:
                    listFlights(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listFlights(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Flight> flights = flightDAO.getAllFlights();
        request.setAttribute("flights", flights);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/flights.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormForAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("routes", new RouteDAO().getAllRoutes());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/flight-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormForUpdate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Flight flight = flightDAO.getFlightById(id);
        request.setAttribute("flight", flight);
        request.setAttribute("routes", new RouteDAO().getAllRoutes());
        System.out.println("Routes: " + new RouteDAO().getAllRoutes());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/flight-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addFlight(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int routeID = Integer.parseInt(request.getParameter("routeID"));
        String departureTime = request.getParameter("departureTime");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        String ticketType = request.getParameter("ticketType");
        float price = Float.parseFloat(request.getParameter("price"));

        Flight newFlight = new Flight(routeID, Timestamp.valueOf(departureTime), duration, capacity, ticketType, price);
        flightDAO.addFlight(newFlight);
        response.sendRedirect("list");
    }

    private void updateFlight(HttpServletRequest request, HttpServletResponse response) {
        int flightID = Integer.parseInt(request.getParameter("flightID"));
        int routeID = Integer.parseInt(request.getParameter("routeID"));
        String departureTimeString = request.getParameter("departureTime");
        departureTimeString = departureTimeString.substring(0, 10) + " " + departureTimeString.substring(11) + ":00";
        System.out.println("time: " + departureTimeString);
        int duration = Integer.parseInt(request.getParameter("duration"));
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        String ticketType = request.getParameter("ticketType");
        float price = Float.parseFloat(request.getParameter("price"));
        Flight flight = new Flight(flightID, routeID, Timestamp.valueOf(departureTimeString), duration, capacity, ticketType, price);
        boolean success = flightDAO.updateFlight(flight);
        try {

            if (success) {
                response.sendRedirect(request.getContextPath() + "/flight");

            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
        } catch (IOException ex) {
            Logger.getLogger(FlightController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(FlightController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteFlight(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int flightId = Integer.parseInt(request.getParameter("id"));
        boolean result;
        result = flightDAO.deleteFlight(flightId);
        System.out.println("Delete: " + flightId + "| -> " + result);
        if (result) {
            response.sendRedirect(request.getContextPath() + "/flight");
        } else {
            response.getWriter().println("Failed to delete flight.");
        }
    }
}
