package by.htp.onlinecafe.command.impl.general;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Opens order.jsp.
 */
public class OpenOrderPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = ORDER_PAGE;
        return page;
    }
}
