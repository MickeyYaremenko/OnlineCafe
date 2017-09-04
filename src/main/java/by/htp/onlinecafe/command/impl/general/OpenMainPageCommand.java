package by.htp.onlinecafe.command.impl.general;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Opens index.jsp.
 */
public class OpenMainPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = WELCOME_PAGE;
        return page;
    }
}
