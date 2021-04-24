import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * class that represents one unique projection
 */
public class ProjectionDAO implements DAO<Projection>{

    private DBConnect db;
    private ArrayList<Projection> list;
    private Projection currentProjection;

    /**
     * @param db object that contains database connection protocols
     */
    public ProjectionDAO(DBConnect db) {
        this.db = db;
    }


    /**
     * @return current list of projections
     */
    public ArrayList<Projection> getList() {
        return list;
    }

    @Override
    public Projection getCurrentItem() {
        return currentProjection;
    }

    @Override
    public void setCurrentItem(Projection currentItem) {
        currentProjection = currentItem;
    }

    /**
     * @param id unique ID of the projection we want to fetch from the table
     */
    @Override
    public void fetch(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);
        Projection fetchedProjection = new Projection();

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Projection WHERE ProjectionID = ?", values, false);
            fetchedProjection.setProjectionID(Integer.parseInt(row.get(0).get(0)));
            fetchedProjection.setStartTime(row.get(0).get(1));
            fetchedProjection.setEndTime(row.get(0).get(2));
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            fetchedProjection.setDate(format.parse(row.get(0).get(3)));
            fetchedProjection.setRoomID(Integer.parseInt(row.get(0).get(4)));
            fetchedProjection.setMovieID(Integer.parseInt(row.get(0).get(5)));

            setCurrentItem(fetchedProjection);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> fetchAvailableDates(int movieID) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + movieID);

        ArrayList<String> dates = new ArrayList<>();
        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT DISTINCT `Date` FROM `Projection` WHERE `MovieID` = ?", values, false);
            for (int i=0; i<row.size(); i++) {
                dates.add(row.get(i).get(0));
            }

            return dates;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> fetchAvailableTimes(int movieID, String date) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + movieID);
        values.add(date);

        ArrayList<String> times = new ArrayList<>();
        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT DISTINCT `StartTime` FROM `Projection` WHERE `MovieID` = ? AND `Date` = ?", values, false);
            for (int i=0; i<row.size(); i++) {
                times.add(row.get(i).get(0));
            }

            return times;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> fetchAvailableRooms(int movieID, String date, String startTime) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + movieID);
        values.add(date);
        values.add(startTime);

        ArrayList<String> rooms = new ArrayList<>();
        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT DISTINCT `RoomID` FROM `Projection` WHERE `MovieID` = ? AND `Date` = ? AND `StartTime` = ?", values, false);
            for (int i=0; i<row.size(); i++) {
                rooms.add(row.get(i).get(0));
            }

            return rooms;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * @param projection prepared object of class Projection whose attributes are translated to column values of the new row in Projection table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean create(Projection projection) {
        ArrayList<String> values = new ArrayList<String>();
        values.add(projection.getStartTime());
        values.add(projection.getEndTime());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        values.add(df.format(projection.getDate()));
        values.add("" + projection.getRoomID());
        values.add("" + projection.getMovieID());


        boolean response = false;
        try {
            response = db.setData("INSERT INTO Projection (StartTime, EndTime, Date, RoomID, MovieID) VALUES(?,?,?,?,?)", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param projection prepared object of class Projection whose attributes are translated to column values of the existing row with specified ID in Projection table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean update(int id, Projection projection) {
        ArrayList<String> values = new ArrayList<String>();
        values.add(projection.getStartTime());
        values.add(projection.getEndTime());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        values.add(df.format(projection.getDate()));
        values.add("" + projection.getRoomID());
        values.add("" + projection.getMovieID());
        values.add("" + projection.getProjectionID());

        values.add("" + id);
        boolean response = false;
        try {
            response = db.setData("UPDATE Projection SET StartTime = '?', EndTime = '?', Date = '?', RoomID = '?', MovieID = '?' WHERE ProjectionID = '?'", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param id unique ID of the projection we want to delete from the table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean remove(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);

        boolean response = false;
        try {
            response = db.setData("DELETE FROM Projection WHERE ProjectionID = ?", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }


    /**
     * retrieves all rows from Projection table and translates them to objects of class Projection and stores them in the list
     */
    @Override
    public void fetchAll() {

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Projection", null, false);
            for (ArrayList<String> record : row) {
                Projection currProjection = new Projection();
                currProjection.setProjectionID(Integer.parseInt(record.get(0)));
                currProjection.setStartTime(record.get(1));
                currProjection.setEndTime(record.get(2));
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                currProjection.setDate(format.parse(record.get(3)));
                currProjection.setRoomID(Integer.parseInt(record.get(4)));
                currProjection.setMovieID(Integer.parseInt(record.get(5)));
                getList().add(currProjection);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
