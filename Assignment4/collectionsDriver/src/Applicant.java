/* Author: Caitlin Coulombe, T00756521
 * Date: August 10, 2024
 * Course: COMP 1231
 * 
 * Create a class named Applicant with two attributes: name and typingSpeed. The class should implement the Comparable intereface so that two applicants can be compared according to their typing speed
 * 
 * 
 */


public class Applicant implements Comparable<Applicant> {
    // global variables
    String name;
    int typingSpeed;
    
    //--------------------------------------------------------------------------------
    // Applicant(name, typingSpeed) constructor
    //--------------------------------------------------------------------------------
    public Applicant(String name, int typingSpeed)
    {
        setName(name);
        setTypeSpeed(typingSpeed);
    }

    //--------------------------------------------------------------------------------
    // setName(name) sets the name of the applicant
    //--------------------------------------------------------------------------------
    private void setName(String name)
    {
        this.name = name;
    }

    //--------------------------------------------------------------------------------
    // getName() returns the name of the applicant
    //--------------------------------------------------------------------------------
    public String getName()
    {
        return name;
    }

    //--------------------------------------------------------------------------------
    // setTypeSpeed(typingSpeed) sets the typingSpeed of the applicant
    //--------------------------------------------------------------------------------
    private void setTypeSpeed(int typingSpeed)
    {
        this.typingSpeed = typingSpeed;
    }

    //--------------------------------------------------------------------------------
    // getTypeSpeed() returns the typingSpeed of the applicant
    //--------------------------------------------------------------------------------
    public int getTypeSpeed()
    {
        return typingSpeed;
    }

    //--------------------------------------------------------------------------------
    // compareTo() used in sorting the applicants in descending order of typing speed.
    //--------------------------------------------------------------------------------
    public int compareTo(Applicant other)
    {
        return Integer.compare(other.typingSpeed, this.typingSpeed);
    }

    //--------------------------------------------------------------------------------
    // toString() returns the name and typing speed of the applicant
    //--------------------------------------------------------------------------------
    public String toString()
    {
        return "Name = " + name + ";\tTyping Speed (words/min) = " + typingSpeed+ "\n";
    }
}
