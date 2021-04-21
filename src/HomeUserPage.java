
import java.awt.*;
import javax.swing.*;
import com.intellij.uiDesigner.core.*;

public class HomeUserPage extends JFrame {

//    private JComboBox selectMovieBox;
//    private JComboBox selectRoomBox;
//    private JComboBox selectTimeBox;
//    private JTextField priceFld;
//    private JTextField titleFld;
//    private JTextField genresFld;
//    private JTextField durationFld;
//    private JTextField is3DFld;
//    private JTextArea descriptionArea;
//    private JButton proceedBtn;

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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        label2 = new JLabel();
        label11 = new JLabel();
        selectMovieBox = new JComboBox();
        titleFld = new JTextField();
        label3 = new JLabel();
        label7 = new JLabel();
        selectRoomBox = new JComboBox();
        genresFld = new JTextField();
        label4 = new JLabel();
        label8 = new JLabel();
        selectTimeBox = new JComboBox();
        durationFld = new JTextField();
        label5 = new JLabel();
        label9 = new JLabel();
        priceFld = new JTextField();
        is3DFld = new JTextField();
        label10 = new JLabel();
        proceedBtn = new JButton();
        scrollPane1 = new JScrollPane();
        descriptionArea = new JTextArea();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayoutManager(12, 5, new Insets(0, 0, 0, 0), -1, -1));

        //---- label1 ----
        label1.setText("Select a movie");
        label1.setForeground(new Color(102, 204, 255));
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 15f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1, new GridConstraints(0, 0, 1, 5,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- label2 ----
        label2.setText("Pick a movie");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 6f));
        contentPane.add(label2, new GridConstraints(1, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- label11 ----
        label11.setText("Title");
        label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 6f));
        contentPane.add(label11, new GridConstraints(1, 2, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- selectMovieBox ----
        selectMovieBox.setFont(selectMovieBox.getFont().deriveFont(selectMovieBox.getFont().getSize() + 6f));
        contentPane.add(selectMovieBox, new GridConstraints(2, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- titleFld ----
        titleFld.setFont(titleFld.getFont().deriveFont(titleFld.getFont().getSize() + 6f));
        contentPane.add(titleFld, new GridConstraints(2, 2, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            new Dimension(200, 30), null, null));

        //---- label3 ----
        label3.setText("Select available room");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 6f));
        contentPane.add(label3, new GridConstraints(3, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- label7 ----
        label7.setText("Genres");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 6f));
        contentPane.add(label7, new GridConstraints(3, 2, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- selectRoomBox ----
        selectRoomBox.setFont(selectRoomBox.getFont().deriveFont(selectRoomBox.getFont().getSize() + 6f));
        contentPane.add(selectRoomBox, new GridConstraints(4, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- genresFld ----
        genresFld.setFont(genresFld.getFont().deriveFont(genresFld.getFont().getSize() + 6f));
        contentPane.add(genresFld, new GridConstraints(4, 2, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            new Dimension(200, 30), null, null));

        //---- label4 ----
        label4.setText("Select time slot");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 6f));
        contentPane.add(label4, new GridConstraints(5, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- label8 ----
        label8.setText("Duration");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 6f));
        contentPane.add(label8, new GridConstraints(5, 2, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- selectTimeBox ----
        selectTimeBox.setFont(selectTimeBox.getFont().deriveFont(selectTimeBox.getFont().getSize() + 6f));
        contentPane.add(selectTimeBox, new GridConstraints(6, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- durationFld ----
        durationFld.setFont(durationFld.getFont().deriveFont(durationFld.getFont().getSize() + 6f));
        contentPane.add(durationFld, new GridConstraints(6, 2, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            new Dimension(200, 30), null, null));

        //---- label5 ----
        label5.setText("Price");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 6f));
        contentPane.add(label5, new GridConstraints(7, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- label9 ----
        label9.setText("3D (yes/no)");
        label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 6f));
        contentPane.add(label9, new GridConstraints(7, 2, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- priceFld ----
        priceFld.setFont(priceFld.getFont().deriveFont(priceFld.getFont().getSize() + 6f));
        contentPane.add(priceFld, new GridConstraints(8, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            new Dimension(200, 30), null, null));

        //---- is3DFld ----
        is3DFld.setFont(is3DFld.getFont().deriveFont(is3DFld.getFont().getSize() + 6f));
        contentPane.add(is3DFld, new GridConstraints(8, 2, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            new Dimension(200, 30), null, null));

        //---- label10 ----
        label10.setText("Description");
        label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 6f));
        contentPane.add(label10, new GridConstraints(9, 2, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- proceedBtn ----
        proceedBtn.setText("Proceed to selecting seat(s)");
        proceedBtn.setFont(proceedBtn.getFont().deriveFont(proceedBtn.getFont().getSize() + 6f));
        proceedBtn.setBackground(new Color(102, 204, 255));
        contentPane.add(proceedBtn, new GridConstraints(10, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(descriptionArea);
        }
        contentPane.add(scrollPane1, new GridConstraints(10, 2, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            new Dimension(250, 200), null, null));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JLabel label2;
    private JLabel label11;
    private JComboBox selectMovieBox;
    private JTextField titleFld;
    private JLabel label3;
    private JLabel label7;
    private JComboBox selectRoomBox;
    private JTextField genresFld;
    private JLabel label4;
    private JLabel label8;
    private JComboBox selectTimeBox;
    private JTextField durationFld;
    private JLabel label5;
    private JLabel label9;
    private JTextField priceFld;
    private JTextField is3DFld;
    private JLabel label10;
    private JButton proceedBtn;
    private JScrollPane scrollPane1;
    private JTextArea descriptionArea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
