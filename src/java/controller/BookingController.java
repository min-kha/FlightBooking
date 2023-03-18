/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import beans.Booking;
import beans.Flight;
import beans.Route;
import beans.Users;
import dao.BookingDAO;
import dao.CityDAO;
import dao.FlightDAO;
import dao.RouteDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khami
 */
@WebServlet(name = "BookingController", urlPatterns = {"/booking"})
public class BookingController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightType = request.getParameter("flightType");
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String departureDate = request.getParameter("departureDate");
        String returnDate = request.getParameter("returnDate");
        String adults = request.getParameter("adults");
        String children = request.getParameter("children");
        String ticketType = request.getParameter("ticketType");
        Route route = new RouteDAO().getRouteByCity(Integer.parseInt(from), Integer.parseInt(to));
        FlightDAO flightDAO = new FlightDAO();

        List<Flight> flights = flightDAO.searchFlights(route.getRouteID(), Date.valueOf(departureDate));

        flights.sort((Object f1, Object f2) -> ((Flight) f1).getDepartureTime().compareTo(((Flight) f2).getDepartureTime()));
        // TODO: Viết câu lệnh sql để lấy tất cả thông tin
        for (Flight flight : flights) {
            System.out.println(flight.toString());
        }

        request.setAttribute("flights", flights);
        request.setAttribute("from", new CityDAO().getCityById(Integer.parseInt(from)).getCityName());
        request.setAttribute("to", new CityDAO().getCityById(Integer.parseInt(to)).getCityName());
        request.getRequestDispatcher("user/listflight.jsp").forward(request, response);

        // Lưu thông tin vào session scope
        HttpSession session = request.getSession();
        session.setAttribute("from", new CityDAO().getCityById(Integer.parseInt(from)).getCityName());
        session.setAttribute("to", new CityDAO().getCityById(Integer.parseInt(to)).getCityName());
        session.setAttribute("departureDate", departureDate);
        session.setAttribute("returnDate", returnDate);
        session.setAttribute("adults", adults);
        session.setAttribute("children", children);
        session.setAttribute("ticketType", ticketType);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String flightID = request.getParameter("f");
        session.setAttribute("flightID", flightID);
        session.setAttribute("flight", new FlightDAO().getFlightById(Integer.parseInt(flightID)));
        Users user = (Users) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login");
            return;
        }
        String from = (String) session.getAttribute("from");
        String to = (String) session.getAttribute("to");
        String departureDate = (String) session.getAttribute("departureDate");
        String returnDate = (String) session.getAttribute("returnDate");
        int adultsNo = Integer.parseInt((String) session.getAttribute("adults"));
        int childsNo = Integer.parseInt((String) session.getAttribute("children"));
        String ticketType = (String) session.getAttribute("ticketType");
        String userID = user.getUserID() + "";
        Booking booking = new Booking(Integer.parseInt(userID), Integer.parseInt(flightID), Date.valueOf(LocalDate.now()), false);
        try {
            BookingDAO bookingDAO = new BookingDAO();
            int bookingID = bookingDAO.addBooking(booking);
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

}
