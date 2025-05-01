import org.example.TicketReservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketReservationTest {

    private TicketReservation reservation;

    @Test
    public void testBookFlight() {
        reservation.bookFlight("FL123", "Alice");

        String expected = "Alice";
        String result = TicketReservation.getBookings().get("FL123");
        Assertions.assertEquals(expected, result);

        expected = "pending";
        result = TicketReservation.getStatuses().get("FL123");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCancelFlight() {
        reservation.bookFlight("FL123", "Alice");
        TicketReservation.cancelFlight("FL123");

        String expected = "cancelled";
        String result = TicketReservation.getStatuses().get("FL123");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testConfirmReservation() {
        reservation.bookFlight("FL123", "Alice");
        TicketReservation.confirmReservation("FL123");

        String expected = "confirmed";
        String result = TicketReservation.getStatuses().get("FL123");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testModifyTicket() {
        reservation.bookFlight("FL123", "Alice");
        reservation.modifyTicket("FL123", "Bob");

        String expected = "Bob";
        String result = TicketReservation.getBookings().get("FL123");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCancelFlight_FlightIdNotFound() {
        TicketReservation.cancelFlight(null);

        String expected = null;
        String result = TicketReservation.getStatuses().get(null);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testConfirmReservationNull() {
        TicketReservation.confirmReservation(null);

        String expected = null;
        String result = TicketReservation.getStatuses().get(null);
        Assertions.assertEquals(expected, result);
    }
}

