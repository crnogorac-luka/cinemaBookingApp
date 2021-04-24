public class Ticket {
    public int ticketID;
    private int reservationID;
    public double price;
    private int cashierID;

    public Ticket() {
        ticketID = -1;
        reservationID = -1;
        price = 0.0;
        cashierID = -1;
    }

    public Ticket(int reservationID, double price, int cashierID) {
        this.reservationID = reservationID;
        this.price = price;
        this.cashierID = cashierID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCashierID() {
        return cashierID;
    }

    public void setCashierID(int cashierID) {
        this.cashierID = cashierID;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }
}