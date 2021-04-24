import java.util.ArrayList;

/**
 * class that represents one unique movie
 */
public class MovieDAO implements DAO<MovieDAO.Movie>{

    private DBConnect db;
    private ArrayList<Movie> list;
    private Movie currentMovie;

    /**
     * @param db object that contains database connection protocols
     */
    public MovieDAO(DBConnect db) {
        this.db = db;
    }


    /**
     * @return current list of movies
     */
    public ArrayList<Movie> getList() {
        return list;
    }

    public Movie getCurrentMovie() {
        return currentMovie;
    }

    public void setCurrentMovie(Movie currentMovie) {
        this.currentMovie = currentMovie;
    }

    @Override
    public Movie getCurrentItem() {
        return currentMovie;
    }

    /**
     * @param id unique ID of the movie we want to fetch from the table
     * @return object of class Movie
     */
    @Override
    public void fetch(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);
        Movie fetchedMovie = new Movie();

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Movie WHERE MovieID = ?", values, false);
            fetchedMovie.setMovieID(Integer.parseInt(row.get(0).get(0)));
            fetchedMovie.setTitle(row.get(0).get(1));
            fetchedMovie.setGenre(row.get(0).get(2));
            fetchedMovie.setDescription(row.get(0).get(3));
            fetchedMovie.setDuration(Integer.parseInt(row.get(0).get(4)));
            String is3D = row.get(0).get(5);
            if (is3D.equals("Yes")) fetchedMovie.setIs3D(true);
            else fetchedMovie.setIs3D(false);

            setCurrentMovie(fetchedMovie);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @param movie prepared object of class Movie whose attributes are translated to column values of the new row in Movie table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean create(Movie movie) {
        ArrayList<String> values = new ArrayList<String>();
        values.add(movie.getTitle());
        values.add(movie.getGenre());
        values.add(movie.getDescription());
        values.add("" + movie.getDuration());
        if (movie.getIs3D()) values.add("Yes");
        else values.add("No");

        boolean response = false;
        try {
            response = db.setData("INSERT INTO Movie (Title, Genre, Description, Duration, Is3D) VALUES(?,?,?,?,?)", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param movie prepared object of class Movie whose attributes are translated to column values of the existing row with specified ID in Movie table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean update(int id, Movie movie) {
        ArrayList<String> values = new ArrayList<String>();
        values.add(movie.getTitle());
        values.add(movie.getGenre());
        values.add(movie.getDescription());
        values.add("" + movie.getDuration());
        if (movie.getIs3D()) values.add("Yes");
        else values.add("No");
        values.add("" + movie.getMovieID());

        values.add("" + id);
        boolean response = false;
        try {
            response = db.setData("UPDATE Movie SET Title = '?', Genre = '?', Description = '?', Duration = '?', Is3D = '?' WHERE MovieID = '?'", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * @param id unique ID of the movie we want to delete from the table
     * @return true if insertion is successful, false if otherwise
     */
    @Override
    public boolean remove(int id) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("" + id);

        boolean response = false;
        try {
            response = db.setData("DELETE FROM Movie WHERE MovieID = ?", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }


    /**
     * retrieves all rows from Movie table and translates them to objects of class Movie and stores them in the list
     */
    @Override
    public void fetchAll() {

        try {
            ArrayList<ArrayList<String>> row = db.getData("SELECT * FROM Movie", null, false);
            for (ArrayList<String> record : row) {
                Movie currMovie = new Movie();
                currMovie.setMovieID(Integer.parseInt(record.get(0)));
                currMovie.setTitle(record.get(1));
                currMovie.setGenre(record.get(2));
                currMovie.setDescription(record.get(3));
                currMovie.setDuration(Integer.parseInt(record.get(4)));
                String is3D = row.get(0).get(5);
                if (is3D.equals("Yes")) currMovie.setIs3D(true);
                else currMovie.setIs3D(false);
                getList().add(currMovie);
            }

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("The record does not exist.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * inner class of MovieDAO that serves as an object model used for object-oriented manipulation of database data
     */
    class Movie {

        private int movieID;
        private String title;
        private String genre;
        private String description;
        private int duration;
        private boolean is3D;

        public Movie() {
            this.movieID = -1;
            this.title = "";
            this.genre = "";
            this.description = "";
            this.duration = -1;
            this.is3D = false;
        }

        /**
         * parameterized constructor for Movie class
         *
         * @param title
         * @param genre
         * @param description
         * @param duration
         * @param is3D
         */
        // PARAMETERIZED CONSTRUCTOR
        public Movie( String title, String genre, String description, int duration, boolean is3D) {
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
        public boolean getIs3D() {
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
}
