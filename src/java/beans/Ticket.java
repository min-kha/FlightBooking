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
public class Ticket {
    private int userID, passengerID;
    private String fullName, from, to; 
    private Timestamp time;
    private String type;
    private float price;
    private boolean isPaid;

    public Ticket() {
    }

    
    public Ticket(int userID, int passengerID, String fullName, String from, String to, Timestamp time, String type, float price, boolean isPaid) {
        this.userID = userID;
        this.passengerID = passengerID;
        this.fullName = fullName;
        this.from = from;
        this.to = to;
        this.time = time;
        this.type = type;
        this.price = price;
        this.isPaid = isPaid;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
    
    
}
