package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.dto.OrderTO;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ManageOrderPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/admin/order_management.jsp";
        OrderService orderService = ServiceFactory.getInstance().getOrderService();
        try {
            List<OrderTO> orderTOList = orderService.showActive();
            request.setAttribute("order_list", orderTOList);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
