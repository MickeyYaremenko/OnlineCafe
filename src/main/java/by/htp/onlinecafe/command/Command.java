package by.htp.onlinecafe.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mike Yaremenko on 15.06.2017.
 */
public interface Command {
    String execute(HttpServletRequest request);
}
