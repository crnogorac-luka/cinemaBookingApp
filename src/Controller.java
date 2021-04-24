import javax.swing.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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


        this.model.getDaoCollection().get("movie").fetchAll();

        LoginUser loginUser = new LoginUser();
        GoRegister goRegister = new GoRegister();
        SearchID searchID = new SearchID();
        SellTickets sellTickets = new SellTickets();
        AddSeats addSeats = new AddSeats();
        ReserveRadioButton rrb = new ReserveRadioButton();
        ReserveButton resBtn = new ReserveButton();
        BuyTicketButton btb = new BuyTicketButton();
        BuyRadioButton brb = new BuyRadioButton();
        RegisterUser registerUser = new RegisterUser();
        ChangeMovie changeMoviePrev = new ChangeMovie(false);
        ChangeMovie changeMovieNext = new ChangeMovie(true);
        SelectDate selectDate = new SelectDate();
        SelectTime selectTime = new SelectTime();
        ProceedProjection proceedProjection = new ProceedProjection();

        this.view.getLoginPage().attachHandlerLoginBtn(loginUser);
        this.view.getSeatsPage().attachHandlerAddSeats(addSeats);
        this.view.getSeatsPage().attachHandlerJRadio(rrb);
        this.view.getSeatsPage().attachHandlerJRadioTwo(brb);
        this.view.getSeatsPage().attachHandlerReserve(resBtn);
        this.view.getHomeCashierPage().searchBtn(searchID);
        this.view.getHomeCashierPage().sellTicketsBtn(sellTickets);
        //this.view.getSeatsPage().attachHandlerBuyTicket(btb);
        //this.view.getHomeCashierPage().researchBtn(searchID);
        this.view.getLoginPage().attachHandlerRegisterBtn(goRegister);
        this.view.getRegisterPage().attachHandlerRegisterButton(registerUser);
        this.view.getHomeUserPage().attachHandlerPrevBtn(changeMoviePrev);
        this.view.getHomeUserPage().attachHandlerNextBtn(changeMovieNext);
        this.view.getHomeUserPage().attachHandlerSelectDateBox(selectDate);
        this.view.getHomeUserPage().attachHandlerSelectTimeBox(selectTime);
        this.view.getHomeUserPage().attachHandlerProceedBtn(proceedProjection);

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

    private class ChangeMovie implements ActionListener {

        ArrayList<Movie> movies;
        Movie newMovie;
        boolean prevOrNext;
        int currIndex;

        ChangeMovie(boolean prevOrNext) {
            this.prevOrNext = prevOrNext;
            movies = ((MovieDAO) model.getDaoCollection().get("movie")).getList();
            newMovie = movies.get(0);
            currIndex = 0;

            setAnother();
            System.out.println(movies.size());

        }

        private void setAnother() {
            model.getDaoCollection().get("movie").setCurrentItem(newMovie);
            view.getHomeUserPage().getTextField1().setText("Movie " + newMovie.getMovieID());
            view.getHomeUserPage().getTitleFld().setText(newMovie.getTitle());
            view.getHomeUserPage().getGenresFld().setText(newMovie.getGenre());
            if (newMovie.getIs3D())
                view.getHomeUserPage().getIs3DFld().setText("Yes");
            else
                view.getHomeUserPage().getIs3DFld().setText("No");
            view.getHomeUserPage().getDurationFld().setText("" + newMovie.getDuration() + " minutes");
            view.getHomeUserPage().getDescriptionArea().setText(newMovie.getDescription());

            // Setting Date options by selected movie
            ArrayList<String> dates = ((ProjectionDAO) model.getDaoCollection().get("projection")).fetchAvailableDates(newMovie.getMovieID());
            view.getHomeUserPage().getSelectDateBox().setModel(new DefaultComboBoxModel<>(dates.toArray()));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Movie currMovie = (Movie) model.getDaoCollection().get("movie").getCurrentItem();
            System.out.println(movies.indexOf(currMovie));

            if(prevOrNext) {
                if(movies.indexOf(currMovie)+1 < movies.size()) {
                    if(movies.indexOf(currMovie)+1 == movies.size()-1) {
                        view.getHomeUserPage().getNextBtn().setEnabled(false);
                        view.getHomeUserPage().getPrevBtn().setEnabled(true);
                    } else {
                        view.getHomeUserPage().getNextBtn().setEnabled(true);
                        view.getHomeUserPage().getPrevBtn().setEnabled(true);
                    }
                    newMovie = movies.get(movies.indexOf(currMovie)+1);
                    setAnother();
                }
            } else {
                if( movies.indexOf(currMovie)-1 > -1) {
                    if(movies.indexOf(currMovie)-1 == 0) {
                        view.getHomeUserPage().getPrevBtn().setEnabled(false);
                        view.getHomeUserPage().getNextBtn().setEnabled(true);
                    } else {
                        view.getHomeUserPage().getPrevBtn().setEnabled(true);
                        view.getHomeUserPage().getNextBtn().setEnabled(true);
                    }
                    newMovie = movies.get(movies.indexOf(currMovie)-1);
                    setAnother();
                }
            }

        }
    }


    private class SelectDate implements ItemListener {

        int movieID = ((Movie) model.getDaoCollection().get("movie").getCurrentItem()).getMovieID();


        @Override
        public void itemStateChanged(ItemEvent event) {

            if (event.getStateChange() == ItemEvent.SELECTED) {
                String date = event.getItem().toString();

                ArrayList<String> times = ((ProjectionDAO)model.getDaoCollection().get("projection")).fetchAvailableTimes(movieID, date);
                System.out.println(times.toString());
                view.getHomeUserPage().getSelectTimeBox().setModel(new DefaultComboBoxModel<>(times.toArray()));
            }

        }
    }

    private class SelectTime implements ItemListener {

        int movieID = ((Movie) model.getDaoCollection().get("movie").getCurrentItem()).getMovieID();
        String date = view.getHomeUserPage().getSelectDateBox().getItemAt(0).toString();

        @Override
        public void itemStateChanged(ItemEvent event) {

            if (event.getStateChange() == ItemEvent.SELECTED) {
                String time = event.getItem().toString();

                movieID = ((Movie) model.getDaoCollection().get("movie").getCurrentItem()).getMovieID();
                date = view.getHomeUserPage().getSelectDateBox().getSelectedItem().toString();
                System.out.println(date);
                ArrayList<String> rooms = ((ProjectionDAO)model.getDaoCollection().get("projection")).fetchAvailableRooms(movieID, date, time);

                view.getHomeUserPage().getSelectRoomBox().setModel(new DefaultComboBoxModel<>(rooms.toArray()));
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


    /**
     * confirmSelection listener
     */
    private class ProceedProjection implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int movieId = ((Movie)model.getDaoCollection().get("movie").getCurrentItem()).getMovieID();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date = view.getHomeUserPage().getSelectDateBox().getSelectedItem().toString();
            String startTime = view.getHomeUserPage().getSelectTimeBox().getSelectedItem().toString();
            String idString = view.getHomeUserPage().getSelectRoomBox().getSelectedItem().toString();
            int roomID = -1;

            if (date == null || startTime.equals("") || idString.equals("")) {
                System.out.println("Please enter all data.");
            } else {
                roomID = Integer.parseInt(idString);

                ((ProjectionDAO)model.getDaoCollection().get("projection")).fetchProjectionByColumns(movieId, date, startTime, roomID);
                view.getHomeUserPage().setVisible(false);
                view.getSeatsPage().setVisible(true);
            }

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

            Reservation reservation = null;

            int id = Integer.parseInt(view.getHomeCashierPage().getSearchTextField().getText());

            model.getDaoCollection().get("reservation").fetch(id);

            reservation = (Reservation) model.getDaoCollection().get("reservation").getCurrentItem();

            if(reservation != null){


            int projID = reservation.getProjectionID();
            System.out.println(projID);
            model.getDaoCollection().get("projection").fetch(projID);

                Projection projection = (Projection) model.getDaoCollection().get("projection").getCurrentItem();

                view.getHomeCashierPage().getProjectionInfoArea().setText("Start time: " + projection.getStartTime() + " End time: " + projection.getEndTime());

                int customerID = reservation.getCustomerID();
                model.getDaoCollection().get("customer").fetch(customerID);
                Customer customer = (Customer) model.getDaoCollection().get("customer").getCurrentItem();

                view.getHomeCashierPage().getReservationInfoArea().setText("Reservation number: " + reservation.getReservationID() + " Customer: " + customer.getFirstName());
                view.getHomeCashierPage().getCustomerInfoArea().setText("Customer: " + customer.getFirstName() + " " + customer.getLastName() + " Phone: " + customer.getPhone() + " Email: ↓ " + customer.getEmail());
                System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName() + "Phone: " + customer.getPhone() + " Email: " + customer.getEmail());

            }else{
                view.getHomeCashierPage().getProjectionInfoArea().setText("No records detected");
                view.getHomeCashierPage().getReservationInfoArea().setText("No records detected");
                view.getHomeCashierPage().getCustomerInfoArea().setText("No records detected");
            }



        }
    }

    /**
     * sellTickets listener
     */
    private class SellTickets implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Sell tickets clicked.");

            int idForSell = Integer.parseInt(view.getHomeCashierPage().getSearchTextField().getText());

            model.getDaoCollection().get("reservation").fetch(idForSell);
            model.getDaoCollection().get("cashier").fetch(idForSell);
            model.getDaoCollection().get("projection").fetch(idForSell);
            model.getDaoCollection().get("room").fetch(idForSell);

            Reservation reservation = (Reservation) model.getDaoCollection().get("reservation").getCurrentItem();
            Cashier cashier = (Cashier) model.getDaoCollection().get("cashier").getCurrentItem();
            Projection projection = (Projection) model.getDaoCollection().get("projection").getCurrentItem();
            Room room = (Room) model.getDaoCollection().get("room").getCurrentItem();

            model.getDaoCollection().get("ticket").create(new Ticket(reservation.getReservationID(),calcPrice(),cashier.getCashierID()));
            System.out.println("Data inserted: ReservationID: " + reservation.getReservationID() + " Price: " + calcPrice() + " CashierID: " + cashier.getCashierID());
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
                        view.getSeatsPage().getTicketsSelected().add(tickets);

                        // set the price
                    double newPrice = calcPrice();
                    view.getSeatsPage().getTextField2().setText(Double.toString(newPrice));
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
            //}
            if(view.getSeatsPage().getTextField1().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please select seat before reserving ticket.");
            } else {
                int customerId = ((Customer) model.getDaoCollection().get("customer").getCurrentItem()).getPersonID();
                int projectionId = ((Projection) model.getDaoCollection().get("projection").getCurrentItem()).getProjectionID();
                model.getDaoCollection().get("reservation").create(new Reservation(1, customerId, projectionId, Integer.parseInt(view.getSeatsPage().getSeatCode())));
                System.out.println("Reservation created for the ticket.");
                System.out.println(view.getSeatsPage().getSeatCode());
                JOptionPane.showMessageDialog(null, "The reservation is successful.");
            }
        }
    }

    private class BuyTicketButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(view.getSeatsPage().getTextField1().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please select seat before buying ticket.");
            } else {
                Reservation reservation = (Reservation) model.getDaoCollection().get("reservation").getCurrentItem();
                int reservationId = reservation.getReservationID();

                double price = calcPrice();
                model.getDaoCollection().get("ticket").create(new Ticket(reservationId, price, 1));
            }
        }
        }
    }
