package by.htp.onlinecafe.command.impl;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Bill;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.BillService;
import by.htp.onlinecafe.service.Exception.ServiceException;
import by.htp.onlinecafe.service.Impl.BillServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OpenClientAccount implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = "default.jsp";
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");
        try {
            BillService billService = BillServiceImpl.getInstance();
            List<Bill> clientHistory = billService.clientHistory(client);
            request.setAttribute("history", clientHistory);
            page = "/WEB-INF/jsp/client_account.jsp";
            return page;
        } catch (ServiceException e) {
            e.printStackTrace();
            return page;
        }

    }
}
