package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.Exception.ServiceException;
import by.htp.onlinecafe.service.Impl.MenuItemServiceImpl;
import by.htp.onlinecafe.service.MenuItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class UpdateOrderCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/order.jsp";
        HttpSession session = request.getSession();
        Map<MenuItem, Integer> order = (Map<MenuItem, Integer>) session.getAttribute("order");
        order = updateOrder(request, order);
        session.setAttribute("order", order);
        return page;
    }

    private Map<MenuItem, Integer> updateOrder(HttpServletRequest request, Map<MenuItem, Integer> order) {
        MenuItemService menuItemService = MenuItemServiceImpl.getInstance();
        String[] tempOrderItems = request.getParameterValues("item");
        String[] tempItemsQuantity = request.getParameterValues("quant");
        for (int i = 0; i < tempOrderItems.length; i++) {
            Integer tempQuantity = Integer.parseInt(tempItemsQuantity[i]);
            String tempItemTitle = tempOrderItems[i];
            MenuItem menuItem;
            try {
                menuItem = menuItemService.getByTitle(tempItemTitle);
                if (tempQuantity > 0) {
                    order.put(menuItem, tempQuantity);
                } else {
                    order.remove(menuItem);
                }
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        return order;
    }

}
