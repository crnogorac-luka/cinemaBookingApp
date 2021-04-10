/**
 * class that represents one unique movie
 */
public class Movie {

    private int movieID;
    private String title;
    private String genre;
    private String description;
    private int duration;
    private boolean is3D;

    /**
     * parameterized constructor for Movie class
     * @param movieID
     * @param title
     * @param genre
     * @param description
     * @param duration
     * @param is3D
     */
    // PARAMETERIZED CONSTRUCTOR
    public Movie(int movieID, String title, String genre, String description, int duration, boolean is3D) {
        this.movieID = movieID;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.duration = duration;
        this.is3D = is3D;
    }

    // ACCESSORS

    /**
     * @return unique ID of this movie
     */
    public int getMovieID() {
        return movieID;
    }

    /**
     * @return title of this movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return genre of this movie
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return description of this movie
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return duration of this movie
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @return true if movie is in 3D, false if otherwise
     */
    public boolean isIs3D() {
        return is3D;
    }



    // MUTATORS

    /**
     * @param movieID sets new unique movie ID
     */
    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    /**
     * @param title sets new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param genre sets new genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @param description sets new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param duration sets new duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * @param is3D changes 3D status of the movie
     */
    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }
}
