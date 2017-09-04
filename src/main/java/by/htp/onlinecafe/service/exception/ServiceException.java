package by.htp.onlinecafe.service.exception;

/**
 * Exception that can happen in service layer
 */
public class ServiceException extends Exception{

    private static final long serialVersionUID = 1729281414964812274L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Exception e) {
        super(message, e);
    }

    public ServiceException(Exception e) {
        super(e);
    }
}
