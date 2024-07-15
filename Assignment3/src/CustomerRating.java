/* Author: Caitlin Coulombe, T00756521
 * Date: July 14, 2024
 * Course: COMP 1231
 * Assignment 3 Question 1: Design and implement a Java application to store the results of a satisfaction 
 * survey for a company's service. The application stores the survey results in a text-based data file 
 * (rating.txt). The application assumes the data file must exist before it can operate. In the data file, 
 * each survey record is written in a single line with two fields (customer's age and rating for the 
 * company's service) separated by a [TAB] key. The application reads all records from the file, displays 
 * them on screen, allows users to add more records, and saves all existing and new records back to the 
 * same data file. Before the application is termianted by a user, it outputs the average customer age and 
 * average rating of all records on screen. The major requirements of the application are described in the 
 * relevant classes.
 * 
 * The major implementation details for this class are:
 *      * Read the data file (i.e. rating.txt) into the application. The data file must exist; otherwise, an exception 
 *      (IOException) will be thrown and the application will terminate abnormally. After all survey records are read 
 *      successfully, they are displayed on screen in an organized format (i.e. age and rating are displayed in aligned 
 *      columns, all floating point numbers are displayed with two decimal points, &c.)
 *      * Store all existing survey records in an array. Set the array size to store only a few records (i.e. 5). When 
 *      the array is full, an attempt to add a new record to the array will raise an exception (ArrayIndexOutOfBoundsException) 
 *      and an error mesage "Array out of bound..." will be displayed on screen. Such a new record will not be recorded 
 *      and the application will continue to run until the user terminates the application. 
 *      * Allow users to input a new survey record through the keyboard. Each record is entered in one single line (enter 
 *      the age, then [TAB], then the rating). If an age or rating is entered with any non-numeric forma (hint use 
 *      Integer.parse.Int and Double.parseDouble methods), an exception (NumberFormatException) will be raised and an error 
 *      message "Invalid number..." will be displayed on screen. Such an input will not be recorded and the application will 
 *      continue to run until the user terminates the application.
 *      * Terminate the application with an exclamation mark ("!"). Before the application is terminated, it outputs the most 
 *      updated list of survey records and the average age and the average rating on the screen. All records excluding the two 
 *      average values are to be written back to the same data file. An exception (IOException) will be thrown if there is any 
 *      error in file writing and the application will terminate automatically.
 *      * Format all data when the are displayed on the screen (aligned columns, numeric data to two decimal places)
 * 
 * Notes:
 *      * the application assumes that the data file must exist. Show an exception that is raised when the 
 *      file is not found. The application should use an array with a smaller size (i.e. 5) in order to 
 *      demonstate that an exception will be raised when there is an attempt to add more records to it. 
 *      Demonstrate also an exception will be raised when the user enter an input with invalid numbers.
 *      * Each survey record is entered in one line with two pieces of data separated by a [TAB]. When the 
 *      user inputs less than two pieces of data, the message prompting for valid input will appear again. 
 *      * Your application should produce similar output as in the example on the moodle. All output to the 
 *      screen must be aligned in columns.
 * 
 */

 import java.util.Scanner;
 import java.io.*;

public class CustomerRating {
    public static void main(String[] args)  {
        // variables
        boolean cont = true;
        String  userInput = "";

        // file varaibles
        String fileName = "records.txt";
        File file = new File(fileName);
        if(!file.exists())
        {
            throw new FileNotFoundException();
        }


        PrintWriter pwd = new PrintWriter(file);
        

        // objects
        Scanner scan = new Scanner(System.in);

        // open the file

        // take the first input from the user
        System.out.println("Welcome. Please enter a rating. (Enter \"!\" to exit.)");
        userInput = scan.nextLine();
        
        if(userInput.equals("!"))
        {
            cont = false;
        }

        while(cont)
        {
            // read the current values and save them to an array
            // take new input and add it to the file

            // see if they want to add another record
            System.out.println("Please enter another rating (Enter \"!\" to exit.)");
            userInput = scan.nextLine();
            if(userInput.equals("!"))
            {
                cont = false;
            }
        }

        scan.close();
    }
}
