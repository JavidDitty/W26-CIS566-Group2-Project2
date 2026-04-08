package edu.cis566.group2.project2.room;

abstract public class HotelRoom {
    protected int numberOfRooms;
    protected float minPrice;
    protected float maxPrice;
    protected HotelRoom successor;

    public HotelRoom(int numberOfRooms, float minPrice, float maxPrice) {
        this.numberOfRooms = numberOfRooms;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public void setSuccessor(HotelRoom successor) {
        this.successor = successor;
    }

    public String handleRequest(float bid, boolean prevHasRooms) {
        boolean currHasRooms = this.numberOfRooms > 0;
        boolean hasRooms = prevHasRooms || currHasRooms;
        String message = null;
        if(currHasRooms && this.minPrice <= bid && bid < this.maxPrice) {
            this.numberOfRooms--;
            message = "You received a " + this + "!";
        } else if(this.successor != null) {
            message = this.successor.handleRequest(bid, hasRooms);
        } else if(hasRooms) {
            message = "We do not have rooms at that price! Please submit another bid!";
        } else {
            message = "We are sold out!";
        }
        return message;
    }

    @Override
    abstract public String toString();
}
