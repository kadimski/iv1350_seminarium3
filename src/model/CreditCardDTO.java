package model;

/**
 * This class represents a credit card and its information.
 */

public class CreditCardDTO
{
    private int creditCardNumber;
    private String expirationDate;
    private int CVC;
    
    /**
     * Creates a new instance of a <code>CreditCardDTO</code>.
     * 
     * @param creditCardNumber The credit card number for a credit card.
     * @param expirationDate The expiration date for a credit card.
     * @param CVC The CVC code for a credit card.
     */
    public CreditCardDTO (int creditCardNumber, String expirationDate, int CVC)
    {
        this.creditCardNumber = creditCardNumber;
        this.expirationDate = expirationDate;
        this.CVC = CVC;
    }
    
    public int getCreditCardNumber()
    {
        return creditCardNumber;
    }
    
    public String getExpirationDate()
    {
        return expirationDate;
    }
    
    public int getCVC()
    {
        return CVC;
    }
}
