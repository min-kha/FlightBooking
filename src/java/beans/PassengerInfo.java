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
public class PassengerInfo {

    private int passengerID;
    private int bookingID;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private String passportNumber;
    private Date dateOfBirth;

    public PassengerInfo() {
    }

    public PassengerInfo(int bookingID, String fullName, String email, String phoneNumber, String address, String passportNumber, Date dateOfBirth) {
        this.bookingID = bookingID;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.passportNumber = passportNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public PassengerInfo(int passengerID, int bookingID, String fullName, String email, String phoneNumber, String address, String passportNumber, Date dateOfBirth) {
        this.passengerID = passengerID;
        this.bookingID = bookingID;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.passportNumber = passportNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "PassengerInfo{"
                + "passengerID=" + passengerID
                + ", bookingID=" + bookingID
                + ", fullName='" + fullName + '\''
                + ", email='" + email + '\''
                + ", phoneNumber='" + phoneNumber + '\''
                + ", address='" + address + '\''
                + ", passportNumber='" + passportNumber + '\''
                + ", dateOfBirth=" + dateOfBirth
                + '}';
    }
}
