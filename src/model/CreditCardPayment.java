package model;

/**
 * This class represents a credit card payment.
 */

public class CreditCardPayment
{
    private CreditCardDTO creditCardDTO;
    private int amount;
    
    /**
     * Creates a new instance of a <code>CreditCardPayment</code>.
     * 
     * @param creditCardDTO The credit card used for the payment.
     * @param amount The amount that is payed with the credit card.
     */
    public CreditCardPayment(CreditCardDTO creditCardDTO, int amount)
    {
        this.creditCardDTO = creditCardDTO;
        this.amount = amount;
    }

    public int getAmount()
    {
        return amount;
    }
}
