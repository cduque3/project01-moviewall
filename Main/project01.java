import java.util.*;

public class project01 {

    public static void main(String[] args) {

        // Pass in the file and put all the movies into a list
        String file = "tmdb_5000_credits.csv";
        movieList movieList = new movieList();

        //readfile.readThroughBufferReader(file, movieList);
        readfile.readThroughBufferReader(file, movieList);


        // Putting all actors in the movie list into a new list of actors
        actorList actorList = new actorList();
        actorList.addActors(movieList);

        // Make a list of the actor's names
        ArrayList<String> names = actorList.actorNames;

        // Display for the user
        System.out.println("Welcome to the Movie Wall!");
        System.out.print("Enter the name of an actor (or EXIT to quit): ");

        // Get user input
        Scanner reader = new Scanner(System.in);
        String userInput = "";
        userInput = reader.nextLine();

        // Repeat loop until user chooses to exit
        while(!userInput.equals("EXIT")) {
    
            // Search for the actor input by the user in the list of actor names
            int search = searching.binarySearch(names, userInput);

            // Case for correct input
            if(search > 0) {

                // Index of the chosen actor in the actor list 
                int index = actorList.actorIndex.indexOf(names.get(search));

                // Print the actor's movies and roles from that index
                actorList.actors.get(index).getInfo();
            }

            // Case for incorrect input
            else {

                // Index of the suggestion for the user
                int suggestion = Math.abs(search);

                // Ask user if they want the suggestion
                System.out.print("No such actor. Did you mean: " + names.get(suggestion) + " Y/N: ");
                userInput = reader.nextLine();

                // Print the suggestion if user chooses to do so
                if(userInput.equals("Y")) {

                    int index = actorList.actorIndex.indexOf(names.get(suggestion));
                    actorList.actors.get(index).getInfo();
                }
            }

            // Repeat process until user chooses to exit
            System.out.println();
            System.out.print("Enter the name of an actor (or EXIT to quit): ");
            userInput = reader.nextLine();
        }

        // Closing message after user chooses to exit
        System.out.println("Thanks for using the Movie Wall!");

        // Close the Scanner
        reader.close();

        return; 
    }
}


    

