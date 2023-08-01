package services;
import model.Bus;
import model.Flight;
import model.Hotel;
import model.Train;

public class FareCalculator extends Booking {
    @Override
    public double booking(int noOfPersons, int rates) {
        return super.booking(noOfPersons, rates);
    }

    public double book(Hotel hotel) {
        double totalFare = 0;
        if(hotel.getFromdate().isBefore(hotel.getTodate())) {
            if(hotel.getNoOfPersons() == 1) {
                if(hotel.getOccupancy().equalsIgnoreCase("single")) {
                    totalFare = booking(1, hotel.getRates());
                } else {
                    totalFare = booking(1, hotel.getRates() * 2);
                }
            } else if(hotel.getNoOfPersons() == 2) {
                if(hotel.getOccupancy().equalsIgnoreCase("single")) {
                    totalFare = booking(1, hotel.getRates());
                } else {
                    totalFare = booking(1, hotel.getRates() * 2) + booking(1, hotel.getRates());
                }
            } else if(hotel.getNoOfPersons() == 3) {
                if(hotel.getOccupancy().equalsIgnoreCase("single")) {
                    totalFare = booking(1, hotel.getRates()) * 3;
                } else {
                    totalFare = booking(1, hotel.getRates() * 2) + booking(1, hotel.getRates());
                }
            }
        }
        return totalFare;
    }

    public double book(Flight flight) {
        double totalFare = 0;
        if(flight.getTriptype().equalsIgnoreCase("round")) {
            if(flight.getFrom().isBefore(flight.getTo())) {
                totalFare = booking(flight.getNoOfPersons(), flight.getRates()) * 2;
            }
        } else {
            totalFare = booking(flight.getNoOfPersons(), flight.getRates());
        }
        return totalFare;
    }

    public double book(Train train) {
        return booking(train.getNoOfPersons(), train.getRates());
    }

    public double book(Bus bus) {
        return booking(bus.getNoOfPersons(), bus.getRates());
    }
}
