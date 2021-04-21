import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import com.intellij.uiDesigner.core.*;


public class LoginPage extends JFrame {

    private JTextField email;
    private JPasswordField passwordField;
    private JButton loginBtn;
    private JButton registerBtn;

    public LoginPage() {
        initComponents();
    }


    public JTextField getEmail() {
        return email;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginBtn() {
        return loginBtn;
    }

    public JButton getRegisterBtn() {
        return registerBtn;
    }





    // ATTACH HANDLERS METHODS

    public void attachHandlerLoginBtn(ActionListener al) {
        loginBtn.addActionListener(al);
    }

    public void attachHandlerRegisterBtn(ActionListener al) {
        registerBtn.addActionListener(al);
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Luka Crnogorac
        label1 = new JLabel();
        label2 = new JLabel();
        loginFld = new JTextField();
        passwordFld = new JTextField();
        loginBtn = new JButton();
        label3 = new JLabel();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayoutManager(7, 1, new Insets(0, 0, 0, 0), -1, -1));

        //---- label1 ----
        label1.setText("Cinema Booking App");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 15f));
        label1.setForeground(new Color(102, 204, 255));
        contentPane.add(label1, new GridConstraints(0, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- label2 ----
        label2.setText("Login");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 7f));
        contentPane.add(label2, new GridConstraints(1, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- loginFld ----
        loginFld.setToolTipText("E-mail");
        loginFld.setText("E-mail");
        contentPane.add(loginFld, new GridConstraints(2, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            new Dimension(200, 20), null, null));

        //---- passwordFld ----
        passwordFld.setToolTipText("Password");
        passwordFld.setText("Password");
        contentPane.add(passwordFld, new GridConstraints(3, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            new Dimension(200, 20), null, null));

        //---- loginBtn ----
        loginBtn.setText("Login");
        loginBtn.setBackground(new Color(102, 204, 255));
        contentPane.add(loginBtn, new GridConstraints(4, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- label3 ----
        label3.setText("Don't have an account?");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 7f));
        contentPane.add(label3, new GridConstraints(5, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- button2 ----
        button2.setText("Register");
        button2.setBackground(new Color(102, 204, 255));
        contentPane.add(button2, new GridConstraints(6, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Luka Crnogorac
    private JLabel label1;
    private JLabel label2;
    private JTextField loginFld;
    private JTextField passwordFld;
    private JButton loginBtn;
    private JLabel label3;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
