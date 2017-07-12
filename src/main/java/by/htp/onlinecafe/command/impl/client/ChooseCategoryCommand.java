package by.htp.onlinecafe.command.impl.client;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.Exception.ServiceException;
import by.htp.onlinecafe.service.Impl.MenuItemServiceImpl;
import by.htp.onlinecafe.service.MenuItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ChooseCategoryCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "default.jsp";
        String category = request.getParameter("category");
        MenuItemService menuItemService = MenuItemServiceImpl.getInstance();
        try {
            List<MenuItem> menuItemList =  menuItemService.showByCategory(category);
            request.setAttribute("menuItemList", menuItemList);
            page = "/WEB-INF/jsp/item_list.jsp";
            return page;
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
