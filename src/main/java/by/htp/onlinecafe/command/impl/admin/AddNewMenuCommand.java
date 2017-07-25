package by.htp.onlinecafe.command.impl.admin;

import by.htp.onlinecafe.command.Command;
import by.htp.onlinecafe.entity.Menu;
import by.htp.onlinecafe.service.MenuService;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AddNewMenuCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/Controller?command=manage_menu";
        String[] itemsID = request.getParameterValues("item_id");
        List<Integer> itemsIDList = new ArrayList<>();
        for (String string: itemsID){
            itemsIDList.add(Integer.parseInt(string));
        }

        Menu menu = new Menu();
        Menu.MenuStatus menuStatus = Menu.MenuStatus.valueOf(request.getParameter("menu_status"));
        Menu.MenuLanguage menuLanguage = Menu.MenuLanguage.valueOf(request.getParameter("menu_language"));
        menu.setMenuLanguage(menuLanguage);
        menu.setMenuStatus(menuStatus);

        MenuService menuService = ServiceFactory.getInstance().getMenuService();
        try {
            menuService.create(menu, itemsIDList);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return page;
    }
}
