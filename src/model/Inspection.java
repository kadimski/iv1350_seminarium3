package model;

import integration.InspectionDTO;

/**
 * This is the class that handles operations involving different InspectionDTO:s.
 */

public class Inspection
{
    /**
     * Returns the inspection cost for an inspection.
     * 
     * @param regNo The regNo identifiying an inspection.
     * @param inspections An array of InspectionDTO:s.
     * @return The cost for an inspection.
     */
    public int getInspectionCost(String regNo, InspectionDTO[] inspections)
    {
        int cost = 0;
        for (int i = 0; i < inspections.length; i++)
        {
            if(inspections[i].getRegNo().equals(regNo))
                cost = inspections[i].getCost();
        }
        
        return cost;
    }
    
    /**
     * Returns the inspection checklist for an inspection.
     * 
     * @param regNo The regNo identifiying an inspection.
     * @param inspections An array of InspectionDTO:s.
     * @return The inspection checklist for an inspection.
     */
    public String[] getInspectionChecklist(String regNo, InspectionDTO[] inspections)
    {
        String[] inspectionChecklist = new String[4];
        for (int i = 0; i < inspections.length; i++)
        {
            if(inspections[i].getRegNo().equals(regNo))
                inspectionChecklist = inspections[i].getInspectionChecklist();
        }
        
        return inspectionChecklist;
    }
    
    /**
     * Updates the inspection results for an inspection.
     * 
     * @param regNo The regNo identifiying an inspection.
     * @param inspections An array of InspectionDTO:s.
     * @param updatedInspectionResults The inspection results for an inspection.
     */
    public void updateInspectionResults(String regNo, InspectionDTO[] inspections, boolean[] updatedInspectionResults)
    {
        for (int i = 0; i < inspections.length; i++)
        {
            if(inspections[i].getRegNo().equals(regNo))
                inspections[i].updateInspectionResults(updatedInspectionResults);
        }
    }
}
