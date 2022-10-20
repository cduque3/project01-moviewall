import java.util.*;

/** 
 * Class with method to binary search the actor list
*/
public class searching {

    /** 
     * Starter function for binary search
     * @param name: 
     * @param target: the value to find/insert in the array
     * @param min: lowest value of the array
     * @param max: highest value of the array
     * @return : index in array to insert/find value
     * 
    */
    public static int binarySearch(ArrayList<String> names, String target) {
        return binarySearchInsert(names, target, 0, names.size() - 1);
    }

    /** 
     * Recursive function to search for an actor in the array list. Can also return
     * an index of the suggested actor if the actor's name isn't in the list
     * @param names: list of actor names
     * @param target: actor to find in the list of actor names
     * @param min: lowest value in the list
     * @param max: highest value in the list
     * @return index of the actor in the array / index of the suggestion (negative)
     * 
    */
    public static int binarySearchInsert(ArrayList<String> names, String target, int min, int max) {

        // Identify the midpoint of the list
        int mid = (max + min)/2;

        // Return index of the suggestion, made negative to indicate the index is a suggestion
        if(min > max) {
            return -(mid + 1);
        }

        // Recurse until actor's name is found
        if(names.get(mid).compareTo(target) == 0) {
            return mid; }
        else if(names.get(mid).compareTo(target) < 0) {
            return binarySearchInsert(names, target, mid + 1, max); }
        else {
            return binarySearchInsert(names, target, min, mid -1);
        }
    }
}
