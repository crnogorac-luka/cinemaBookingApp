import java.util.ArrayList;

public class TicketDAO implements DAO<Ticket> {

    private DBConnect db;
    private ArrayList<Ticket> list;
    private Ticket currentTicket;

    /**
     * @param db object that contains database connection protocols
     */
    public TicketDAO(DBConnect db) {
        this.db = db;
    }


    /**
     * @return current list of Ticket
     */
    public ArrayList<Ticket> getList() {
        return list;
    }


    @Override
    public Ticket getCurrentItem() {
        return currentTicket;
    }

    @Override
    public void setCurrentItem(Ticket currentItem) {
        currentTicket = currentItem;
    }

    /**
     * @param id unique ID of the Ticket we want to fetch from the table
     * @return object of class Movie
     */
    @Override
    public void fetch(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);
        Ticket fetchedTicket = new Ticket();

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Ticket WHERE TicketID = ?", values, false);
            fetchedTicket.setTicketID(Integer.parseInt(row.get(0).get(0)));
            fetchedTicket.setReservationID(Integer.parseInt(row.get(0).get(1)));
            fetchedTicket.setPrice(Double.parseDouble(row.get(0).get(2)));
            fetchedTicket.setCashierID(Integer.parseInt(row.get(0).get(3)));


            setCurrentItem(fetchedTicket);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            new DBException(e, "The record does not exist for the Ticket");
        }
    }


    /**
     * @param ticket prepared object of class Ticket whose attributes are translated to column values of the new row in Ticket table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean create(Ticket ticket) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + ticket.getReservationID());
        values.add("" + ticket.getPrice());
        values.add("" + ticket.getCashierID());


        boolean response = false;
        try {
            response = db.setData("INSERT INTO Ticket (ReservationID, Price, CashierID) VALUES(?,?,?)", values);
        } catch (Exception e) {
            new DBException(e, "Wrong create operation for the Ticket");
        }

        return response;
    }

    public boolean createAsCustomer(Ticket ticket) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + ticket.getReservationID());
        values.add("" + ticket.getPrice());


        boolean response = false;
        try {
            response = db.setData("INSERT INTO Ticket (ReservationID, Price, CashierID) VALUES(?,?,null)", values);
        } catch (Exception e) {
            new DBException(e, "Wrong createAsCustomer operation for the Ticket");
        }

        return response;
    }

    /**
     * @param ticket prepared object of class Ticket whose attributes are translated to column values of the existing row with specified ID in Ticket table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean update(int id, Ticket ticket) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + ticket.getReservationID());
        values.add("" + ticket.getPrice());
        values.add("" + ticket.getCashierID());
        values.add("" + id);

        values.add("" + id);
        boolean response = false;
        try {
            response = db.setData("UPDATE Ticket SET ReservationID = '?' Price = '?', CashierID = '?',  WHERE TicketID = '?'", values);
        } catch (Exception e) {
            new DBException(e, "Wrong update operation for the Ticket");
        }

        return response;
    }

    /**
     * @param id unique ID of the Ticket we want to delete from the table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean remove(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);

        boolean response = false;
        try {
            response = db.setData("DELETE FROM Ticket WHERE TicketID = ?", values);
        } catch (Exception e) {
            new DBException(e, "Wrong remove operation for the Ticket");
        }

        return response;
    }


    /**
     * retrieves all rows from Ticket table and translates them to objects of class Ticket and stores them in the list
     */
    @Override
    public void fetchAll() {

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Ticket", null, false);
            for (ArrayList<String> record : row) {
                Ticket currTicket = new Ticket();
                currTicket.setTicketID(Integer.parseInt(record.get(0)));
                currTicket.setReservationID(Integer.parseInt(record.get(1)));
                currTicket.setPrice(Double.parseDouble(record.get(2)));
                currTicket.setCashierID(Integer.parseInt(record.get(3)));

                getList().add(currTicket);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            new DBException(e, "The record does not exist for the Ticket");
        }
    }

}
