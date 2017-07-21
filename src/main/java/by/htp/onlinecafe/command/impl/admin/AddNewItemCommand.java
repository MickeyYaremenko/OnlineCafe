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
import java.math.BigDecimal;
import java.util.List;

public class AddNewItemCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(AddNewItemCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
//        String page = "/WEB-INF/jsp/admin/menu_item_management.jsp";
        String page = "/Controller?command=manage_menu_items";
        String title = request.getParameter("title");
        String weight = request.getParameter("weight");
        BigDecimal price =  new BigDecimal(request.getParameter("price"));
        String category = request.getParameter("category").toLowerCase();
        String description = request.getParameter("description");

        MenuItemService menuItemService = ServiceFactory.getInstance().getMenuItemService();

        try {
            menuItemService.addNew(title, weight, price, category, description);
            List<MenuItem> menuItemList = menuItemService.showAll();
            request.setAttribute("menuItemList", menuItemList);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }

        return page;
    }
}
