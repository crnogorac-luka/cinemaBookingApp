import java.util.ArrayList;

/**
 * Represents a room (hall) in a cinema with a unique ID
 */
public class RoomDAO implements DAO<Room>{

    private DBConnect db;
    private ArrayList<Room> list;
    private Room currentRoom;

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


    @Override
    public Room getCurrentItem() {
        return currentRoom;
    }

    @Override
    public void setCurrentItem(Room currentItem) {
        currentRoom = currentItem;
    }

    /**
     * @param id unique ID of the room we want to fetch from the table
     * @return object of class Room
     */
    @Override
    public void fetch(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);
        Room fetchedRoom = new Room();

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Room WHERE RoomID = ?", values, false);
            fetchedRoom.setRoomID(Integer.parseInt(row.get(0).get(0)));
            fetchedRoom.setFor3D(Integer.parseInt(row.get(0).get(1)));

            setCurrentItem(fetchedRoom);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @param room prepared object of class Room whose attributes are translated to column values of the new row in Room table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean create(Room room) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + room.getRoomID());
        values.add("" + room.getFor3D());

        boolean response = false;
        try {
            response = db.setData("INSERT INTO Room VALUES(?, ?)", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param room prepared object of class Room whose attributes are translated to column values of the existing row with specified ID in Room table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean update(int id, Room room) {
        ArrayList<String> values = new ArrayList<String>();

        values.add("" + room.getFor3D());
        values.add("" + id);

        values.add("" + id);
        boolean response = false;
        try {
            response = db.setData("UPDATE Room SET For3D = '?' WHERE RoomID = '?'", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param id unique ID of the room we want to delete from the table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
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
    @Override
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



}
