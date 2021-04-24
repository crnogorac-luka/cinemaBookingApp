public class Room {
    private int roomID;
    private int for3D;

    /**
     * @param roomID parameterized constructor for Room class
     * @param for3D
     */
    // PARAMETERIZED CONSTRUCTOR
    public Room(int roomID, int for3D) {
        this.roomID = roomID;
        this.for3D = for3D;
    }

    public Room() {
        this.roomID = -1;
        this.for3D = 0;
    }


    // ACCESSORS

    /**
     * @return unique room ID
     */
    public int getRoomID() {
        return roomID;
    }

    /**
     * @return 1 if room is for 3D movies and 0 if 2D
     */
    public int getFor3D() {
        return for3D;
    }

    // MUTATORS

    /**
     * @param roomID sets a new unique room ID
     */
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    /**
     * @param for3D sets 0 or 1 depending on support for 3D movies
     */
    public void setFor3D(int for3D) {
        this.for3D = for3D;
    }
}
