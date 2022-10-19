import java.util.ArrayList;

/** 
 * Class for a list of all the actors
*/
public class actorList {

    public ArrayList <Actor> actors = new ArrayList<Actor>(); //actor objects
    public ArrayList <String> actorIndex = new ArrayList<String>(); //list of strings to find the index of each actor object
    public ArrayList <String> actorNames = new ArrayList<String>(); //actor names which will be sorted in order


    /**  
     * Add actors from each movie 
     * @param movieList: list of movies
     * @return 
    */
    public void addActors(movieList list) {

        // For each movie in the movie list
        for(int i = 0; i < list.getLength() - 1; i++ ) {

            // Variable for the current movie
            Movie currentMovie = list.movies.get(i);

            // For each actor and their role in the given movie
            for(int j = 0; j < currentMovie.getCastSize(); j++ ) {

                // Variables for the current actor and their role in the current movie
                String currentActor = currentMovie.cast.get(j);
                String currentCharacter = currentMovie.characters.get(j);

                // Variable to search the actor list for an actor
                int search = searching.binarySearch(actorNames, currentActor);

                // If actor in list not found, create new actor and add it to the list
                if(search < 0) {

                    // Set the actor's name, movie, and role and add it to the list
                    Actor newActor = new Actor();
                    newActor.setName(currentActor);
                    newActor.addMovie(currentMovie.title);
                    newActor.addRole(currentMovie.characters.get(j));
                    actors.add(newActor);

                    // Add actor's name into the list of actor names and list of actor indices
                    actorNames.add(newActor.name);
                    actorIndex.add(newActor.name);
                    
                    // Insert actor name into the proper position i.e. alphabetical order
                    insertActors(newActor.name);
                }

                // If actor in list found, add their movie and role into their object
                else {

                    // Get the index of the actor's object
                    int index = actorIndex.indexOf(actorNames.get(search));

                    // Add the movie and role to the actor's object
                    actors.get(index).addMovie(currentMovie.title);
                    actors.get(index).addRole(currentCharacter);

                }
            }
        }
    }

    /**  
     * Insert an actor into the list alphabetically
     * @param String: new actor to add to the list
     * @return 
    */
    public void insertActors(String newActor) {

        // Index in the list to insert the new actor
        int insert = Math.abs(searching.binarySearch(actorNames, newActor));

        //Put new actor into that index
        actorNames.add(insert, newActor);
    }
}
