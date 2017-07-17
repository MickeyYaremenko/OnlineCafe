package by.htp.onlinecafe.command.impl.general;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import by.htp.onlinecafe.service.MenuItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ChooseCategoryCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/item_list.jsp";
        String category = request.getParameter("category");
        MenuItemService menuItemService = ServiceFactory.getInstance().getMenuItemService();
        try {
            List<MenuItem> menuItemList =  menuItemService.showByCategory(category);
            request.setAttribute("menuItemList", menuItemList);
            return page;
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
