package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.entity.dto.OrderTO;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Opens client_account.jsp.
 */
public class OpenClientAccountCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(OpenClientAccountCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = CLIENT_ACCOUNT_PAGE;
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute(CLIENT);
        try {
            OrderService orderService = ServiceFactory.getInstance().getOrderService();
            List<OrderTO> clientHistory = orderService.clientHistory(client);
            List<OrderTO> currentOrders = orderService.currentClientOrders(client);
            request.setAttribute(HISTORY, clientHistory);
            request.setAttribute(CURRENT, currentOrders);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return page;
    }
}
