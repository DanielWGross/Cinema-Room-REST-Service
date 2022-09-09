package com.example.cinemaroomrestservice;

public class ReturnedTicket {
    private final Seat returned_ticket;

    public ReturnedTicket(int row, int column) {
        this.returned_ticket = new Seat(row, column);
    }

    public Seat getReturned_ticket() {
        return returned_ticket;
    }
}
