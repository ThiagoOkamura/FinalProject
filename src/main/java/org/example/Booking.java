package org.example;

public interface Booking {
    void bookFlight(String ticketId, String flightDetails);
    void cancelFlight(String ticketId);
    void modifyTicket(String ticketId, String newDetails);
}
