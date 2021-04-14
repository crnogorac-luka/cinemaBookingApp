import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class View extends Application{

    private Scene loginPage;
    private Scene homeUserPage;
    private Scene homeCashierPage;
    private Scene seatsPage;
    private FXMLLoader loader;

    public View() {
        loader = new FXMLLoader();

        try {
            loader.setLocation(new URL("file://javafx_files/login.fxml"));
            VBox loginPageBox = loader.<VBox>load();
            loginPage = new Scene(loginPageBox);

            loader.setLocation(new URL("javafx_files/homeUser.fxml"));
            VBox homeUserPageBox = loader.<VBox>load();
            homeUserPage = new Scene(homeUserPageBox);

            loader.setLocation(new URL("javafx_files/homeCashier.fxml"));
            VBox homeCashierPageBox = loader.<VBox>load();
            homeCashierPage = new Scene(homeCashierPageBox);

            loader.setLocation(new URL("javafx_files/seats.fxml"));
            VBox seatsPageBox = loader.<VBox>load();
            seatsPage = new Scene(seatsPageBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(loginPage);
        primaryStage.show();
    }

}
