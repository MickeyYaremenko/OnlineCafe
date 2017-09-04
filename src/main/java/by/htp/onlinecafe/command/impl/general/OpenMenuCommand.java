package by.htp.onlinecafe.command.impl.general;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Opens menu.jsp.
 */
public class OpenMenuCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = MENU_PAGE;
        return page;
    }
}
