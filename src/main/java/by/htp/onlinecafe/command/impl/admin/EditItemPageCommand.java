package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.service.MenuItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditItemPageCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(EditItemPageCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/admin/edit_item.jsp";
        String itemTitle = request.getParameter("item");
        MenuItemService menuItemService = ServiceFactory.getInstance().getMenuItemService();

        try {
            MenuItem menuItem =  menuItemService.getByTitle(itemTitle);
            request.setAttribute("item", menuItem);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }

        return page;
    }
}
