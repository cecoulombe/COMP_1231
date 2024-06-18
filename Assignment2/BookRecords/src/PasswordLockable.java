/* From Assignment2, question 1. See the BookDriver notes for more information
 * Create a Java interface named PasswordLockable that includes four methods: setPassword (sets up a password), lock (locks an object with a correct password), 
 * unlock (unlocks an object with a correct password), and isLocked (indicates whether the object is locked).
 * The setPassword, lock, and unlock methods take a String parameter that represents the password. The isLocked method returns true if the object is locked and 
 * false otherwise.
 */

public interface PasswordLockable {
    String setPassword(String newPassword);
    String lock(String password);
    String unlock(String password);
    boolean isLocked();
}
