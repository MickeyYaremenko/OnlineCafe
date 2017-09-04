package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.ClientService;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.util.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Adds funds to client's balance.
 */
public class AddFundsCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(AddFundsCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = REDIRECT_CLIENT_ACCOUNT_PAGE;
        ClientService clientService = ServiceFactory.getInstance().getClientService();
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute(CLIENT);
        String sumToAdd = request.getParameter(SUM);

        if (Validator.checkNumbersWithDelimiter(sumToAdd)){
            try{
                BigDecimal BDSum = new BigDecimal(sumToAdd);
                clientService.addFunds(client, BDSum);
            } catch (NumberFormatException | ServiceException e){
                LOGGER.error(e);
            }
        }
        return page;
    }
}
