package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TicketSystem {
    public static final String usersPath = "src/main/resources/users.csv";
    public static final String bookingPath = "src/main/resources/bookings.csv";
    public static final String domFlightPath = "src/main/resources/departedDomesticFlights.csv";
    public static final String intFlightPath = "src/main/resources/departedInternationalFlights.csv";

    private List<User> users;
    private TicketReservation reservations;

    public TicketSystem(List<User> users, TicketReservation reservations) {
        this.users = new ArrayList<>();
        this.reservations = reservations;
    }

    /**
     * takes the user information and write in a file
     * @param usersPath the file location to write
     */
    public void initUsers(String usersPath) {
        File file = new File(usersPath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String email = parts[2];
                String role = parts[3];

                if (role.equalsIgnoreCase("admin")) {
                    users.add(new Admin(id, name, email));
                } else {
                    users.add(new Passenger(id, name, email));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * writes the information of all the passengers in a flight
     * @param users the users
     * @param bookingPath the file location to write
     */
    public void writeListOfPassengers(List<User> users, String bookingPath) {
        File file = new File(bookingPath);
        try (FileWriter fw = new FileWriter(file)) {
            for (User user : users) {
                fw.write(user.getId() + ",");
                fw.write(user.getName() + ",");
                fw.write(user.getEmail() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * keeps a list of the departed domestic flights
     * @param flights the list of flights to get stored
     * @param domFlightPath the file location to write
     */
    public void writeListOfDepartedDomesticFlights(DomesticFlight flights, String domFlightPath) {
        Queue<Flight> flights1 = new LinkedList<>();
        flights1.add(flights);
        File file = new File(domFlightPath);

        try (FileWriter fw = new FileWriter(file)) {
            for (Flight flight : flights1) {
                fw.write(flight.getFlightId() + ",");
                fw.write(flight.getOrigin() + ",");
                fw.write(flight.getDestination() + ",");
                fw.write(flight.getDepartureDate() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * keeps a list of the departed international flights
     * @param flights the list of flights to get stored
     * @param intFlightPath the file location to write
     */
    public void writeListOfDepartedInternationalFlights(InternationalFlight flights, String intFlightPath) {
        Queue<Flight> flights1 = new LinkedList<>();
        flights1.add(flights);
        File file = new File(intFlightPath);

        try (FileWriter fw = new FileWriter(file)) {
            for (Flight flight : flights1) {
                fw.write(flight.getFlightId() + ",");
                fw.write(flight.getOrigin() + ".");
                fw.write(flight.getDestination() + ",");
                fw.write(flight.getDepartureDate() + "\n");
                fw.write(flight.getDepartureTime() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
