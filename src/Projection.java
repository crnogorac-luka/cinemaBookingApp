import java.util.Date;

public class Projection {

    private int projectionID;
    private String startTime;
    private String endTime;
    private Date date;
    private int roomID;
    private int movieID;

    /**
     * default constructor
     */
    public Projection() {
        this.projectionID = -1;
        this.startTime = "";
        this.endTime = "";
        this.date = null;
        this.roomID = -1;
        this.movieID = -1;
    }

    /**
     * parameterized constructor for Projection class
     *
     * @param projectionID unique projection ID
     * @param startTime    timestamp of the start of this projection
     * @param endTime      timestamp of the end of this projection
     * @param date         date of the projection
     * @param roomID       unique ID of the room where projection is held
     * @param movieID      unique ID of the projection that is projected
     */
    public Projection(int projectionID, String startTime, String endTime, Date date, int roomID, int movieID) {
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
    public String getStartTime() {
        return startTime;
    }

    /**
     * @return timestamp of the end of this projection
     */
    public String getEndTime() {
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
     * @return unique ID of the projection that is projected
     */
    public int getMovieID() {
        return movieID;
    }


    // MUTATORS

    /**
     * @param projectionID new unique ID of the projection
     */
    public void setProjectionID(int projectionID) {
        this.projectionID = projectionID;
    }

    /**
     * @param startTime new timestamp of the start of this projection
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @param endTime new timestamp of the end of this projection
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @param date new date of the projection
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @param roomID new unique ID of the room where projection is held
     */
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    /**
     * @param movieID new unique ID of the projection that is projected
     */
    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

}
