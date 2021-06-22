import java.util.Scanner;

public class Rates 
{
    // Class properties
    private double firstRate, secondRate, thirdRate;

    // Initializing the class properties to 0
    public Rates()
    {
        firstRate = 0;
        secondRate = 0;
        thirdRate = 0;
    }

    // Initializing the class properties to passed in values
    public Rates(double firstRate, double secondRate, double thirdRate)
    {
        this.firstRate = firstRate;
        this.secondRate = secondRate;
        this.thirdRate = thirdRate;
    }

    // Method to get the before 9PM babysitter rate
    public double getFirstRate()
    {
        return firstRate;
    }

    // Method to get the between 9PM and midnight babysitter rate
    public double getSecondRate()
    {
        return secondRate;
    }

    // Method to get the after midnight babysitter rate
    public double getThirdRate()
    {
        return thirdRate;
    }

    // Printing out the rates
    @Override
    public String toString()
    {
        return String.format("%.2f", firstRate) + "\t" + String.format("%.2f", secondRate) + "\t" + String.format("%.2f", thirdRate);
    }

    // Reading in the babysitter rates from a file
    public static Rates read(Scanner sc)
    {
        if(!sc.hasNext())
        {
            return null;
        }

        return new Rates(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
    }
}
