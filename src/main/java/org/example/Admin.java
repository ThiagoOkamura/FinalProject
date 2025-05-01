package org.example;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private TicketReservation ticketReservation;

    public Admin(int id, String name, String email) {
        super(id, name, email);
        this.ticketReservation = ticketReservation;
    }

    /**
     * displays the Admin version of the menu
     */
    @Override
    public void displayMenu() {
        System.out.println("Admin Menu:");
        System.out.println("1. View All Registrations");
        System.out.println("2. Confirm Reservation");
        System.out.println("3. Cancel Reservation");
    }

    public void viewAllRegistrations() {
        TicketReservation.viewAllRegistrations();
    }

    public void confirmReservation(String flightId) {
        TicketReservation.confirmReservation(flightId);
    }

    public void cancelReservation(String flightId) {
        TicketReservation.cancelFlight(flightId);
    }
}

