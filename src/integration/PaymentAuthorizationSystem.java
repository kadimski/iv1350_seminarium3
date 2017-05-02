package integration;

import model.CreditCardPayment;

/**
 * This class represents a payment authorization system used in credit card payments.
 */

public class PaymentAuthorizationSystem
{
    /**
     * Authorizes a credit card payment, returns true if the argument is an <code>instanceof</code> <code>CreditCardPayment</code>, otherwise returns false.
     * 
     * @param creditCardPayment The credit card payment that requests to be authorized.
     * @return The value of the authorization.
     */
    public boolean authorizePayment(CreditCardPayment creditCardPayment)
    {
        boolean isPaymentAuthorized = false;
        
        if(creditCardPayment instanceof CreditCardPayment)
            isPaymentAuthorized = true;
        
        System.out.println("Payment authorized = " + isPaymentAuthorized + ".");
        
        return isPaymentAuthorized;
    } 
}
