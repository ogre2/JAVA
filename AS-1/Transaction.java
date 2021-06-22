public abstract class Transaction
{
    private int customerID;
    private int transactNum;

    public Transaction()
    {
        customerID = 0;
        transactNum = 0;
    }

    public Transaction(int customerID, int transactNum) {
        this.customerID = customerID;
        this.transactNum = transactNum;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Transaction)
        {
            Transaction other = (Transaction)obj;

            return this.transactNum == other.transactNum;
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

    public int getTransactionNum()
    {
        return transactNum;
    }

    public String toString()
    {
        return "#" + getTransactionNum();
    }
}