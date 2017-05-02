package integration;

/**
 * This is the database handler that is used to fake a real database.
 */

public class InspectionDBHandler
{
    private InspectionDTO[] inspections;
    
    /**
     * Creates a new instance of <code>InspectionDBHandler</code> with hardcoded InspectionDTO:s.
     */
    public InspectionDBHandler()
    {
        InspectionDTO inspectionDTO1 = new InspectionDTO("ABC123", 'A');
        InspectionDTO inspectionDTO2 = new InspectionDTO("DEF456", 'B');
        InspectionDTO inspectionDTO3 = new InspectionDTO("GHI789", 'C');
        InspectionDTO[] inspections = {inspectionDTO1, inspectionDTO2, inspectionDTO3};
        
        this.inspections = inspections;
    }
    
    /**
     * Simulates a database call returning all the inspections.
     * 
     * @return The list of InspectionDTO:s.
     */
    public InspectionDTO[] getInspections()
    {
        return inspections;
    }
    
    /**
     * Simulates a database search for a specific inspection.
     * 
     * @param regNo The regNo identifiying an inspection.
     * @return The <code>InspectionDTO</code> that the user searched after.
     */
    public InspectionDTO getInspectionDTO(String regNo)
    {
        InspectionDTO inspectionDTO = null;
        for (int i = 0; i < inspections.length; i++)
        {
            if(inspections[i].getRegNo().equals(regNo))
                inspectionDTO = inspections[i];
        }
        return inspectionDTO;
    }
}