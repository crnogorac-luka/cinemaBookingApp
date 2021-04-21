
import java.awt.*;
import javax.swing.*;

public class SeatsPage extends JFrame {

    private JTextField seatsFld;
    private JTextField totalFld;
    private JButton reserveTicketBtn;
    private JButton buyTicketBtn;

    public SeatsPage() {

    }

    public JTextField getSeatsFld() {
        return seatsFld;
    }

    public JTextField getTotalFld() {
        return totalFld;
    }

    public JButton getReserveTicketBtn() {
        return reserveTicketBtn;
    }

    public JButton getBuyTicketBtn() {
        return buyTicketBtn;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Luka Crnogorac

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(7, 7));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
