package com.example.cinemaroomrestservice;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class Theater {
    private final int total_rows = 9;
    private final int total_columns = 9;
    private final Set<Seat> available_seats = new HashSet<>(total_rows * total_columns);
    @JsonIgnore()
    private final Set<PurchasedSeat> purchased_seats = new HashSet<>(total_rows * total_columns);

    public Theater() {
        for (int i = 1; i <= total_rows; i++) {
            for (int j = 1; j <= total_columns; j++) {
                available_seats.add(new Seat(i, j));
            }
        }
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public Set<Seat> getAvailable_seats() {
        return available_seats;
    }

    public Set<PurchasedSeat> getPurchased_seats() {
        return purchased_seats;
    }

    public PurchasedSeat purchaseSeat(Seat seat) {
        PurchasedSeat purchasedSeat = new PurchasedSeat(seat);
        if (purchased_seats.contains(purchasedSeat)) {
            throw new RuntimeException("The ticket has been already purchased!");
        } else if (purchasedSeat.getTicket().getRow() > total_rows
                || purchasedSeat.getTicket().getRow() < 1
                || purchasedSeat.getTicket().getColumn() > total_columns
                || purchasedSeat.getTicket().getColumn() < 1) {
            throw new RuntimeException("The number of a row or a column is out of bounds!");
        }
        purchased_seats.add(purchasedSeat);
        return purchasedSeat;
    }

    public ReturnedTicket returnSeat(String token) {
        PurchasedSeat purchasedSeat = purchased_seats
                .stream()
                .filter(seat -> ((seat.getToken()).equals(token)))
                .findAny()
                .orElse(null);

        if (purchasedSeat == null) {
            throw new RuntimeException("Wrong token!");
        }
        purchased_seats.remove(purchasedSeat);
        return new ReturnedTicket(purchasedSeat.getTicket().getRow(), purchasedSeat.getTicket().getColumn());

    }

    public Stat stats() {
        int sum = purchased_seats.stream()
                .map(x -> x.getTicket().getPrice())
                .reduce(0, Integer::sum);

        int count = (int) purchased_seats.stream().count();

        Stat stat = new Stat(sum, 81 - count, count);
        return stat;

    }

}
