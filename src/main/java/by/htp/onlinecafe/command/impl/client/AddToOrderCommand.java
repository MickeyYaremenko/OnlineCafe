package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.Exception.ServiceException;
import by.htp.onlinecafe.service.Impl.MenuItemServiceImpl;
import by.htp.onlinecafe.service.MenuItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class AddToOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/order.jsp";
        HttpSession session = request.getSession();
        Map<MenuItem, Integer> order = (Map<MenuItem, Integer>) session.getAttribute("order");
        if (order == null){
            order = parseOrder(request);
        } else {
            order = parseOrder(request, order);
        }
        session.setAttribute("order", order);
        return page;
    }

    private Map<MenuItem, Integer> parseOrder(HttpServletRequest request) {
        MenuItemService menuItemService = MenuItemServiceImpl.getInstance();
        Map<MenuItem, Integer> order = new HashMap<>();
        String[] tempOrderItems = request.getParameterValues("item");
        String[] tempItemsQuantity1 = request.getParameterValues("quant");
        for (int i = 0; i < tempOrderItems.length; i++) {
            Integer tempQuantity = Integer.parseInt(tempItemsQuantity1[i]);
            if (tempQuantity > 0) {
                String tempItemTitle = tempOrderItems[i];
                try {
                    MenuItem menuItem  = menuItemService.getByTitle(tempItemTitle);
                    order.put(menuItem, tempQuantity);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
            }
        }
        return order;
    }

    private Map<MenuItem, Integer> parseOrder(HttpServletRequest request, Map<MenuItem, Integer> order) {
        MenuItemService menuItemService = MenuItemServiceImpl.getInstance();
        String[] tempOrderItems = request.getParameterValues("item");
        String[] tempItemsQuantity = request.getParameterValues("quant");
        for (int i = 0; i < tempOrderItems.length; i++) {
            Integer tempQuantity = Integer.parseInt(tempItemsQuantity[i]);
            if (tempQuantity > 0) {
                String tempItemTitle = tempOrderItems[i];
                try {
                    MenuItem menuItem = menuItemService.getByTitle(tempItemTitle);
                    if (order.containsKey(menuItem)) {
                        order.put(menuItem, order.get(menuItem) + tempQuantity);
                    } else {
                        order.put(menuItem, tempQuantity);
                    }
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
            }
        }
        return order;
    }
}
