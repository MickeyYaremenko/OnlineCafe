package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.dto.MenuTO;
import by.htp.onlinecafe.service.MenuService;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Opens menu_management.jsp.
 */
public class MenuManagementPageCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(MenuManagementPageCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = MENU_MANAGEMENT_PAGE;
        MenuService menuService = ServiceFactory.getInstance().getMenuService();
        try {
            List<MenuTO> menuTOList =  menuService.getAll();
            request.setAttribute(MENU_LIST, menuTOList);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return page;
    }
}
