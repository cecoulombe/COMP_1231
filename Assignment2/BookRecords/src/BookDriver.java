/* Author: Caitlin Coulombe, T00756521
 * Date: June 16, 2024
 * Course: COMP 1231
 * Assignment 2 Question 1: Design and implement a Java application that maintains some book records. Each book record has a book code, a title, a price, and a genre. 
 * Some examples of genre of books are "action" and "comedy". The application helps users to update the details of book records. For security reasons, the book records
 * are locked with a password. The application will have the function of setting up a password and using the password to lock and unlock the book records before performing 
 * record update. In addition, the applciation is able to identify and display the book with the highest price. If there are more than one book having the same highest price, 
 * they will be identified and displayed. 
 * The implementation requirements of the application include:
 *      * Create an interface Genre, PasswordLockable, and a class Book.
 *      * create a driver to demonstrate the various features. The driver should start with an array of Book and stores a few book records in it (Assumption: user always 
 *      enters unique book codes; trherefore the application does not need to check for uniqueness of each book case)
 *      * Use the text exhibit in the assignment as a reference to design your demonstration
 *      * Create a UML class diagram (can exclude the driver)
 * 
 */

public class BookDriver {
    public static void main(String[] args) throws Exception {

        // constants
        final int RECORD_SIZE = 4;

        // variables
        Book[] bookList = new Book[RECORD_SIZE];

        // initialize four books to fill the array
        bookList[0] = new Book("A001", "Perish Forcefully", 123.45, Genre.ACTION);
        bookList[1] = new Book("B002", "Ponty Mython and the Mystic Cup", 7.99, Genre.COMEDY);
        bookList[2] = new Book("C003", "The Man, The Myth, The Legend: Story of Scott Sterling", 22.22, Genre.AUTOBIOGRAPHY);
        bookList[3] = new Book("D004", "unknown", 0.00, Genre.UNCLASSIFIED);

        // create a password
        bookList[0].setPassword("actionP@ss1");
        bookList[1].setPassword("comedyP@ss1");
        bookList[2].setPassword("autoBioP@ss1");
        System.out.println(bookList[3].setPassword("ABC123"));

        // return the record for the first book
        System.out.println("The books in the list are:");
        for (Book book : bookList) {
            System.out.println(book);
        }
        
        // lock the first book using the password
        System.out.println(bookList[3].lock("ABC123"));

        // attempt to modify the first book without the password
        System.out.println(bookList[3].modifyBook("D004", "The Master of the Bracelets", 123.45, Genre.ACTION));

        // attempt to unlock the first book with the wrong password
        System.out.println(bookList[3].unlock("BadPassword"));

        // unlock the first book with the correct password and modify it
        System.out.println(bookList[3].unlock("ABC123"));
        System.out.println(bookList[3].modifyBook("D004", "The Master of the Bracelets", 123.45, Genre.ACTION));

        // return the highest priced book(s)
        Book mostExpensive = bookList[0];

        // first find the most expensive book
        for(int i = 0; i <= bookList.length - 1; i++)
        {
            if(bookList[i].compareTo(mostExpensive) > 0)
                {
                    mostExpensive = bookList[i];
                }
        }

        // now see if there are others that cost the same
        System.out.println("The most expensive book(s) in the list are:");
        for(int i = 0; i <= bookList.length - 1; i++)
        {
            if(bookList[i].compareTo(mostExpensive) == 0)
            {
                System.out.println(bookList[i]);
            }
        }


    }
}
