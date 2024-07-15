/* Author: Caitlin Coulombe, T00756521
 * Date: July 14, 2024
 * Course: COMP 1231
 * Assignment 3 Question 1: majority of the details are in the surveyDriver class.
 * 
 * Customer has two attributes: age and rating. Each survey record is treated as an instance of the class Customer.
 * 
 */

import java.text.DecimalFormat;

public class Customer {
    // global variables
    int age;
    double rating;

    // number format
    DecimalFormat fmt = new DecimalFormat("0.00");
    
    //------------------------------------------------------------------------------------------------
    // Customer() create a new record with the age and the rating from the user
    //------------------------------------------------------------------------------------------------
    public Customer(int age, double rating) {
        setAge(age);
        setRating(rating);
    }

    //------------------------------------------------------------------------------------------------
    // setAge() setter for age
    //------------------------------------------------------------------------------------------------
    void setAge(int age) {
        this.age = age;
    }

    //------------------------------------------------------------------------------------------------
    //getAge() returns the age of the review
    //------------------------------------------------------------------------------------------------
    public int getAge() {
        return age;
    }

    //------------------------------------------------------------------------------------------------
    // setRating() setter for rating
    //------------------------------------------------------------------------------------------------
    void setRating(double rating) {
        this.rating = rating;
    }

    //------------------------------------------------------------------------------------------------
    //getRating() returns the rating of the review
    //------------------------------------------------------------------------------------------------
    public double getRating() {
        return rating;
    }

    //------------------------------------------------------------------------------------------------
    // toString() returns the relevant information about the review
    //------------------------------------------------------------------------------------------------
    public String toString()
    {
        return age + "\t" + rating;
    }
}

