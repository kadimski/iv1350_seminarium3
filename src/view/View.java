package view;

import controller.GarageController;
import controller.InspectionController;
import controller.PaymentController;
import java.util.Arrays;
import model.CreditCardPayment;
import model.CreditCardDTO;

/**
 * This class is the placeholder for the entire view.
 */

public class View
{
    private GarageController garageContr;
    private InspectionController inspectionContr;
    private PaymentController paymentContr;
    
    private String inputRegNo = ("ABC123");
    private int inspectionCost = 200;
    
    /**
     * Creates a new instance of <code>View</code>.
     * 
     * @param garageContr The controller that is used for all garage operations.
     * @param inspectionContr The controller that is used for all inspection operations.
     * @param paymentContr The controller that is used for all payment operations.
     */
    public View(GarageController garageContr, InspectionController inspectionContr, PaymentController paymentContr)
    {
        this.garageContr = garageContr;
        this.inspectionContr = inspectionContr;
        this.paymentContr = paymentContr;
    }
    
    /**
     * Simulation of a display getting updated and a garage door opening and closing.
     */ 
    public void sampleExecutionNextCustomer()
    {
        garageContr.nextCustomer();
        garageContr.closeGarageDoor();
    }
    
    /**
     * Simulation of some inspection cost getting printed out.
     */ 
    public void sampleExecutionGetInspectionCost()
    {
        int cost = inspectionContr.getInspectionCost(inputRegNo);
        System.out.println("Cost for regNo " + inputRegNo + " is " + cost + " SEK.");
    }
    
    /**
     * Simulation of some inspection checklist getting printed out.
     */ 
    public void sampleExecutionGetInspectionChecklist()
    {
        String[] inspectionChecklist = inspectionContr.getInspectionChecklist(inputRegNo);
        System.out.println("Inspection checklist for regNo " + inputRegNo + " is " + Arrays.toString(inspectionChecklist) + ".");
    }
    
    /**
     * Simulation of some inspection results getting updated.
     */ 
    public void sampleExecutionUpdateAndPrintInspectionResults()
    {
        boolean[] updatedInspectionResults = {false, true, false, true};
        inspectionContr.updateInspectionResults(inputRegNo, updatedInspectionResults);
        inspectionContr.printInspectionResults(inputRegNo);
    }
    
    /**
     * Simulation of a credit card payment.
     */
    public void sampleExecutionCreditCardPayment()
    {
        CreditCardDTO creditCardDTO = new CreditCardDTO(123456789, "01-01", 123);
        CreditCardPayment creditCardPayment = new CreditCardPayment(creditCardDTO, inspectionCost);
        paymentContr.creditCardPayment(creditCardPayment);
    }
    
    /**
     * Simulation of a garage door opening and closing.
     */
    public void sampleExecutionLetCustomerOut()
    {
        garageContr.letCustomerOut();
    }
}
