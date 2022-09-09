package com.example.cinemaroomrestservice;

import java.util.Objects;

public class Seat {
    private int row;
    private int column;

    public Seat() {}
    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return row <= 4 ? 10 : 8;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
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

        Seat seat = (Seat)o;
        return row == seat.row && column == seat.column;
    }
}
