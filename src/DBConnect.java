import java.sql.*;

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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ mySQL,userName,password);
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
}
