import core.*;
import factories.VehicleFactory;
import gate.Gate;
import vehicles.Vehicle;

import static vehicles.VehicleType.*;

public class ParkingLotApplication {
    public static void main(String[] args) throws Exception {
        // 1. Create parking spots
        ParkingSpot carSpot = new CarParkingSpot("1-C");
        ParkingSpot bikeSpot = new BikeParkingSpot("1-B");

        // 2. Create parking floor
        ParkingFloor parkingFloor = new ParkingFloor("1-F");
        parkingFloor.addParkingSpot(carSpot);
        parkingFloor.addParkingSpot(bikeSpot);

        // 3. Add floor to parking lot
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addFloor(parkingFloor);

        // 4. Create Gate
        Gate gate = new Gate("1-G");

        // 5. Create vehicles
        Vehicle car1 = VehicleFactory.createVehicle(CAR, "C-1234");
        Vehicle car2 = VehicleFactory.createVehicle(CAR, "C-5678");
        Vehicle bike1 = VehicleFactory.createVehicle(BIKE, "B-1234");
        Vehicle bike2 = VehicleFactory.createVehicle(BIKE, "B-5678");

        Vehicle[] vehicles = {car1, car2, bike1, bike2};

        for (Vehicle vehicle: vehicles) {
            try {
                System.out.println("Parking " + vehicle.getNumberPlate());
                Ticket ticket = gate.enterParking(vehicle);
                System.out.println("Ticket number: " + ticket.getId());
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        for (Vehicle vehicle : vehicles) {
            try {
                System.out.println("Exiting " + vehicle.getNumberPlate());
                double cost = gate.exitParking(vehicle.getNumberPlate());
                System.out.println("Cost: " + cost);
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }


    }
}
