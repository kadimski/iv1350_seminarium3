package integration;

/**
 * This class represents an inspection with its information.
 */

public class InspectionDTO
{
    private String regNo;
    private int cost;
    private char vehicleType;
    private String[] inspectionChecklist = new String[4];
    private boolean[] inspectionResults;
    
    /**
     * Creates a new instance of <code>InspectionDTO</code>.
     * 
     * @param regNo The regNo identifiying an inspection.
     * @param vehicleType The vehicle type of the vehicle being inspected, depending on the type the inspection cost will vary.
     */
    public InspectionDTO(String regNo, char vehicleType)
    {
        this.regNo = regNo;
        
        if(vehicleType == 'a' || vehicleType == 'A')
            this.cost = 200;
        else if(vehicleType == 'b' || vehicleType == 'B')
            this.cost = 300;
        else if(vehicleType == 'c' || vehicleType == 'C')
            this.cost = 400;
        
        this.inspectionChecklist[0] = ("1. Engine");
        this.inspectionChecklist[1] = ("2. Steering");
        this.inspectionChecklist[2] = ("3. Brakes");
        this.inspectionChecklist[3] = ("4. Headlights");
        this.inspectionResults = new boolean[4];
    }
    
    /**
     * Updates the current inspection results.
     * 
     * @param updatedInspectionResults The updated inspection results list. 
     */
    public void updateInspectionResults(boolean[] updatedInspectionResults)
    {
        this.inspectionResults = updatedInspectionResults;
    }
      
    public String getRegNo()
    {
        return regNo;
    }
    
    public int getCost()
    {
        return cost;
    }
    
    public char getVehicleType()
    {
        return vehicleType;
    }
    
    public String[] getInspectionChecklist()
    {
        return inspectionChecklist;
    }
    
    public boolean[] getInspectionResults()
    {
        return inspectionResults;
    }
}