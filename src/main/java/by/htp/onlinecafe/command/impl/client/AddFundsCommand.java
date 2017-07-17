package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.ClientService;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

public class AddFundsCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/client/client_account.jsp";
        ClientService clientService = ServiceFactory.getInstance().getClientService();
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");
        String sumToAdd = request.getParameter("sum");

        try{
            BigDecimal BDSum = new BigDecimal(sumToAdd);
            clientService.addFunds(client, BDSum);
        } catch (NumberFormatException | ServiceException e){
            e.printStackTrace();
        }

        return page;
    }
}
