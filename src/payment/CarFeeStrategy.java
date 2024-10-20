package payment;

import core.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class CarFeeStrategy implements FeeStrategy{
    private static final double CAR_FEE = 20;
    @Override
    public double calculateCost(Ticket ticket) {
        long duration = Duration
                .between(ticket.getEntryTime(), LocalDateTime.now())
                .toMinutes();

        return duration * CAR_FEE;
    }
}
