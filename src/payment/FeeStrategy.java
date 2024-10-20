package payment;

import core.Ticket;

public interface FeeStrategy {
    double calculateCost(Ticket ticket);
}
