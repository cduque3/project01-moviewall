package Database;
import java.util.*;

/** 
 * Class for a list of all the movies
*/
public class movieList {

        protected ArrayList <Movie> movies = new ArrayList<Movie>();

        /**  
         * Add a movie to the movie list
         * @param Movie: movie to add to list
         * @return 
        */
        public void addMovies(Movie newMovies) {
            movies.add(newMovies);
        }

        /**  
         * Get the size of the movie list
         * @return size of movie list
        */
        protected int getLength() {
            return movies.size();
        }
    }



        


    


