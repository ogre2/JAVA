import java.util.Scanner;

public class Info
{

    // Class properties
    private String lName, fName;
    String streetName, zoneInfo;

    // Initializing the class properties to empty strings
    public Info()
    {
        lName = "";
        fName = "";
        streetName = "";
        zoneInfo = "";
    }

    /**
     * Initializing the class properties to passed in string values
     * @param lName
     * @param fName
     */
    public Info(String lName, String fName, String streetName, String zoneInfo)
    {
        this.lName = lName;
        this.fName = fName;
        this.streetName = streetName;
        this.zoneInfo = zoneInfo;
    }

    // Method that returns the last name
    public String getLName()
    {
        return lName.replace(",", "");
    }

    // Method that returns the first name
    public String getFName()
    {
        return fName;
    }

    // Method that returns the full name
    public String getName()
    {
        return getLName() + ", " + getFName();
    }

    // Method that returns the street name
    public String getStreet()
    {
        return streetName;
    }

    // Method that returns the zone info
    public String getZone()
    {
        return zoneInfo;
    }

    // toString method of the class
    @Override
    public String toString()
    {
        // Returning string format "last name, first name"
        return getLName() + ", " + getFName() + "\n" + getStreet() + "\n" + getZone();
    }

    /**
     * Method that reads in a new name using a scanner passed in to
     * read the string values for last and first name
     * @param sc
     * @return
     */
    public static Info read(Scanner sc)
    {
        // If scanner has no more lines to read
        if(!sc.hasNext())
        {
            // Return null
            return null;
        }

        String lName = sc.next();
        String fName = sc.next();

        sc.nextLine();

        String streetName = sc.nextLine();
        String zoneInfo = sc.nextLine();

        return new Info(lName, fName, streetName, zoneInfo);
    }
}
