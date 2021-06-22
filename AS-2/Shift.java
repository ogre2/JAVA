import java.util.Scanner;

public class Shift
{
    // Class properties
    private Time clockIn, clockOut;

    // Initializing class properties to default values
    public Shift()
    {
        clockIn = new Time();
        clockOut = new Time();
    }

    // Initializing class properties to passed in values
    public Shift(Time clockIn, Time clockOut)
    {
        this.clockIn = clockIn;
        this.clockOut = clockOut;
    }

    // Getting the shift clock in time
    public Time getClockIn()
    {
        return clockIn;
    }

    // Getting the shift clock out time
    public Time getClockOut()
    {
        return clockOut;
    }

    // Getting the time difference for shift before 9PM
    public Time getFirstSplit()
    {
        Time diff = new Time(0, 0);
        Time split = new Time(9, 0);

        if((clockIn.hour >= 6 && clockIn.hour <= 9) && (clockOut.hour >= clockIn.hour && clockOut.hour <= 9))
        {
            if(clockIn.minutes > clockOut.minutes)
            {
                --clockOut.hour;
                clockOut.minutes += 60;
            }

            diff.minutes = clockOut.minutes - clockIn.minutes;
            diff.hour = clockOut.hour - clockIn.hour;
        }
        else if((clockIn.hour >= 6 && clockIn.hour <= 9) && (clockOut.hour >= 9 && clockOut.hour <= 12))
        {
            diff.hour = 9 - clockIn.hour;
            
            if(clockIn.minutes > split.minutes)
            {
                diff.minutes = clockIn.minutes;
            }
        }
        else if((clockIn.hour >= 6 && clockIn.hour <= 9) && (clockOut.hour >= 0 && clockOut.hour <= 6))
        {
            diff.hour = split.hour - clockIn.hour;

            if(clockIn.minutes > split.minutes)
            {
                diff.minutes = clockIn.minutes;
            }
        }

        if(diff.hour < 0)
            diff = new Time(0, 0);
            
        // return the difference time
        return(diff);
    }

    // Getting the time difference for shift between 9PM and midnight
    public Time getSecondSplit()
    {
        Time diff = new Time(0, 0);
        Time split = new Time(9, 0);

        if((clockIn.hour >= 6 && clockIn.hour <= 9) && (clockOut.hour >= 0 && clockOut.hour <= 6))
        {
            diff.hour = 3;
        }
        else if((clockIn.hour >= 9 && clockIn.hour <= 12) && (clockOut.hour >= clockIn.hour && clockOut.hour <= 12))
        {
            diff.hour = clockOut.hour - clockIn.hour;

            if(clockOut.minutes > clockIn.minutes)
            {
                diff.minutes = clockOut.minutes;
            }
        }
        else if(clockOut.hour >= 9 && clockOut.hour <= 12)
        {
            diff.hour = clockOut.hour - split.hour;

            if(clockOut.minutes == split.minutes)
            {
                diff.minutes = 0;
            }
            else if(clockOut.minutes > split.minutes)
            {
                diff.minutes = clockOut.minutes;
            }
        }

        if(diff.hour < 0)
            diff = new Time(0, 0);
            
        // return the difference time
        return(diff);
    }

    // Getting time difference for shift hours after midnight
    public Time getThirdSplit()
    {
        Time diff = new Time(0, 0);
        if((clockIn.hour >= 0 && clockIn.hour <= 6) && (clockOut.hour >= clockIn.hour && clockOut.hour <= 6))
        {
            if(clockIn.minutes > clockOut.minutes)
            {
                --clockOut.hour;
                clockOut.minutes += 60;
            }

            diff.minutes = clockOut.minutes - clockIn.minutes;
            diff.hour = clockOut.hour - clockIn.hour;
        }
        else if((clockIn.hour <= 12) && (clockOut.hour >= 0 && clockOut.hour <= 6))
        {
            diff.hour = clockOut.hour - 0;
            
            if(clockOut.minutes >= 0)
            {
                diff.minutes = clockOut.minutes;
            }
        }
        

        if(diff.hour < 0)
            diff = new Time(0, 0);
            
        // return the difference time
        return(diff);
    }

    // Printing out the shift clock in and clock out times
    @Override
    public String toString()
    {
        return super.toString() + "\n" + "Clocked in: " + clockIn.toString() + "\t" + "Clocked Out: " + clockOut.toString();
    }

    // Reading in a shift from a file
    public static Shift read(Scanner sc)
    {
        if(!sc.hasNext())
        {
            return null;
        }

        return new Shift(Time.read(sc), Time.read(sc));
    }
}
