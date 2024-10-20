package core;

import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private String id;
    private List<ParkingSpot> spots;

    public ParkingFloor(String id) {
        spots = new ArrayList<>();
    }

    public void addParkingSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        for (ParkingSpot spot : getSpots()) {
            if(spot.isAvailable() && spot.supports(vehicle)) {
                return spot;
            }
        }
        return null;
    }
}
