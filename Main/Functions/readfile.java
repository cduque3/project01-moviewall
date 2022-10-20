import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import Database.Movie;
import Database.movieList;

/** 
 * Class with methods to read CSV file and put it's info into a movie list
*/
public class readfile {

    /**  
     * Pass in the CSV file and get each movie + their info
     * @param String: CSV file
     * @param movieList: empty ArrayList of movies 
     * @return newly populated movieList with all movies
    */
    public static void readThroughBufferReader(String file, movieList movies) {  

        try { 
            // Use FileReader and BufferedReader to read file 
            FileReader filereader = new FileReader(file); 
            BufferedReader reader = new BufferedReader(filereader);

            // String array to hold each column in a given row
            String row;

            // Skip the header
            row = reader.readLine(); 
            row = reader.readLine();

            // Go through each row in the CSV file
            while (row != null) { 
                
                // Split the row, use just to get the title
                String title[] = row.split(",");
   
                // Error handling for certain lines
                if (title[1].charAt(0) != '\"' && row.contains("]")) {

                    // Create variable to handle the json section of each row
                    String json = row.substring(row.indexOf("["), row.indexOf("]"));

                    // Get each actor + their role from the json and put them into their own lists
                    ArrayList<String> actorList = extractCast(json);
                    ArrayList<String> characterList = extractCharacters(json);
       

                    //Create new Movie object and populate it with a movie's title, characters, and cast
                    Movie m = new Movie();
                    m.setTitle(title[1]);
                    m.setCharacters(characterList);
                    m.setCast(actorList);
                    movies.addMovies(m);
                }

                row = reader.readLine();
        } 

        // Close reader
        reader.close();   
        }

        // Exception Handling
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 

        /**  
     * Pass in the JSON string from the CSV file and put all movie characters in a list
     * @param String: JSON string
     * @return list with movie characters
    */
    public static ArrayList<String> extractCharacters(String line) {

        // ArrayList to hold the movie's characters
        ArrayList<String> characterList = new ArrayList<String>();

        // Take out the quotes from JSON string
        String json = line.replaceAll("\"", "");
        json = json.replaceAll("\"", "");
        
        // Get index of the first movie character
        // Index will increment to each movie character until it reaches the end of the string
        String ch = "character: ";
        int index = json.indexOf(ch);
    
        // Keep looping until the index cannot find another character
        while (index != -1) {
    
            // String to hold a character
            String character = "";

            // Get string starting from the character to the end of the JSON string
            character = json.substring(index + 11, json.length()) ;

            // Error handling for if there is no following comma; exception thrown without this line 
            if(character.indexOf(",") < 0) {
                break;
            }

            // Cut the string off at the next comma after the movie character so that it's now just the character
            character = character.substring(0, character.indexOf(","));

            // Now add the movie character to the ArrayList of characters
            characterList.add(character);
    
            // Increment index to the next character
            index = json.indexOf(ch, index + 1);
        }

        // Return the array list of characters
        return characterList;
    }
         
    /**  
     * Pass in the JSON string from the CSV file and put all the cast members in a list
     * @param String: JSON string
     * @return list of cast members
    */ 
    public static ArrayList<String> extractCast(String line) {

        // ArrayList to hold the movie's cast members
        ArrayList<String> nameList = new ArrayList<String>();

        //Take out the quotes from the JSON string
        String json = line.replaceAll("\"", "");
        json = json.replaceAll("\"", "");

        // Get index of the first cast member
        // Index will increment to each cast member until it reaches the end of the JSON string
        String n = "name: ";
        int index = json.indexOf(n);

        // Keep looping until the index cannot find another character
        while (index != -1) {

            // String to hold a cast member
            String name = "";
            
            // Get string starting from the cast member to the end of the JSON string
            name = json.substring(index + 6, json.length() - 1 ) ;

            // Error handling for if there is no following comma; exception thrown without this line
            if(name.indexOf(",") < 0) {
                break;
            }

            // Cut the string off at the comma so that it's now just the cast member
            name = name.substring(0, name.indexOf(","));

            // Now add the cast member to the ArrayList of cast members
            nameList.add(name);
            
            
            // Increment index to next cast member
            index = json.indexOf(n, index + 1);
        }

        return nameList;
    }



}
