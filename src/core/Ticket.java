package core;

import vehicles.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    private String id;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private LocalDateTime entryTime;

    public Ticket(String id, Vehicle vehicle, ParkingSpot spot) {
        this.id = id;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public String getId() {
        return id;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
