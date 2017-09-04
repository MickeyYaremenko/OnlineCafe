package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Opens change_pass_failed.jsp.
 */
public class ChangePassFailedPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = CHANGE_PASS_FAIL_PAGE;
        return page;
    }
}
