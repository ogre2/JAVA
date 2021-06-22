import java.io.File;
// import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
// import java.io.IOException;
import java.util.Scanner;
// import java.util.ArrayList;

public class Main
{

    public static void main(String[] args) throws Exception
    {
        // ArrayList<Customer> customers = new ArrayList<>();

        File customersFile = new File("customers.txt");
        Scanner cScanner = new Scanner(customersFile);

        FileWriter fw = new FileWriter("output.txt");
        PrintWriter pw = new PrintWriter(fw);
        
        while (cScanner.hasNext())
        {
            Customer customer;
            try
            {
                int customerID = cScanner.nextInt();
                String customerName = cScanner.next();
                double customerBalance = cScanner.nextDouble();

                customer = new Customer(customerID, customerName, customerBalance);

                // customers.add(customer);

                File transactionsFile = new File("transactions.txt");
                Scanner tScanner = new Scanner(transactionsFile);

                while (tScanner.hasNext())
                {
                    Transaction transaction;

                    try
                    {
                        char type = tScanner.next().charAt(0);

                        if (type == 'P')
                        {
                            transaction = Payment.read(tScanner);
                        }
                        else
                        {
                            transaction = Order.read(tScanner);
                        }

                        if (customer.getCustomerID() == transaction.getCustomerID())
                        {
                            customer.addTransaction(transaction);
                        }
                        else
                        {
                            throw new UnknownCustomerException(transaction.getTransactionNum());
                        }
                    }
                    catch (Exception ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                }

                pw.write(customer.toString());

                tScanner.close();
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }

        cScanner.close();

        // for (Customer customer : customers)
        // {
        //     pw.write(customer.toString());
        // }

        pw.close();
    }
}