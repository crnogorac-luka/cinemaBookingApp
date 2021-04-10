
/**
 * A class that represents reservation
 *
 * @author Ante
 */
public class Reservation {
    
    private int reservationID;
    private int personID;
    private int projectionID;
    private int seatCode;

    /**
     * parameterized constructor for Reservation class
     * @param reservationID
     * @param personID
     * @param projectionID
     * @param seatCode
     */
    public Reservation(int reservationID, int personID, int projectionID, int seatCode) {
        this.reservationID = reservationID;
        this.personID = personID;
        this.projectionID = projectionID;
        this.seatCode = seatCode;
    }
    
    // ACCESSORS

    /**
     * return the id of the reservation
     * @return
     */

    public int getReservationID() {
        return reservationID;
    }

    /**
     * return the id of the person
     * @return
     */
    public int getPersonID() {
        return personID;
    }

    /**
     * return the id of the projection
     * @return
     */
    public int getProjectionID() {
        return projectionID;
    }

    /**
     * return the seat code number
     * @return
     */
    public int getSeatCode() {
        return seatCode;
    }
    
    
    // MUTATORS

    /**
     *
     * @param reservationID
     */

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    /**
     *
     * @param personID
     */
    public void setPersonID(int personID) {
        this.personID = personID;
    }

    /**
     *
     * @param projectionID
     */
    public void setProjectionID(int projectionID) {
        this.projectionID = projectionID;
    }

    /**
     *
     * @param seatCode
     */
    public void setSeatCode(int seatCode) {
        this.seatCode = seatCode;
    }
    
}
