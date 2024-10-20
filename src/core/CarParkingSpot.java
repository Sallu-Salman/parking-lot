package core;

import vehicles.Car;
import vehicles.Vehicle;

public class CarParkingSpot extends ParkingSpot{
    public CarParkingSpot(String id) {
        super(id);
    }

    @Override
    public boolean supports(Vehicle vehicle) {
        return vehicle instanceof Car;
    }
}
