import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        FileWriter output = new FileWriter("output.txt");

        Scanner transactions = new Scanner(new File("transactions.txt"));
        Scanner customers = new Scanner(new File("customers.txt"));

        Transaction transaction = readTransaction(transactions);

        while(customers.hasNext())
        {
            Customer customer = Customer.read(customers);

            while(transactions.hasNext())
            {
                if (customer.getCustomerID() > transaction.getCustomerID())
                {
                    System.out.println("Transaction #" + transaction.getTransactionNum() + " is not matched to customer " + customer.getCustomerID());
                    
                    transaction = readTransaction(transactions);

                    break;
                }
                else if (customer.getCustomerID() == transaction.getCustomerID())
                {
                    customer.addTransaction(transaction);

                    transaction = readTransaction(transactions);
                }
                else
                {
                    break;
                }
            }

            output.write(customer.toString());
        }

        output.close();
    }

    public static Transaction readTransaction(Scanner sc)
    {
        Transaction transaction;

        char type = sc.next().charAt(0);

        if (type == 'P')
        {
            transaction = Payment.read(sc);
        }
        else
        {
            transaction = Order.read(sc);
        }

        sc.nextLine();

        return transaction;
    }

    public static Customer readCustomer(Scanner sc)
    {
        Customer customer = Customer.read(sc);

        return customer;
    }
}