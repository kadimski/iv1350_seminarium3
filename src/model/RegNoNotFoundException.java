package model;

/**
 * Thrown when trying to search for an unexisting regNo.
 */

public class RegNoNotFoundException extends Exception
{
    private String regNoThatCantBeFound;
    
    /**
     * Creates a new instance with a message specifying that the searched regNo can't found.
     * 
     * @param regNoThatCantBeFound The regNo that can't be found.  
     */
    public RegNoNotFoundException(String regNoThatCantBeFound) 
    {
        super("Unable to find regNo " + regNoThatCantBeFound + " please try again.");
        this.regNoThatCantBeFound = regNoThatCantBeFound;
    }
    
    /**
     * @return The regNo that can't be found. 
     */
    public String getRegNoThatCantBeFound()
    {
        return regNoThatCantBeFound;
    }
}
