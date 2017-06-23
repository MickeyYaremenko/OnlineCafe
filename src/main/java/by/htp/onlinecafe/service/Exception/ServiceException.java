package by.htp.onlinecafe.service.Exception;

/**
 * Created by Mike Yaremenko on 18.06.2017.
 */
public class ServiceException extends Exception{

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
