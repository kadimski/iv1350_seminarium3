package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for <code>InspectionCompanyBalance</code>.
 */

public class InspectionCompanyBalanceTest
{
    private CreditCardDTO creditCardDTO;
    private int testAmount;
    private CreditCardPayment creditCardPayment;
    private InspectionCompanyBalance instance;
    
    @Before
    public void setUp()
    {
        this.creditCardDTO = new CreditCardDTO(123456789, "01-01", 123);
        this.testAmount = 400;
        this.creditCardPayment = new CreditCardPayment(creditCardDTO, testAmount);
        this.instance = new InspectionCompanyBalance();
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
     * Testing if <code>updateBalance</code> functions correctly.
     */
    @Test
    public void testUpdateBalance()
    {
        instance.updateBalance(creditCardPayment);
        int expResult = 1400;
        int result = instance.getBalance();
        assertEquals("Incorrect balance amount.", expResult, result);
    }
    
}
