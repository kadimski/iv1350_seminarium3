package integration;

/**
 * This is a representation of the display containing all its functions.
 */

public class Display
{
    private int queueNumber = 0;
    
    /**
     * This function increments and prints out <code>queueNumber</code>.
     */    
    public void updateCurrentNumber()
    {
        queueNumber += 1;
        System.out.println("Queue number: " + queueNumber);
    }   
}