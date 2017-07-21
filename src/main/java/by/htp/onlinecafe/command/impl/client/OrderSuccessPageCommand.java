package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Mike Yaremenko on 21.07.2017.
 */
public class OrderSuccessPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/client/order_success.jsp";
        return page;
    }
}
