package analysis.in.java.util;

/**
 * Exception class for access in empty containers
 * such as stacks, queues, and priority queues.
 */
public class CycleFoundException extends RuntimeException
{
    /**
     * Construct this exception object.
     * @param message the error message.
     */
    public CycleFoundException( String message )
    {
        super( message );
    }
    
    public CycleFoundException()
    {
        this("cycle found");
    }
}