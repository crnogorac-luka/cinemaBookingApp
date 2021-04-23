import java.awt.event.*;

/**
 * class that serves as the access point to the business layer data model
 */


public class Controller {

    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        LoginUser loginUser = new LoginUser();

        this.view.getLoginPage().attachHandlerLoginBtn(loginUser);

    }

    // LOGIN SCREEN LISTENERS

    /**
     * loginUser listener
     */
    private class LoginUser implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String email = view.getLoginPage().getLoginFld().getText();
            String password = String.valueOf(view.getLoginPage().getPasswordField().getPassword());
            ((CustomerDAO) model.getDaoCollection().get("customer")).fetch(email, password);

            if (model.getDaoCollection().get("customer").getCurrentItem() != null) {
                view.getLoginPage().dispose();
                view.getHomeUserPage().setVisible(true);
            } else {
                ((CashierDAO) model.getDaoCollection().get("cashier")).fetch(email, password);

                if (model.getDaoCollection().get("cashier").getCurrentItem() != null) {
                    view.getLoginPage().dispose();
                    view.getHomeCashierPage().setVisible(true);
                }
            }
            //System.out.println(((CustomerDAO.Customer) model.getDaoCollection().get("customer").getCurrentItem()).getFirstName());
        }
    }

    /**
     * registerUser listener
     */
    private class registerUser implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    // HOME USERS LISTENERS

    /**
     * selectMovie listener
     */
    private class selectMovie implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {

            if (event.getStateChange() == ItemEvent.SELECTED) {
                String id = event.getItem().toString();

            }

        }
    }

    /**
     * selectRoom listener
     */
    private class selectRoom implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {

            if (event.getStateChange() == ItemEvent.SELECTED) {
                String id = event.getItem().toString();

            }

        }
    }

    /**
     * selectTime listener
     */
    private class selectTime implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {

            if (event.getStateChange() == ItemEvent.SELECTED) {
                String id = event.getItem().toString();

            }

        }
    }

    /**
     * confirmSelection listener
     */
    private class confirmSelection implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    // SEATS USER LISTENERS

    /**
     * board selection listener
     */
    private class selectBoard implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {

            if (event.getStateChange() == ItemEvent.SELECTED) {
                String id = event.getItem().toString();

            }

        }
    }

    /**
     * buyTickets listener
     */
//    private class buyTickets implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//        }
//    }


    // HOME CASHIER LISTENERS

    /**
     * bookedProjection listener
     */
    private class bookedProjection implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {

            if (event.getStateChange() == ItemEvent.SELECTED) {
                String id = event.getItem().toString();

            }

        }
    }

    /**
     * sellTickets listener
     */
    private class sellTickets implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    // PAYMENT INFO LISTENER

    /**
     * buyTickets listener
     */
    private class AddSeats extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            //view.getSeatsPage().getSeatsList().list1_itemClicked(e);
            //view.getSeatsPage().getSeatsList().list1_mouseClicked(e);
            System.out.println("Clicked.");
            String tickets = (String) view.getSeatsPage().getSeatsList().getSelectedValue();
            if (e.getClickCount() == 1) {
                if (view.getSeatsPage().getTicketsSelected().contains(tickets)) {
                    JOptionPane.showMessageDialog(null, "The seat is already taken.");
                    System.out.println("The seat is already taken");
                } else {
                    for(int i = 1; i <= 6; i++) {
                        int seatCode = Integer.parseInt(view.getSeatsPage().getSeatsList().getSelectedValue().split("-")[1]);
                        view.getSeatsPage().getTicketsSelected().add(tickets);
                        view.getSeatsPage().getTextField1().setText(view.getSeatsPage().getTextField1().getText() + "" + tickets + ",");
                        System.out.println(view.getSeatsPage().getTicketsSelected());
                        view.getSeatsPage().getTextField2().setText("1");

                       // int customerId = ((CustomerDAO.Customer) model.getDaoCollection().get("customer").getCurrentItem()).getPersonID();
                       // int projectionId = ((ProjectionDAO.Projection) model.getDaoCollection().get("projection").getCurrentItem()).getProjectionID();
                        int customerId = 5;
                        int projectionId = 30;
                        model.getDaoCollection().get("reservation").create(new Reservation(1, customerId, projectionId, seatCode));
                    }
                }
            }
        }
    }
}
