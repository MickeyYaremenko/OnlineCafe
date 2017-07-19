package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.dto.OrderTO;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ManageOrderPageCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(ManageOrderPageCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/admin/order_management.jsp";
        OrderService orderService = ServiceFactory.getInstance().getOrderService();
        try {
            List<OrderTO> orderTOList = orderService.showActive();
            request.setAttribute("order_list", orderTOList);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return page;
    }
}
