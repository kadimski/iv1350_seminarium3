package integration;

import model.CreditCardDTO;
import model.CreditCardPayment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the class <code>PaymentAuthorizationSystem</code>.
 */

public class PaymentAuthorizationSystemTest
{
    private CreditCardDTO creditCardDTO;
    private int testAmount;
    private CreditCardPayment creditCardPayment;
    private PaymentAuthorizationSystem instance;
    
    @Before
    public void setUp()
    {
        this.creditCardDTO = new CreditCardDTO(123456789, "01-01", 123);
        this.testAmount = 100;
        this.creditCardPayment = new CreditCardPayment(creditCardDTO, testAmount);
        this.instance = new PaymentAuthorizationSystem();
    }
    
    @After
    public void tearDown()
    {
        this.creditCardDTO = null;
        this.testAmount = 0;
        this.creditCardPayment = null;
        this.instance = null;
    }

    /**
     * Testing if <code>authorizePayment</code> returns true if the argument is <code>instanceof</code> <code>CreditCardPayment</code>.
     */
    @Test
    public void testArgumentOfCorrectType()
    {
        boolean expResult = true;
        boolean result = instance.authorizePayment(creditCardPayment);
        assertEquals("Incorrect argument type." , expResult, result);
    }
    
    /**
     * Testing if <code>authorizePayment</code> returns false if the argument is not <code>instanceof</code> <code>CreditCardPayment</code>.
     */
    @Test
    public void testArgumentOfIncorrectType()
    {
        boolean expResult = false;
        boolean result = instance.authorizePayment(null);
        assertEquals("Correct argument type." , expResult, result);
    }
}
