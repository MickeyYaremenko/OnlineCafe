package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.service.MenuItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Edits information about menu item.
 */
public class EditItemCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(EditItemCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = REDIRECT_MANAGE_MENU_ITEMS;

        Integer id = Integer.parseInt(request.getParameter(ITEM_ID));
        String title = request.getParameter(TITLE);
        String weight = request.getParameter(WEIGHT);
        BigDecimal price =  new BigDecimal(request.getParameter(PRICE));
        String category = request.getParameter(CATEGORY).toLowerCase();
        String description = request.getParameter(DESCRIPTION);

        MenuItemService menuItemService = ServiceFactory.getInstance().getMenuItemService();

        try {
            menuItemService.updateItem(id, title, weight, price, category, description);
            List<MenuItem> menuItemList = menuItemService.showAll();
            request.setAttribute(MENU_ITEM_LIST, menuItemList);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }

        return page;
    }
}
