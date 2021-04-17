import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SeatsScene extends Scene {
    private Scene seatsPage;
    @FXML private TextField seats;
    @FXML private TextField total;
    @FXML private Button reserveTicket;
    @FXML private Button buyTicket;
    public SeatsScene(VBox parent) {
        super(parent);
    }

    public Scene getSeatsPage() {
        return seatsPage;
    }

    public TextField getSeats() {
        return seats;
    }

    public void setSeats(TextField seats) {
        this.seats = seats;
    }

    public TextField getTotal() {
        return total;
    }

    public void setTotal(TextField total) {
        this.total = total;
    }

    public Button getReserveTicket() {
        return reserveTicket;
    }

    public void setReserveTicket(Button reserveTicket) {
        this.reserveTicket = reserveTicket;
    }

    public Button getBuyTicket() {
        return buyTicket;
    }

    public void setBuyTicket(Button buyTicket) {
        this.buyTicket = buyTicket;
    }

    public void setSeatsPage(Scene seatsPage) {
        this.seatsPage = seatsPage;
    }
}
