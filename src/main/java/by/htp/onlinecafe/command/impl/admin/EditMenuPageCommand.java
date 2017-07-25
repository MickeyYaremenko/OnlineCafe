package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Menu;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.MenuItemService;
import by.htp.onlinecafe.service.MenuService;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EditMenuPageCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(EditMenuPageCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/admin/edit_menu.jsp";
        MenuService menuService = ServiceFactory.getInstance().getMenuService();
        MenuItemService menuItemService = ServiceFactory.getInstance().getMenuItemService();
        Integer menuID = Integer.parseInt(request.getParameter("menu_id"));
        try {
            Menu menu =  menuService.getByID(menuID);

            List<MenuItem> salad = menuItemService.getAllByCategory("salad");
            List<MenuItem> soup = menuItemService.getAllByCategory("soup");
            List<MenuItem> appetizier = menuItemService.getAllByCategory("appetizier");
            List<MenuItem> hot = menuItemService.getAllByCategory("hot");
            List<MenuItem> dessert = menuItemService.getAllByCategory("dessert");
            List<MenuItem> drink = menuItemService.getAllByCategory("drink");
            request.setAttribute("menu", menu);

            request.setAttribute("salad", salad);
            request.setAttribute("soup", soup);
            request.setAttribute("appetizier", appetizier);
            request.setAttribute("hot", hot);
            request.setAttribute("dessert", dessert);
            request.setAttribute("drink", drink);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return page;
    }
}
