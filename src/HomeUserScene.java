import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class HomeUserScene extends Scene {
    private Scene homeUserPage;
    @FXML private ComboBox pickMovie;
    @FXML private ComboBox availableRoom;
    @FXML private ComboBox timeSlot;
    @FXML private TextField price;
    @FXML private TextField title;
    @FXML private TextField genres;
    @FXML private TextField duration;
    @FXML private TextField yesOrNo3d;
    @FXML private TextArea description;
    @FXML private Button proceed;

    public HomeUserScene(VBox parent) {
        super(parent);
    }

    public Scene getHomeUserPage() {
        return homeUserPage;
    }

    public void setHomeUserPage(Scene homeUserPage) {
        this.homeUserPage = homeUserPage;
    }

    public ComboBox getPickMovie() {
        return pickMovie;
    }

    public void setPickMovie(ComboBox pickMovie) {
        this.pickMovie = pickMovie;
    }

    public ComboBox getAvailableRoom() {
        return availableRoom;
    }

    public void setAvailableRoom(ComboBox availableRoom) {
        this.availableRoom = availableRoom;
    }

    public ComboBox getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(ComboBox timeSlot) {
        this.timeSlot = timeSlot;
    }

    public TextField getPrice() {
        return price;
    }

    public void setPrice(TextField price) {
        this.price = price;
    }

    public TextField getTitle() {
        return title;
    }

    public void setTitle(TextField title) {
        this.title = title;
    }

    public TextField getGenres() {
        return genres;
    }

    public void setGenres(TextField genres) {
        this.genres = genres;
    }

    public TextField getDuration() {
        return duration;
    }

    public void setDuration(TextField duration) {
        this.duration = duration;
    }

    public TextField getYesOrNo3d() {
        return yesOrNo3d;
    }

    public void setYesOrNo3d(TextField yesOrNo3d) {
        this.yesOrNo3d = yesOrNo3d;
    }

    public TextArea getDescription() {
        return description;
    }

    public void setDescription(TextArea description) {
        this.description = description;
    }

    public Button getProceed() {
        return proceed;
    }

    public void setProceed(Button proceed) {
        this.proceed = proceed;
    }
}
