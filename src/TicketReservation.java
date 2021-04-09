public class TicketReservation {
    public int ticketID;
    public int reservationID;

    public TicketReservation() {
    }

    public TicketReservation(int ticketID, int reservationID) {
        this.ticketID = ticketID;
        this.reservationID = reservationID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }
}
