package by.htp.onlinecafe.dao.exception;

/**
 * Exception that can happen in dao layer
 */
public class DAOException extends Exception {

    private static final long serialVersionUID = 3384108988464160947L;

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
