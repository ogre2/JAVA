import java.util.Scanner;

public class Payment extends Transaction
{
    private String type;
    private double paidAmount;

    public Payment()
    {
        type = ""; 
        paidAmount = 0;
    }

    public Payment(int customerID, int transactionNum, String type, double paidAmount)
    {
        super(customerID, transactionNum);
        this.type = type;
        this.paidAmount = paidAmount;
    }

    public double getPaidAmount()
    {
        return paidAmount;
    }

    public String getType()
    {
        return type;
    }

    @Override
    public String toString()
    {
        return super.toString() + "\t\t" + getType() + "\t\t" + String.format("%.2f", getPaidAmount());
    }

    public static Payment read(Scanner sc)
    {
        if (!sc.hasNext())
        {
            return null;
        }

        return new Payment(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextDouble());
    }
}
