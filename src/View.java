import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class View extends Application {

    private LoginScene loginPage;
    private HomeUserScene homeUserPage;
    private SeatsScene seatsPage;
    private HomeUserScene homeCashierPage;


    public View() {

        try {
            VBox loginPageBox = FXMLLoader.load(getClass().getResource("/javafx_files/login.fxml"));
            loginPage = new LoginScene(loginPageBox);

            VBox homeUserPageBox = FXMLLoader.<VBox>load(getClass().getResource("/javafx_files/homeUser.fxml"));
            homeUserPage = new HomeUserScene(homeUserPageBox);

            VBox seatsPageBox = FXMLLoader.<VBox>load(getClass().getResource("/javafx_files/seats.fxml"));
            seatsPage = new SeatsScene(seatsPageBox);

            VBox homeCashierPageBox = FXMLLoader.<VBox>load(getClass().getResource("/javafx_files/homeCashier.fxml"));
            homeCashierPage = new HomeUserScene(homeCashierPageBox);

            launch("");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(loginPage);
        primaryStage.show();
    }

    /*public static void main(String[] args) {
        launch(args);
    }*/

    public LoginScene getLoginPage() {
        return loginPage;
    }

    public HomeUserScene getHomeUserPage() {
        return homeUserPage;
    }

    public SeatsScene getSeatsPage() {
        return seatsPage;
    }

    public HomeUserScene getHomeCashierPage() {
        return homeCashierPage;
    }
}
