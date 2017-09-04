package by.htp.onlinecafe.command.impl.general;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Signs out client from session.
 */
public class SignOutCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = WELCOME_PAGE;
        HttpSession session = request.getSession();
        session.invalidate();
        return page;
    }
}
