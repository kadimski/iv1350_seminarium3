package controller;

import integration.InspectionDBHandler;
import model.Inspection;
import integration.InspectionDTO;
import integration.Printer;

/**
 * This is the inspection controller which handles all calls involving an inspection.
 */

public class InspectionController
{
    private InspectionDBHandler inspectionDBHandler;
    private Inspection inspection;
    private Printer printer;
    private InspectionDTO[] listOfInspectionDTOs;
    
    /**
     * Creates a new instance of <code>InspectionController</code>.
     * 
     * @param inspectionDBHandler The database handler that handles a database with InspectionDTO:s.
     * @param inspection The class that handles all operations involving an inspection.
     * @param printer The class that represents a real life printer.
     */
    public InspectionController(InspectionDBHandler inspectionDBHandler, Inspection inspection, Printer printer)
    {
        this.inspectionDBHandler = inspectionDBHandler;
        this.inspection = inspection;
        this.printer = printer;
    }
    
    /**
     * Returns the cost for an inspection.
     * 
     * @param regNo The regNo identifiying an inspection.
     * @return The cost for an inspection.
     */
    public int getInspectionCost(String regNo)
    {
        this.listOfInspectionDTOs = inspectionDBHandler.getInspections();
        int cost = this.inspection.getInspectionCost(regNo, listOfInspectionDTOs);
        return cost;
    }
    
    /**
     * Returns the inspection checklist for an inspection, the checklist is the same for every inspection in my program.
     * 
     * @param regNo The regNo identifiying an inspection.
     * @return The checklist for an inspection.
     */
    public String[] getInspectionChecklist(String regNo)
    {
        this.listOfInspectionDTOs = inspectionDBHandler.getInspections();
        String[] inspectionChecklist = this.inspection.getInspectionChecklist(regNo, listOfInspectionDTOs);
        return inspectionChecklist;
    }
    
    /**
     * Updates the inspection results for an inspection.
     * 
     * @param regNo The regNo identifiying an inspection.
     * @param updatedInspectionResults The updated inspection results list for an inspection.
     */
    public void updateInspectionResults(String regNo, boolean[] updatedInspectionResults)
    {
        this.inspection.updateInspectionResults(regNo, listOfInspectionDTOs, updatedInspectionResults);
    }
    
    /**
     * Simulates a scenario of a printer which prints out the inspection results for an inspection.
     * 
     * @param regNo The regNo identifiying an inspection whose results will be printed out.
     */
    public void printInspectionResults(String regNo)
    {
        InspectionDTO inspectionDTO = inspectionDBHandler.getInspectionDTO(regNo);
        printer.printInspectionResults(inspectionDTO);
    }
}