/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.sql.Date;

/**
 *
 * @author khami
 */
public class Booking {

    private int bookingID;
    private int userID;
    private int flightID;
    private Date bookingTime;
    private boolean isPaid;

    public Booking() {
    }

    public Booking(int bookingID, int userID, int flightID, Date bookingTime, boolean isPaid) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.flightID = flightID;
        this.bookingTime = bookingTime;
        this.isPaid = isPaid;
    }

    public Booking(int userID, int flightID, Date bookingTime, boolean isPaid) {
        this.userID = userID;
        this.flightID = flightID;
        this.bookingTime = bookingTime;
        this.isPaid = isPaid;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    @Override
    public String toString() {
        return "Booking [bookingID=" + bookingID + ", userID=" + userID
                + ", flightID=" + flightID + ", bookingTime=" + bookingTime
                + ", isPaid=" + isPaid + "]";
    }
}
