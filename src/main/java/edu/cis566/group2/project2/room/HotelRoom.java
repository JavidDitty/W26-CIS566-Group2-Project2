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

    public String handleBid(float bid, boolean prevHasRooms) {
        boolean currHasRooms = this.numberOfRooms > 0;
        boolean hasRooms = prevHasRooms || currHasRooms;
        String message = null;
        if(currHasRooms && this.minPrice <= bid && bid < this.maxPrice) {
            // 4. The handler checks if there are rooms of its type (SuiteRoom) available at the given bid price.
            //    While the bid price falls within its range [280, inf), it does not have any available rooms.
            // 6. The handler checks if there are rooms of its type (DeluxeRoom) available at the given bid price.
            //    It does not have any available rooms.
            // 8. The handler checks if there are rooms of its type (StandardRoom) available at the given bid price.
            //    It does not have any available rooms.
            this.numberOfRooms--;
            message = "You received a " + this + "!";
        } else if(this.successor != null) {
            // 5. Since it does not have available rooms, the handler passes the bid,
            //    and a value indicating that handlers until this point do not have rooms (prevHasRooms),
            //    to the next handler (DeluxeRoom) by calling its request handler method (DeluxeRoom.handleBid).
            // 7. Since it does not have available rooms, the handler passes the bid,
            //    and a value indicating that handlers until this point still do not have rooms (prevHasRooms),
            //    to the next handler (StandardRoom) by calling its request handler method (StandardRoom.handleBid).
            message = this.successor.handleBid(bid, hasRooms);
        } else if(hasRooms) {
            message = "We do not have rooms at that price! Please submit another bid!";
        } else {
            // 9. Since it is the last handler, it cannot pass the bid along.
            //    Instead, the handler determines that there are no rooms available in the request chain (hasRooms == false)
            //    and returns a message to the GUI controller, indicating that all rooms are sold out.
            message = "We are sold out!";
        }
        return message;
    }

    @Override
    abstract public String toString();
}
