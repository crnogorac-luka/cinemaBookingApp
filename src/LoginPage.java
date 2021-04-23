import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;




public class LoginPage extends JFrame {

    //    private JTextField loginFld;
//    private JPasswordField passwordFld;
//    private JButton loginBtn;
//    private JButton registerBtn;
//
//    private JLabel label1;
//    private JLabel label2;
//    private JLabel label3;
// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
// Generated using JFormDesigner Evaluation license - Luka Crnogorac
private JLabel title;
private JLabel labelLogin;
private JLabel labelEmail;
private JTextField loginFld;
private JLabel labelPassword;
private JPasswordField passwordFld;
private JButton loginBtn;
private JLabel labelRegister;
private JButton registerBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public LoginPage() {
        initComponents();
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    // GETTERS

    public JTextField getLoginFld() {
        return loginFld;
    }

    public JPasswordField getPasswordField() {
        return passwordFld;
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
        title = new JLabel();
        labelLogin = new JLabel();
        labelEmail = new JLabel();
        loginFld = new JTextField();
        labelPassword = new JLabel();
        passwordFld = new JPasswordField();
        loginBtn = new JButton();
        labelRegister = new JLabel();
        registerBtn = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayoutManager(9, 1, new Insets(0, 0, 0, 0), -1, -1));

        //---- title ----
        title.setText("Cinema Booking App");
        title.setFont(title.getFont().deriveFont(title.getFont().getStyle() | Font.BOLD, title.getFont().getSize() + 15f));
        title.setForeground(new Color(102, 204, 255));
        contentPane.add(title, new GridConstraints(0, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- labelLogin ----
        labelLogin.setText("Login");
        labelLogin.setFont(new Font("Helvetica World", labelLogin.getFont().getStyle() | Font.BOLD, 19));
        contentPane.add(labelLogin, new GridConstraints(1, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- labelEmail ----
        labelEmail.setText("E-mail");
        contentPane.add(labelEmail, new GridConstraints(2, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- loginFld ----
        loginFld.setToolTipText("E-mail");
        contentPane.add(loginFld, new GridConstraints(3, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            new Dimension(200, 20), null, null));

        //---- labelPassword ----
        labelPassword.setText("Password");
        contentPane.add(labelPassword, new GridConstraints(4, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- passwordFld ----
        passwordFld.setToolTipText("Password");
        contentPane.add(passwordFld, new GridConstraints(5, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            new Dimension(200, 20), null, null));

        //---- loginBtn ----
        loginBtn.setText("Login");
        loginBtn.setBackground(new Color(102, 204, 255));
        contentPane.add(loginBtn, new GridConstraints(6, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- labelRegister ----
        labelRegister.setText("Don't have an account?");
        labelRegister.setFont(new Font("Helvetica World", labelRegister.getFont().getStyle() | Font.BOLD, 19));
        contentPane.add(labelRegister, new GridConstraints(7, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //---- registerBtn ----
        registerBtn.setText("Register");
        registerBtn.setBackground(new Color(102, 204, 255));
        contentPane.add(registerBtn, new GridConstraints(8, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


}
