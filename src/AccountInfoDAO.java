
import java.util.ArrayList;
import java.util.*;
import java.sql.*;

/**
 * class that represents account info 
 * Authors: Igor, Ante
 */
public class AccountInfoDAO implements DAO<AccountInfo> {

    private DBConnect db;
    private ArrayList<AccountInfo> list;
    private AccountInfo currentAccountInfo;

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

    @Override
    public AccountInfo getCurrentItem() {
        return currentAccountInfo;
    }

    @Override
    public void setCurrentItem(AccountInfo currentItem) {
        currentAccountInfo = currentItem;
    }

    @Override
    public void fetch(int id) {

    }

    /**
     * @param email unique EMAIL of the AccountInfo we want to fetch from the
     *              table
     * @return object of class AccountInfo
     */
    public boolean fetch(String email) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + email);
        AccountInfo fetchedAccount = new AccountInfo();

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM AccountInfo WHERE Email = ?", values, false);
            fetchedAccount.setEmail(row.get(0).get(0));
            fetchedAccount.setPassword(row.get(0).get(1));
            currentAccountInfo = fetchedAccount;
            return true;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @param accountInfo prepared object of class AccountInfo whose attributes
     *                    are translated to column values of the new row in AccountInfo table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean create(AccountInfo accountInfo) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + accountInfo.getEmail());
        values.add(accountInfo.getPassword());

        //boolean response = false;
        try {
            db.setData("INSERT INTO AccountInfo (Email, Password) VALUES(?,MD5(?))", values);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(int id, AccountInfo item) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    /**
     * @param accountInfo prepared object of class AccountInfo whose attributes
     *                    are translated to column values of the existing row with specified ID in
     *                    AccountInfo table
     * @return true if insertion is successful, false if otherwise
     */
    public boolean update(String email, AccountInfo accountInfo) {
        ArrayList<String> values = new ArrayList<String>();
        values.add(accountInfo.getPassword());
        values.add(email);

        boolean response = false;
        try {
            response = db.setData("UPDATE AccountInfo SET Password = '?' WHERE Email = '?'", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param email unique ID of the AccountInfo we want to delete from the table
     * @return true if insertion is successful, false if otherwise
     */
    public boolean remove(String email) {
        ArrayList<String> values = new ArrayList<String>();
        values.add(email);

        boolean response = false;
        try {
            response = db.setData("DELETE FROM AccountInfo WHERE Email = ?", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * retrieves all rows from AccountInfo table and translates them to objects
     * of class AccountInfo and stores them in the list
     */
    @Override
    public void fetchAll() {

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM AccountInfo", null, false);
            for (ArrayList<String> record : row) {
                AccountInfo currentAccount = new AccountInfo();
                currentAccount.setEmail(record.get(0));
                currentAccount.setPassword(record.get(1));
                getList().add(currentAccount);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
