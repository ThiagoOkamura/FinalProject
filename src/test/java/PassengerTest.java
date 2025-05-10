import org.example.Flight;
import org.example.Passenger;
import org.example.Ticket;
import org.example.TicketReservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PassengerTest {

    private Passenger passenger;
    private TicketReservation reservationSystem;

    @Test
    public void testSearchFLights() {
        List<Flight> availableFlights = new ArrayList<>();
        availableFlights.add(new Flight(0013, "Paris", "Tokyo", "2025-07-01", "09:00", 700));
        availableFlights.add(new Flight(12, "New York", "London", "2025-07-01", "12:00", 600));

        List<Flight> expected = new ArrayList<>();
        expected.add(availableFlights.get(0));

        List<Flight> result = new ArrayList<>();
        for (Flight flight : availableFlights) {
            if (flight.getOrigin().equalsIgnoreCase("Paris") &&
                    flight.getDestination().equalsIgnoreCase("Tokyo") &&
                    flight.getDepartureDate().equals("2025-07-01")) {
                result.add(flight);
            }
        }

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testBookFlight() {
        passenger.bookFlight("FL123", 500.0, "12A");
        List<Ticket> expected = new ArrayList<>();
        expected.add(new Ticket("FL123", "12A", 500.0, "pending", "John Doe"));

        List<Ticket> result = passenger.getTickets();
        Assertions.assertEquals(expected.get(0).getFlightId(), result.get(0).getFlightId());
    }

    @Test
    public void testCancelReservation() {
        passenger.bookFlight("FL123", 500.0, "12A");
        passenger.cancelReservation("FL123");
        List<Ticket> expected = new ArrayList<>();
        List<Ticket> result = passenger.getTickets();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCancelReservationt() {
        passenger.cancelReservation("INVALID");
        List<Ticket> expected = new ArrayList<>();
        List<Ticket> result = passenger.getTickets();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testSearchFlights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(003, "Paris", "Tokyo", "2025-07-01", "09:00", 700));
        flights.add(new Flight(7006, "New York", "London", "2025-07-01", "12:00", 600));

        List<Flight> expected = new ArrayList<>();
        expected.add(flights.get(0));

        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getOrigin().equalsIgnoreCase("Paris") &&
                    flight.getDestination().equalsIgnoreCase("Tokyo") &&
                    flight.getDepartureDate().equals("2025-07-01")) {
                result.add(flight);
            }
        }

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testViewMyReservations() {
        List<Ticket> expected = new ArrayList<>();
        List<Ticket> result = passenger.getTickets();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testViewMyReservations_PrintsReservations() {
        passenger.bookFlight("FL001", 400.0, "8B");
        List<Ticket> expected = new ArrayList<>();
        expected.add(new Ticket("FL001", "8B", 400.0, "pending", "John Doe"));
        List<Ticket> result = passenger.getTickets();
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(expected.get(0).getFlightId(), result.get(0).getFlightId());
    }
}
