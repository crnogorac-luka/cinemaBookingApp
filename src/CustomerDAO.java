import java.security.MessageDigest;
import java.util.ArrayList;

public class CustomerDAO implements DAO<Customer> {


    private DBConnect db;
    private ArrayList<Customer> list;
    private Customer currentCustomer;

    /**
     * @param db object that contains database connection protocols
     */
    public CustomerDAO(DBConnect db) {
        this.db = db;
    }


    /**
     * @return current list of customers
     */
    public ArrayList<Customer> getList() {
        return list;
    }

    @Override
    public Customer getCurrentItem() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }


    /**
     * @param id unique ID of the customer we want to fetch from the table
     */
    @Override
    public void fetch(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);
        Customer fetchedCustomer = new Customer();

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Customer WHERE CustomerID = ?", values, false);
            fetchedCustomer.setPersonID(Integer.parseInt(row.get(0).get(0)));
            fetchedCustomer.setFirstName(row.get(0).get(1));
            fetchedCustomer.setLastName(row.get(0).get(2));
            fetchedCustomer.setPhone(row.get(0).get(3));
            fetchedCustomer.setEmail(row.get(0).get(4));

            setCurrentCustomer(fetchedCustomer);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void fetch(String email, String password) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + email);
        Customer fetchedCustomer = new Customer();

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
                fetchedCustomer.setPersonID(Integer.parseInt(row.get(0).get(0)));
                fetchedCustomer.setFirstName(row.get(0).get(1));
                fetchedCustomer.setLastName(row.get(0).get(2));
                fetchedCustomer.setPhone(row.get(0).get(3));
                fetchedCustomer.setEmail(row.get(0).get(4));

                setCurrentCustomer(fetchedCustomer);
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
     * @param customer prepared object of class Customer whose attributes are translated to column values of the new row in Movie table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean create(Customer customer) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + customer.getPersonID());
        values.add(customer.getFirstName());
        values.add(customer.getLastName());
        values.add(customer.getPhone());
        values.add("" + customer.getEmail());

        boolean response = false;
        try {
            response = db.setData("INSERT INTO Customer VALUES(?,'?','?','?','?')", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param customer prepared object of class Customer whose attributes are translated to column values of the existing row with specified ID in Movie table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean update(int id, Customer customer) {
        ArrayList<String> values = new ArrayList<String>();
        values.add(customer.getFirstName());
        values.add(customer.getLastName());
        values.add(customer.getPhone());
        values.add("" + customer.getEmail());

        values.add("" + id);

        boolean response = false;
        try {
            response = db.setData("UPDATE Customer SET FirstName = '?', LastName = '?', Phone = '?', Email = '?' WHERE PersonID = '?'", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param id unique ID of the customer we want to delete from the table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean remove(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);

        boolean response = false;
        try {
            response = db.setData("DELETE FROM Customer WHERE CustomerID = ?", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }


    /**
     * retrieves all rows from Customer table and translates them to objects of class Customer and stores them in the list
     */
    @Override
    public void fetchAll() {

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Customer", null, false);
            for (ArrayList<String> record : row) {
                Customer currCustomer = new Customer();
                currCustomer.setPersonID(Integer.parseInt(record.get(0)));
                currCustomer.setFirstName(record.get(1));
                currCustomer.setLastName(record.get(2));
                currCustomer.setPhone(record.get(3));
                currCustomer.setEmail(record.get(4));

                getList().add(currCustomer);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



