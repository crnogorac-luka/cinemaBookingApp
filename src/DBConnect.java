import java.sql.*;
import java.util.ArrayList;
import java.sql.DriverManager;

public class DBConnect {
    private String userName;
    private String password;
    private String mySQL;
    private Connection connection;

    public DBConnect() {
    }

    public DBConnect(String userName, String password, String mySQL) {
        this.userName = userName;
        this.password = password;
        this.mySQL = mySQL;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMySQL() {
        return mySQL;
    }

    public void setMySQL(String mySQL) {
        this.mySQL = mySQL;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean connect(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://freedb.tech:3306/"+ mySQL,userName,password);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public boolean close(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }





    // CRUD OPERATIONS

    //prepare
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
            e.printStackTrace();
        }

        return statement;
    }



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
            e.printStackTrace();
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
            e.printStackTrace();
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
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }



    public void endTrans() {
        try {
            if (connection != null) {
                connection.setAutoCommit(true);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }




    public void rollbackTrans() {
        try {
            if (connection != null) {
                connection.rollback();
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }
}
