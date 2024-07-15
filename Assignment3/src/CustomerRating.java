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
 import java.text.DecimalFormat;

public class CustomerRating {
    // global variables
    Customer customers[];
    int size;   // to track the number of elements in the array

    //---------------------------------------------------------------------------------------------------------------------------------
    // CustomerRating() constructor to create an instance of the class so that the non-static method readFromFile can be called as an instance method
    //---------------------------------------------------------------------------------------------------------------------------------
    private CustomerRating(int capacity)
    {
        this.customers = new Customer[capacity];
        this.size = 0;
    }

    //---------------------------------------------------------------------------------------------------------------------------------
    // readFromFile() reads the data from the file, ensures they are formatted correctly, and saves them in the global customers array
    //---------------------------------------------------------------------------------------------------------------------------------
    private void readFromFile(String filename) throws IOException
    {
        // initialize the fileReader and the bufferedReader to wrap it
        FileReader fr = null;
        BufferedReader reader = null;

        try
        {
            // open the file
            fr = new FileReader(filename);
            reader = new BufferedReader(fr);

            String line;
            
            System.out.println("Age\tRating\n----------------");
            while((line = reader.readLine()) != null)
            {
                // store each line of the txt file in an array and split the line at the [tab]
                line = line.trim();
                String[] parts = line.split("\t");

                System.out.println("Parts length = " + parts.length);
                // check that there is an age and a rating in the line
                if(parts.length != 2)
                {
                    // invalid format in the text file shouldn't occur, but if it does, print an error
                    System.err.println("Parts.length = " + parts.length + ". Invalid format in input file: " + line);
                    continue;
                }

                try 
                {
                    int age = Integer.parseInt(parts[0].trim());
                    double rating = Double.parseDouble(parts[1].trim());

                    if(size < customers.length)
                    {
                        customers[size] = new Customer(age, rating);
                        System.out.println(customers[size]);
                        size++;
                    }
                    else
                    {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)     // second try loop
                {
                    System.out.println("Array out of bounds: Cannot add any more customers from input file.");
                }
                catch(NumberFormatException e)     // second try loop
                {
                    System.out.println("Invalid number format in input file: " + line);
                }   
            }
        }
        catch (FileNotFoundException e)   // big try block
        {
            // catches it and then rethrows it to the caller
            throw e;    
        }
        finally
        {   //big try block
            // close all resource leaks after everything has been done with them
            if(reader != null)
            {
                reader.close();
            }
            if(fr != null)
            {
                fr.close();
            }
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------
    // writeNewRatings() takes input from the user and writes a new rating into the array assuming there is space until the exit key is input
    //---------------------------------------------------------------------------------------------------------------------------------
    private void writeNewRatings(String filename) throws IOException
    {
        // local variables
        String userInput = "";

        // objects
        Scanner scan = new Scanner(System.in);

        
        while(!userInput.equals("!"))
        {
            System.out.print("Enter AGE [integer], followed by one [TAB], then RATING [decimal number] (or enter \"!\" to exit): ");
            userInput = scan.nextLine();
            System.out.println();

            if(!userInput.equals("!"))
            {
                String[] parts = userInput.split("\t");

                // System.out.println("Parts length = " + parts.length);

                // check that there is an age and a rating in the line
                if(parts.length != 2)
                {
                    // invalid format in the text file shouldn't occur, but if it does, print an error
                    System.err.println("Invalid format, entry skipped.");
                    continue;
                }

                try 
                {
                    int age = Integer.parseInt(parts[0].trim());
                    double rating = Double.parseDouble(parts[1].trim());

                    if(size < customers.length)
                    {
                        customers[size] = new Customer(age, rating);
                        System.out.println("Customer added! Age: " + age + "\tRating: " + rating);
                        System.out.println();
                        size++;
                    }
                    else
                    {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)     // second try loop
                {
                    System.out.println("Array out of bounds!! Record skipped.");
                }
                catch(NumberFormatException e)     // second try loop
                {
                    System.out.println("Invalid number format!! Record skipped.");
                }   
            }
        }
        scan.close();
        printArr();
        writeToFile(filename);
    }

    //---------------------------------------------------------------------------------------------------------------------------------
    // printArr() prints the formatted array and averages when the program is terminated
    //---------------------------------------------------------------------------------------------------------------------------------
    private void printArr()
    {
        // local variables
        int sumAge = 0;
        double sumRat = 0;
        int count = 0;

        // objects
        DecimalFormat fmt = new DecimalFormat("0.00");

        System.out.println("Age\tRating\n----------------");
        for (Customer customer : customers) {
            if(customer != null)
            {
                System.out.println(customer);
                sumAge += customer.getAge();
                sumRat += customer.getRating();
                count++;
            }
        }

        System.out.println("Average age: " + fmt.format((double) sumAge/count));
        System.out.println("Average rating: " + fmt.format((double) sumRat/(double) count));
    }

    //---------------------------------------------------------------------------------------------------------------------------------
    // writeToFile() writes the updated array to the file
    //---------------------------------------------------------------------------------------------------------------------------------
    private void writeToFile(String filename) throws IOException
    {
        FileWriter fw = null;
        BufferedWriter writer = null;

        // objects
        DecimalFormat fmt = new DecimalFormat("0.00");

        try
        {
            // open the file
            fw = new FileWriter(filename);
            writer = new BufferedWriter(fw);

            for (int i = 0; i < size; i++)
            {
                Customer customer = customers[i];
                String line = customer.getAge() + "\t" + fmt.format(customer.getRating());

                writer.write(line);
                writer.newLine();
            }

        }
        catch (FileNotFoundException e)   // big try block
        {
            // catches it and then rethrows it to the caller
            throw e;    
        }
        finally
        {   //big try block
            // close all resource leaks after everything has been done with them
            if(writer != null)
            {
                writer.close();
            }
            if(fw != null)
            {
                fw.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String fileName = "rating.txt";
        //create an instance of the class
        CustomerRating customerRating = new CustomerRating(5);

        // call readFromFile on that instance
        customerRating.readFromFile(fileName);

        customerRating.writeNewRatings(fileName);

    }
}
