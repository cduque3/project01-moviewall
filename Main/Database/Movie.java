package Database;
import java.util.*;

/** 
 * Class for a movie with its characters and cast members
*/
public class Movie {
        public String title;
        public ArrayList <String> characters;
        public ArrayList <String> cast;

        /**  
         * Set title of the movie
         * @param String: movie's title
         * @return 
        */
        public void setTitle(String newTitle) {
            title = newTitle;
        }

        /**  
         * Add list of characters for the movie
         * @param ArrayList<String>: list of characters
         * @return 
        */
        public void setCharacters(ArrayList<String> newCharacters) {
            characters = newCharacters;
        }

        /**  
         * Add list of cast members for the movie
         * @param ArrayList<String>: list of cast members
         * @return 
        */
        public void setCast(ArrayList<String> newCast) {
            cast = newCast;
        }

        /**  
         * Get the size of the movie's cast
         * @return movie's cast size
        */
        protected int getCastSize() {
            return cast.size();
        }

    }
    


    

