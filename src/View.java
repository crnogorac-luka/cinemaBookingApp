import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class View extends Application{

    private Scene loginPage;
    private Scene homeUserPage;
    private Scene seatsPage;
    private Scene homeCashierPage;



    public View() {

        try {
            VBox loginPageBox = FXMLLoader.<VBox>load(getClass().getResource("/javafx_files/login.fxml"));
            loginPage = new Scene(loginPageBox);

            VBox homeUserPageBox = FXMLLoader.<VBox>load(getClass().getResource("/javafx_files/homeUser.fxml"));
            homeUserPage = new Scene(homeUserPageBox);

            VBox seatsPageBox = FXMLLoader.<VBox>load(getClass().getResource("/javafx_files/seats.fxml"));
            seatsPage = new Scene(seatsPageBox);

            VBox homeCashierPageBox = FXMLLoader.<VBox>load(getClass().getResource("/javafx_files/homeCashier.fxml"));
            homeCashierPage = new Scene(homeCashierPageBox);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Scene getLoginPage() {
        return loginPage;
    }

    public Scene getHomeUserPage() {
        return homeUserPage;
    }

    public Scene getSeatsPage() {
        return seatsPage;
    }

    public Scene getHomeCashierPage() {
        return homeCashierPage;
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(loginPage);
        primaryStage.show();
    }

}
