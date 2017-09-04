package by.htp.onlinecafe.command;

import javax.servlet.http.HttpServletRequest;

/**
 * The (@Command) interface contains only one method (@code execute).
 * The method handles the request and returns page to be opened.
 */
public interface Command {

    /**
     * The main method that performs inner logic.
     * @param       request the request with parameters
     * @return      page, which will be opened
     */
    String execute(HttpServletRequest request);
}
