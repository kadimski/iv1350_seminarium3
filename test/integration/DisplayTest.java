package integration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the class <code>Display</code>.
 */

public class DisplayTest
{
    private Display instance;
    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;
    
    @Before
    public void setUp()
    {
        this.instance = new Display();
        this.originalSysOut = System.out;
        this.outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }
    
    @After
    public void tearDown()
    {
        this.instance = null;
        this.outContent = null;
        System.setOut(originalSysOut);
    }

    /**
     * Testing if correct output is printed when calling <code>updateCurrentNumber</code> once.
     */
    @Test
    public void testCorrectOutput()
    {
        instance.updateCurrentNumber();
        String expResult = "Queue number: 1";
        String result = outContent.toString();
        assertTrue("Incorrect output.", result.contains(expResult));
    }
    
    /**
     * Tesing if correct output is printed when calling <code>updateCurrentNumber</code> twice.
     */
    @Test
    public void testNumberIncrementedCorrectly()
    {
        instance.updateCurrentNumber();
        instance.updateCurrentNumber();
        String expResult = "Queue number: 2";
        String result = outContent.toString();
        assertTrue("Incorrect output.", result.contains(expResult));
    }
}
