package org.example;

import java.util.Objects;

public class Flight implements Comparable<Flight> {
    private int flightId;
    private String origin;
    private String destination;
    private String departureDate; // Format: YYYY-MM-DD
    private String departureTime; // Format: HH:MM
    private double price;

    public Flight(int flightId, String origin, String destination, String departureDate, String departureTime, double price) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.price = price;
    }

    private void flightDetails() {
        //TODO
    }

    private boolean isAvailable() {
        //TODO
        return true;
    }

    @Override
    public int compareTo(Flight o) {
        return this.flightId - o.flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Double.compare(price, flight.price) == 0 && Objects.equals(flightId, flight.flightId) && Objects.equals(origin, flight.origin) && Objects.equals(destination, flight.destination) && Objects.equals(departureDate, flight.departureDate) && Objects.equals(departureTime, flight.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, origin, destination, departureDate, departureTime, price);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", price=" + price +
                '}';
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
