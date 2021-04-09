public class Ticket {
    public int ticketID;
    public double price;
    private int cashierID;

    public Ticket() {
    }

    public Ticket(int ticketID, double price, int cashierID) {
        this.ticketID = ticketID;
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
}
