package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.MenuItemService;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Deletes an item from database.
 */
public class DeleteItemCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(DeleteItemCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = REDIRECT_MANAGE_MENU_ITEMS;

        Integer id = Integer.parseInt(request.getParameter(ITEM_ID));

        MenuItemService menuItemService = ServiceFactory.getInstance().getMenuItemService();
        try {
            menuItemService.deleteById(id);
            List<MenuItem> menuItemList = menuItemService.showAll();
            request.setAttribute(MENU_ITEM_LIST, menuItemList);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }

        return page;
    }
}
