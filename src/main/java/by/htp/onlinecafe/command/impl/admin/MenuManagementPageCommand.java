package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Menu;
import by.htp.onlinecafe.service.MenuService;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MenuManagementPageCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(MenuManagementPageCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/WEB-INF/jsp/admin/menu_management.jsp";
        MenuService menuService = ServiceFactory.getInstance().getMenuService();
        try {
            List<Menu> menuList =  menuService.getAll();
            request.setAttribute("menuList", menuList);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return page;
    }
}
