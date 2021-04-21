import java.awt.*;
import javax.swing.*;

public class HomeCashierPage extends JFrame {

    private JComboBox selectProjectionsBox;
    private JButton sellTicketsBtn;
    private JTextArea projectionInfoArea;
    private JTextArea reservationInfoArea;
    private JTextArea customerInfoArea;

    public HomeCashierPage() {
        initComponents();
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Luka Crnogorac
        label3 = new JLabel();
        selectProjectionsBox = new JComboBox();
        sellTicketsBtn = new JButton();
        label4 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        scrollPane1 = new JScrollPane();
        projectionInfoArea = new JTextArea();
        scrollPane2 = new JScrollPane();
        reservationInfoArea = new JTextArea();
        scrollPane3 = new JScrollPane();
        customerInfoArea = new JTextArea();
        titleLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- label3 ----
        label3.setText("Booked projections");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));

        //---- selectProjectionsBox ----
        selectProjectionsBox.setFont(selectProjectionsBox.getFont().deriveFont(selectProjectionsBox.getFont().getSize() + 2f));

        //---- sellTicketsBtn ----
        sellTicketsBtn.setText("Sell ticket(s)");
        sellTicketsBtn.setFont(sellTicketsBtn.getFont().deriveFont(sellTicketsBtn.getFont().getSize() + 3f));

        //---- label4 ----
        label4.setText("Projection Info");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));

        //---- label7 ----
        label7.setText("Reservation Info");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 2f));

        //---- label8 ----
        label8.setText("Customer Info");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 2f));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(projectionInfoArea);
        }

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(reservationInfoArea);
        }

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(customerInfoArea);
        }

        //---- titleLabel ----
        titleLabel.setText("ADMINISTRATIV WINDOW");
        titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getSize() + 5f));
        titleLabel.setForeground(new Color(90, 191, 221));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(145, 145, 145)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                    .addGap(102, 102, 102)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(128, 128, 128)
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                    .addGap(179, 179, 179))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(336, 336, 336)
                            .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(197, 197, 197)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label3, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(selectProjectionsBox, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                            .addGap(158, 158, 158)
                            .addComponent(sellTicketsBtn, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                    .addGap(46, 46, 46)
                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(sellTicketsBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addComponent(selectProjectionsBox, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                    .addGap(82, 82, 82)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                        .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                    .addGap(94, 94, 94))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Luka Crnogorac
    private JLabel label3;
    private JComboBox selectProjectionsBox;
    private JButton sellTicketsBtn;
    private JLabel label4;
    private JLabel label7;
    private JLabel label8;
    private JScrollPane scrollPane1;
    private JTextArea projectionInfoArea;
    private JScrollPane scrollPane2;
    private JTextArea reservationInfoArea;
    private JScrollPane scrollPane3;
    private JTextArea customerInfoArea;
    private JLabel titleLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
