
import java.util.ArrayList;
import java.util.*;
import java.sql.*;

/**
 * class that represents account info 
 * Authors: Igor, Ante
 */
public class AccountInfoDAO {

    private DBConnect db;
    private ArrayList<AccountInfo> list;

    /**
     * @param db object that contains database connection protocols
     */
    public AccountInfoDAO(DBConnect db) {
        this.db = db;
    }

    /**
     * @return current list of accounts
     */
    public ArrayList<AccountInfo> getList() {
        return list;
    }

    /**
     * @param email unique EMAIL of the AccountInfo we want to fetch from the
     *              table
     * @return object of class AccountInfo
     */
    public AccountInfo fetch(String email) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + email);
        AccountInfo fetchedAccount = new AccountInfo();

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM AccountInfo WHERE email = ?", values, false);
            fetchedAccount.setEmail(row.get(0).get(0));
            fetchedAccount.setPassword(row.get(0).get(1));
            fetchedAccount.setRole(row.get(0).get(2));
            return fetchedAccount;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param AccountInfo prepared object of class AccountInfo whose attributes
     *                    are translated to column values of the new row in AccountInfo table
     * @return true if insertion is successful, false if otherwise
     */
    public boolean create(AccountInfo accountInfo) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + accountInfo.getEmail());
        values.add(accountInfo.getPassword());
        values.add(accountInfo.getRole());

        boolean response = false;
        try {
            response = db.setData("INSERT INTO AccountInfo VALUES('?','?','?')", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param AccountInfo prepared object of class AccountInfo whose attributes
     *                    are translated to column values of the existing row with specified ID in
     *                    AccountInfo table
     * @return true if insertion is successful, false if otherwise
     */
    public boolean update(AccountInfo accountInfo) {
        ArrayList<String> values = new ArrayList<String>();
        values.add(accountInfo.getEmail());
        values.add(accountInfo.getPassword());
        values.add(accountInfo.getRole());

        boolean response = false;
        try {
            response = db.setData("UPDATE AccountInfo SET email = '?', password = '?', role = '?'", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param id unique ID of the AccountInfo we want to delete from the table
     * @return true if insertion is successful, false if otherwise
     */
    public boolean remove(String email) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + email);

        boolean response = false;
        try {
            response = db.setData("DELETE FROM AccountInfo WHERE email = ?", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * retrieves all rows from AccountInfo table and translates them to objects
     * of class AccountInfo and stores them in the list
     */
    public void fetchAll() {

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM AccountInfo", null, false);
            for (ArrayList<String> record : row) {
                AccountInfo currentAccount = new AccountInfo();
                currentAccount.setEmail(record.get(0));
                currentAccount.setPassword(record.get(1));
                currentAccount.setRole(record.get(2));
                getList().add(currentAccount);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * inner class of AccountInfoDAO that serves as an object model used for
     * object-oriented manipulation of database data
     */
    class AccountInfo {

        public String email;
        private String password;
        public Role role;

        /**
         *
         */
        public AccountInfo() {
        }

        /**
         * @param email
         * @param password
         * @param role
         */
        public AccountInfo(String email, String password, Role role) {
            this.email = email;
            this.password = password;
            this.role = role;
        }

        /**
         * @return
         */
        public String getEmail() {
            return email;
        }

        /**
         * @param email
         */
        public void setEmail(String email) {
            this.email = email;
        }

        /**
         * @return
         */
        public String getPassword() {
            return password;
        }

        /**
         * @param password
         */
        public void setPassword(String password) {
            this.password = password;
        }

        /**
         * @return
         */
        public Role getRole() {
            return role;
        }

        /**
         * @param role
         */
        public void setRole(Role role) {
            this.role = role;
        }
    }
}