import java.util.ArrayList;

/**
 * Represents a room (hall) in a cinema with a unique ID
 */
public class RoomDAO {

    private DBConnect db;
    private ArrayList<Room> list;

    /**
     * @param db object that contains database connection protocols
     */
    public RoomDAO(DBConnect db) {
        this.db = db;
    }


    /**
     * @return current list of rooms
     */
    public ArrayList<Room> getList() {
        return list;
    }


    /**
     * @param id unique ID of the room we want to fetch from the table
     * @return object of class Room
     */
    public Room fetch(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);
        Room fetchedRoom = new Room();

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Room WHERE RoomID = ?", values, false);
            fetchedRoom.setRoomID(Integer.parseInt(row.get(0).get(0)));

            return fetchedRoom;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * @param room prepared object of class Room whose attributes are translated to column values of the new row in Room table
     * @return true if insertion is successful, false if otherwise
     */
    public boolean create(Room room) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + room.getRoomID());

        boolean response = false;
        try {
            response = db.setData("INSERT INTO Room VALUES(?)", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param room prepared object of class Room whose attributes are translated to column values of the existing row with specified ID in Room table
     * @return true if insertion is successful, false if otherwise
     */
    public boolean update(Room room) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + room.getRoomID());
        values.add("" + room.getRoomID());

        boolean response = false;
        try {
            response = db.setData("UPDATE Room SET RoomID = '?' WHERE RoomID = '?'", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param id unique ID of the room we want to delete from the table
     * @return true if insertion is successful, false if otherwise
     */
    public boolean remove(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);

        boolean response = false;
        try {
            response = db.setData("DELETE FROM Room WHERE RoomID = ?", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }


    /**
     * retrieves all rows from Room table and translates them to objects of class Room and stores them in the list
     */
    public void fetchAll() {

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Room", null, false);
            for (ArrayList<String> record : row) {
                Room currRoom = new Room();
                currRoom.setRoomID(Integer.parseInt(record.get(0)));
                getList().add(currRoom);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public class Room {

        private int roomID;

        /**
         * @param roomID parameterized constructor for Room class
         */
        // PARAMETERIZED CONSTRUCTOR
        public Room(int roomID) {
            this.roomID = roomID;
        }

        public Room() {
            this.roomID = -1;
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
}
