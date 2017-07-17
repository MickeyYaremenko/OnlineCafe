package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.entity.dto.OrderTO;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OpenClientAccountCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/client/client_account.jsp";
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");
        try {
            OrderService orderService = ServiceFactory.getInstance().getOrderService();
            List<OrderTO> clientHistory = orderService.clientHistory(client);
            List<OrderTO> currentOrders = orderService.currentClientOrders(client);
            request.setAttribute("history", clientHistory);
            request.setAttribute("current", currentOrders);
            return page;
        } catch (ServiceException e) {
            e.printStackTrace();
            return page;
        }

    }
}
