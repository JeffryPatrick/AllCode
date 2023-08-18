package ApplicationSystem.RailwayReservationSystem;

import java.util.Scanner;

/**
 * Main
 */
public class Main {

    /*
     * Book Ticket
     */
    public static void bookTicket(Passenger p) {
        TicketBooker booker = new TicketBooker();

        // if no WL is available, means all tickets are filled. so no tickets available
        if (TicketBooker.availableWaitingList == 0) {
            System.out.println("No Tickets Available");
            return;
        }

        // check if preferred berth is available
        if ((p.berthPreference.equals("L") && TicketBooker.availableLowerBerths > 0) ||
                (p.berthPreference.equals("U") && TicketBooker.availableUpperBerths > 0) ||
                (p.berthPreference.equals("M") && TicketBooker.availableMiddleBerths > 0)) {

            System.out.println("Preferred Berth Available");
            if (p.berthPreference.equals("L")) {
                System.out.println("Lower Berth Given");
                // call bookTicket() in the TicketBooker Class
                booker.bookTicket(p, (TicketBooker.lowerBerthPositions.get(0)), "L");
                // remove the booked position from available positions and also decrease
                // available seats of that
                // particular type
                TicketBooker.lowerBerthPositions.remove(0);
                TicketBooker.availableLowerBerths--;
            } else if (p.berthPreference.equals("U")) {
                System.out.println("Upper Berth Available");
                // call bookTicket() in the TicketBooker class
                booker.bookTicket(p, (TicketBooker.upperBerthPositions.get(0)), "U");
                // remove the booked position from available positions and also decrease
                // available seats of that
                // particular type
                TicketBooker.upperBerthPositions.remove(0);
                TicketBooker.availableUpperBerths--;
            } else if (p.berthPreference.equals("M")) {
                System.out.println("Middle Berth Available");
                // call bookTicket() in the TicketBooker class
                booker.bookTicket(p, (TicketBooker.middleBerthPositions.get(0)), "M");
                // remove the booked position from available positions and also decrease
                // available seats of that
                // particular type
                TicketBooker.middleBerthPositions.remove(0);
                TicketBooker.availableMiddleBerths--;
            }
        }

        // preference not available -> book the available berth
        // check for lower berth
        else if (TicketBooker.availableLowerBerths > 0) {
            System.out.println("Lower Berth Given");
            // call bookTicket() in TicketBooker class
            booker.bookTicket(p, (TicketBooker.lowerBerthPositions.get(0)), "L");
            // remove the booked position from available positions and also decrease
            // available seats of that
            // particular type
            TicketBooker.lowerBerthPositions.remove(0);
            TicketBooker.availableLowerBerths--;
        }
        // check for upper berth
        else if (TicketBooker.availableUpperBerths > 0) {
            System.out.println("Upper Berth Given");
            // call bookTicket() in TicketBooker class
            booker.bookTicket(p, (TicketBooker.upperBerthPositions.get(0)), "U");
            // remove the booked position from available positions and also decrease
            // available seats of that
            // particular type
            TicketBooker.upperBerthPositions.remove(0);
            TicketBooker.availableUpperBerths--;
        }
        // check for middle berth
        else if (TicketBooker.availableMiddleBerths > 0) {
            System.out.println("Middle Berth Given");
            // call bookTicket() in TicketBooker class
            booker.bookTicket(p, (TicketBooker.middleBerthPositions.get(0)), "M");
            // remove the booked position from available positions and also decrease
            // available seats of that
            // particular type
            TicketBooker.middleBerthPositions.remove(0);
            TicketBooker.availableMiddleBerths--;
        }

        // if no berth available go to RAC
        else if (TicketBooker.availableRacTickets > 0) {
            System.out.println("RAC Available");
            booker.addToRac(p, (TicketBooker.racPositions.get(0)), "RAC");
        }

        // if no RAC is available go to WL
        else if (TicketBooker.availableWaitingList > 0) {
            System.out.println("Added to Waiting List");
            booker.addToWaitingList(p, (TicketBooker.waitingListPositions.get(0)), "WL");
        }
    }

    /*
     * Cancel Ticket
     */
    public static void cancelTicket(int id) {
        TicketBooker booker = new TicketBooker();
        if (TicketBooker.passengers.containsKey(id)) {
            booker.cancelTicket(id);
        } else {
            System.out.println("Passenger detail Unknown");
        }
    }

    /*
     * Main Method
     */
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            boolean loop = true;
            System.out.println("--------------------------------");
            System.out.println("Railway Reservation System");
            // loop to get choices from the user until he stops
            while (loop) {
                System.out.println("--------------------------------");
                System.out.println("1. Book Ticket");
                System.out.println("2. Cancel Ticket");
                System.out.println("3. Available Tickets");
                System.out.println("4. Booked Tickets");
                System.out.println("5. Exit");
                System.out.println("--------------------------------");
                int choice = s.nextInt();
                System.out.println("--------------------------------");
                switch (choice) {
                    case 1: {
                        // get details from passenger
                        System.out.println("Enter Passenger Name : ");
                        String name = s.next();
                        System.out.println("Enter Age : ");
                        int age = s.nextInt();
                        System.out.println("Enter the Berth Preference : ");
                        String berthPreference = s.next();
                        // create a passenger object
                        Passenger p = new Passenger(name, age, berthPreference);
                        // booking
                        bookTicket(p);
                    }
                        break;
                    case 2: {
                        // get passenger id to cancel
                        System.out.println("Enter passenger id to cancel : ");
                        int id = s.nextInt();
                        cancelTicket(id);
                    }
                        break;
                    case 3: {
                        TicketBooker.printAvailableTickets();
                    }
                        break;
                    case 4: {
                        TicketBooker.printPassengers();
                    }
                        break;
                    case 5: {
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