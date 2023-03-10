/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author khami
 */
public class Route {

    private int routeID;
    private int departureCityID;
    private int arrivalCityID;
    private int distance;

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public int getDepartureCityID() {
        return departureCityID;
    }

    public void setDepartureCityID(int departureCityID) {
        this.departureCityID = departureCityID;
    }

    public int getArrivalCityID() {
        return arrivalCityID;
    }

    public void setArrivalCityID(int arrivalCityID) {
        this.arrivalCityID = arrivalCityID;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
