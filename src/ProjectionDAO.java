import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * class that represents one unique projection
 */
public class ProjectionDAO {

    private DBConnect db;
    private ArrayList<Projection> list;

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


    /**
     * @param id unique ID of the projection we want to fetch from the table
     * @return object of class Projection
     */
    public Projection fetch(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);
        Projection fetchedProjection = new Projection();

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Projection WHERE ProjectionID = ?", values, false);
            fetchedProjection.setProjectionID(Integer.parseInt(row.get(0).get(0)));
            fetchedProjection.setStartTime(Integer.parseInt(row.get(0).get(1)));
            fetchedProjection.setEndTime(Integer.parseInt(row.get(0).get(2)));
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            fetchedProjection.setDate(format.parse(row.get(0).get(3)));
            fetchedProjection.setRoomID(Integer.parseInt(row.get(0).get(4)));
            fetchedProjection.setMovieID(Integer.parseInt(row.get(0).get(5)));

            return fetchedProjection;
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
    public boolean create(Projection projection) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + projection.getProjectionID());
        values.add("" + projection.getStartTime());
        values.add("" + projection.getEndTime());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        values.add(df.format(projection.getDate()));
        values.add("" + projection.getRoomID());
        values.add("" + projection.getMovieID());


        boolean response = false;
        try {
            response = db.setData("INSERT INTO Projection VALUES(?,?,?,'?',?,?)", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param projection prepared object of class Projection whose attributes are translated to column values of the existing row with specified ID in Projection table
     * @return true if insertion is successful, false if otherwise
     */
    public boolean update(Projection projection) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + projection.getStartTime());
        values.add("" + projection.getEndTime());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        values.add(df.format(projection.getDate()));
        values.add("" + projection.getRoomID());
        values.add("" + projection.getMovieID());
        values.add("" + projection.getProjectionID());

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
    public void fetchAll() {

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Projection", null, false);
            for (ArrayList<String> record : row) {
                Projection currProjection = new Projection();
                currProjection.setProjectionID(Integer.parseInt(record.get(0)));
                currProjection.setStartTime(Integer.parseInt(record.get(1)));
                currProjection.setEndTime(Integer.parseInt(record.get(2)));
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


    class Projection {

        private int projectionID;
        private int startTime;
        private int endTime;
        private Date date;
        private int roomID;
        private int movieID;

        /**
         * default constructor
         */
        public Projection() {
            this.projectionID = -1;
            this.startTime = -1;
            this.endTime = -1;
            this.date = null;
            this.roomID = -1;
            this.movieID = -1;
        }

        /**
         * parameterized constructor for Projection class
         *
         * @param projectionID unique projection ID
         * @param startTime    timestamp of the start of this projection
         * @param endTime      timestamp of the end of this projection
         * @param date         date of the projection
         * @param roomID       unique ID of the room where projection is held
         * @param movieID      unique ID of the projection that is projected
         */
        public Projection(int projectionID, int startTime, int endTime, Date date, int roomID, int movieID) {
            this.projectionID = projectionID;
            this.startTime = startTime;
            this.endTime = endTime;
            this.date = date;
            this.roomID = roomID;
            this.movieID = movieID;
        }


        // ACCESSORS

        /**
         * @return unique ID of the projection
         */
        public int getProjectionID() {
            return projectionID;
        }

        /**
         * @return timestamp of the start of this projection
         */
        public int getStartTime() {
            return startTime;
        }

        /**
         * @return timestamp of the end of this projection
         */
        public int getEndTime() {
            return endTime;
        }

        /**
         * @return date of the projection
         */
        public Date getDate() {
            return date;
        }

        /**
         * @return unique ID of the room where projection is held
         */
        public int getRoomID() {
            return roomID;
        }

        /**
         * @return unique ID of the projection that is projected
         */
        public int getMovieID() {
            return movieID;
        }


        // MUTATORS

        /**
         * @param projectionID new unique ID of the projection
         */
        public void setProjectionID(int projectionID) {
            this.projectionID = projectionID;
        }

        /**
         * @param startTime new timestamp of the start of this projection
         */
        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        /**
         * @param endTime new timestamp of the end of this projection
         */
        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        /**
         * @param date new date of the projection
         */
        public void setDate(Date date) {
            this.date = date;
        }

        /**
         * @param roomID new unique ID of the room where projection is held
         */
        public void setRoomID(int roomID) {
            this.roomID = roomID;
        }

        /**
         * @param movieID new unique ID of the projection that is projected
         */
        public void setMovieID(int movieID) {
            this.movieID = movieID;
        }
    }
}
