import java.awt.event.*;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
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

        //this.view.getLoginPage().attachHandlerLoginBtn(loginUser);

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

                if(model.getDaoCollection().get("cashier").getCurrentItem() != null) {
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
    private class registerUser implements ActionListener{

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
    private class confirmSelection implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    // SEATS USER LISTENERS

    /**
     *  board selection listener
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
     * search listener
     */
    private class searchID implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            int id = Integer.parseInt(view.getHomeCashierPage().getSearchTextField().getText());

            model.getDaoCollection().get("reservation").fetch(id);

            ReservationDAO.Reservation reservation = (ReservationDAO.Reservation) model.getDaoCollection().get("reservation").getCurrentItem();
            view.getHomeCashierPage().getProjectionInfoArea().append(""+reservation.getReservationID());


        }
    }

    /**
     * sellTickets listener
     */
    private class sellTickets implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    // PAYMENT INFO LISTENER

    /**
     * buyTickets listener
     */
    private class buyTickets implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
