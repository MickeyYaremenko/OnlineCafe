package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.dto.MenuTO;
import by.htp.onlinecafe.service.MenuService;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static by.htp.onlinecafe.util.constant.JSPPageConstant.*;
import static by.htp.onlinecafe.util.constant.ParameterAttributeConstant.*;

/**
 * Implementation of Command {@link Command}.
 * Edits information about menu.
 */
public class EditMenuCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        String page = REDIRECT_MANAGE_MENU;
        String[] itemsID = request.getParameterValues(ITEM_ID);
        List<Integer> itemsIDList = new ArrayList<>();
        for (String string: itemsID){
            itemsIDList.add(Integer.parseInt(string));
        }

        MenuTO menuTO = new MenuTO();
        Integer menuID = Integer.parseInt(request.getParameter(MENU_ID));
        MenuTO.MenuStatus menuStatus = MenuTO.MenuStatus.valueOf(request.getParameter(MENU_STATUS));
        MenuTO.MenuLanguage menuLanguage = MenuTO.MenuLanguage.valueOf(request.getParameter(MENU_LANGUAGE));
        menuTO.setId(menuID);
        menuTO.setMenuLanguage(menuLanguage);
        menuTO.setMenuStatus(menuStatus);

        MenuService menuService = ServiceFactory.getInstance().getMenuService();
        try {
            menuService.update(menuTO, itemsIDList);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
