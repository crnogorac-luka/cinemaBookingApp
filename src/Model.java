import java.util.HashMap;

public class Model {

    private HashMap<String, DAO> daoCollection;

    public Model(DBConnect db) {
        this.daoCollection = new HashMap<>();
        loadObjects(db);
    }

    private void loadObjects(DBConnect db) {
        daoCollection.put("customer", new CustomerDAO(db));
    }


    public HashMap<String, DAO> getDaoCollection() {
        return daoCollection;
    }
}
