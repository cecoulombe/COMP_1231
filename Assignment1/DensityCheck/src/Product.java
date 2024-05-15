/* Author: Caitlin Coulombe, T00756521
 * Date: May 14, 2024
 * Course: COMP 1231
 * 
 * For the abstract class Product: assign two private attributes: the product's product ID as a string and the volume of the product in cm^3
 * Each attribute should have an accessor and mutator method and there should be a method to perform an analysis on the calculated density value to 
 * determine if it falls in the product range (create an abstract density calculator and a method to determine if it is within the range)
 * Declare a default constructor and a parameterized constructor for each class. All classes except the driver class must also have a toString() 
 * method that returns a custom string about the details of a product
 * 
 * 
 */

public abstract class Product {
// create a product with an ID number and a volume in cm^3
// generic constructor
// parameterized constructor
// accessor and mutator for both ID number and product volume

// create everything that any product might need (ID, mass, volume, density, and results analysis)

// variables
private String productID;
private double volume;

//--------------------------------------------------------------------------------------------------------------------------------------------------
// default constructor Product(): send an error and say that there needs to be a product ID, mass, and density passed as parameters
//--------------------------------------------------------------------------------------------------------------------------------------------------
protected Product()
{
    // tell the user that an object cannot be built without information about it and to input another object
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
// Constructor Product(ID, mass, density): takes three parameters and uses them to create a new product that can be analyzed
//--------------------------------------------------------------------------------------------------------------------------------------------------
protected Product(String productID, double volume)
{
    // create an object with the specified productID, mass, and volume
    this.productID = productID;
    this.volume = volume;
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
// setProductID: assigns an input string to the product
//--------------------------------------------------------------------------------------------------------------------------------------------------
protected void setProductID(String productID)
{
    this.productID = productID;
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
// getProductID: returns the ID for the product
//--------------------------------------------------------------------------------------------------------------------------------------------------
protected String getProductID()
{
    return productID;
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
// setVolume: assigns a new volume to the product
//--------------------------------------------------------------------------------------------------------------------------------------------------
protected void setVolume(double volume)
{
    this.volume = volume;
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
// getVolume: returns the volume of the product
//--------------------------------------------------------------------------------------------------------------------------------------------------
protected double getVolume()
{
    return volume;
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
// computeDensity: creates an abstract method which will be overridden by the child classes depending on the units for mass
//--------------------------------------------------------------------------------------------------------------------------------------------------
protected abstract double computeDensity();

//--------------------------------------------------------------------------------------------------------------------------------------------------
// analysisResults: determines where the results lie within the range and returns the appropriate results
//--------------------------------------------------------------------------------------------------------------------------------------------------
protected abstract String analysisResults();

//--------------------------------------------------------------------------------------------------------------------------------------------------
// toString: return the ID number and volume of the product
//--------------------------------------------------------------------------------------------------------------------------------------------------
public String toString()
{
    String productDescription = "The product \"" + productID + "\" has a volume of " + volume + " cubed cm.";
    return productDescription;
}


}
