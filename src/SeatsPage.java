import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SeatsPage extends JFrame {

    private JTextField seatsFld;
    private JTextField totalFld;
    private JButton reserveTicketBtn;
    private JButton buyTicketBtn;
    ArrayList<String> ticketsSelected = new ArrayList<String>();

    public SeatsPage() {
        initComponents();
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
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

    public JList<String> getSeatsList() {return list1;}

    public JTextField getTextField1() {return textField1;}
    public JTextField getTextField2() {return textField2;}

    public ArrayList<String> getTicketsSelected() {return ticketsSelected;}

    public void attachHandlerAddSeats(MouseAdapter ma) {
        list1.addMouseListener(ma);
    }

    private void btn_reserveTickets(ActionEvent e) {
        if(e.getActionCommand().equals("Reserve tickets")) {
            String tickets = (String) list1.getSelectedValue();
            textField1.setText(textField1.getText() + "" + tickets + ",");
            System.out.println("Working seats...");
        }
    }

    private void list1_itemClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void list1_mouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Luka Crnogorac
        tabbedPane2 = new JTabbedPane();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        label1 = new JLabel();
        panel8 = new JPanel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        panel9 = new JPanel();
        button3 = new JButton();
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        textField1.setEditable(false);
        textField2.setEditable(false);

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

        //======== tabbedPane2 ========
        {

            //======== panel4 ========
            {
                panel4.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder ( 0
                , 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM
                , new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,
                panel4. getBorder () ) ); panel4. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
                ) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
                panel4.setLayout(new GridLayout(2, 0));

                //======== panel5 ========
                {
                    panel5.setLayout(new GridLayout(1, 2));

                    //======== panel6 ========
                    {
                        panel6.setLayout(new GridLayout());

                        //======== panel7 ========
                        {
                            panel7.setLayout(new GridLayout());

                            //---- label1 ----
                            label1.setText("Pick seat(s)");
                            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 10f));
                            label1.setForeground(new Color(102, 204, 255));
                            label1.setHorizontalAlignment(SwingConstants.CENTER);
                            label1.setVerticalAlignment(SwingConstants.TOP);
                            panel7.add(label1);

                            //======== panel8 ========
                            {
                                panel8.setLayout(new GridLayout(3, 3));

                                //---- label2 ----
                                label2.setText("Seats");
                                label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 6f));
                                label2.setHorizontalAlignment(SwingConstants.RIGHT);
                                panel8.add(label2);
                                panel8.add(textField1);

                                //---- label3 ----
                                label3.setText("Total");
                                label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 6f));
                                label3.setHorizontalAlignment(SwingConstants.RIGHT);
                                panel8.add(label3);
                                panel8.add(textField2);

                                //---- button1 ----
                                button1.setText("Reserve tickets");
                                button1.addActionListener(e -> btn_reserveTickets(e));
                                panel8.add(button1);

                                //---- button2 ----
                                button2.setText("Proceed");
                                panel8.add(button2);
                            }
                            panel7.add(panel8);
                        }
                        panel6.add(panel7);
                    }
                    panel5.add(panel6);
                }
                panel4.add(panel5);

                //======== panel9 ========
                {
                    panel9.setLayout(new GridLayout(1, 2));

                    //---- button3 ----
                    button3.setIcon(new ImageIcon("C:\\Users\\Korisnik\\IdeaProjects\\githubapps\\imgnew.png"));
                    panel9.add(button3);
                }
                panel4.add(panel9);
            }
            tabbedPane2.addTab("Reservation", panel4);

            //======== scrollPane1 ========
            {

                //---- list1 ----
                list1.setModel(new AbstractListModel<String>() {
                    String[] values = {
                        "A1-1",
                        "A2-2",
                        "A3-3",
                        "A4-4",
                        "A5-5",
                        "B1-6",
                        "B2-7",
                        "B3-8",
                        "B4-9",
                        "B5-10",
                        "C1-11",
                        "C2-12",
                        "C3-13",
                        "C4-14",
                        "C5-15",
                        "D1-16",
                        "D2-17",
                        "D3-18",
                        "D4-19",
                        "D5-20",
                        "E1-21",
                        "E2-22",
                        "E3-23",
                        "E4-24",
                        "E5-25"
                    };
                    @Override
                    public int getSize() { return values.length; }
                    @Override
                    public String getElementAt(int i) { return values[i]; }
                });
                scrollPane1.setViewportView(list1);
            }
            tabbedPane2.addTab("Seats", scrollPane1);
        }
        contentPane.add(tabbedPane2);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Luka Crnogorac
    private JTabbedPane tabbedPane2;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JLabel label1;
    private JPanel panel8;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JPanel panel9;
    private JButton button3;
    private JScrollPane scrollPane1;
    private JList<String> list1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
