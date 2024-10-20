package payment;

import core.Ticket;

public class FeeCalculator {
    public static double calculateCost (Ticket ticket) throws Exception {
        FeeStrategy feeStrategy = null;

        switch (ticket.getVehicle().getType()) {
            case CAR:
                feeStrategy = new CarFeeStrategy();
                break;
            case BIKE:
                feeStrategy = new BikeFeeStrategy();
                break;
        }

        if(feeStrategy == null) {
            throw new Exception("Invalid vehicle type!");
        }

        return feeStrategy.calculateCost(ticket);
    }
}
