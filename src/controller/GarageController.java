package controller;

import integration.Display;
import integration.GarageDoor;

/**
 * This is the garage controller which handles all calls involving the garage door and the display.
 */

public class GarageController
{
    private Display display;
    private GarageDoor garageDoor;
    
    /**
     * Creates a new instance of <code>GarageController</code>. 
     * 
     * @param display A model of a display.
     * @param garageDoor A model of a garage door.
     */
    public GarageController(Display display, GarageDoor garageDoor)
    {
        this.display = display;
        this.garageDoor = garageDoor;
    }
    
    /**
     * Increments the current queue number and lets a customer enter the garage.
     */
    public void nextCustomer()
    {
        display.updateCurrentNumber();
        garageDoor.openGarageDoor();
    }
    
    /**
     * Closes the garage door.
     */
    public void closeGarageDoor()
    {
        garageDoor.closeGarageDoor();
    }
    
    /**
     * Lets a customer get out of the garage.
     */
    public void letCustomerOut()
    {
        garageDoor.openGarageDoor();
        garageDoor.closeGarageDoor();
    }
}
