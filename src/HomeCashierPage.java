import javax.swing.*;

public class HomeCashierPage extends JFrame {

    private JComboBox selectProjectionsBox;
    private JButton sellTicketsBtn;
    private JTextArea projectionInfoArea;
    private JTextArea reservationInfoArea;
    private JTextArea customerInfoArea;

    public HomeCashierPage() {

    }

    public JComboBox getSelectProjectionsBox() {
        return selectProjectionsBox;
    }

    public JButton getSellTicketsBtn() {
        return sellTicketsBtn;
    }

    public JTextArea getProjectionInfoArea() {
        return projectionInfoArea;
    }

    public JTextArea getReservationInfoArea() {
        return reservationInfoArea;
    }

    public JTextArea getCustomerInfoArea() {
        return customerInfoArea;
    }
}
