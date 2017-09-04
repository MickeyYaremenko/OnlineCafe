package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.dto.OrderTO;
import by.htp.onlinecafe.service.OrderService;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Gets by id order from database.
 */
public class OpenViewOrderPageCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(OpenViewOrderPageCommand.class);
    @Override
    public String execute(HttpServletRequest request) {
        String page = OPEN_VIEW_ORDER_PAGE;

        Integer id = Integer.parseInt(request.getParameter(ORDER_ID));
        OrderService orderService = ServiceFactory.getInstance().getOrderService();
        OrderTO orderTO = null;
        try {
            orderTO = orderService.getById(id);
            request.setAttribute(ORDER, orderTO);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }

        return page;
    }
}
