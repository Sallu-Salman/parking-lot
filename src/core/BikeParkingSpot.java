package core;

import vehicles.Bike;
import vehicles.Vehicle;

public class BikeParkingSpot extends ParkingSpot{
    public BikeParkingSpot(String id) {
        super(id);
    }

    @Override
    public boolean supports(Vehicle vehicle) {
        return vehicle instanceof Bike;
    }
}
