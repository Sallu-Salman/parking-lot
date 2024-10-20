package core;

import payment.FeeCalculator;
import vehicles.Vehicle;

import java.util.*;

public class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingFloor> floors;
    private Map<String, Ticket> activeTickets;

    private ParkingLot() {
        floors = new ArrayList<>();
        activeTickets = new HashMap<>();
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public Ticket parkVehicle(Vehicle vehicle) throws Exception{
        ParkingSpot spot = getParkingSpot(vehicle);
        if(spot == null) {
            throw new Exception("No parking spots available!");
        }

        spot.assignVehicle(vehicle);
        Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, spot);
        activeTickets.put(vehicle.getNumberPlate(), ticket);
        return ticket;
    }

    public double exitVehicle(String vehicleNumber) throws Exception {
        Ticket ticket = activeTickets.get(vehicleNumber);
        if (ticket == null) {
            throw new Exception("No ticket found for this vehicle!");
        }

        double cost = FeeCalculator.calculateCost(ticket);
        activeTickets.remove(vehicleNumber);
        ticket.getSpot().releaseVehicle();
        return cost;
    }

    private ParkingSpot getParkingSpot(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.findParkingSpot(vehicle);
            if(spot != null) {
                return  spot;
            }
        }

        return null;
    }
}
