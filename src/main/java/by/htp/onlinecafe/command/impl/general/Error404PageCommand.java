package by.htp.onlinecafe.command.impl.general;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Opens error404.jsp.
 */
public class Error404PageCommand  implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = ERROR_404_PAGE;
        return page;
    }
}
