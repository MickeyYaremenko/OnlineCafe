package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.Exception.ServiceException;
import by.htp.onlinecafe.service.Impl.MenuItemServiceImpl;
import by.htp.onlinecafe.service.MenuItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditItemPageCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/admin/edit_item.jsp";
        String itemTitle = request.getParameter("item");
        MenuItemService menuItemService = MenuItemServiceImpl.getInstance();

        try {
            MenuItem menuItem =  menuItemService.getByTitle(itemTitle);
            request.setAttribute("item", menuItem);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
