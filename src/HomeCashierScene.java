import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class HomeCashierScene extends Scene {
    private Scene homeCashierPage;
    @FXML private ComboBox projections;
    @FXML private Button sellTickets;
    @FXML private TextArea projectionInfo;
    @FXML private TextArea reservationInfo;
    @FXML private TextArea customerInfo;

    public HomeCashierScene(VBox parent) {
        super(parent);
    }

    public Scene getHomeCashierPage() {
        return homeCashierPage;
    }

    public ComboBox getProjections() {
        return projections;
    }

    public void setProjections(ComboBox projections) {
        this.projections = projections;
    }

    public Button getSellTickets() {
        return sellTickets;
    }

    public void setSellTickets(Button sellTickets) {
        this.sellTickets = sellTickets;
    }

    public TextArea getProjectionInfo() {
        return projectionInfo;
    }

    public void setProjectionInfo(TextArea projectionInfo) {
        this.projectionInfo = projectionInfo;
    }

    public TextArea getReservationInfo() {
        return reservationInfo;
    }

    public void setReservationInfo(TextArea reservationInfo) {
        this.reservationInfo = reservationInfo;
    }

    public TextArea getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(TextArea customerInfo) {
        this.customerInfo = customerInfo;
    }

    public void setHomeCashierPage(Scene homeCashierPage) {
        this.homeCashierPage = homeCashierPage;
    }
}
