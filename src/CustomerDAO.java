import java.util.ArrayList;

public class CustomerDAO implements DAO<CustomerDAO.Customer>{


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

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }


    /**
     * @param id unique ID of the customer we want to fetch from the table
     * @return object of class Movie
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


    /**
     * inner class of CustomerDAO that serves as an object model used for object-oriented manipulation of database data
     */
    class Customer {

        public int personID;
        public String firstName;
        public String lastName;
        public String phone;
        public String email;


        public Customer() {
            this.personID = -1;
            this.firstName = "";
            this.lastName = "";
            this.phone = "";
            this.email = "";
        }

        /**
         * @param personID
         * @param firstName
         * @param lastName
         * @param phone
         * @param email
         */
        // PARAMETERIZED CONSTRUCTOR
        public Customer(int personID, String firstName, String lastName, String phone, String email) {
            this.personID = personID;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
            this.email = email;
        }


        // ACCESSORS

        /**
         * @return personID
         */
        public int getPersonID() {
            return personID;
        }

        /**
         * @return firstName
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * @return lastName
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * @return phone
         */
        public String getPhone() {
            return phone;
        }

        /**
         * @return email
         */
        public String getEmail() {
            return email;
        }

        // MUTATORS

        /**
         * @param personID sets new personID
         */
        public void setPersonID(int personID) {
            this.personID = personID;
        }

        /**
         * @param firstName sets new firstName
         */
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        /**
         * @param lastName sets new lastName
         */
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        /**
         * @param phone sets new phone
         */
        public void setPhone(String phone) {
            this.phone = phone;
        }

        /**
         * @param email sets new email
         */
        public void setEmail(String email) {
            this.email = email;
        }
    }
}



