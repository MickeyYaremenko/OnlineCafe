package by.htp.onlinecafe.command.impl.general;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.dto.MenuTO;
import by.htp.onlinecafe.service.MenuService;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Opens item_list.jsp with items from selected category.
 */
public class ChooseCategoryCommand implements Command{

    private static final Logger LOGGER = LogManager.getLogger(ChooseCategoryCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = ITEM_LIST_PAGE;
        HttpSession session = request.getSession();
        String language = (String) session.getAttribute(LANGUAGE);
        if (language == null){
            language = RUSSIAN;
        }
        String category = request.getParameter(CATEGORY);
        MenuService menuService = ServiceFactory.getInstance().getMenuService();
        try {
            MenuTO menuTO = menuService.getActiveByCategory(language, category);
            request.setAttribute(MENU, menuTO);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return page;
    }
}
