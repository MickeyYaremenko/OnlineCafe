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
 * Opens order_management.jsp.
 */
public class ManageOrderPageCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(ManageOrderPageCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = ORDER_MANAGEMENT_PAGE;
        OrderService orderService = ServiceFactory.getInstance().getOrderService();
        try {
            List<OrderTO> orderTOList = orderService.showActive();
            request.setAttribute(ORDER_LIST, orderTOList);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return page;
    }
}
