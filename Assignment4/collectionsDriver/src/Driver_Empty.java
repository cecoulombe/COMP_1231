/* Author: Caitlin Coulombe, T00756521
 * Date: August 10, 2024
 * Course: COMP 1231
 * Assignment 4 Question 1: Design an implement a Java application that helps a company to handle the selection of applicants for a few typist positions. To qualify as a candidate for the job position, the applicant must be able to type at a speed of minimum 60 wpm. The applicatin will select those who have fulfilled the typing speed requirements and creates a list of qualified candidates. The candidates will then be sorted in descending order according to their typing speeds.
 *      * create a class Application (details in the class source files)
 *      * create a generic class Group (details in the class source files)
 *      * create a driver class to test the application.
 *          * The driver program will first create a group of applicants (i.e. applicantList) using the Applicant class and the Group generic class
 *          * Create a standard applicant (i.e. standard) with the minimum tying speed requirement. 
 *          * Add between 8 and 10 applicants to applicantList. Form a candidate list of applicants who have fulfilled the typing speed requirement (i.e. compare each applicant with the standard)
 *          * Remove the last candidate, who was the last one submitting the application, from applicantList. 
 *          * Sort the final list of candidates in a descending order according to their typing speed
 *          * Output the applicants details from applicantList only if there are applicants in applicantList. If there is no applicant or candidate in the list, a message "No applicant.candidate ..." should be displayed
 * 
 * Note: You may use Collections.sort() to sort the applicants. since such a sort() method works on a regular ArrayList instance, you may need to copy applicationList to a regular ArrayLIst instance in order to use the method.
 * 
 * There is an example output that you should be able to reproduce.
 * 
 */

 import java.util.ArrayList;
 import java.util.Collections;
import java.util.NoSuchElementException;

public class Driver_Empty {
    public static void main(String[] args) throws Exception {
        // variables and objects
        Group<Applicant> applicantList = new Group<Applicant>();
        Group<Applicant> rejectList = new Group<Applicant>();

        Applicant standard = new Applicant("Standard", 60);

        // add applicants to the list
        // no applicants added for this example

        // print the applicants who have applied for the job
        System.out.println("The following applicants are applying for the job:\n" + applicantList);

        // print the total number of applicants
        System.out.println("Total number of applicants: " + applicantList.getNumberOfMembers() + "\n");

        // copmare candidates to the standard of 60 wpm
        for (Applicant applicant : applicantList.getMembers()) {
            if(applicant.getTypeSpeed() < standard.getTypeSpeed())
            {
                try {
                    applicantList.removeFromGroup(applicant);
                    rejectList.addToGroup(applicant);
                } catch (NoSuchElementException e) {
                    System.out.println(e.getMessage() + "\n");
                }
                
            }
        }

        // print the rejects
        String messageReject = "";
        if(!rejectList.hasNoMember())
        {
            // messageReject = rejectList.toString();
            for (Applicant applicant : rejectList.getMembers()) {
                messageReject += "Remove:\t" + applicant.toString();
            }
        }
        else
        {
            messageReject = "No applicants failed the speed test requirements.\n";
        }
        System.out.println("Applicants who do not fulfill typing speed test requirement:\n" + messageReject);

        // print the candidates
        String messageAppList = "";
        if(!applicantList.hasNoMember())
        {
            messageAppList = applicantList.toString();

        }
        else
        {
            messageAppList = "No candidate has been selected!\n";
        }
        System.out.println("Candidates who have fulfilled typing speed test requirement:\n" + messageAppList);

        // remove the last candidate the submitted the application
        String messageRemove = "";
        try {
            Applicant removedApplicant = applicantList.removeFromGroup();
            messageRemove = "Remove:\t" +removedApplicant.toString();
        } catch (NoSuchElementException e) {
            messageRemove = e.getMessage() + "\n";
        }
        System.out.println("The following candidate who submitted the application last has been removed from the list:\n" + messageRemove);

        

        // sort the candidates in descending order
        ArrayList<Applicant> sortedApplicants = applicantList.getMembers();
        Collections.sort(sortedApplicants);

        // print the candidates in sorted order
        // additional formatting was added due to the sorting becuase is no longer a group, it is a ArrayList
        String messageSorted = "";

        if(!sortedApplicants.isEmpty())
        {
            for (Applicant applicant : sortedApplicants) {
                messageSorted += applicant;
            }
        }
        else
        {
            messageSorted = "No candidate in the list.\n";
        }
        System.out.println("The candidates are sorted in a descending order based on their typing speed:\n" + messageSorted);
    }
}
