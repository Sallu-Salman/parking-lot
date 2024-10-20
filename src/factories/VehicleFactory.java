package factories;

import vehicles.Bike;
import vehicles.Car;
import vehicles.Vehicle;
import vehicles.VehicleType;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, String numberPlate) throws Exception {
        Vehicle vehicle = null;

        switch (type) {
            case CAR:
                vehicle = new Car(numberPlate);
                break;
            case BIKE:
                vehicle = new Bike(numberPlate);
                break;
        }

        if (vehicle == null) {
            throw  new Exception("Invalid vehicle type");
        }

        return vehicle;
    }
}
