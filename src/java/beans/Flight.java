/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.sql.Timestamp;

/**
 *
 * @author khami
 */
public class Flight {

    private int flightID;
    private int routeID;
    private Timestamp departureTime;
    private int duration;
    private int capacity;
    private String ticketType;
    private float price;

    public Flight() {
    }

    public Flight(int flightID, int routeID, Timestamp departureTime, int duration, int capacity, String ticketType, float price) {
        this.flightID = flightID;
        this.routeID = routeID;
        this.departureTime = departureTime;
        this.duration = duration;
        this.capacity = capacity;
        this.ticketType = ticketType;
        this.price = price;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{"
                + "flightID=" + flightID
                + ", routeID=" + routeID
                + ", departureTime=" + departureTime
                + ", duration=" + duration
                + ", capacity=" + capacity
                + ", ticketType='" + ticketType + '\''
                + ", price=" + price
                + '}';
    }
}
