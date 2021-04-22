import java.sql.*;
import java.util.ArrayList;
import java.sql.DriverManager;

public class DBConnect {
    private String userName;
    private String password;
    private String mySQL;
    private Connection connection;

    private DBException dbException;

    public DBConnect() {
        userName = "";
        password = "";
        mySQL = "";
        connection = null;
        dbException = null;
    }

    public DBConnect(String userName, String password, String mySQL) {
        this.userName = userName;
        this.password = password;
        this.mySQL = mySQL;
    }

    // GETTERS

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getMySQL() {
        return mySQL;
    }

    public Connection getConnection() {
        return connection;
    }


    //SETTERS

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMySQL(String mySQL) {
        this.mySQL = mySQL;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }




    // OPENING connection

    public boolean connect(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://freedb.tech:3306/"+ mySQL,userName,password);
            return true;
        } catch (SQLException e) {
            dbException = new DBException(e, "Opening the connection failed");
            dbException.log();
        }
        return false;
    }

    // CLOSING connection

    public boolean close(){
        try {
            connection.close();
        } catch (SQLException e) {
            dbException = new DBException(e, "Closing the connection failed");
            dbException.log();
        }
        return true;
    }



    // PREPARE statement
    public PreparedStatement prepare(String query, ArrayList<String> values) {
        PreparedStatement statement = null;
        int placeholderCount = 0;
        try {
            if (connect()) {
                statement = connection.prepareStatement(query);
                String query2 = query;
                placeholderCount = query2.length() - query2.replace("?", "").length();
                for (int i=0; i<placeholderCount; i++) {
                    statement.setString(i+1, values.get(i));
                }
            }
        } catch (Exception e) {
            //System.out.println("Error occurred...");
            dbException = new DBException(e, "Preparing the statement failed");
            dbException.log();
        }

        return statement;
    }



    // ---- ---- ----- CRUD OPERATIONS  -- --- ------ - --- - -- ---

    // READ
    public ArrayList<ArrayList<String>> getData(String query, ArrayList<String> values, boolean hasHeader) {

        ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();

        try {
            if (connect()) {
                PreparedStatement stmt = prepare(query, values);
                ResultSet rs = stmt.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();

                if (hasHeader) {
                    ArrayList<String> header = new ArrayList<String>();

                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        String columnName = rsmd.getColumnName(i);
                        header.add(columnName);
                    }
                    table.add(header);
                }

                while (rs.next()) {
                    ArrayList<String> currRow = new ArrayList<String>();
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        currRow.add(rs.getString(i));
                    }
                    table.add(currRow);
                }

            }
        } catch (Exception e) {
            dbException = new DBException(e, "Data retrieval failed");
            dbException.log();
        } finally {
            close();
        }

        return table;
    }

    // CREATE, UPDATE, DELETE
    public boolean setData(String query, ArrayList<String> values) {
        try {
            if (connect()) {
                PreparedStatement stmt = prepare(query, values);
                int numRes = stmt.executeUpdate();
                if (numRes == 0) return false;
            }

        } catch (SQLException e) {
            dbException = new DBException(e, "Manipulating the data failed");
            dbException.log();
        } finally {
            close();
        }

        return true;

    }





    // TRANSACTIONS

    public void startTrans() {
        try {
            if (connect()) {
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            }
        } catch(SQLException e) {
            rollbackTrans();
            dbException = new DBException(e, "Starting the transaction failed");
            dbException.log();
        }
    }



    public void endTrans() {
        try {
            if (connection != null) {
                connection.setAutoCommit(true);
            }
        } catch(SQLException e) {
            rollbackTrans();
            dbException = new DBException(e, "Ending the transaction failed");
            dbException.log();
        }
    }




    public void rollbackTrans() {
        try {
            if (connection != null) {
                connection.rollback();
            }
        } catch(SQLException e) {
            dbException = new DBException(e, "Rolling back the transaction failed");
            dbException.log();
        } finally {
            close();
        }
    }
}
