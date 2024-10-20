package core;

import vehicles.Vehicle;

public abstract class ParkingSpot {
    private String id;
    private boolean isAvailable;
    private Vehicle vehicle;

    public ParkingSpot(String id) {
        this.id = id;
        this.isAvailable = true;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        isAvailable = false;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public abstract boolean supports(Vehicle vehicle);

    public Vehicle releaseVehicle() {
        this.isAvailable = true;
        Vehicle lastVehicle = this.vehicle;
        this.vehicle = null;
        return lastVehicle;
    }
}
