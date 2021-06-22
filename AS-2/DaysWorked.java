import java.util.ArrayList;
import java.util.Scanner;

public class DaysWorked 
{
    // Class properties
    private int employeeNum, daysWorked;
    protected ArrayList<Shift> allShifts;

    // Initializing the class properties to default values
    public DaysWorked()
    {
        employeeNum = 0;
        daysWorked = 0;
        allShifts = new ArrayList<>();
    }

    // Initializing the class properties to passed in values
    public DaysWorked(int employeeNum, int daysWorked, ArrayList<Shift> allShifts)
    {
        this.employeeNum = employeeNum;
        this.daysWorked = daysWorked;
        this.allShifts = allShifts;
    }

    // Method to get the employee/babysitter number
    public int getEmployeeNum()
    {
        return employeeNum;
    }

    // Method to get the number of days an employee/babysitter worked
    public int getDaysWorked()
    {
        return daysWorked;
    }

    // Method to get the shifts an employee/babysitter worked
    public ArrayList<Shift> getAllShifts()
    {
        return allShifts;
    }

    // Printing out the employee/babysitter number, number of days worked, and the shifts
    public String toString()
    {
        return "Employee #000" + getEmployeeNum() + ",\t" + "Days Worked: " + getDaysWorked() + "\n" + allShifts.toString().replace("[", "").replace("]", "")+ "\n";
    }

    // Reading in the days a babysitter/employee works from a file
    public static DaysWorked read(Scanner sc)
    {
        if(!sc.hasNext())
        {
            return null;
        }

        int employeeNum = Integer.parseInt(sc.next());
        int daysWorked = Integer.parseInt(sc.next());
        ArrayList<Shift> allShifts = new ArrayList<>();

        for(int i = 0; i < daysWorked; i++)
        {
            Shift shift = Shift.read(sc);

            allShifts.add(shift);
        }

        return new DaysWorked(employeeNum, daysWorked, allShifts);
    }
}
