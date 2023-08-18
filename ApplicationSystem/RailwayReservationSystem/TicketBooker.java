package ApplicationSystem.RailwayReservationSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Ticket Booker
 */

public class TicketBooker {

    static int[] berthPositions = new int[21];
    static int[] racpositions = new int[18];
    static int[] waitingPositions = new int[10];

    /*
     * Constructor
     */
    TicketBooker() {
        for (int i = 0; i < berthPositions.length; i++) {
            berthPositions[i] = i + 1;
        }
        for (int i = 0; i < racpositions.length; i++) {
            racpositions[i] = i + 1;
        }
        for (int i = 0; i < waitingPositions.length; i++) {
            waitingPositions[i] = i + 1;
        }
    }

    // 63 berths(upper, lower, middle) + (18 RAC passengers)
    // 10 waiting list tickets -> 21 L, 21 M, 21 U, 18 RAC, 10WL
    static int availableLowerBerths = 21; // real value 21
    static int availableUpperBerths = 21; // real value 21
    static int availableMiddleBerths = 21; // real value 21
    static int availableRacTickets = 18; // real value 18
    static int availableWaitingList = 10; // real value 10

    // to maintain the order of ticket we use queue and linkedlist
    static Queue<Integer> waitingList = new LinkedList<>(); // queue of WL passengers
    static Queue<Integer> racList = new LinkedList<>(); // queue of RAC passengers

    // to store id of passengers whose berth confirmed
    static List<Integer> bookedTicketList = new ArrayList<>(); // list for bookedticket passengers

    static List<Integer> lowerBerthPositions = new ArrayList<>(Arrays.asList(21));
    static List<Integer> upperBerthPositions = new ArrayList<>(Arrays.asList(21));
    static List<Integer> middleBerthPositions = new ArrayList<>(Arrays.asList(21));
    static List<Integer> racPositions = new ArrayList<>(Arrays.asList(18));
    static List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(10));

    static Map<Integer, Passenger> passengers = new HashMap<>(); // map of passenger ids to passengers

    /*
     * bookTicket() method
     */
    public void bookTicket(Passenger p, int berthInfo, String allotedBerth) {
        // assign the seat number and type of berth(L, U, M)
        p.seatNumber = berthInfo;
        p.alloted = allotedBerth;
        // add passenger to the map
        passengers.put(p.passengerId, p);
        // add passenger id to the list of booked tickets
        bookedTicketList.add(p.passengerId);
        System.out.println("----------------------");
        System.out.println("Booked Successfully!");
    }

    /*
     * addToRac() method
     */
    public void addToRac(Passenger p, int racInfo, String allotedRac) {
        // assign seat number and type(RAC)
        p.seatNumber = racInfo;
        p.alloted = allotedRac;
        // add passenger to the map
        passengers.put(p.passengerId, p);
        // add passenger id to queue of RAC tickets
        racList.add(p.passengerId);
        // decrease available RAC tickets by 1
        availableRacTickets--;
        // remove the position that was alloted to the passenger
        racPositions.remove(0);
        System.out.println("--------------------------");
        System.out.println("Added to RAC Successfully");
    }

    /*
     * addToWaitingList() method
     */
    public void addToWaitingList(Passenger p, int waitingInfo, String allotedWl) {
        // assign seat number and type(WL)
        p.seatNumber = waitingInfo;
        p.alloted = allotedWl;
        // add passenger to the map
        passengers.put(p.passengerId, p);
        // add passenger id to queue of WL tickets
        waitingList.add(p.passengerId);
        // decrease available WL tickets by 1
        availableWaitingList--;
        // remove the position that was alloted to the passenger
        waitingListPositions.remove(0);
        System.out.println("---------------------------");
        System.out.println("Added to Waiting List Successfully");
    }

    /**
     * cancelTicket() method
     */
    public void cancelTicket(int id) {

        // remove the passenger from map
        Passenger p = passengers.get(id);
        passengers.remove(id);

        // remove the booked ticket from the list
        bookedTicketList.remove(id);

        // take the booked position which is now free
        int positionBooked = p.seatNumber;

        System.out.println("--------------------------");
        System.out.println("Cancelled Successfully");

        // add the free position to the corressponding type of list (either L, M, U)
        if (p.alloted.equals("L")) {
            availableLowerBerths++;
            lowerBerthPositions.add(positionBooked);
        } else if (p.alloted.equals("M")) {
            availableMiddleBerths++;
            middleBerthPositions.add(positionBooked);
        } else if (p.alloted.equals("U")) {
            availableUpperBerths++;
            upperBerthPositions.add(positionBooked);
        }

        // check if any RAC is there
        if (racList.size() > 0) {
            // take passenger from RAC and increase the free space in RAC list
            // and increase available RAC tickets
            Passenger passengerFromRac = passengers.get(racList.poll());
            int positionRac = passengerFromRac.seatNumber;
            racPositions.add(positionRac);
            racList.remove(passengerFromRac.passengerId);
            availableRacTickets++;

            // check if any WL is there
            if (waitingList.size() > 0) {
                // take passenger from WL and add them to RAC, increase the free space in WL
                // and decrease the availability of RAC by 1
                Passenger passengerFromWaitingList = passengers.get(waitingList.poll());
                int positionWl = passengerFromWaitingList.seatNumber;
                waitingListPositions.add(positionWl);
                waitingList.remove(passengerFromWaitingList.passengerId);

                passengerFromWaitingList.seatNumber = racPositions.get(0);
                passengerFromWaitingList.alloted = "RAC";
                racPositions.remove(0);
                racList.add(passengerFromWaitingList.passengerId);

                availableWaitingList++;
                availableRacTickets--;
            }
            // now we have a passenger from RAC to whom we can book a ticket,
            // so book the cancelled ticket to the RAC passenger
            Main.bookTicket(passengerFromRac);
        }
    }

    /*
     * printAvailableTickets() method
     */
    public static void printAvailableTickets() {
        System.out.println("Available Lower Berths = " + availableLowerBerths);
        System.out.println("Available Middle Berths = " + availableMiddleBerths);
        System.out.println("Available Upper Berths = " + availableUpperBerths);
        System.out.println("Available RACs = " + availableRacTickets);
        System.out.println("Available Waiting List = " + availableWaitingList);
        System.out.println("-------------------------------------------------------");
    }

    /*
     * printPassengers() method
     */
    public static void printPassengers() {
        if (passengers.size() == 0) {
            System.out.println("No Details of Passengers");
            return;
        }
        for (Passenger passenger : passengers.values()) {
            System.out.println("Passenger Id = " + passenger.passengerId);
            System.out.println("Name = " + passenger.name);
            System.out.println("Age = " + passenger.age);
            System.out.println("Berth Preference = " + passenger.berthPreference);
            System.out.println("Status = " + passenger.seatNumber + passenger.alloted);
            System.out.println("---------------------------------------------");
        }
    }
}
