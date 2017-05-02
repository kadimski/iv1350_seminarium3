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
import model.Inspection;
import model.InspectionCompanyBalance;

/**
 * This is the <code>main</code> used to startup the program.
 */

public class Main
{
    /**
     * Starts the program and executes hardcoded inputs from the <code>View</code>.
     * 
     * @param args The program does not take any command line parameters.
     */
    public static void main(String[] args)
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
                
        new View(garageContr, inspectionContr, paymentContr).sampleExecutionNextCustomer();
        new View(garageContr, inspectionContr, paymentContr).sampleExecutionGetInspectionCost();
        new View(garageContr, inspectionContr, paymentContr).sampleExecutionGetInspectionChecklist();
        new View(garageContr, inspectionContr, paymentContr).sampleExecutionUpdateAndPrintInspectionResults();
        new View(garageContr, inspectionContr, paymentContr).sampleExecutionCreditCardPayment();
        new View(garageContr, inspectionContr, paymentContr).sampleExecutionLetCustomerOut();
    }  
}
