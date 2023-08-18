package ApplicationSystem.RailwayReservationSystem;

/**
 * Passenger
 */
public class Passenger {
    static int id = 1; // static variable to give id for every new passenger
    String name;
    int age;
    String berthPreference; // U or M or L
    int passengerId; // id of passenger created automatically
    String alloted; // alloted type (L, U, M, RAC, WL)
    int seatNumber; // seat number

    public Passenger(String name, int age, String berthPreference) {
        this.name = name;
        this.age = age;
        this.berthPreference = berthPreference;
        this.passengerId = id++;
        alloted = "";
        seatNumber = -1;
    }
}
