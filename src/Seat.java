
/**
 * A class that represents seat position
 *
 * @author Ante
 */

public class Seat {
    
    private int seatCode;
    private int row;
    private int column;

    /**
     * parameterized constructor for Seat class
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
     * @return
     */
    public int getSeatCode() {
        return seatCode;
    }

    /**
     * return the row number
     * @return
     */
    public int getRow() {
        return row;
    }

    /**
     * return the column number
     * @return
     */
    public int getColumn() {
        return column;
    }
    
    
    // MUTATORS

    /**
     *
     * @param seatCode
     */

    public void setSeatCode(int seatCode) {
        this.seatCode = seatCode;
    }

    /**
     *
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     *
     * @param column
     */
    public void setColumn(int column) {
        this.column = column;
    }
    
}
