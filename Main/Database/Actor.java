package Database;

import java.util.*;

/** 
 * Class for a movie actor with their name, movies, and roles
*/
public class Actor {
    public String name;
    public ArrayList <String> movies = new ArrayList<String>();
    public ArrayList <String> roles = new ArrayList<String>();;

    /**  
     * Set name of the actor
     * @param String: actor's name
     * @return 
    */
    protected void setName(String newName) {
        name = newName;
    }

    /**  
     * Add movie to actor's list of movies
     * @param String: actor's movie
     * @return 
    */
    protected void addMovie(String newMovie) {
        movies.add(newMovie);
    }

    /**  
     * Add role to actor's list of roles
     * @param String: actor's movie
     * @return 
    */
    protected void addRole(String newRole) {
        roles.add(newRole);
    }

    /**  
     * Print each movie and role for the actor
     * @return 
    */
    public void getInfo() {
        for(int i = 0; i < movies.size(); i ++) {
            System.out.println("* Movie: " + movies.get(i) + " as " + roles.get(i));
        }
    }
}
