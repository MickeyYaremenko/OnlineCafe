package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.Exception.ServiceException;
import by.htp.onlinecafe.service.Impl.MenuItemServiceImpl;
import by.htp.onlinecafe.service.MenuItemService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

public class EditItemCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/WEB-INF/jsp/admin/menu_item_management.jsp";

        Integer id = Integer.parseInt(request.getParameter("item_id"));
        String title = request.getParameter("title");
        String weight = request.getParameter("weight");
        BigDecimal price =  new BigDecimal(request.getParameter("price"));
        String category = request.getParameter("category");
        String description = request.getParameter("description");

        MenuItemService menuItemService = MenuItemServiceImpl.getInstance();

        try {
            menuItemService.updateItem(id, title, weight, price, category, description);
            List<MenuItem> menuItemList = menuItemService.showAll();
            request.setAttribute("menuItemList", menuItemList);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
