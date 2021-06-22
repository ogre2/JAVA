import java.util.Scanner;

public class Time
{
    // Class properties
    protected int hour, minutes;

    // Initializing the class properties to 0
    public Time()
    {
        hour = 0;
        minutes = 0;
    }

    // Initializing the class properties to passed in integers
    public Time(int hour, int minutes)
    {
        this.hour = hour;
        this.minutes = minutes;
    }

    // Method to get the hour
    public int getHour()
    {
        return hour;
    }

    // Method to set the hour
    public void setHour(int hour)
    {
        this.hour = hour;
    }

    // Method to get the minutes
    public int getMinutes()
    {
        return minutes;
    }

    // Method to set the minutes
    public void setMinutes(int minutes)
    {
        this.minutes = minutes;
    }

    // Printing out the full time (hour : minutes)
    @Override
    public String toString()
    {
        if(minutes <= 1)
        {
            return hour + ":" + minutes + "0";
        }
        else
        {
            return hour + ":" + minutes;
        }
    }

    // Reading in a time from a file
    public static Time read(Scanner sc)
    {
        if(!sc.hasNext())
        {
            return null;
        }

        String s = sc.next(); //instead of nextLine()
        String arr[] = s.split(":");
        int hour = Integer.parseInt(arr[0]);
        int minutes = Integer.parseInt(arr[1]);

        return new Time(hour, minutes);
    }
}
