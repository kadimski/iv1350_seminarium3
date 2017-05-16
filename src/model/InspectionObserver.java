package model;

/**
 * A listener interface for receiving notifications about passed and failed inspections.
 */

public interface InspectionObserver
{
    /**
     * Invoked when an inspection is passed.
     */
    void passedInspection();
    
    /**
     * Invoked when an inspection fails.
     */
    void failedInspection();
}
