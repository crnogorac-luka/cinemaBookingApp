import java.util.ArrayList;

/**
 * class that represents one unique seat
 */
public class SeatDAO implements DAO<SeatDAO.Seat>{

    private DBConnect db;
    private ArrayList<Seat> list;
    private Seat currentSeat;

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

    public Seat getCurrentSeat() {
        return currentSeat;
    }

    public void setCurrentSeat(Seat currentSeat) {
        this.currentSeat = currentSeat;
    }

    @Override
    public Seat getCurrentItem() {
        return currentSeat;
    }

    /**
     * @param id unique ID of the seat we want to fetch from the table
     * @return object of class Seat
     */
    @Override
    public void fetch(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);
        Seat fetchedSeat = new Seat();

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Seat WHERE SeatCode = ?", values, false);
            fetchedSeat.setSeatCode(Integer.parseInt(row.get(0).get(0)));
            fetchedSeat.setRow(row.get(0).get(1).charAt(0));
            fetchedSeat.setColumn(Integer.parseInt(row.get(0).get(2)));

            setCurrentSeat(fetchedSeat);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @param seat prepared object of class Seat whose attributes are translated to column values of the new row in Seat table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
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
    @Override
    public boolean update(int id, Seat seat) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + seat.getRow());
        values.add("" + seat.getColumn());
        values.add("" + seat.getSeatCode());

        values.add("" + id);
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
    @Override
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
    @Override
    public void fetchAll() {

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Seat", null, false);
            for (ArrayList<String> record : row) {
                Seat currSeat = new Seat();
                currSeat.setSeatCode(Integer.parseInt(record.get(0)));
                currSeat.setRow(record.get(1).charAt(0));
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
        private char row;
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
        public Seat(int seatCode, char row, int column) {
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
        public char getRow() {
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
        public void setRow(char row) {
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