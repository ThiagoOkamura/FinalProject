package org.example;

import java.util.*;

public class TicketReservation {
    private double price;
    private String flightId;
    private String seat;
    private String status;
    private String passengerName;
    private static Map<String, String> bookings;
    private static Map<String, String> statuses = new HashMap<>();

    public TicketReservation(double price, String flightId, String seat, String status, String passengerName, Map<String, String> bookings) {
        this.price = price;
        this.flightId = flightId;
        this.seat = seat;
        this.status = status;
        this.passengerName = passengerName;
        this.bookings = new HashMap<>();
    }

    /**
     * registers a passenger into a flight
     * @param flightId the id of the flight
     * @param passengerName the name of the passenger to be assigned
     */
    public void bookFlight(String flightId, String passengerName) {
        bookings.put(flightId, passengerName);
        statuses.put(flightId, "pending");
        System.out.println(passengerName + " successfully assigned to flight: " + flightId + " (pending)");
    }

    /**
     * allows for the company to cancel a flight registration
     * @param flightId the id of the flight
     */
    public static void cancelFlight(String flightId) {
        if (bookings.containsKey(flightId)) {
            statuses.put(flightId, "cancelled");
            System.out.println("Booking cancelled: " + flightId);
        } else {
            System.out.println("Flight ID not found.");
        }
    }

    /**
     * allows for the company to confirm a registration
     * @param flightId the flight ID of the reservation
     */
    public static void confirmReservation(String flightId) {
        if (statuses.containsKey(flightId) && statuses.get(flightId).equals("pending")) {
            statuses.put(flightId, "confirmed");
            System.out.println("Reservation confirmed for flight: " + flightId);
        } else {
            System.out.println("Cannot confirm: Either not found or already confirmed/cancelled.");
        }
    }

    /**
     * shows all the registrations in a flight
     */
    public static void viewAllRegistrations() {
        System.out.println("All Registrations:");
        for (String flightId : bookings.keySet()) {
            String passenger = bookings.get(flightId);
            String status = statuses.getOrDefault(flightId, "unknown");
            System.out.println("Flight ID: " + flightId + ", Passenger: " + passenger + ", Status: " + status);
        }
    }

    /**
     * allows for a passenger to modify flight information
     * @param flightId the flight to be modified
     * @param newDetails the new flight details
     */
    public void modifyTicket(String flightId, String newDetails) {
        if (bookings.containsKey(flightId)) {
            bookings.put(flightId, newDetails);
            System.out.println("Booking modified: " + flightId);
        } else {
            System.out.println("Ticket ID not found.");
        }
    }

    /**
     * shows all bookings
     */
    public void viewAllBookings() {
        System.out.println("All Bookings:");
        for (Map.Entry<String, String> entry : bookings.entrySet()) {
            System.out.println("Ticket ID: " + entry.getKey() + ", Details: " + entry.getValue());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TicketReservation that = (TicketReservation) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(flightId, that.flightId) && Objects.equals(seat, that.seat) && Objects.equals(status, that.status) && Objects.equals(passengerName, that.passengerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, flightId, seat, status, passengerName);
    }

    @Override
    public String toString() {
        return "TicketReservation{" +
                "price=" + price +
                ", flightId='" + flightId + '\'' +
                ", seat='" + seat + '\'' +
                ", status='" + status + '\'' +
                ", passengerName='" + passengerName + '\'' +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public static Map<String, String> getBookings() {
        return bookings;
    }

    public static void setBookings(Map<String, String> bookings) {
        TicketReservation.bookings = bookings;
    }

    public static Map<String, String> getStatuses() {
        return statuses;
    }

    public static void setStatuses(Map<String, String> statuses) {
        TicketReservation.statuses = statuses;
    }
}