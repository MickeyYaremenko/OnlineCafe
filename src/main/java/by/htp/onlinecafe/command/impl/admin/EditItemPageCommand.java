package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.service.MenuItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Opens edit_item.jsp.
 */
public class EditItemPageCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(EditItemPageCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = EDIT_ITEM_PAGE;
        String itemTitle = request.getParameter(ITEM);
        HttpSession session = request.getSession();
        session.setAttribute("PrevRequest", request);
        MenuItemService menuItemService = ServiceFactory.getInstance().getMenuItemService();

        try {
            MenuItem menuItem =  menuItemService.getByTitle(itemTitle);
            request.setAttribute(ITEM, menuItem);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }

        return page;
    }
}
