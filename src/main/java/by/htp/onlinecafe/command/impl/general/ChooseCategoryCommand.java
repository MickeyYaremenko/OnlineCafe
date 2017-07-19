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
import java.util.List;

public class ChooseCategoryCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(ChooseCategoryCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/item_list.jsp";
        String category = request.getParameter("category");
        MenuItemService menuItemService = ServiceFactory.getInstance().getMenuItemService();
        try {
            List<MenuItem> menuItemList =  menuItemService.showByCategory(category);
            request.setAttribute("menuItemList", menuItemList);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return page;
    }
}
