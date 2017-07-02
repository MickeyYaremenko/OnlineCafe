package by.htp.onlinecafe.command.impl;


import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.Exception.ServiceException;
import by.htp.onlinecafe.service.Impl.OrderServiceImpl;
import by.htp.onlinecafe.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class MakeOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String page = "/WEB-INF/jsp/order_success.jsp";
        OrderService orderService = OrderServiceImpl.getInstance();
        HttpSession session = request.getSession();

        Client client = (Client) session.getAttribute("client");
        Map<MenuItem, Integer> order = (Map<MenuItem, Integer>) session.getAttribute("order");

        try {
            orderService.makeOrder(order, client);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
