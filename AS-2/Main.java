import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        // Output filewriter
        FileWriter output = new FileWriter("output.txt");

        // Personell file scanner
        Scanner personnel = new Scanner(new File("personnel.txt"));
        // Payroll file scanner
        Scanner payroll = new Scanner(new File("payroll.txt"));

        // Arraylist of employees
        ArrayList<BabySitter> employees = new ArrayList<BabySitter>();
        // Arraylist of people on payroll
        ArrayList<DaysWorked> onPayroll = new ArrayList<>();

        // Scanning through personnel file
        while(personnel.hasNext())
        {
            // Creating a new babysitter from read in information from file
            BabySitter babySitter = BabySitter.read(personnel);
            // Adding babysitter to the employees list
            employees.add(babySitter);
        }

        // Scanning through payroll file
        while(payroll.hasNext())
        {
            // Creating new entry for shifts worked by employees on payroll
            DaysWorked daysWorked = DaysWorked.read(payroll);

            // Adding to the list of employees on payroll
            onPayroll.add(daysWorked);
        }

        // Iterating through list of babysitters/employees
        for(BabySitter babySitter : employees)
        {
            // Iterating through list of workers on payroll
            for(DaysWorked daysWorked : onPayroll)
            {
                // If the baysitter number and employee on payroll numbers match
                if(daysWorked.getEmployeeNum() == babySitter.getEmployeeNum())
                {
                    // Move the shifts from the payroll to the babysitter
                    babySitter.shifts.addAll(daysWorked.getAllShifts());
                }
            }
        }

        // Calling the list sort method
        sort(employees);
        // Calling the output print method
        print(employees, output);

        // Closing scanners and filewriters
        payroll.close();
        personnel.close();
        output.close();
    }

    // Method to prints to output file the list of employees/babysitters
    public static void print(ArrayList<BabySitter> employees, FileWriter output) throws Exception
    {
        // Iterate through list
        for (BabySitter babySitter : employees) {
            // Print to outputfile each item in the list
            output.write(babySitter.toString() + "\n");
        }
    }

    // Method that sorts the list of employees/babysitters alphabetically by last name
    public static void sort(ArrayList<BabySitter> employees)
    {
        // Comparing baysitters and sorting them from one another
        employees.sort((o1, o2) -> o1.getInfo().getLName().compareTo(o2.getInfo().getLName()));
    }
}
