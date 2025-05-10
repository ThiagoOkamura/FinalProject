package org.example;

import java.util.Objects;

public class InternationalFlight extends Flight {
    private Status status;

    public InternationalFlight(int flightId, String origin, String destination, String departureDate, String departureTime, double price, Status status) {
        super(flightId, origin, destination, departureDate, departureTime, price);
        this.status = status;
    }

    /**
     * sends the flight to the class TicketSystem where the flight is added to the list of departed flights
     * @return if the flight has departed
     */
    private boolean flightStatus() {
        return status.compareTo(InternationalFlight.Status.DEPARTED) == 0;
    }

    /**
     * international flight's version of flight details
     */
    @Override
    public void flightDetails() {
        System.out.println("Flight Details: \n" +
                "Flight ID: " + getFlightId() + "\n" +
                "Origin: " + getOrigin() + "\n" +
                "Destination: " + getDestination() + "\n" +
                "Departure Date: " + getDepartureDate() + "\n" +
                "Departure Time: " + getDepartureTime() + "\n" +
                "Price: " + getPrice()
        );
    }

    public static enum Status {
        DEPARTED, PENDING
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InternationalFlight that = (InternationalFlight) o;
        return status == that.status;
    }

    @Override
    public String toString() {
        return "InternationalFlight{" +
                "status=" + status +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), status);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
