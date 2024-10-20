package vehicles;

public abstract class Vehicle {
    private String numberPlate;
    private VehicleType type;

    public Vehicle(String numberPlate, VehicleType type) {
        this.numberPlate = numberPlate;
        this.type = type;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public VehicleType getType() {
        return type;
    }
}
