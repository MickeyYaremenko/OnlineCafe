package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.dto.MenuTO;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.MenuItemService;
import by.htp.onlinecafe.service.MenuService;
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
 * Opens edit_menu.jsp.
 */
public class EditMenuPageCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(EditMenuPageCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = EDIT_MENU_PAGE;
        MenuService menuService = ServiceFactory.getInstance().getMenuService();
        MenuItemService menuItemService = ServiceFactory.getInstance().getMenuItemService();

        Integer menuID = Integer.parseInt(request.getParameter(MENU_ID));
        try {
            MenuTO menuTO =  menuService.getByID(menuID);

            List<MenuItem> salad = menuItemService.getAllByCategory(SALAD);
            List<MenuItem> soup = menuItemService.getAllByCategory(SOUP);
            List<MenuItem> appetizier = menuItemService.getAllByCategory(APPETIZIER);
            List<MenuItem> hot = menuItemService.getAllByCategory(HOT);
            List<MenuItem> dessert = menuItemService.getAllByCategory(DESSERT);
            List<MenuItem> drink = menuItemService.getAllByCategory(DRINK);
            request.setAttribute(MENU, menuTO);

            request.setAttribute(SALAD, salad);
            request.setAttribute(SOUP, soup);
            request.setAttribute(APPETIZIER, appetizier);
            request.setAttribute(HOT, hot);
            request.setAttribute(DESSERT, dessert);
            request.setAttribute(DRINK, drink);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return page;
    }
}
