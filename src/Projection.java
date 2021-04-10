import java.util.Date;

/**
 * class that represents one unique projection
 */
public class Projection {

    private int projectionID;
    private int startTime;
    private int endTime;
    private Date date;
    private int roomID;
    private int movieID;

    /**
     * parameterized constructor for Projection class
     * @param projectionID unique projection ID
     * @param startTime timestamp of the start of this projection
     * @param endTime timestamp of the end of this projection
     * @param date date of the projection
     * @param roomID unique ID of the room where projection is held
     * @param movieID unique ID of the movie that is projected
     */
    public Projection(int projectionID, int startTime, int endTime, Date date, int roomID, int movieID) {
        this.projectionID = projectionID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.roomID = roomID;
        this.movieID = movieID;
    }


    // ACCESSORS

    /**
     * @return unique ID of the projection
     */
    public int getProjectionID() {
        return projectionID;
    }

    /**
     * @return timestamp of the start of this projection
     */
    public int getStartTime() {
        return startTime;
    }
    /**
     * @return timestamp of the end of this projection
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * @return date of the projection
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return unique ID of the room where projection is held
     */
    public int getRoomID() {
        return roomID;
    }

    /**
     * @return unique ID of the movie that is projected
     */
    public int getMovieID() {
        return movieID;
    }



    // MUTATORS

    /**
     * @param projectionID
     */
    public void setProjectionID(int projectionID) {
        this.projectionID = projectionID;
    }

    /**
     * @param startTime
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @param roomID
     */
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    /**
     * @param movieID
     */
    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }
}
