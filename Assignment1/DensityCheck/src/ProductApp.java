/* Author: Caitlin Coulombe, T00756521
 * Date: May 14, 2024
 * Course: COMP 1231
 * Assignment 1 Question 1: Design and implement a Java application that performs a density check for various chemical products manufactured by a chemical company. All products are in liquid form. 
 * The formula of calculating the density is dividing the product's mass in grams (g) by the products volume in cubmic centimeters (cm^3)  Each product can be sold to the customer in any volume size 
 * and it must have a density between 1.25 g/cm^3 and 1.55g/cm^3  If it does not fall in this range, it is either "too thin" or "too thick"  
 * The application will accept the product's mass in pounds and ounces (Imperial system) or in kilograms (Metric system)  But it will accept the volume in cm^%3 only  The application will determine 
 * if the product is too thin, too thick, or acceptable  
 *      * Design the application using the inheritance hierarchy starting with an abstract class Product and two derived classes: ImperialUnit and MetricUnit
 *      * Create a driver class named ProductApp with a single array reference of the Product class. Since no user input is needed in the driver, you can write some code statements to store in the 
 *      array with three objects using the Imperial system and an additional three objects using the Metric system (a total of six objects)
 *      * Use a loop to traverse the array in the driver to display the details of the six objects (Note: ProductApp should have only one System.out.println statement that is coded within the loop 
 *      to display the details of all objects. No other println statements should be coded in the driver. The output text messages should be coded in the abstract and derived classes. All numbers 
 *      must be formatted with 2 decimal points).
 *      * Illustrate the class design using a UML diagram (Note: the driver class can be excluded from the diagram). Draw the UML diagram using a software tool (a UML CASE tool or anything similar)
 *          * Testing: Use the test exhibit in the assignment as a reference to design your demonstration (you can use the same data shown in the example to perform the test)
 * 
 * 
 */

public class ProductApp {
    public static void main(String[] args) throws Exception {
        // object array
        Product[] productList = new Product[6];

        // create 3 metric produce objects with 3 parameters each (ID, mass in kg, and volume in cm^3)
        productList[0] = new MetricUnit("MA1122", 0.52, 541.85);
        productList[1] = new MetricUnit("MB3452", 0.63, 496.24);
        productList[2] = new MetricUnit("MC9470", 0.44, 282.05);

        // create 3 imperial product objects with 4 parameters each (ID, mass in pounds, mass in ounces, and volume in cm^3)
        productList[3] = new ImperialUnit("I1969X", 0, 14, 320.00);
        productList[4] = new ImperialUnit("I8927Y", 1, 5, 389.63);
        productList[5] = new ImperialUnit("I0920Z", 4, 1, 1000.19);

        // iterate through the list and print out the information for that product
        for(Product item : productList)
        {
            System.out.println(item);
        }

    }
}
