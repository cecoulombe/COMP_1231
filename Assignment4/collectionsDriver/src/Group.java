/* Author: Caitlin Coulombe, T00756521
 * Date: August 10, 2024
 * Course: COMP 1231
 * 
 * Create a generic class named Group with a type parameter T. An instance of Group (i.e. aGroup) will 
 * store an instance of an ArrayList of type T (i.e. aList). Implement in group the following methods:
 *      * addToGroup(): adds a member (i.e. an object of T) to aList
 *      * removeFromGroup(): removes the last member who joined aLIst (i.e. remove the member at the 
 *      end of aList)
 *      * removeFromGroup (T t): removes a member (i.e. an object of type T) from aLIst
 *      * getNumberOfMembers(): returns the number of members in aList
 *      * hasNoMember(): returns true if there is no members in aLIst, or false otherwise
 *      * toString(): outputs all members in aList. Each member's attributes are displayed on a separate 
 *      line
 * 
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Group<T extends Comparable<T>> {
    // objects
    ArrayList<T> aList;

    //--------------------------------------------------------------------------------
    // Group() constructor
    //--------------------------------------------------------------------------------
    public Group()
    {
        this.aList = new ArrayList<>();
    }

    //--------------------------------------------------------------------------------
    // addToGroup(member) adds the new member of type T to the end of the list
    //--------------------------------------------------------------------------------
    public void addToGroup(T member)
    {
        aList.add(member);
    }

    //--------------------------------------------------------------------------------
    // removeFromGroup() removes the last member from the group
    //--------------------------------------------------------------------------------
    public T removeFromGroup()
    {
        // check first that its not empty before removing someone
        if(!aList.isEmpty())
        {
            return aList.remove(aList.size() - 1);
        }
        else
        {
            throw new NoSuchElementException("No candidate in the list.");
        }
    }

    //--------------------------------------------------------------------------------
    // removeFromGroup() removes the last member from the group
    //--------------------------------------------------------------------------------
    public void removeFromGroup(T member)
    {
        // check first that the member is in the list
        if(aList.contains(member))
        {
            aList.remove(member);
        }
        else
        {
            throw new NoSuchElementException("Member not found in the group: " + member);
        }
    }

    //--------------------------------------------------------------------------------
    // getNumberOfMembers() returns the number of members in the list
    //--------------------------------------------------------------------------------
    public int getNumberOfMembers()
    {
        return aList.size();
    }
    
    //--------------------------------------------------------------------------------
    // hasNoMember() returns true if there are no members in the list
    //--------------------------------------------------------------------------------
    public boolean hasNoMember()
    {
        return aList.isEmpty();
    }

    //--------------------------------------------------------------------------------
    // sortMembers() sorts the list so that the final list is in descending order
    //--------------------------------------------------------------------------------
    public void sortMembers()
    {
        Collections.sort(aList);
    }

    //--------------------------------------------------------------------------------
    // getMembers() returns a copy of the list
    //--------------------------------------------------------------------------------
    public ArrayList<T> getMembers()
    {
        return new ArrayList<T>(aList);
    }

    //--------------------------------------------------------------------------------
    // toString() outputs all members in aList. Each member's attributes are displayed 
    // on a separate line
    //--------------------------------------------------------------------------------
    public String toString()
    {
        String message = "";

        if(!hasNoMember())
        {
            for (T member : aList) {
                message += member.toString();
            }
        }
        else
        {
            message = "There are no members in the group.";
        }

        return message;
    }
}
