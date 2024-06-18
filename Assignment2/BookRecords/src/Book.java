/* From Assignment2, question 1. See the BookDriver notes for more information
 * Create a class named Book with six private attributes: an alpha-numeric book code, a title, a price, a genre, a password, and a boolean attribude 
 * named bookIsLocked. Define accessor/mutator methods for code, title, price, and genre. Define also a method to convert the genre (which is an integer) 
 * to a text description. For the password, only a mutator is needed since reading a password is not permitted in general.
 * 
 * Make the class Book follow some standard when dealing with genre, password, and a comparison between two book records. Therefore, book with implement 
 * the Genre interface, the passwordLockable interface, and the comparable interface.
 * 
 * Add code statements to the mutator methods defined in Book to ensure that any update on any attribute of a book record can be performed only if the 
 * book record is unlocked. If the record is locked, the mutator methods will only output a warning message saying "... record is locked ... no update 
 * performed".
 * 
 * Define the compareTo method in Book to allow comparison of the prices between two book records. The application must use the compareTo method as part 
 * of the program design to identify the book(s) with the highest price.
 * 
 */

 import java.text.DecimalFormat;

public class Book implements Genre, PasswordLockable, Comparable<Book>{

    // methods for Book itself need to include a getter and setter for each book as well as a toString
    
    // Varibles
    String idCode;
    String title;
    double price;
    int genre;

    String password;
    boolean bookIsLocked;

    // number format
    DecimalFormat fmt = new DecimalFormat("0.00");



    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // Book() creates the book object using the book code, name, price, and genre
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    public Book(String idCode, String title, double price, int genre)
    {
        setIdCode(idCode);
        setTitle(title);
        setPrice(price);
        setGenre(genre);
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // modifyBook() changes the information of the book
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    public String modifyBook(String idCode, String title, double price, int genre)
    {
        if(!isLocked())
        {
            setIdCode(idCode);
            setTitle(title);
            setPrice(price);
            setGenre(genre);
            return getTitle() + " was successfully modified";
        }
        return "Book " + getIdCode()+ " is locked and could not be modified. Please enter the correct password to modify the book";

    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // setIdCode() sets the alpha-numeric code used to identify the book
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    private void setIdCode(String idCode)
    {
        this.idCode = idCode;

        return;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // getIdCode() returns the alpha-numeric code used to identify the book
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    public String getIdCode()
    {
        return idCode;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // setTitle() sets the title of the book
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    private void setTitle(String title)
    {
        this.title = title;

        return;
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // getTitle() returns the title of the book
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    public String getTitle()
    {
        return title;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // setPrice() sets the price of the book
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    private void setPrice(double price)
    {
        this.price = price;

        return;
    }
   
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // getPrice() returns the price of the book
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    public double getPrice()
    {
        return price;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // getGenreText() returns the textual description of the genre of the book
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    public String getGenreText() 
    {
        switch(getGenre())
        {
            case 1:
            {
                return "Action";
            }
            case 2:
            {
                return "Comedy";
            }
            case 3:
            {
                return "Autobiography";
            }
            default:
            {
                return "Unclassified";
            }
        }
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // toString() returns the relevant information about the book
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    public String toString()
    {
        return "Book code: " + getIdCode() + " \tTitle: " + getTitle() + "\tPrice: " + fmt.format(getPrice()) + "\tGenre: " + getGenreText() + "\n";
    }

    // *** methods from the Genre interface ***

    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // setGenre() sets the genre of the initialized book as the passed string
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    public void setGenre(int genre)
    {
        this.genre = genre;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // getGenre() sets the genre of the initialized book as the passed string
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    public int getGenre()
    {
        return 1;
    }

    // *** methods from the PasswordLockable interface ***

    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // setPassword() sets a password used to lock and access the records
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    public String setPassword(String newPassword)
    {
        password = newPassword;
        return "A new password has been set for book " + getIdCode()+ ".";
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // lock() locks the book
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    public String lock(String password)
    {
        bookIsLocked = true;
        return "The book " + getIdCode()+ " record has been locked.";
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // unlock() unlockes the book using the password
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    public String unlock(String passwordGuess)
    {
        if(password.compareTo(passwordGuess) == 0)
        {
            bookIsLocked = false;
            return "The book " + getIdCode()+ " record has been unlocked.";
        }

        return "Invalid password. The book " + getIdCode() + " record is locked.";
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // isLocked() returns the locked status of the book
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    public boolean isLocked()
    {
        return bookIsLocked;
    }

    // *** methods from the Comparable interface ***

    //--------------------------------------------------------------------------------------------------------------------------------------------------
    // compareTo()return if object1 is greater than, equal to, or less than object2
    //--------------------------------------------------------------------------------------------------------------------------------------------------
    public int compareTo(Book other)
    {
        if(this.getPrice() > other.getPrice())
        {
            return 1;
        }
        else if(this.getPrice() < other.getPrice())
        {
            return -1;
        }

        return 0;
    }
}
