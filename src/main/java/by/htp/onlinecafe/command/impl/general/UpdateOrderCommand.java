package by.htp.onlinecafe.command.impl.general;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.service.MenuItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class UpdateOrderCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(UpdateOrderCommand.class);

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
        MenuItemService menuItemService = ServiceFactory.getInstance().getMenuItemService();
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
                LOGGER.error(e);
            }
        }
        return order;
    }

}
