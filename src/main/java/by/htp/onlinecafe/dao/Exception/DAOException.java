package by.htp.onlinecafe.dao.Exception;

/**
 * Created by Mike Yaremenko on 18.06.2017.
 */
public class DAOException extends Exception {

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Exception e) {
        super(message, e);
    }

    public DAOException(Exception e) {
        super(e);
    }
}
