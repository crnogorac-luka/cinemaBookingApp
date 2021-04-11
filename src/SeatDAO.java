import java.util.ArrayList;

/**
 * class that represents one unique seat
 */
public class SeatDAO {

    private DBConnect db;
    private ArrayList<Seat> list;

    /**
     * @param db object that contains database connection protocols
     */
    public SeatDAO(DBConnect db) {
        this.db = db;
    }


    /**
     * @return current list of seats
     */
    public ArrayList<Seat> getList() {
        return list;
    }

    /**
     * @param id unique ID of the seat we want to fetch from the table
     * @return object of class Seat
     */
    public Seat fetch(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);
        Seat fetchedSeat = new Seat();

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Seat WHERE SeatCode = ?", values, false);
            fetchedSeat.setSeatCode(Integer.parseInt(row.get(0).get(0)));
            fetchedSeat.setRow(Integer.parseInt(row.get(0).get(1)));
            fetchedSeat.setColumn(Integer.parseInt(row.get(0).get(2)));

            return fetchedSeat;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * @param seat prepared object of class Seat whose attributes are translated to column values of the new row in Seat table
     * @return true if insertion is successful, false if otherwise
     */
    public boolean create(Seat seat) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + seat.getSeatCode());
        values.add("" + seat.getRow());
        values.add("" + seat.getColumn());

        boolean response = false;
        try {
            response = db.setData("INSERT INTO Seat VALUES(?,?,?)", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param seat prepared object of class Seat whose attributes are translated to column values of the existing row with specified ID in Seat table
     * @return true if insertion is successful, false if otherwise
     */
    public boolean update(Seat seat) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + seat.getRow());
        values.add("" + seat.getColumn());
        values.add("" + seat.getSeatCode());

        boolean response = false;
        try {
            response = db.setData("UPDATE Seat SET Row = ?, Column = ? WHERE SeatCode = ?", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param id unique ID of the seat we want to delete from the table
     * @return true if insertion is successful, false if otherwise
     */
    public boolean remove(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);

        boolean response = false;
        try {
            response = db.setData("DELETE FROM Seat WHERE SeatCode = ?", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }


    /**
     * retrieves all rows from Seat table and translates them to objects of class Seat and stores them in the list
     */
    public void fetchAll() {

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Seat", null, false);
            for (ArrayList<String> record : row) {
                Seat currSeat = new Seat();
                currSeat.setSeatCode(Integer.parseInt(record.get(0)));
                currSeat.setRow(Integer.parseInt(record.get(1)));
                currSeat.setColumn(Integer.parseInt(record.get(2)));
                getList().add(currSeat);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class Seat {

        private int seatCode;
        private int row;
        private int column;

        public Seat() {
        }

        /**
         * parameterized constructor for Seat class
         *
         * @param seatCode
         * @param row
         * @param column
         */
        public Seat(int seatCode, int row, int column) {
            this.seatCode = seatCode;
            this.row = row;
            this.column = column;
        }


        // ACCESSORS

        /**
         * return the seat code number
         *
         * @return
         */
        public int getSeatCode() {
            return seatCode;
        }

        /**
         * return the row number
         *
         * @return
         */
        public int getRow() {
            return row;
        }

        /**
         * return the column number
         *
         * @return
         */
        public int getColumn() {
            return column;
        }


        // MUTATORS

        /**
         * @param seatCode the seat code
         */

        public void setSeatCode(int seatCode) {
            this.seatCode = seatCode;
        }

        /**
         * @param row the number of the row
         */
        public void setRow(int row) {
            this.row = row;
        }

        /**
         * @param column the number of the column
         */
        public void setColumn(int column) {
            this.column = column;
        }

    }
}