package view;

import model.InspectionObserver;

/**
 * Shows the number of passed and failed inspections.
 */

public class InspectionStatsView implements InspectionObserver
{
    private int noOfPassedInspections;
    private int noOfFailedInspections;
    
    /**
     * Creates a new instance of <code>InspectionStatsView</code>.
     */
    public InspectionStatsView()
    {
        noOfPassedInspections = 0;
        noOfFailedInspections = 0;
    }
    
    /**
     * Updates and prints out the number of passed inspecitons.
     */
    @Override
    public void passedInspection()
    {
        noOfPassedInspections += 1;
        printNumberOfPassedAndFailedInspections();
    }
    
    /**
     * Updates and prints out the number of failed inspecitons.
     */
    @Override
    public void failedInspection()
    {
        noOfFailedInspections += 1;
        printNumberOfPassedAndFailedInspections();
    }
               
    private void printNumberOfPassedAndFailedInspections()
    {
        System.out.println("Number of passed inspections: " + noOfPassedInspections);
        System.out.println("Number of failed inspections: " + noOfFailedInspections);
    }
}
