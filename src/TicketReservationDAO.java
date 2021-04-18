import java.util.ArrayList;

public class TicketReservationDAO implements DAO<TicketReservationDAO.TicketReservation>{


        private DBConnect db;
        private ArrayList<TicketReservation> list;
        private TicketReservation currentTicketReservation;

        /**
         * @param db object that contains database connection protocols
         */
        public TicketReservationDAO(DBConnect db) {
            this.db = db;
        }


        /**
         * @return current list of TicketReservation
         */
        public ArrayList<TicketReservation> getList() {
            return list;
        }

        public TicketReservation getCurrentTicketReservation() {
            return currentTicketReservation;
        }

        public void setCurrentTicketReservation(TicketReservation currentTicketReservation) {
            this.currentTicketReservation = currentTicketReservation;
        }

    @Override
    public TicketReservation getCurrentItem() {
        return currentTicketReservation;
    }

    /**
         * @param id unique ID of the TicketReservation we want to fetch from the table
         * @return object of class Movie
         */
        @Override
        public void fetch(int id) {
            ArrayList<String> values = new ArrayList<String>();
            values.add("" + id);
            TicketReservation fetchedTicketReservation = new TicketReservation();

            try {
                ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM TicketReservation WHERE TicketID = ?", values, false);
                fetchedTicketReservation.setTicketID(Integer.parseInt(row.get(0).get(0)));
                fetchedTicketReservation.setReservationID(Integer.parseInt(row.get(0).get(1)));


                setCurrentTicketReservation(fetchedTicketReservation);
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("The record does not exist.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        /**
         * @param ticketReservation prepared object of class Customer whose attributes are translated to column values of the new row in Ticket table
         * @return true if insertion is successful, false if otherwise
         */
        @Override
        public boolean create(TicketReservation ticketReservation) {
            ArrayList<String> values = new ArrayList<String>();
            values.add("" + ticketReservation.getTicketID());
            values.add("" + ticketReservation.getReservationID());


            boolean response = false;
            try {
                response = db.setData("INSERT INTO TicketReservation VALUES(?,'?')", values);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return response;
        }

        /**
         * @param ticketReservation prepared object of class TicketReservation whose attributes are translated to column values of the existing row with specified ID in TicketReservation table
         * @return true if insertion is successful, false if otherwise
         */
        @Override
        public boolean update(int id, TicketReservation ticketReservation) {
            ArrayList<String> values = new ArrayList<String>();
            values.add("" + ticketReservation.getReservationID());
            values.add("" + ticketReservation.getTicketID());

            values.add("" + id);
            boolean response = false;
            try {
                response = db.setData("UPDATE TicketReservation SET ReservationID = '?' WHERE TicketID = '?'", values);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return response;
        }

        /**
         * @param id unique ID of the ticketReservation we want to delete from the table
         * @return true if insertion is successful, false if otherwise
         */
        @Override
        public boolean remove(int id) {
            ArrayList<String> values = new ArrayList<String>();
            values.add("" + id);

            boolean response = false;
            try {
                response = db.setData("DELETE FROM TicketReservation WHERE TicketID = ?", values);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return response;
        }


        /**
         * retrieves all rows from TicketReservation table and translates them to objects of class TicketReservation and stores them in the list
         */
        @Override
        public void fetchAll() {

            try {
                ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM TicketReservation", null, false);
                for (ArrayList<String> record : row) {
                    TicketReservation currTicketReservation = new TicketReservation();
                    currTicketReservation.setTicketID(Integer.parseInt(record.get(0)));
                    currTicketReservation.setReservationID(Integer.parseInt(record.get(1)));

                    getList().add(currTicketReservation);
                }

            } catch (IndexOutOfBoundsException ex) {
                System.out.println("The record does not exist.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        /**
         * inner class of TicketReservation that serves as an object model used for object-oriented manipulation of database data
         */
         class TicketReservation {
            public int ticketID;
            public int reservationID;

            public TicketReservation() {
            }

            public TicketReservation(int ticketID, int reservationID) {
                this.ticketID = ticketID;
                this.reservationID = reservationID;
            }

            public int getTicketID() {
                return ticketID;
            }

            public void setTicketID(int ticketID) {
                this.ticketID = ticketID;
            }

            public Integer getReservationID() {
                return reservationID;
            }

            public void setReservationID(int reservationID) {
                this.reservationID = reservationID;
            }
        }

}







