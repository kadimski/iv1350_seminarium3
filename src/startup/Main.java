package startup;

import view.View;
import controller.GarageController;
import controller.InspectionController;
import controller.PaymentController;
import integration.Display;
import integration.GarageDoor;
import integration.InspectionDBHandler;
import integration.PaymentAuthorizationSystem;
import integration.Printer;
import java.io.IOException;
import model.Inspection;
import model.InspectionCompanyBalance;
import model.RegNoNotFoundException;

/**
 * This is the <code>main</code> used to startup the program.
 */

public class Main
{
    /**
     * Starts the program and executes hardcoded inputs from the <code>View</code>.
     * 
     * @param args The program does not take any command line parameters.
     * 
     * @throws RegNoNotFoundException If the regNo that is entered can't found.
     * @throws IOException If a log file can't be created.
     */
    public static void main(String[] args) throws RegNoNotFoundException, IOException
    {
        Display display = new Display();
        GarageDoor garageDoor = new GarageDoor();
        
        InspectionDBHandler inspectionDBHandler = new InspectionDBHandler();
        Inspection inspectionManager = new Inspection();
        
        Printer printer = new Printer();
        PaymentAuthorizationSystem paymentAuthorizationSystem = new PaymentAuthorizationSystem();
        InspectionCompanyBalance inspectionCompanyBalance = new InspectionCompanyBalance();
        
        GarageController garageContr = new GarageController(display, garageDoor);
        InspectionController inspectionContr = new InspectionController(inspectionDBHandler, inspectionManager, printer);
        PaymentController paymentContr = new PaymentController(paymentAuthorizationSystem, printer, inspectionCompanyBalance);
        
        new View(garageContr, inspectionContr, paymentContr).sampleExecution();
    }  
}
