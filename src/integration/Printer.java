package integration;

import model.CreditCardPayment;

/**
 * This class represents a model of a real printer. 
 */

public class Printer
{
    /**
     * Simulates a printer printing out inspection results.
     * 
     * @param inspection The <code>InspectionDTO</code> whose inspection results will be printed out.
     */
    public void printInspectionResults(InspectionDTO inspection)
    {
        boolean[] inspectionResults = inspection.getInspectionResults();
        System.out.println("Inspection results for regNo " + inspection.getRegNo() + ":");
        System.out.println("1. Engine, pass = " + inspectionResults[0]);
        System.out.println("2. Steering, pass = " + inspectionResults[1]);
        System.out.println("3. Brakes, pass = " + inspectionResults[2]);
        System.out.println("4. Headlights, pass = " + inspectionResults[3]);
    }
    
    /**
     * Simulates a printer printing out a payment receipt.
     * 
     * @param creditCardPayment The payment that will be printed out.
     */
    public void printPaymentReceipt(CreditCardPayment creditCardPayment)
    {
        int paymentAmount = creditCardPayment.getAmount();
        System.out.println("Total inspection cost is " + paymentAmount + " SEK.");
    }
}
