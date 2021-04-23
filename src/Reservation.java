public class Reservation {

    private int reservationID;
    private int customerID;
    private int projectionID;
    private int seatCode;

    public Reservation() {
    }

    /**
     * parameterized constructor for Reservation class
     * @param reservationID
     * @param customerID
     * @param projectionID
     * @param seatCode
     */
    public Reservation(int reservationID, int customerID, int projectionID, int seatCode) {
        this.reservationID = reservationID;
        this.customerID = customerID;
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
    public int getCustomerID() {
        return customerID;
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
     * @param reservationID the reservation id
     */

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    /**
     *
     * @param customerID the customer id
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     *
     * @param projectionID the projection id
     */
    public void setProjectionID(int projectionID) {
        this.projectionID = projectionID;
    }

    /**
     *
     * @param seatCode the seat code
     */
    public void setSeatCode(int seatCode) {
        this.seatCode = seatCode;
    }

}