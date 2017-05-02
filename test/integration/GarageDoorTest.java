package integration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the class <code>GarageDoor</code>.
 */

public class GarageDoorTest
{
    private GarageDoor instance;
    ByteArrayOutputStream outContent;
    PrintStream originalSysOut;
    
    @Before
    public void setUp()
    {
        this.instance = new GarageDoor();
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
     * Testing if correct output is printed when calling <code>openGarageDoor</code>, of class <code>GarageDoor</code>.
     */
    @Test
    public void testCorrectOutput()
    {
        instance.openGarageDoor();
        String expResult = "Opening garage door...";
        String result = outContent.toString();
        assertTrue("Incorrect output.", result.contains(expResult));
    }

    /**
     * Testing if correct output is printed when calling <code>closeGarageDoor</code>, of class <code>GarageDoor</code>.
     */
    @Test
    public void testCloseGarageDoor()
    {
        instance.closeGarageDoor();
        String expResult = "Closing garage door...";
        String result = outContent.toString();
        assertTrue("Incorrect output.", result.contains(expResult));
    }
    
}
