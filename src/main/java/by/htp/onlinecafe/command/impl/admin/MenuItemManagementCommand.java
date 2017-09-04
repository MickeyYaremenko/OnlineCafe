package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.service.MenuItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Opens menu_item_management.jsp.
 */
public class MenuItemManagementCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(MenuItemManagementCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = MENU_ITEM_MANAGEMENT_PAGE;
        MenuItemService menuItemService = ServiceFactory.getInstance().getMenuItemService();
        try {
            List<MenuItem> menuItemList =  menuItemService.showAll();
            request.setAttribute(MENU_ITEM_LIST, menuItemList);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return page;
    }
}
