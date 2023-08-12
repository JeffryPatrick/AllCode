package ApplicationSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CallTaxiBookingSystem extends Booking {

    /*
     * Implementation of main function
     */

    public static void main(String[] args) {

        System.out.println("-----Call Taxi Booking System-----");
        Scanner s = new Scanner(System.in);
        int noOfTaxis;
        System.out.println("Enter the No of Taxis : ");
        noOfTaxis = s.nextInt();
        // create 4 taxis
        List<Taxi> taxis = createTaxis(noOfTaxis);

        int id = 1;

        while (true) {
            System.out.println("---------------------------");
            System.out.println("1. Book Taxi");
            System.out.println("2. Print Taxi Details");
            System.out.println("3. Exit");
            System.out.println("---------------------------");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    // Get details from customers
                    int customerId = id;
                    System.out.println("Enter Pickup Point : ");
                    char pickupPoint = s.next().charAt(0);
                    System.out.println("Enter Drop Point : ");
                    char dropPoint = s.next().charAt(0);
                    System.out.println("Enter Pickup Time : ");
                    int pickupTime = s.nextInt();

                    // check if pickup and drop point are valid
                    if (pickupPoint < 'A' || dropPoint > 'F' || pickupPoint > 'F' || dropPoint < 'A') {
                        System.out.println("Valid pickup and drop are A, B, C, D, E, F : ");
                        return;
                    }

                    // get all free taxis that can reach customer on or before pickup time
                    List<Taxi> freeTaxis = getFreeTaxis(taxis, pickupTime, pickupPoint);

                    // no free taxi means we cannot alloct, so Exit!
                    if (freeTaxis.size() == 0) {
                        System.out.println("Sorry, No Taxi is Alloted. Exiting");
                        return;
                    }

                    // sort taxis based on earnings
                    Collections.sort(freeTaxis, (a, b) -> a.totalEarnings - b.totalEarnings);

                    // get free Taxi nearest to us
                    bookTaxi(customerId, pickupPoint, dropPoint, pickupTime, freeTaxis);
                    id++;
                    break;
                case 2:
                    for (Taxi taxi : taxis) {
                        taxi.printDetails();
                    }
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }

}

/*
 * Implementation of Taxi class
 */
class Taxi {
    static int taxiCount = 0; // taxi number
    int id;
    boolean booked; // taxi booked or not
    char currentSpot; // where taxi is now
    int freeTime; // when taxi becomes free
    int totalEarnings; // total earnings of taxi
    List<String> trips; // all details of all trips by this taxi

    public Taxi() {
        booked = false;
        currentSpot = 'A'; // starting point
        freeTime = 6; // example 6 AM
        totalEarnings = 0;
        trips = new ArrayList<String>();
        taxiCount += 1;
        id = taxiCount;
    }

    /*
     * Implementation of setDetails() function
     */

    public void setDetails(boolean booked, char currentSpot, int freeTime, int totalEarnings, String tripDetails) {
        this.booked = booked;
        this.currentSpot = currentSpot;
        this.freeTime = freeTime;
        this.totalEarnings = totalEarnings;
        this.trips.add(tripDetails);
    }

    /*
     * Implementation of printDetails() function
     */

    public void printDetails() {
        // print all trip details
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Taxi - " + this.id + " Total Earnings - " + this.totalEarnings);
        System.out.println("TaxiId | BookingId | CustomerId | From | To | PickupTime | DropTime | Amount |");
        for (String trip : trips) {
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println(id + "      | " + trip);
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }
}

/*
 * Implementation of Booking class
 */
class Booking {

    /*
     * Implementation of bookTaxi() function
     */
    public static void bookTaxi(int customerId, char pickupPoint, char dropPoint, int pickupTime,
            List<Taxi> freeTaxis) {
        // to find the nearest distance
        int min = 999;

        // distance between pickup and drop
        int distanceBetweenPickupAndDrop = 0;

        // this trip earning
        int earning = 0;

        // when taxi will be free next
        int nextFreeTime = 0;

        // when taxi is after trip is over
        char nextSpot = 'Z';

        // booked Taxi
        Taxi bookedTaxi = null;

        // all details of current trip as string
        String tripDetail = "";

        for (Taxi t : freeTaxis) {
            int distanceBetweenCustomerAndTaxi = Math.abs((t.currentSpot - '0') - (pickupPoint - '0')) * 15;
            if (distanceBetweenCustomerAndTaxi < min) {
                bookedTaxi = t;

                // distance between pickup and drop = (drop - pickup) * 15KM
                distanceBetweenPickupAndDrop = Math.abs((dropPoint - '0') - (pickupPoint - '0')) * 15;

                // trip earning = 100 + (distanceBetweenPickupAndDrop - 5) * 10
                earning = (distanceBetweenPickupAndDrop - 5) * 10 + 100;

                // drop time calculation
                int dropTime = pickupTime + distanceBetweenPickupAndDrop / 15;

                // when taxi will be free next
                nextFreeTime = dropTime;

                // taxi will be at drop point after trip
                nextSpot = dropPoint;

                // creating trip detail
                tripDetail = customerId
                        + "         | "
                        + customerId
                        + "          | "
                        + pickupPoint
                        + "    | "
                        + dropPoint
                        + "  | "
                        + pickupTime
                        + "          | "
                        + dropTime
                        + "       | "
                        + earning
                        + "    |";
            }
        }

        // setting corresponding details to alloted taxi
        bookedTaxi.setDetails(true, nextSpot, nextFreeTime, earning, tripDetail);

        // Booked Successfully
        System.out.println("Taxi - " + bookedTaxi.id + " booked");
    }

    /*
     * Implementation of createTaxi() function
     */

    public static List<Taxi> createTaxis(int noOfTaxis) {
        List<Taxi> taxis = new ArrayList<>();
        // create taxis
        for (int i = 1; i <= noOfTaxis; i++) {
            Taxi taxi = new Taxi();
            taxis.add(taxi);
        }
        return taxis;
    }

    /*
     * Implementation of getFreeTaxis() function
     */
    public static List<Taxi> getFreeTaxis(List<Taxi> taxi, int pickupTime, char pickupPoint) {
        List<Taxi> freeTaxis = new ArrayList<>();
        for (Taxi t : taxi) {
            if (t.freeTime <= pickupTime
                    && Math.abs((t.currentSpot - '0') - (pickupPoint - '0')) <= pickupTime - t.freeTime) {
                freeTaxis.add(t);
            }
        }
        return freeTaxis;
    }
}