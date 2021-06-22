import java.util.ArrayList;
import java.util.Scanner;

public class BabySitter
{
    // Class properties
    private int employeeNum;
    private Info info;
    private Rates rates;
    protected ArrayList<Shift> shifts;
    private double payment;

    // Initializing class properties to defaults
    public BabySitter()
    {
        employeeNum = 0;
        info = new Info();
        rates = new Rates();
        payment = 0;
    }

    // Initializing class properties to passed in values
    public BabySitter(int employeeNum, Info info, Rates rates)
    {
        this.employeeNum = employeeNum;
        this.info = info;
        this.rates = rates;
        shifts = new ArrayList<>();
    }

    // Getting the employee number
    public int getEmployeeNum()
    {
        return employeeNum;
    }

    // Getting the baby sitter information (name, address)
    public Info getInfo()
    {
        return info;
    }

    // Getting the baby sitter hourly rates
    public Rates getRates()
    {
        return rates;
    }

    // Adding worked shifts to the shifts list
    public void addShift(Shift shift)
    {
        shifts.add(shift);
    }

    // Getting the list of shifts
    public ArrayList<Shift> getShifts()
    {
        return shifts;
    }

    // Calculating the total amount of money earned for all worked shifts
    public double calculatePayment()
    {
        for(Shift shift : shifts)
        {
            double firstSplit = (double)shift.getFirstSplit().getHour() + ((double)shift.getFirstSplit().getMinutes())/60;
            double secondSplit = (double)shift.getSecondSplit().getHour() + ((double)shift.getSecondSplit().getMinutes())/60;
            double thirdSplit = (double)shift.getThirdSplit().getHour() + ((double)shift.getThirdSplit().getMinutes())/60;

            payment += (rates.getFirstRate() * firstSplit) + (rates.getSecondRate() * secondSplit) + (rates.getThirdRate() * thirdSplit);
        }

        // for(Shift shift : shifts)
        // {
        //     System.out.println("First split: " + shift.getFirstSplit());
        //     System.out.println("Second split: " + shift.getSecondSplit());
        //     System.out.println("Third split: " + shift.getThirdSplit());
        //     System.out.println("-----------------------------------------");
        // }

        return payment;
    }

    // To String method
    @Override
    public String toString()
    {
        return info.getName() + "\n" + "Amount Earned: $" + String.format("%.2f", calculatePayment()) + "\n";
    }

    // Reading in a new baby sitter from a file
    public static BabySitter read(Scanner sc)
    {
        if(!sc.hasNext())
        {
            return null;
        }

        return new BabySitter(sc.nextInt(), Info.read(sc), Rates.read(sc));
    }
}