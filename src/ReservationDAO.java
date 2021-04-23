import java.util.ArrayList;

/**
 * class that represents one unique reservation
 */
public class ReservationDAO implements DAO<Reservation>{

    private DBConnect db;
    private ArrayList<Reservation> list;
    private Reservation currentReservation;
    /**
     * @param db object that contains database connection protocols
     */
    public ReservationDAO(DBConnect db) {
        this.db = db;
    }


    /**
     * @return current list of reservations
     */
    public ArrayList<Reservation> getList() {
        return list;
    }

    public Reservation getCurrentReservation() {
        return currentReservation;
    }

    public void setCurrentReservation(Reservation currentReservation) {
        this.currentReservation = currentReservation;
    }

    @Override
    public Reservation getCurrentItem() {
        return currentReservation;
    }

    /**
     * @param id unique ID of the reservation we want to fetch from the table
     * @return object of class Reservation
     */
    @Override
    public void fetch(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);
        Reservation fetchedReservation = new Reservation();

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Reservation WHERE ReservationID = ?", values, false);
            fetchedReservation.setReservationID(Integer.parseInt(row.get(0).get(0)));
            fetchedReservation.setCustomerID(Integer.parseInt(row.get(0).get(1)));
            fetchedReservation.setProjectionID(Integer.parseInt(row.get(0).get(2)));
            fetchedReservation.setSeatCode(Integer.parseInt(row.get(0).get(3)));

            setCurrentReservation(fetchedReservation);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @param reservation prepared object of class Reservation whose attributes are translated to column values of the new row in Reservation table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean create(Reservation reservation) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + reservation.getCustomerID());
        values.add("" + reservation.getProjectionID());
        values.add("" + reservation.getSeatCode());

        boolean response = false;
        try {
            response = db.setData("INSERT INTO Reservation VALUES(?,?,?)", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param reservation prepared object of class Reservation whose attributes are translated to column values of the existing row with specified ID in Reservation table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean update(int id, Reservation reservation) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + reservation.getCustomerID());
        values.add("" + reservation.getProjectionID());
        values.add("" + reservation.getSeatCode());
        values.add("" + id);

        values.add("" + id);
        boolean response = false;
        try {
            response = db.setData("UPDATE Reservation SET CustomerID = ?, ProjectionID = ?, SeatCode = ? WHERE ReservationID = ?", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param id unique ID of the reservation we want to delete from the table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean remove(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);

        boolean response = false;
        try {
            response = db.setData("DELETE FROM Reservation WHERE ReservationID = ?", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }


    /**
     * retrieves all rows from Reservation table and translates them to objects of class Reservation and stores them in the list
     */
    @Override
    public void fetchAll() {

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Reservation", null, false);
            for (ArrayList<String> record : row) {
                Reservation currReservation = new Reservation();
                currReservation.setReservationID(Integer.parseInt(record.get(0)));
                currReservation.setCustomerID(Integer.parseInt(record.get(1)));
                currReservation.setProjectionID(Integer.parseInt(record.get(2)));
                currReservation.setSeatCode(Integer.parseInt(record.get(3)));
                getList().add(currReservation);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//public class Reservation {
//
//    private int reservationID;
//    private int customerID;
//    private int projectionID;
//    private int seatCode;
//
//    public Reservation() {
//    }
//
//    /**
//     * parameterized constructor for Reservation class
//     * @param reservationID
//     * @param customerID
//     * @param projectionID
//     * @param seatCode
//     */
//    public Reservation(int reservationID, int customerID, int projectionID, int seatCode) {
//        this.reservationID = reservationID;
//        this.customerID = customerID;
//        this.projectionID = projectionID;
//        this.seatCode = seatCode;
//    }
//
//    // ACCESSORS
//
//    /**
//     * return the id of the reservation
//     * @return
//     */
//
//    public int getReservationID() {
//        return reservationID;
//    }
//
//    /**
//     * return the id of the person
//     * @return
//     */
//    public int getCustomerID() {
//        return customerID;
//    }
//
//    /**
//     * return the id of the projection
//     * @return
//     */
//    public int getProjectionID() {
//        return projectionID;
//    }
//
//    /**
//     * return the seat code number
//     * @return
//     */
//    public int getSeatCode() {
//        return seatCode;
//    }
//
//
//    // MUTATORS
//
//    /**
//     *
//     * @param reservationID the reservation id
//     */
//
//    public void setReservationID(int reservationID) {
//        this.reservationID = reservationID;
//    }
//
//    /**
//     *
//     * @param customerID the customer id
//     */
//    public void setCustomerID(int customerID) {
//        this.customerID = customerID;
//    }
//
//    /**
//     *
//     * @param projectionID the projection id
//     */
//    public void setProjectionID(int projectionID) {
//        this.projectionID = projectionID;
//    }
//
//    /**
//     *
//     * @param seatCode the seat code
//     */
//    public void setSeatCode(int seatCode) {
//        this.seatCode = seatCode;
//    }
//
//}
