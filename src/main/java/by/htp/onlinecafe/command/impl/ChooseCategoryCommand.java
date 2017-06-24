package by.htp.onlinecafe.command.impl;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.Exception.ServiceException;
import by.htp.onlinecafe.service.Impl.MenuItemServiceImpl;
import by.htp.onlinecafe.service.MenuItemService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ChooseCategoryCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = "default.jsp";
        String category = request.getParameter("category");
        MenuItemService menuItemService = MenuItemServiceImpl.getInstance();
        try {
            List<MenuItem> menuItemList =  menuItemService.showByCategory(category);
            request.setAttribute("menuItemList", menuItemList);
            page = "menu_category.jsp";
            return page;
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }
}
