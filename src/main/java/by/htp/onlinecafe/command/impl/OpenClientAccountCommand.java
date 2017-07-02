package by.htp.onlinecafe.command.impl;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.entity.DTO.OrderTO;
import by.htp.onlinecafe.service.Exception.ServiceException;
import by.htp.onlinecafe.service.Impl.OrderServiceImpl;
import by.htp.onlinecafe.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OpenClientAccountCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = "index.jsp";
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");
        try {
            OrderService billService = OrderServiceImpl.getInstance();
            List<OrderTO> clientHistory = billService.clientHistory(client);
            request.setAttribute("history", clientHistory);
            page = "/WEB-INF/jsp/client_account.jsp";
            return page;
        } catch (ServiceException e) {
            e.printStackTrace();
            return page;
        }

    }
}
