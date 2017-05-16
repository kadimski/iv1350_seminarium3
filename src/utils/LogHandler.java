package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class is responsible for the logging.
 */

public class LogHandler
{
    private static final String LOG_FILE_NAME = "inspection-log.txt";
    private PrintWriter logFile;
    
    /**
     * Creates a new instance of a log handler.
     * 
     * @throws IOException If a log file can't be created. 
     */
    public LogHandler() throws IOException
    {
        logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
    }
    
    /**
     * Logs an exception to a .txt-file.
     * 
     * @param exception The excepction that needs to be logged. 
     */
    public void logException(Exception exception) 
    {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append("Exception was thrown: ");
        logMsgBuilder.append(exception.getMessage());
        logFile.println(logMsgBuilder);
        exception.printStackTrace(logFile);
    }
}
