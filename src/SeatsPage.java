import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import com.intellij.uiDesigner.core.*;
import info.clearthought.layout.*;
import net.miginfocom.swing.*;

public class SeatsPage extends JFrame {

    private JTextField seatsFld;
    private JTextField totalFld;
    private JButton reserveTicketBtn;
    private JButton buyTicketBtn;

    public SeatsPage() {
        initComponents();
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
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

    private void btn_reserveTickets(ActionEvent e) {
        if(e.getActionCommand().equals("Reserve ticket(s)")) {
            int index = list1.getSelectedIndex();
            System.out.println("Index selected " + index);
            String selectedSeats = String.valueOf(list1.getSelectedIndex());
            textField1.setText(selectedSeats);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Luka Crnogorac
        panel1 = new JPanel();
        label1 = new JLabel();
        panel3 = new JPanel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        button2 = new JButton();
        button1 = new JButton();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        panel4 = new JPanel();
        button3 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2, 0));

        //======== panel1 ========
        {
            panel1.setMaximumSize(new Dimension(32767, 32601));
            panel1.setMinimumSize(new Dimension(175, 15));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
                    border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER
                    , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font
                    .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (
                new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order"
                        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
            panel1.setLayout(new GridLayout());

            //---- label1 ----
            label1.setText("Select seat(s)");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 15f));
            label1.setForeground(new Color(102, 204, 255));
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setVerticalAlignment(SwingConstants.TOP);
            panel1.add(label1);

            //======== panel3 ========
            {
                panel3.setLayout(new GridLayout(4, 0));

                //---- label2 ----
                label2.setText("Seats");
                label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 6f));
                label2.setHorizontalAlignment(SwingConstants.RIGHT);
                panel3.add(label2);
                panel3.add(textField1);

                //---- label3 ----
                label3.setText("Total");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 6f));
                label3.setHorizontalAlignment(SwingConstants.RIGHT);
                panel3.add(label3);
                panel3.add(textField2);

                //---- button2 ----
                button2.setText("Reserve ticket(s)");
                button2.addActionListener(e -> btn_reserveTickets(e));
                panel3.add(button2);

                //---- button1 ----
                button1.setText("Buy ticket(s)");
                panel3.add(button1);
            }
            panel1.add(panel3);
        }
        contentPane.add(panel1);

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayout(1, 2));

            //======== scrollPane1 ========
            {

                //---- list1 ----
                list1.setModel(new AbstractListModel<String>() {
                    String[] values = {
                            "A1",
                            "A2",
                            "A3",
                            "A4",
                            "A5",
                            "B1",
                            "B2",
                            "B3",
                            "B4",
                            "B5"
                    };
                    @Override
                    public int getSize() { return values.length; }
                    @Override
                    public String getElementAt(int i) { return values[i]; }
                });
                scrollPane1.setViewportView(list1);
            }
            panel2.add(scrollPane1);

            //======== panel4 ========
            {
                panel4.setLayout(new GridLayout());

                //---- button3 ----
                button3.setIcon(new ImageIcon("C:\\Users\\Korisnik\\Desktop\\imgnew.png"));
                panel4.add(button3);
            }
            panel2.add(panel4);
        }
        contentPane.add(panel2);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Luka Crnogorac
    private JPanel panel1;
    private JLabel label1;
    private JPanel panel3;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    private JButton button2;
    private JButton button1;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JList<String> list1;
    private JPanel panel4;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}