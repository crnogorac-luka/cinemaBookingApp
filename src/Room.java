/**
 * Represents a room (hall) in a cinema with a unique ID
 */
public class Room {

    private int roomID;

    /**
     * @param roomID parameterized constructor for Room class
     */
    // PARAMETERIZED CONSTRUCTOR
    public Room(int roomID) {
        this.roomID = roomID;
    }


    // ACCESSORS

    /**
     * @return unique room ID
     */
    public int getRoomID() {
        return roomID;
    }


    // MUTATORS

    /**
     * @param roomID sets a new unique room ID
     */
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
}
