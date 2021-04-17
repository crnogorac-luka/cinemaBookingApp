import java.awt.event.*;

/**
 * class that serves as the access point to the business layer data model
 */


public class Controller {


    // LOGIN SCREEN LISTENERS

    /**
     * loginUser listener
     */
    private class loginUser implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

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
