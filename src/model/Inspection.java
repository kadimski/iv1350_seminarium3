package model;

import integration.InspectionDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the class that handles operations involving different InspectionDTO:s.
 */

public class Inspection
{
    private List<InspectionObserver> inspectionObservers = new ArrayList<>();
    
    /**
     * Returns the inspection cost for an inspection.
     * 
     * @param regNo The regNo identifiying an inspection.
     * @param inspections An array of InspectionDTO:s.
     * @return The cost for an inspection.
     * 
     * @throws RegNoNotFoundException If the regNo isn't found.
     */
    public int getInspectionCost(String regNo, InspectionDTO[] inspections) throws RegNoNotFoundException
    {
        int cost = 0;
        boolean regNoFound = false;
        
        for (int i = 0; i < inspections.length; i++)
        {
            if(inspections[i].getRegNo().equals(regNo))
            {
                cost = inspections[i].getCost();
                regNoFound = true;
            }
            if(regNoFound == false)
                throw new RegNoNotFoundException(regNo);
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
     * Updates the inspection results for an inspection and notifies the <code>InspectionStatsView</code> if the inspection passed or failed.
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
        
        if(inspectionPass(updatedInspectionResults))
            notifyPassedObservers();
        else
            notifyFailedObservers();
    }
    
    private void notifyPassedObservers() 
    {
        for (InspectionObserver obs : inspectionObservers) 
            obs.passedInspection();
    }
    
    private void notifyFailedObservers() 
    {
        for (InspectionObserver obs : inspectionObservers) 
            obs.failedInspection();
    }
    
    private boolean inspectionPass(boolean[] inspectionChecklist)
    {
        boolean InspectionPass = true;
        
        for (int i = 0; i < inspectionChecklist.length; i++)
        {
            if(inspectionChecklist[i] == false)
                InspectionPass = false;
        }
        
        return InspectionPass;
    }
    
    /**
     * Adds an <code>InspectionObserver</code>.
     * 
     * @param obs The observer that will be added.
     */
    public void addInspectionObserver(InspectionObserver obs) 
    {
        inspectionObservers.add(obs);
    }
    
    /**
     * Adds a list of <code>InspectionObserver</code>.
     * 
     * @param observers The list of observers that will be added.
     */
    public void addInspectionObservers(List<InspectionObserver> observers)
    {
        inspectionObservers.addAll(observers);    
    }
}
