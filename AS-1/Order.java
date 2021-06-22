import java.util.Scanner;

public class Order extends Transaction
{
    private String itemName;
    private int itemsBought;
    private double itemCost;
    private double totalCost;

    public Order()
    {
        itemName = "";
        itemsBought = 0;
        itemCost = 0;
        totalCost = 0;
    }

    public Order(int customerID, int transactionNum, String itemName, int itemsBought, double itemCost)
    {
        super(customerID, transactionNum);
        this.itemName = itemName;
        this.itemsBought = itemsBought;
        this.itemCost = itemCost;
        
        totalCost = itemsBought * itemCost;
    }

    public String getItemName()
    {
        return itemName;
    }

    public int getItemsBought()
    {
        return itemsBought;
    }

    public double getItemCost()
    {
        return itemCost;
    }

    public double getTotalCost()
    {
        return totalCost;
    }

    @Override
    public String toString()
    {
        return super.toString() + "\t\t" + getItemName() + "\t\t" + String.format("%.2f", getTotalCost());
    }

    public static Order read(Scanner sc)
    {
        if (!sc.hasNext())
        {
            return null;
        }

        return new Order(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble());
    }
}