package gate;

import core.ParkingLot;
import core.Ticket;
import vehicles.Vehicle;

public class Gate {
    private String id;

    public Gate (String id) {
        this.id = id;
    }

    public Ticket enterParking(Vehicle vehicle) throws Exception {
        ParkingLot parkingLot = ParkingLot.getInstance();
        return parkingLot.parkVehicle(vehicle);
    }

    public double exitParking(String vehicleNumber) throws Exception {
        ParkingLot parkingLot = ParkingLot.getInstance();
        return parkingLot.exitVehicle(vehicleNumber);
    }
}
