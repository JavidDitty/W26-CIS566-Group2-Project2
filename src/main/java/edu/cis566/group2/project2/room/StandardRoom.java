package edu.cis566.group2.project2.room;

public class StandardRoom extends HotelRoom {
    public StandardRoom() {
        super(45, 80f, 150f);
    }

    @Override
    public String toString() {
        return "Standard Room";
    }
}
