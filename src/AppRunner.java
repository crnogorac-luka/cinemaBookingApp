
import java.util.Scanner;

public class AppRunner {
    public static void main(String[] args) {
        /*DBConnect dbConnect = new DBConnect();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide below details to connect MySQL Database");
        System.out.println("Enter Database");
        dbConnect.setMySQL(scanner.nextLine());
        System.out.println("Enter UserName");
        dbConnect.setUserName(scanner.nextLine());
        System.out.println("Enter Password");
        dbConnect.setPassword(scanner.nextLine());

        boolean connect = dbConnect.connect();
        if(connect){
            System.out.println("Connection successful");
        }
        boolean close = dbConnect.close();
        if(close){
            System.out.println("close successful");
        }*/

        DBConnect dbConnect = new DBConnect();
        dbConnect.setMySQL("freedbtech_CinemaDB");
        dbConnect.setUserName("freedbtech_teamproject");
        dbConnect.setPassword("student");
        Model model = new Model(dbConnect);
        View view = new View();
        new Controller(view, model);


    }
}
