public class UnknownCustomerException extends Exception
{
    public UnknownCustomerException()
    {
        super("Transaction does not have a matching customer record.");
    }
    public UnknownCustomerException(int transactionNum)
    {
        super("Transaction #" + transactionNum + ", does not have a matching customer on record.");
    }
}
