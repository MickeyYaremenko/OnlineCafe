package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.dto.OrderTO;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Edits order status.
 */
public class SetOrderStatusCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(SetOrderStatusCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = REDIRECT_MANAGE_ORDERS;

        Integer orderID = Integer.parseInt(request.getParameter(ORDER_ID));
        String status = request.getParameter(STATUS);
        OrderService orderService = ServiceFactory.getInstance().getOrderService();
        try {
            orderService.setStatus(orderID, status);
            List<OrderTO> orderTOList = orderService.showActive();
            request.setAttribute(ORDER_LIST, orderTOList);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return page;
    }
}
