package services;

import java.time.LocalDate;
import model.Hotel;
import model.Flight;
import model.Bus;
import model.Train;


public class Main {
    public static void main(String[] args) {

        Hotel hotel = new Hotel(3, "Deluxe", 2000, "Double Occupancy", LocalDate.of(2023, 5, 1), LocalDate.of(2023, 5, 5));
        Flight flight = new Flight(2,"economy", 1500, LocalDate.of(2023, 5, 1), LocalDate.of(2023, 5, 5),"Round Trip");
        Train train = new Train(4,"Sleeper", 500, LocalDate.of(2023, 5, 1));
        Bus bus = new Bus(5, "AC Sleeper", 800, LocalDate.of(2023, 5, 1));

        // Create an instance of FareCalculator
        FareCalculator fareCalculator = new FareCalculator();

        // Bookings
        double hotelFare = fareCalculator.book(hotel);
        double flightFare = fareCalculator.book(flight);
        double trainFare = fareCalculator.book(train);
        double busFare = fareCalculator.book(bus);

        // Print the total fare
        System.out.println("Hotel Fare: $" + hotelFare);
        System.out.println("Flight Fare: $" + flightFare);
        System.out.println("Train Fare: $" + trainFare);
        System.out.println("Bus Fare: $" + busFare);
    }
}
