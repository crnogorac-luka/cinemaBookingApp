import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

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
        GoRegister goRegister = new GoRegister();
        SearchID searchID = new SearchID();
        AddSeats addSeats = new AddSeats();
        ReserveRadioButton rrb = new ReserveRadioButton();
        ReserveButton resBtn = new ReserveButton();
        BuyRadioButton brb = new BuyRadioButton();
        RegisterUser registerUser = new RegisterUser();

        this.view.getLoginPage().attachHandlerLoginBtn(loginUser);
        this.view.getSeatsPage().attachHandlerAddSeats(addSeats);
        this.view.getSeatsPage().attachHandlerJRadio(rrb);
        this.view.getSeatsPage().attachHandlerJRadioTwo(brb);
        this.view.getSeatsPage().attachHandlerReserve(resBtn);
        this.view.getHomeCashierPage().researchBtn(searchID);
        this.view.getLoginPage().attachHandlerRegisterBtn(goRegister);
        this.view.getRegisterPage().attachHandlerRegisterButton(registerUser);

    }


    public double calcPrice() {
        double tempPrice = 4.0;

        Projection projection = (Projection) model.getDaoCollection().get("projection").getCurrentItem();
        String startTime = projection.getStartTime();

        Room room = (Room) model.getDaoCollection().get("room").getCurrentItem();
        int for3D = room.getFor3D();

        int startHour = Integer.parseInt(startTime.substring(0, 2));
        if (startHour > 19 || startHour < 2)
            tempPrice += 0.5;
        if (for3D == 1)
            tempPrice += 1.0;

        return tempPrice;

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

            /*((CashierDAO) model.getDaoCollection().get("cashier")).fetch(email, password);
            if(model.getDaoCollection().get("cashier").getCurrentItem() != null) {
                view.getLoginPage().dispose();
                view.getHomeCashierPage().setVisible(true);
            }*/

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
    private class RegisterUser implements ActionListener{
        public int id = 1;
        boolean accountSuccess=false;
        boolean customerSuccess=false;
        @Override
        public void actionPerformed(ActionEvent e) {
            String fName = view.getRegisterPage().getFNameFld().getText();
            String lName = view.getRegisterPage().getLNameFld().getText();
            String phone = String.valueOf(view.getRegisterPage().getPhoneFld().getText());
            String email = view.getRegisterPage().getEmailFld().getText();
            String password = String.valueOf(view.getRegisterPage().getPasswordFld().getPassword());
            accountSuccess = (model.getDaoCollection().get("accountInfo")).create(new AccountInfo(email, password));
            if (accountSuccess) {
                customerSuccess = (model.getDaoCollection().get("customer")).create(new Customer(fName, lName, phone, email));
                if (customerSuccess) {

                    view.getRegisterPage().dispose();
                    view.getLoginPage().setVisible(true);
                }
            }
        }
    }


    private class GoRegister implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getLoginPage().setVisible(false);
            view.getRegisterPage().setVisible(true);
        }
    }


    // HOME USERS LISTENERS

    private class PrevMovie implements ActionListener {

        ArrayList<Movie> movies = ((MovieDAO) model.getDaoCollection().get("movie")).getList();
        ListIterator<Movie> i = movies.listIterator(movies.size());

        Movie newMovie = null;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (i.hasPrevious()) {
                newMovie = i.previous();
                view.getHomeUserPage().getTextField1().setText("Movie " + newMovie.getMovieID());
                view.getHomeUserPage().getTitleFld().setText(newMovie.getTitle());
                view.getHomeUserPage().getGenresFld().setText(newMovie.getGenre());
                if(newMovie.getIs3D())
                    view.getHomeUserPage().getIs3DFld().setText("Yes");
                else
                    view.getHomeUserPage().getIs3DFld().setText("No");
                view.getHomeUserPage().getDurationFld().setText(""+newMovie.getDuration()+" minutes");
                view.getHomeUserPage().getDescriptionArea().setText(newMovie.getDescription());


            }
        }
    }

    /**
     * selectMovie listener
     */
    /*
    private class selectMovie implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {

            if (event.getStateChange() == ItemEvent.SELECTED) {
                String id = event.getItem().toString();

            }

        }
    }
*/

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
     * search listener
     */
    private class SearchID implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int id = Integer.parseInt(view.getHomeCashierPage().getSearchTextField().getText());

            model.getDaoCollection().get("reservation").fetch(id);

            Reservation reservation = (Reservation) model.getDaoCollection().get("reservation").getCurrentItem();

            int projID = reservation.getProjectionID();
            model.getDaoCollection().get("projection").fetch(projID);


            Projection projection = (Projection) model.getDaoCollection().get("projection").getCurrentItem();
            view.getHomeCashierPage().getProjectionInfoArea().append("Start time: " + projection.getStartTime() + " End time: " + projection.getEndTime());


            ProjectionDAO.Projection projection = (ProjectionDAO.Projection) model.getDaoCollection().get("projection").getCurrentItem();
            Projection projection = (Projection) model.getDaoCollection().get("projection").getCurrentItem();
            view.getHomeCashierPage().getProjectionInfoArea().setText("Start time: " + projection.getStartTime() + " End time: " + projection.getEndTime());

            int customerID = reservation.getCustomerID();
            model.getDaoCollection().get("customer").fetch(customerID);
            Customer customer = (Customer) model.getDaoCollection().get("customer").getCurrentItem();

            view.getHomeCashierPage().getReservationInfoArea().setText("Reservation number: " + reservation.getReservationID() + " Customer: " + customer.getFirstName());

            view.getHomeCashierPage().getCustomerInfoArea().setText("Customer: " + customer.getFirstName() + " " + customer.getLastName() + " Phone: " + customer.getPhone() + " Email: ↓ " + customer.getEmail());
            //System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName() + "Phone: " + customer.getPhone() + " Email: ↓" + customer.getEmail());

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
            System.out.println("Add seat clicked.");
            String tickets = (String) view.getSeatsPage().getSeatsList().getSelectedValue();
            view.getSeatsPage().seatColumn = tickets.substring(0,1);
            view.getSeatsPage().seatRow = tickets.substring(1,2);
            view.getSeatsPage().seatCode = Integer.toString(view.getSeatsPage().getSeatsList().getSelectedIndex() + 1);
            if (e.getClickCount() == 1) {
                if (view.getSeatsPage().getTicketsSelected().contains(tickets)) {
                    JOptionPane.showMessageDialog(null, "The seat is already taken.");
                    System.out.println("The seat is already taken");
                } else {
                        view.getSeatsPage().setSeatCode(tickets);
                        view.getSeatsPage().setSeatColumn(view.getSeatsPage().getSeatColumn());
                        view.getSeatsPage().setSeatRow(view.getSeatsPage().getSeatRow());
                        view.getSeatsPage().setSeatCode(view.getSeatsPage().getSeatCode());
                        System.out.println("Seat column: " + view.getSeatsPage().getSeatColumn());
                        System.out.println("Seat row: " + view.getSeatsPage().getSeatRow());
                        System.out.println("Seat code: " + view.getSeatsPage().getSeatCode());
                        view.getSeatsPage().getTicketsSelected().add(tickets);
                        view.getSeatsPage().getTextField1().setText(view.getSeatsPage().getTextField1().getText() + "" + tickets + ",");
                }
            }
        }
    }

    private class ReserveRadioButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.getSeatsPage().getRadioButton2().isSelected() == true) {
                view.getSeatsPage().getButton1().setEnabled(true);
                view.getSeatsPage().getRadioButton3().setSelected(false);
                view.getSeatsPage().getButton2().setEnabled(false);
            } else {
                view.getSeatsPage().getButton1().setEnabled(false);
             }
            }
        }

    private class BuyRadioButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.getSeatsPage().getRadioButton3().isSelected() == true) {
                view.getSeatsPage().getButton2().setEnabled(true);
                view.getSeatsPage().getRadioButton2().setSelected(false);
                view.getSeatsPage().getButton1().setEnabled(false);
            } else {
                view.getSeatsPage().getButton2().setEnabled(false);
            }
        }
    }

    private class ReserveButton implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //for(int i = 1; i <= 6; i++) {
            // int customerId = ((CustomerDAO.Customer) model.getDaoCollection().get("customer").getCurrentItem()).getPersonID();
            // int projectionId = ((ProjectionDAO.Projection) model.getDaoCollection().get("projection").getCurrentItem()).getProjectionID();
            //}

            int customerId = 123;
            int projectionId = 983;
            model.getDaoCollection().get("reservation").create(new Reservation(1, customerId, projectionId, Integer.parseInt(view.getSeatsPage().getSeatCode())));
            System.out.println("Reservation created for the ticket.");
            System.out.println(view.getSeatsPage().getSeatCode());
        }
    }
    }
