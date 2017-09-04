package by.htp.onlinecafe.command.impl.general;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Opens sign_in.jsp.
 */
public class SignInPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = SIGN_IN_PAGE;
        return page;
    }
}
