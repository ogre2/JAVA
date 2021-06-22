import java.util.Scanner;

public class Name
{
    // Variable that will hold the customer name
    private String customerName;

    /**
     * Initializing the first and last name data fields to empty strings
     */
    public Name() {
        this.customerName = "";
    }

    /**
     * Initializing the customer name with a passed in string value
     * @param first
     */
    public Name(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Class equals method
     */
    @Override
    public boolean equals(Object obj) {
        // Ensuring that the object paramater is of type Name
        if (obj instanceof Name) {
            // Casting the Object paramater to the Name type
            Name other = (Name)obj;
            // Returning boolean evaluation
            return (this.customerName.equals(other.customerName));
        } else {
            // Returning false if the parameter is not of the same type
            return false;
        }
    }

    /**
     * Overriding the toString method of the Object class
     */
    @Override
    public String toString() {
        // Returing string concatening the first and last name
        return customerName;
    }

    /**
     * Creating a new Name object from a scanner read in string
     * @param sc Scanner
     * @return Created Name object
     */
    public static Name read(Scanner sc) {
        // Seeing if the scanner does not have a value to read
        if (!sc.hasNext()) {
            // Returning null
            return null;
        }

        /**
         * Creating and returning the name object
         */
        return new Name(sc.next());
    }
}
