package ApplicationSystem;

import java.util.Scanner;

public class CallTaxiBookingSystem {

    /*
     * Implementation of Add Booking
     */
    public static int addBooking(Booking[] booking, int bookingId, Taxi[] taxi, int taxiId) {
        int availability, customerId, pickupTime;
        char pickupPoint, dropPoint;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the Customer Id : ");
        customerId = s.nextInt();
        System.out.println("Enter Pickup Point (A - F) : ");
        pickupPoint = s.nextLine().charAt(0);
        System.out.println("Enter the Drop Point (A - F) : ");
        dropPoint = s.nextLine().charAt(0);
        System.out.println("Enter the Pickup Time : ");
        pickupTime = s.nextInt();
        booking[bookingId] = new Booking(customerId, pickupPoint, dropPoint, pickupTime);
        availability = booking[bookingId].checkAvailability(taxi, taxiId);
        s.close();
        return availability;
    }

    /*
     * Implementation of Calculation of Earnings
     */
    public static void calcEarnings(Booking[] booking, int bookingId, Taxi[] taxi, int taxiId, int pickupPoint,
            int dropPoint) {
        int earning;
        earning = (((Math.abs(pickupPoint - dropPoint) * 15) - 5) * 10) + 100;
        booking[bookingId].earning = earning;
        taxi[taxiId].earning += earning;
    }

    /*
     * Implementation of UserInput
     */
    public static void userInput() {
        Scanner s = new Scanner(System.in);
        Taxi[] taxi = new Taxi[10];
        int taxiId = 4, bookingId = 0;
        Booking[] booking = new Booking[20];
        taxi[0] = new Taxi();
        taxi[1] = new Taxi();
        taxi[2] = new Taxi();
        taxi[3] = new Taxi();
        int choice, availability;
        while (true) {
            System.out.println("Call Taxi Booking System");
            System.out.println("1. Booking");
            System.out.println("2. Booking Details");
            System.out.println("3. Taxi Details");
            System.out.println("4. Exit");
            System.out.println("Enter your Choice : ");
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    availability = addBooking(booking, bookingId, taxi, taxiId);
                    if (availability != -1) {
                        System.out.println("Your booking is Successfull with taxi no : " + availability);
                        booking[bookingId].dropTime();
                        calcEarnings(booking, bookingId, taxi, taxiId, choice, availability);
                        bookingId++;
                    } else {
                        System.out.println("No Taxi is Free for your Pickup Time!!");
                        System.out.println("You may change your pickup time and try your booking");
                    }
                    break;
                case 2:
                    System.out.println(
                            "Booking Id\nCustomer Id\nTaxi No\nPickupPoint\nDropPoint\nPickupTime\nDropTime\nEarnings");
                    for (int bookingid = 0; bookingid < bookingId; bookingid++) {
                        
                    }
            }
        }

    }

    public static void main(String[] args) {
        userInput();
    }
}

/*
 * Implementation of Taxi class
 */
class Taxi {
    char currentPosition;
    int earning, departureTime;

    public Taxi() {
        currentPosition = 'a';
    }

    public boolean isTaxiFree(int pickupTime) {
        if (departureTime < pickupTime) {
            return false;
        }
        return true;
    }

    public void departureTime(char pickupPoint, char dropPoint, int pickupTime) {
        departureTime = pickupTime + Math.abs(pickupTime - dropPoint);
    }
}

/*
 * Implementation of Booking class
 */

class Booking {
    int customerId, pickupTime, dropTime, taxiNo, earning;
    char pickupPoint, dropPoint;

    public Booking(int customerId, char pickupPoint, char dropPoint, int pickupTime) {
        this.customerId = customerId;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
    }

    public void dropTime() {
        this.dropTime = pickupTime + Math.abs(pickupPoint - dropPoint);
    }

    public int checkAvailability(Taxi[] taxi, int taxiCount) {
        int taxiId, taxiId2 = 0, shortestDistance = 6;
        for (taxiId = 0; taxiId < taxiCount; taxiId++) {
            if (taxi[taxiId].isTaxiFree(pickupTime)) {
                if (Math.abs(taxi[taxiId].currentPosition - pickupPoint) < shortestDistance) {
                    taxiId2 = taxiId;
                }
                if (Math.abs(taxi[taxiId].currentPosition - pickupPoint) == shortestDistance) {
                    if (taxi[taxiId].earning < taxi[taxiId2].earning) {
                        taxiId2 = taxiId;
                    }

                }
            }
            shortestDistance = Math.abs(taxi[taxiId].currentPosition - pickupPoint);
        }
        if (shortestDistance != 6) {
            taxi[taxiId2].departureTime(pickupPoint, dropPoint, pickupTime);
            taxi[taxiId2].currentPosition = dropPoint;
            taxiNo = taxiId2;
            return taxiNo;
        }
        return -1;
    }
}