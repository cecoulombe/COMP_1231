/* From Assignment2, question 1. See the BookDriver notes for more information
 * Create a Java interface named Genre that defined four integer constants (UNCLASSIFIED and three other genres at your choice 
 * e.g. UNCLASSIFIED = 0 and so on) and include two methods (setGenre and getGenre)
 */

public interface Genre {
    // define four different genres and a getter and setter method for genre

    // Constants
    final int UNCLASSIFIED = 0;
    final int ACTION = 1;
    final int COMEDY = 2;
    final int AUTOBIOGRAPHY = 3;

    void setGenre(int genre);
    int getGenre();

}
