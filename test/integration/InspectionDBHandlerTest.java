package integration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for <code>InspectionDBHandler</code>.
 */

public class InspectionDBHandlerTest
{
    private InspectionDBHandler instance;
    private InspectionDTO[] inspections;
    private String regNo;
    
    @Before
    public void setUp()
    {
        this.instance = new InspectionDBHandler();
        InspectionDTO inspectionDTO1 = new InspectionDTO("ABC123", 'A');
        InspectionDTO inspectionDTO2 = new InspectionDTO("DEF456", 'B');
        InspectionDTO inspectionDTO3 = new InspectionDTO("GHI789", 'C');
        InspectionDTO[] inspections = {inspectionDTO1, inspectionDTO2, inspectionDTO3};
        this.inspections = inspections;
        this.regNo = "GHI789";
    }
    
    @After
    public void tearDown()
    {
        this.instance = null;
        this.inspections = null;
        this.regNo = null;
    }

    /**
     * Testing if <code>getInspectionDTO</code> returns the correct <code>InspectionDTO</code> by comparing the regNo.
     */
    @Test
    public void testGetInspectionDTO()
    {
        String expResult = "GHI789";
        String result = instance.getInspectionDTO(regNo).getRegNo();
        assertEquals("Incorrect InspectionDTO.", expResult, result);
    }
    
}
