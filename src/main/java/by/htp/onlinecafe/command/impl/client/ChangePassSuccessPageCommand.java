package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Opens password_changed.jsp.
 */
public class ChangePassSuccessPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = CHANGE_PASS_SUCCESS_PAGE;
        return page;
    }
}
