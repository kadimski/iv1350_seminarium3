package view;

import controller.GarageController;
import controller.InspectionController;
import controller.PaymentController;
import java.util.Arrays;
import model.CreditCardPayment;
import model.CreditCardDTO;
import model.RegNoNotFoundException;
import utils.LogHandler;
import java.io.IOException;

/**
 * This class is the placeholder for the entire view.
 */

public class View
{
    private GarageController garageContr;
    private InspectionController inspectionContr;
    private PaymentController paymentContr;
    private LogHandler logger;
    
    private String inputRegNo = ("ABC123");
    private int inspectionCost = 200;
    
    /**
     * Creates a new instance of <code>View</code>.
     * 
     * @param garageContr The controller that is used for all garage operations.
     * @param inspectionContr The controller that is used for all inspection operations.
     * @param paymentContr The controller that is used for all payment operations.
     * @throws IOException If a log file can't be created.
     */
    public View(GarageController garageContr, InspectionController inspectionContr, PaymentController paymentContr) throws IOException
    {
        this.garageContr = garageContr;
        this.inspectionContr = inspectionContr;
        inspectionContr.addInspectionObserver(new InspectionStatsView());
        this.paymentContr = paymentContr;
        this.logger = new LogHandler(); 
    }
    
    /**
     * Simulation of all the private sample execution methods.
     * 
     * @throws RegNoNotFoundException If the regNo isn't found.
     */
    public void sampleExecution() throws RegNoNotFoundException  
    {
        try{
        sampleExecutionNextCustomer();
        sampleExecutionGetInspectionCost();
        sampleExecutionGetInspectionChecklist();
        sampleExecutionUpdateAndPrintInspectionResults();
        sampleExecutionCreditCardPayment();
        sampleExecutionLetCustomerOut();
        }catch (RegNoNotFoundException exc){
            System.out.println("Unable to find regNo " + inputRegNo + " please try again.");
            logger.logException(exc);
        }
    }
    
    private void sampleExecutionNextCustomer()
    {
        garageContr.nextCustomer();
        garageContr.closeGarageDoor();
    }
    
    private void sampleExecutionGetInspectionCost() throws RegNoNotFoundException
    {
        int cost = inspectionContr.getInspectionCost(inputRegNo);
        System.out.println("Cost for regNo " + inputRegNo + " is " + cost + " SEK.");
    }
    
    private void sampleExecutionGetInspectionChecklist()
    {
        String[] inspectionChecklist = inspectionContr.getInspectionChecklist(inputRegNo);
        System.out.println("Inspection checklist for regNo " + inputRegNo + " is " + Arrays.toString(inspectionChecklist) + ".");
    }
     
    private void sampleExecutionUpdateAndPrintInspectionResults()
    {
        boolean[] updatedInspectionResults = {true, false, true, true};
        inspectionContr.updateInspectionResults(inputRegNo, updatedInspectionResults);
        inspectionContr.printInspectionResults(inputRegNo);
    }

    private void sampleExecutionCreditCardPayment()
    {
        CreditCardDTO creditCardDTO = new CreditCardDTO(123456789, "01-01", 123);
        CreditCardPayment creditCardPayment = new CreditCardPayment(creditCardDTO, inspectionCost);
        paymentContr.creditCardPayment(creditCardPayment);
    }
    
    private void sampleExecutionLetCustomerOut()
    {
        garageContr.letCustomerOut();
    }
}
