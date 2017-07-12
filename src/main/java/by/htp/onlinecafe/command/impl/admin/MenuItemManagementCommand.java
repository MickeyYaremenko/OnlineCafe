package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.Exception.ServiceException;
import by.htp.onlinecafe.service.Impl.MenuItemServiceImpl;
import by.htp.onlinecafe.service.MenuItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MenuItemManagementCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/admin/menu_item_management.jsp";
        MenuItemService menuItemService = MenuItemServiceImpl.getInstance();
        try {
            List<MenuItem> menuItemList =  menuItemService.showAll();
            request.setAttribute("menuItemList", menuItemList);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return page;
    }
}
