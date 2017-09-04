package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Opens order_success.jsp.
 */
public class OrderSuccessPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = ORDER_SUCCESS_PAGE;
        return page;
    }
}
