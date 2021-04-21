
import javax.swing.*;

public class HomeUserPage extends JFrame {

    private JComboBox selectMovieBox;
    private JComboBox selectRoomBox;
    private JComboBox selectTimeBox;
    private JTextField priceFld;
    private JTextField titleFld;
    private JTextField genresFld;
    private JTextField durationFld;
    private JTextField is3DFld;
    private JTextArea descriptionArea;
    private JButton proceedBtn;

    public HomeUserPage() {

    }

    public JComboBox getSelectMovieBox() {
        return selectMovieBox;
    }

    public JComboBox getSelectRoomBox() {
        return selectRoomBox;
    }

    public JComboBox getSelectTimeBox() {
        return selectTimeBox;
    }

    public JTextField getPriceFld() {
        return priceFld;
    }

    public JTextField getTitleFld() {
        return titleFld;
    }

    public JTextField getGenresFld() {
        return genresFld;
    }

    public JTextField getDurationFld() {
        return durationFld;
    }

    public JTextField getIs3DFld() {
        return is3DFld;
    }

    public JTextArea getDescriptionArea() {
        return descriptionArea;
    }

    public JButton getProceedBtn() {
        return proceedBtn;
    }
}
