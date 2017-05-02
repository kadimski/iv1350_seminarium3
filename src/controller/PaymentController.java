package controller;

import integration.PaymentAuthorizationSystem;
import integration.Printer;
import model.CreditCardPayment;
import model.InspectionCompanyBalance;

/**
 * This is the controller that handles all operations involving payment.
 */

public class PaymentController
{
    private PaymentAuthorizationSystem paymentAuthorizationSystem;
    private Printer printer;
    private InspectionCompanyBalance inspectionCompanyBalance;
    
    /**
     * Creates a new instance of <code>PaymentController</code>.
     * 
     * @param paymentAuthorizationSystem The external system that authorizes payments.
     * @param printer The printer that is used to print out payment receipts.
     * @param inspectionCompanyBalance A model of the company's balance/bank account.
     */
    public PaymentController(PaymentAuthorizationSystem paymentAuthorizationSystem, Printer printer, InspectionCompanyBalance inspectionCompanyBalance)
    {
        this.paymentAuthorizationSystem = paymentAuthorizationSystem;
        this.printer = printer;
        this.inspectionCompanyBalance = inspectionCompanyBalance;
    }
    
    /**
     * Sends a payment authorization request to the payment authorization system, updates the inspection comapany's balance and prints out a payment receipt.
     * 
     * @param creditCardPayment The payment that needs to be authorized and printed out.
     */
    public void creditCardPayment(CreditCardPayment creditCardPayment)
    {
        paymentAuthorizationSystem.authorizePayment(creditCardPayment);
        inspectionCompanyBalance.updateBalance(creditCardPayment);
        printer.printPaymentReceipt(creditCardPayment);
    }
}