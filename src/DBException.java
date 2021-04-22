import java.sql.*;
import java.io.*;
import java.util.Date;


public class DBException extends Exception{

    private Exception e;
    private String additionalInfo, errorCode, state, errorMessage;


    public DBException(Exception e) {
        this.e = e;
    }

    public DBException(Exception e, String additionalInfo) {
        this.e = e;
        if(e instanceof SQLException) {
            errorCode = ((SQLException)e).getErrorCode() + "";
            state = ((SQLException)e).getSQLState();
        }
        errorMessage = e.getMessage();
        this.additionalInfo = additionalInfo;
    }




    public Exception getE() {
        return e;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getState() {
        return state;
    }

    public String getErrorMessage() {
        return errorMessage;
    }



    public void log() {

        Date date = new Date();
        String timestamp = date.toString();
        String infoMessage = String.format("Exception message: %s\n SQLState: %s\n Error Code: %s\n Additional info: %s\n Error occured at: %s\n", getErrorMessage(), getState(),
                getErrorCode(), getAdditionalInfo(), timestamp);
        BufferedWriter bw = null;

        try{
            File logFile = new File("log.txt");
            FileWriter fw = new FileWriter(logFile, true);
            bw = new BufferedWriter(fw);
            bw.write(infoMessage);
            bw.flush();
            bw.close();

        }catch (IOException e) {
            System.out.println("Writing to a log file failed.");
            e.printStackTrace();
        }

    }
}
