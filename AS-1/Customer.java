import java.util.ArrayList;
import java.util.Scanner;

public class Customer
{
    private int customerID;
    private String customerName;
    protected double balance;
    private ArrayList<Transaction> transactions;

    public Customer()
    {
        customerID = 0;
        customerName = "";
        balance = 0;
    }

    public Customer(int customerID, String customerName, double balance)
    {
        this.customerID = customerID;
        this.customerName = customerName;
        this.balance = balance;
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction)
    {
        transactions.add(transaction);
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Customer)
        {
            Customer other = (Customer)obj;

            return this.customerID == other.customerID;
        }
        else
        {
            return false;
        }
    }

    public int getCustomerID()
    {
        return customerID;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public double getBalance()
    {
        return balance;
    }

    public ArrayList<Transaction> getTransactions()
    {
        return transactions;
    }

    public double balanceChange()
    {
        for (Transaction transaction : transactions)
        {
            if (transaction instanceof Order)
            {
                Order order = (Order)transaction;

                balance = balance + order.getTotalCost();
            }
            else if (transaction instanceof Payment)
            {
                Payment payment = (Payment)transaction;

                balance = balance - payment.getPaidAmount();
            }
        }

        return balance;
    }

    public String toString()
    {
        String data = "";

        data = data + getCustomerName() + "\t\t" + getCustomerID() + "\n\t\t\t" + 
        "Previous Balance" + "\t\t$" + getBalance() + "\n\n";

        for (Transaction transaction : transactions)
        {
            data = data + transaction.toString() + "\n";
        }

        data = data + "\n\t\t\tBalance Due" + "\t\t\t$" + String.format("%.2f", balanceChange()) + "\n\n";

        return data;
    }

    public Customer read(Scanner sc)
    {
        if (!sc.hasNext())
        {
            return null;
        }
        else
        {
            int customerID = sc.nextInt();
            String customerName = sc.next();
            double customerBalance = sc.nextDouble();

            return new Customer(customerID, customerName, customerBalance);
        }
    }
}
