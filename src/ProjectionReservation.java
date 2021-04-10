
/**
 * A class that represents projection reservation
 *
 * @author Ante
 */

public class ProjectionReservation {

    private int projectionID;
    private int reservationID;

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
     * @param projectionID
     */
    public void setProjectionID(int projectionID) {
        this.projectionID = projectionID;
    }

    /**
     *
     * @param reservationID
     */
    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }
    
}
