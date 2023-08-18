package ApplicationSystem.FlightManagementSystem;

import java.util.HashMap;
import java.util.Scanner;

class PassengerFlight {
    static int id = 1;
    int passengerId;
    String name;
    int noOfTickets;
    int flightId;
    int cost;

    public PassengerFlight(String name, int noOfTickets, int flightId) {
        this.name = name;
        this.noOfTickets = noOfTickets;
        this.flightId = flightId;
        this.passengerId = id++;
        this.cost = 0;
    }
}

class Flight {
    static int id = 1;
    int flightId;
    int tickets;
    int price;
    // used to add passenger for the corressponding flight
    HashMap<Integer, PassengerFlight> passengerList = new HashMap<>();

    public Flight() {
        this.tickets = 50;
        this.price = 5000;
        this.flightId = id++;
    }

}

class FlightModule {

    static HashMap<Integer, PassengerFlight> allPassengerList = new HashMap<>();
    static HashMap<Integer, Flight> flightList = new HashMap<>();

    FlightModule() {
        Flight flight1 = new Flight();
        Flight flight2 = new Flight();
        flightList.put(flight1.flightId, flight1);
        flightList.put(flight2.flightId, flight2);
    }

    /*
     * Booking Ticket method
     */
    public void bookingFlightTicket(PassengerFlight passengerFlight) {
        Flight chooseFlight = flightList.get(passengerFlight.flightId);
        if (!flightList.containsKey(passengerFlight.flightId)) {
            System.out.println("No Flight Available");
            return;
        }
        if (chooseFlight.tickets == 0) {
            System.out.println("No Tickets Available");
            return;
        }
        if (passengerFlight.noOfTickets > chooseFlight.tickets) {
            System.out.println("The flight has remaining " + chooseFlight.tickets + " Seats");
            return;
        }
        // report the cost for tickets
        passengerFlight.cost = chooseFlight.price * passengerFlight.noOfTickets;
        // update the tickets in flight
        chooseFlight.tickets -= passengerFlight.noOfTickets;
        // update the price of ticket in flight
        chooseFlight.price += (passengerFlight.noOfTickets * 200);
        // add passenger to passengerList map
        chooseFlight.passengerList.put(passengerFlight.passengerId, passengerFlight);
        // add passenger to allPassengerList map
        allPassengerList.put(passengerFlight.passengerId, passengerFlight);

        System.out.println("-----------------------------------------------");
        System.out.println(passengerFlight.noOfTickets + " Seats Booked Successfully");
    }

    /*
     * Cancel Ticket method
     */
    public void cancelFlightTicket(int id) {

        if (!allPassengerList.containsKey(id)) {
            System.out.println("Passenger Unknown");
            return;
        }
        PassengerFlight cancelPassenger = allPassengerList.get(id);
        Flight cancelFlight = flightList.get(cancelPassenger.flightId);
        cancelFlight.price -= (cancelPassenger.noOfTickets * 200);
        cancelFlight.tickets += cancelPassenger.noOfTickets;
        System.out.println("Amount Refund after cancelling Tickets = " + cancelPassenger.cost);
        cancelPassenger.cost = 0;
        cancelPassenger.noOfTickets = 0;
        cancelFlight.passengerList.remove(cancelPassenger.passengerId);
        System.out.println("Cancelled Successfully!");
    }

    /*
     * Print Details method
     */
    public void printFlightDetailsWithPassengers() {
        for (Flight flight : flightList.values()) {
            System.out.println("-----------------------------------------------");
            System.out.println("Flight Id = " + flight.flightId);
            System.out.println("Tickets Available = " + flight.tickets);
            System.out.println("Ticket Price = " + flight.price);
            System.out.println("Passenger Details in Flight Id " + flight.flightId);
            if (flight.passengerList.size() == 0) {
                System.out.println("No Passenger in this Flight" + flight.flightId);
                continue;
            }
            for (PassengerFlight passenger : flight.passengerList.values()) {
                System.out.println("-----------------");
                System.out.println("Passenger Id : " + passenger.passengerId);
                System.out.println("Passenger Name : " + passenger.name);
                System.out.println("No of Tickets : " + passenger.noOfTickets);
                System.out.println("Cost for Tickets : " + passenger.cost);
            }
        }
    }

}

public class Main {

    /*
     * Main method
     */
    public static void main(String[] args) {
        // object for flightModule
        FlightModule flightModule = new FlightModule();
        try (// scanner for getting input
                Scanner s = new Scanner(System.in)) {
            // loop variable used for exit
            boolean loop = true;
            System.out.println("-----------------------------------------------");
            System.out.println("Flight Booking System");
            while (loop) {
                System.out.println("-----------------------------------------------");
                System.out.println("1. Book Flight Ticket");
                System.out.println("2. Cancel the Ticket");
                System.out.println("3. Print Flight Details with Passengers");
                System.out.println("4. Exit");
                System.out.println("-----------------------------------------------");
                System.out.println("Enter the choice : ");
                int choice = s.nextInt();
                System.out.println("-----------------------------------------------");
                switch (choice) {
                    case 1: {
                        // getting passenger details with flight id
                        System.out.println("Enter the name : ");
                        String name = s.next();
                        System.out.println("Enter the noOfTickets : ");
                        int noOfTickets = s.nextInt();
                        System.out.println("Enter the Flight Id : ");
                        int flightId = s.nextInt();
                        // create an object for passengerFlight
                        PassengerFlight passengerFlight = new PassengerFlight(name, noOfTickets, flightId);
                        flightModule.bookingFlightTicket(passengerFlight);
                    }
                        break;
                    case 2: {
                        System.out.println("Enter the Passenger Id : ");
                        int id = s.nextInt();
                        flightModule.cancelFlightTicket(id);
                    }
                        break;
                    case 3: {
                        flightModule.printFlightDetailsWithPassengers();
                    }
                        break;
                    case 4: {
                        loop = false;
                    }
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
