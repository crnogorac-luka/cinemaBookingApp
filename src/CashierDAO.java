import java.security.MessageDigest;
import java.util.ArrayList;

/**
 * class that represents cashier account info 
 * Authors: Igor, Ante
 */
public class CashierDAO implements DAO<CashierDAO.Cashier> {

    private DBConnect db;
    private ArrayList<Cashier> list;
    private CashierDAO.Cashier currentCashier;
    /**
     * @param db object that contains database connection protocols
     */
    public CashierDAO(DBConnect db) {
        this.db = db;
    }

    public Cashier getCurrentCashier() {
        return currentCashier;
    }

    public void setCurrentCashier(Cashier currentCashier) {
        this.currentCashier = currentCashier;
    }

    /**
     * @return current list of cashiers
     */
    public ArrayList<Cashier> getList() {
        return list;
    }

    @Override
    public Cashier getCurrentItem() {
        return currentCashier;
    }

    /**
     * @param id unique Cashier ID of the Cashier we want to fetch from the table
     */
    @Override
    public void fetch(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);
        Cashier fetchedCashier = new Cashier();

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Cashier WHERE CashierID = ?", values, false);
            fetchedCashier.setCashierID(Integer.parseInt(row.get(0).get(0)));
            fetchedCashier.setName(row.get(0).get(1));
            fetchedCashier.setSalary(Double.parseDouble(row.get(0).get(2)));
            fetchedCashier.setEmail(row.get(0).get(3));

            setCurrentCashier(fetchedCashier);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fetch(String email, String password) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + email);
        CashierDAO.Cashier fetchedCashier = new CashierDAO.Cashier();

        try {
            AccountInfoDAO accountInfoDAO = new AccountInfoDAO(db);
            accountInfoDAO.fetch(email);
            String fetchedPassword = accountInfoDAO.getCurrentItem().getPassword();

            // ENCRYPTING (HASHING) the provided password
            byte[] bytesOfMessage = password.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            StringBuilder result = new StringBuilder();
            for (byte aByte : thedigest) {
                result.append(String.format("%02x", aByte));
            }
            //password hashed with MD5
            String hashedPassword = result.toString();

            if (hashedPassword.equals(fetchedPassword)) {
                ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Customer WHERE Email = ?", values, false);
                fetchedCashier.setCashierID(Integer.parseInt(row.get(0).get(0)));
                fetchedCashier.setName(row.get(0).get(1));
                fetchedCashier.setSalary(Double.parseDouble(row.get(0).get(2)));
                fetchedCashier.setEmail(row.get(0).get(4));

                setCurrentCashier(fetchedCashier);
            } else {
                System.out.println("Wrong username or password. Try again.");
            }


        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param cashierInfo prepared object of class Cashier whose attributes
     *                    are translated to column values of the new row in Cashier table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean create(Cashier cashierInfo) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + cashierInfo.getCashierID());
        values.add(cashierInfo.getName());
        values.add("" + cashierInfo.getSalary());
        values.add(cashierInfo.getEmail());

        boolean response = false;
        try {
            response = db.setData("INSERT INTO Cashier VALUES('?','?','?', '?')", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param cashierInfo prepared object of class Cashier whose attributes
     *                    are translated to column values of the existing row with specified CashierID in
     *                    Cashier table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean update(int id, Cashier cashierInfo) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + cashierInfo.getCashierID());
        values.add(cashierInfo.getName());
        values.add("" + cashierInfo.getSalary());
        values.add(cashierInfo.getEmail());

        values.add("" + id);
        boolean response = false;
        try {
            response = db.setData("UPDATE Cashier SET CashierID = '?', name = '?', salary = '?', email = '?'", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param id unique ID of the Cashier we want to delete from the table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean remove(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);

        boolean response = false;
        try {
            response = db.setData("DELETE FROM Cashier WHERE CashierID = ?", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * retrieves all rows from Cashier table and translates them to objects
     * of class Cashier and stores them in the list
     */
    @Override
    public void fetchAll() {

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Cashier", null, false);
            for (ArrayList<String> record : row) {
                Cashier currentCashier = new Cashier();
                currentCashier.setCashierID(Integer.parseInt(row.get(0).get(0)));
                currentCashier.setName(row.get(0).get(1));
                currentCashier.setSalary(Double.parseDouble(row.get(0).get(2)));
                currentCashier.setEmail(row.get(0).get(3));
                getList().add(currentCashier);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * inner class of CashierDAO that serves as an object model used for
     * object-oriented manipulation of database data
     */
     class Cashier {

        public int cashierID;
        public String name;
        public double salary;
        public String email;

        /**
         * @param cashierID
         * @param name
         * @param salary
         * @param email
         */
        public Cashier(int cashierID, String name, double salary, String email) {
            this.cashierID = cashierID;
            this.name = name;
            this.salary = salary;
            this.email = email;
        }

        public Cashier() {

        }

        // ACCESSORS

        /**
         * @return cashierID
         */
        public int getCashierID() {
            return cashierID;
        }

        /**
         * @return name
         */
        public String getName() {
            return name;
        }

        /**
         * @return salary
         */
        public double getSalary() {
            return salary;
        }

        /**
         * @return email
         */
        public String getEmail() {
            return email;
        }

        // MUTATORS

        /**
         * @param cashierID sets new cashierID
         */
        public void setCashierID(int cashierID) {
            this.cashierID = cashierID;
        }

        /**
         * @param name sets new name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @param salary sets new salary
         */
        public void setSalary(double salary) {
            this.salary = salary;
        }

        /**
         * @param email sets new email
         */
        public void setEmail(String email) {
            this.email = email;
        }
    }
}