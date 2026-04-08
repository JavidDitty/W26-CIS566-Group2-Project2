package edu.cis566.group2.project2.room;

public class DeluxeRoom extends HotelRoom{
    public DeluxeRoom() {
        super(15, 150f, 280f);
    }

    @Override
    public String toString() {
        return "Deluxe Room";
    }
}
