package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Opens admin_page.jsp.
 */
public class OpenAdminPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = ADMIN_PAGE;
        return page;
    }
}
