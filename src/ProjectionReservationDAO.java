import java.util.ArrayList;

/**
 * class that represents one unique reservation
 */
public class ProjectionReservationDAO {

    private DBConnect db;
    private ArrayList<ProjectionReservation> list;

    /**
     * @param db object that contains database connection protocols
     */
    public ProjectionReservationDAO(DBConnect db) {
        this.db = db;
    }


    /**
     * @return current list of reservations
     */
    public ArrayList<ProjectionReservation> getList() {
        return list;
    }

    /**
     * @param id unique ID of the PROJECTION_RESERVATION we want to fetch from the table
     * @return object of class ProjectionReservation
     */
    public ProjectionReservation fetch(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);
        ProjectionReservation fetchedProjectionReservation = new ProjectionReservation();

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM PROJECTION_RESERVATION WHERE ProjectionID = ?", values, false);
            fetchedProjectionReservation.setProjectionID(Integer.parseInt(row.get(0).get(0)));
            fetchedProjectionReservation.setReservationID(Integer.parseInt(row.get(0).get(1)));

            return fetchedProjectionReservation;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * @param projectionReservation prepared object of class ProjectionReservation whose attributes are translated to column values of the new row in PROJECTION_RESERVATION table
     * @return true if insertion is successful, false if otherwise
     */
    public boolean create(ProjectionReservation projectionReservation) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + projectionReservation.getProjectionID());
        values.add("" + projectionReservation.getReservationID());

        boolean response = false;
        try {
            response = db.setData("INSERT INTO PROJECTION_RESERVATION VALUES(?,?)", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param projectionReservation prepared object of class ProjectionReservation whose attributes are translated to column values of the existing row with specified ID in PROJECTION_RESERVATION table
     * @return true if insertion is successful, false if otherwise
     */
    public boolean update(ProjectionReservation projectionReservation) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + projectionReservation.getReservationID());
        values.add("" + projectionReservation.getProjectionID());

        boolean response = false;
        try {
            response = db.setData("UPDATE PROJECTION_RESERVATION SET ReservationID = ? WHERE ProjectionID = ?", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param id unique ID of the PROJECTION_RESERVATION we want to delete from the table
     * @return true if insertion is successful, false if otherwise
     */
    public boolean remove(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);

        boolean response = false;
        try {
            response = db.setData("DELETE FROM PROJECTION_RESERVATION WHERE ProjectionID = ?", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }


    /**
     * retrieves all rows from PROJECTION_RESERVATION table and translates them to objects of class ProjectionReservation and stores them in the list
     */
    public void fetchAll() {

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM PROJECTION_RESERVATION", null, false);
            for (ArrayList<String> record : row) {
                ProjectionReservation currProjectionReservation = new ProjectionReservation();
                currProjectionReservation.setProjectionID(Integer.parseInt(record.get(0)));
                currProjectionReservation.setReservationID(Integer.parseInt(record.get(1)));
                getList().add(currProjectionReservation);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ProjectionReservation {

        private int projectionID;
        private int reservationID;

        public ProjectionReservation() {
        }

        /**
         * parameterized constructor for ProjectionReservation class
         * @param projectionID
         * @param reservationID
         */
        public ProjectionReservation(int projectionID, int reservationID) {
            this.projectionID = projectionID;
            this.reservationID = reservationID;
        }

        // ACCESSORS

        /**
         * return the id of the projection
         * @return
         */
        public int getProjectionID() {
            return projectionID;
        }

        /**
         * return the id of the reservation
         * @return
         */
        public int getReservationID() {
            return reservationID;
        }


        // MUTATORS

        /**
         *
         * @param projectionID the projection id
         */
        public void setProjectionID(int projectionID) {
            this.projectionID = projectionID;
        }

        /**
         *
         * @param reservationID the reservation id
         */
        public void setReservationID(int reservationID) {
            this.reservationID = reservationID;
        }

    }

}