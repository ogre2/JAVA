import java.util.Scanner;

public class Payment extends Transaction
{
    private double paidAmount;

    public Payment()
    {
        paidAmount = 0;
    }

    public Payment(int customerID, int transactionNum, double paidAmount)
    {
        super(customerID, transactionNum);
        this.paidAmount = paidAmount;
    }

    public double getPaidAmount()
    {
        return paidAmount;
    }

    @Override
    public String toString()
    {
        return super.toString() + "\t\t" + "Payment\t\t" + String.format("%.2f", getPaidAmount());
    }

    public static Payment read(Scanner sc)
    {
        if (!sc.hasNext())
        {
            return null;
        }

        return new Payment(sc.nextInt(), sc.nextInt(), sc.nextDouble());
    }
}