import java.util.*;
import java.io.*;
import com.opencsv.CSVReader;

/** 
 * Class with methods to read CSV file and put it's info into a movie list
*/
public class readfile {

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

    /**  
     * Pass in the CSV file and get each movie + their info
     * @param String: CSV file
     * @param movieList: empty ArrayList of movies 
     * @return newly populated movieList with all movies
    */
    public static void readThroughCSV(String file, movieList movies) {  

        try { 
            // Use FileReader and CSVReader to read file 
            FileReader filereader = new FileReader(file); 
            CSVReader reader = new CSVReader(filereader);

            // String array to hold each column in a given row
            String[] line;

            // Skip the header
            line = reader.readNext(); 

            // Go through each row in the CSV file
            while ((line = reader.readNext()) != null) { 
            
                //Create new Movie object and populate it with a movie's title, characters, and cast
                Movie m = new Movie();
                m.setTitle(line[1]);
                m.setCharacters(extractCharacters(line[2]));
                m.setCast(extractCast(line[2]));
            
                // Add the new movie to the movie list
                movies.addMovies(m);
        } 

        // Close reader
        reader.close();   
        }

        // Exception Handling
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 


}
