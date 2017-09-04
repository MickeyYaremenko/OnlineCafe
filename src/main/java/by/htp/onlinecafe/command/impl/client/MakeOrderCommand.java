package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Adds an order to database.
 */
public class MakeOrderCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(MakeOrderCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = ORDER_PAGE;
        OrderService orderService = ServiceFactory.getInstance().getOrderService();
        HttpSession session = request.getSession();

        Client client = (Client) session.getAttribute(CLIENT);
        Map<MenuItem, Integer> order = (Map<MenuItem, Integer>) session.getAttribute(ORDER);

        try {

            Boolean success = orderService.makeOrder(order, client);
            if (success){
                page = REDIRECT_ORDER_SUCCESS_PAGE;
                session.removeAttribute(ORDER);
            } else{
                page = REDIRECT_ORDER_FAIL_PAGE;
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return page;
    }
}
