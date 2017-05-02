package model;

/**
 * This class represents the inspection comapny's balance/bank account.
 */

public class InspectionCompanyBalance
{
    private int balance;
    
    /**
     * Creates a new instance of <code>InspectionComapnyBalance</code>.
     */
    public InspectionCompanyBalance()
    {
        this.balance = 1000;
    }
    
    /**
     * Updates the current balance.
     * 
     * @param creditCardPayment The payment whose amount will be added to the balance/bank account.
     */
    public void updateBalance(CreditCardPayment creditCardPayment)
    {
        this.balance += creditCardPayment.getAmount();
        System.out.println("New inspection comapany balance is: " + balance + " SEK.");
    }
    
    public int getBalance()
    {
        return balance;
    }
}
