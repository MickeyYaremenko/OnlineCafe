package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.ClientService;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

public class AddFundsCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(AddFundsCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
//        String page = "/WEB-INF/jsp/client/client_account.jsp";
        String page = "/Controller?command=open_client_acc";
        ClientService clientService = ServiceFactory.getInstance().getClientService();
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");
        String sumToAdd = request.getParameter("sum");

        try{
            BigDecimal BDSum = new BigDecimal(sumToAdd);
            clientService.addFunds(client, BDSum);
        } catch (NumberFormatException | ServiceException e){
            LOGGER.error(e);
        }

        return page;
    }
}
