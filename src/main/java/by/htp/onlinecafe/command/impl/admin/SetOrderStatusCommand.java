package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.dto.OrderTO;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SetOrderStatusCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/admin/order_management.jsp";
        Integer orderID = Integer.parseInt(request.getParameter("orderID"));
        String status = request.getParameter("status");
        OrderService orderService = ServiceFactory.getInstance().getOrderService();
        try {
            orderService.setStatus(orderID, status);
            List<OrderTO> orderTOList = orderService.showActive();
            request.setAttribute("order_list", orderTOList);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
