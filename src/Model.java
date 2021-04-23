import java.util.HashMap;

public class Model {

    private HashMap<String, DAO> daoCollection;

    public Model(DBConnect db) {
        this.daoCollection = new HashMap<>();
        loadObjects(db);
    }

    private void loadObjects(DBConnect db) {
        daoCollection.put("accountInfo", new AccountInfoDAO(db));
        daoCollection.put("customer", new CustomerDAO(db));
        daoCollection.put("room", new RoomDAO(db));
        daoCollection.put("seat", new SeatDAO(db));
        daoCollection.put("movie", new MovieDAO(db));
        daoCollection.put("cashier", new CashierDAO(db));
        daoCollection.put("projection", new ProjectionDAO(db));
        daoCollection.put("reservation", new ReservationDAO(db));
        daoCollection.put("ticket", new TicketDAO(db));

    }


    public HashMap<String, DAO> getDaoCollection() {
        return daoCollection;
    }
}
