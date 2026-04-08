package edu.cis566.group2.project2.room;

public class SuiteRoom extends HotelRoom {
    public SuiteRoom() {
        super(10, 280f, Float.MAX_VALUE);
    }

    @Override
    public String toString() {
        return "Suite Room";
    }
}
