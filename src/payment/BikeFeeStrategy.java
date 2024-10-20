package payment;

import core.Ticket;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BikeFeeStrategy implements FeeStrategy{
    private static final double BIKE_FEE = 10;

    @Override
    public double calculateCost(Ticket ticket) {
        long duration = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toMinutes();
        return duration * BIKE_FEE;
    }
}
