package org.example;

import java.util.Objects;

public class Ticket {
    private String flightId;
    private String seat;
    private double price;
    private String status; // e.g., "pending", "confirmed", "cancelled"
    private String passengerName;

    public Ticket(String flightId, String seat, double price, String status, String passengerName) {
        this.flightId = flightId;
        this.seat = seat;
        this.price = price;
        this.status = status;
        this.passengerName = passengerName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Double.compare(price, ticket.price) == 0 && Objects.equals(flightId, ticket.flightId) && Objects.equals(seat, ticket.seat) && Objects.equals(status, ticket.status) && Objects.equals(passengerName, ticket.passengerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, seat, price, status, passengerName);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "flightId='" + flightId + '\'' +
                ", seat='" + seat + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", passengerName='" + passengerName + '\'' +
                '}';
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
}
