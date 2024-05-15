/* Author: Caitlin Coulombe, T00756521
 * Date: May 14, 2024
 * Course: COMP 1231
 * 
 * For ImperialUnit, assign two attributes for the mass (pounds lb and ounces oz). Use the conversion 1lb = 16oz and 1oz = 28.35g for the conversions.
 * Each attribute should have an accessor and mutator method and there should be a method to perform an analysis on the calculated density value to 
 * determine if it falls in the product range (create an overridden version of the abstract density calculator)
 * Declare a default constructor and a parameterized constructor for each class. All classes except the driver class must also have a toString() method 
 * that returns a custom string about the details of a product
 * 
 * 
 * 
 */
import java.text.DecimalFormat;

public class ImperialUnit extends Product{
// variables
private double massInOunces;

// decimal formatting
DecimalFormat fmt = new DecimalFormat("#.00");

//--------------------------------------------------------------------------------------------------------------------------------------------------
// Default contructor ImperialUnit(): default constructor which will return an error to the user saying there must be an ID, mass, and volume given for the product
//--------------------------------------------------------------------------------------------------------------------------------------------------
public ImperialUnit()
{
    // error message saying to pass some parameters
} 

//--------------------------------------------------------------------------------------------------------------------------------------------------
// Constructor ImperialUnit(productID, mass, volume): initializes an object with the specifications from the driver
//--------------------------------------------------------------------------------------------------------------------------------------------------
public ImperialUnit(String productID, double pounds, double ounces, double volume)
{
    // use the parent to create a product with its ID and volume
    super(productID, volume);

    massInOunces = ounces + (pounds * 16);
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
// setMass(mass): sets the new mass of the object according to an input from the driver
//--------------------------------------------------------------------------------------------------------------------------------------------------
public void setMass(double pounds, double ounces)
{
    massInOunces = ounces + (pounds * 16);
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
// getMass(): returns the mass in ounces to the driver
//--------------------------------------------------------------------------------------------------------------------------------------------------
public double getMass()
{
    return massInOunces;
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
// getMassInGrams(): returns the mass in grams
//--------------------------------------------------------------------------------------------------------------------------------------------------
public double getMassInGrams()
{
    // constants
    final double OZ_TO_GRAM = 28.35;    // 1oz = 28.35g

    return massInOunces * OZ_TO_GRAM;
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
// computeDensity: create an override of the abstract method from the Product parent class. compute the density and return whether or not it is in range
//--------------------------------------------------------------------------------------------------------------------------------------------------
protected double computeDensity()
{
    // local variables
    double density;
    double massInGram = getMassInGrams();

    // compute the density
    density = massInGram / super.getVolume();

    return density;

}

//--------------------------------------------------------------------------------------------------------------------------------------------------
// analysisResults: override of the abstract method from the Product parent class. determines where the results lie within the range and returns the 
// appropriate results
//--------------------------------------------------------------------------------------------------------------------------------------------------
protected String analysisResults()
{
    // local variables
    String analysisResults;
    double density = computeDensity();


    // local constants
    final double UPPER_LIMIT = 1.55;
    final double LOWER_LIMIT = 1.25;


    // compare against the limits to determine if it is above, within, or below the acceptable range
    if(density > UPPER_LIMIT)
    {
        // too thick
        analysisResults = "Too thick";
    }
    else if(density < LOWER_LIMIT)
    {
        // too thin
        analysisResults = "Too thin";
    }
    else
    {
        // acceptable
        analysisResults = "Acceptable";
    }

    // return the message about the analysis
    return analysisResults;
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
// toString: return the ID number and volume of the product
//--------------------------------------------------------------------------------------------------------------------------------------------------
public String toString()
{
    String productInfo = "ID = " + super.getProductID() + "\tVolume = " + fmt.format(super.getVolume()) + " cubic_cm\tMass = " + fmt.format(getMassInGrams()) + " (g)\tDensity = " + fmt.format(computeDensity()) + "\tResults of Analysis = " + analysisResults();

    return productInfo;
}

}
