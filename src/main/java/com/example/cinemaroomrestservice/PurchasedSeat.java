package com.example.cinemaroomrestservice;

import java.util.Objects;
import java.util.UUID;

public class PurchasedSeat {

    private final UUID token;
    private final Seat ticket;

    public PurchasedSeat(Seat ticket) {
        this.ticket = ticket;
        this.token = new Token().getToken();
    }

    public Seat getTicket() {
        return ticket;
    }

    public String getToken() {
        return token.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket.getRow(), ticket.getColumn());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        PurchasedSeat seat = (PurchasedSeat) o;
        return ticket.getRow() == seat.ticket.getRow() && ticket.getColumn() == seat.ticket.getColumn();
    }
}