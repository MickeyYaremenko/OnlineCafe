package by.htp.onlinecafe.command.impl.general;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.service.MenuItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Creates an order in session or add items to an existing order.
 */
public class AddToOrderCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(AddToOrderCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = REDIRECT_ORDER_PAGE;
        HttpSession session = request.getSession();
        Map<MenuItem, Integer> order = (Map<MenuItem, Integer>) session.getAttribute(ORDER);
        if (order == null){
            order = parseOrder(request);
        } else {
            order = parseOrder(request, order);
        }
        session.setAttribute(ORDER, order);
        return page;
    }

    private Map<MenuItem, Integer> parseOrder(HttpServletRequest request) {
        MenuItemService menuItemService = ServiceFactory.getInstance().getMenuItemService();
        Map<MenuItem, Integer> order = new HashMap<>();
        String[] tempOrderItems = request.getParameterValues(ITEM);
        String[] tempItemsQuantity = request.getParameterValues(QUANTITY);
        for (int i = 0; i < tempOrderItems.length; i++) {
            Integer tempQuantity = Integer.parseInt(tempItemsQuantity[i]);
            if (tempQuantity > 0) {
                String tempItemTitle = tempOrderItems[i];
                try {
                    MenuItem menuItem  = menuItemService.getByTitle(tempItemTitle);
                    order.put(menuItem, tempQuantity);
                } catch (ServiceException e) {
                    LOGGER.error(e);
                }
            }
        }
        return order;
    }

    private Map<MenuItem, Integer> parseOrder(HttpServletRequest request, Map<MenuItem, Integer> order) {
        MenuItemService menuItemService = ServiceFactory.getInstance().getMenuItemService();
        String[] tempOrderItems = request.getParameterValues(ITEM);
        String[] tempItemsQuantity = request.getParameterValues(QUANTITY);
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
                    LOGGER.error(e);
                }
            }
        }
        return order;
    }
}
