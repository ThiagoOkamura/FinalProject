package org.example;

import java.util.*;

public class Passenger extends User {
    private boolean frequentFlyer;
    private List<Ticket> tickets;
    private TicketReservation ticketReservation;
    private Sorting sorting;

    public Passenger(int id, String name, String email) {
        super(id, name, email);
        this.frequentFlyer = frequentFlyer;
        this.tickets = new ArrayList<>();
        this.ticketReservation = ticketReservation;

    }

    /**
     * displays the Passenger version of the menu
     */
    @Override
    public void displayMenu() {
        System.out.println("Passenger Menu:");
        System.out.println("1. Search for Flights");
        System.out.println("2. Book Flight");
        System.out.println("3. Cancel Reservation");
        System.out.println("4. Modify Reservation");
    }

    /**
     * allows the passenger to search for a flight based on its origin
     * @param availableFlights the list of available flights
     * @param origin the origin of the flight
     * @param destination the destination of the flight
     * @param date the day of departure
     */
    public void searchFlights(List<Flight> availableFlights, String origin, String destination, String date) {
        System.out.println("Searching for flights from " + origin + " to " + destination + " on " + date + ":");
        for (Flight flight : availableFlights) {
            if (flight.getOrigin().equalsIgnoreCase(origin) &&
                    flight.getDestination().equalsIgnoreCase(destination) &&
                    flight.getDepartureDate().equals(date)) {
                System.out.println(flight.getDestination() + " " + flight.getDepartureDate() + " " + flight.getDepartureTime());
            }
        }
    }

    /**
     * allows for the passenger to book a flight
     * @param flightId the ID of the flight
     * @param price the cost to buy the ticket
     * @param seat the seat assigned to the possenger
     */
    public void bookFlight(String flightId, double price, String seat) {
        ticketReservation.bookFlight(flightId, name);
        Ticket ticket = new Ticket(flightId, seat, price, "pending", name);
        tickets.add(ticket);
        System.out.println("Flight successfully booked.");
    }

    /**
     * allows for the passenger to cancel a flight based on its id
     * @param flightId the flight id
     */
    public void cancelReservation(String flightId) {
        Ticket toRemove = null;
        for (Ticket ticket : tickets) {
            if (ticket.getFlightId().equals(flightId)) {
                toRemove = ticket;
                break;
            }
        }
        if (toRemove != null) {
            ticketReservation.cancelFlight(flightId);
            tickets.remove(toRemove);
            System.out.println("Reservation successfully cancelled.");
        } else {
            System.out.println("You have no reservation for flight: " + flightId);
        }
    }

    /**
     * allows for the user to see all their flight reservations
     */
    public void viewMyReservations() {
        if (tickets == null) {
            return;
        }

        if (tickets.isEmpty()) {
            System.out.println("You have no reservations.");
            return;
        }
        System.out.println("Your Reservations:");
        for (Ticket ticket : tickets) {
            System.out.println("- " + ticket);
        }
    }

    /**
     * sorting based on id, then name if the id is the same
     */
    class idNameComparator implements Comparator<Passenger> {

        @Override
        public int compare(Passenger o1, Passenger o2) {
            if (sorting.compareTo(Sorting.NAME) == 0) {
                return o1.name.compareTo(o2.name);
            }

            else return o1.id - o2.id;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Passenger passenger = (Passenger) o;
        return frequentFlyer == passenger.frequentFlyer && Objects.equals(tickets, passenger.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), frequentFlyer, tickets);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "frequentFlyer=" + frequentFlyer +
                ", tickets=" + tickets +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public boolean isFrequentFlyer() {
        return frequentFlyer;
    }

    public void setFrequentFlyer(boolean frequentFlyer) {
        this.frequentFlyer = frequentFlyer;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public static enum Sorting {
        ID, NAME;
    }
}
