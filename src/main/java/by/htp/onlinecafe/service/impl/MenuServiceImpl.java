package by.htp.onlinecafe.service.impl;

import by.htp.onlinecafe.dao.MenuDAO;
import by.htp.onlinecafe.dao.MenuItemDAO;
import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.dao.factory.DAOFactory;
import by.htp.onlinecafe.entity.Menu;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.MenuService;
import by.htp.onlinecafe.service.exception.ServiceException;

import java.util.List;

public class MenuServiceImpl implements MenuService{
    private static MenuServiceImpl instance = new MenuServiceImpl();

    public static MenuServiceImpl getInstance() {
        if (instance == null){
            instance = new MenuServiceImpl();
        }
        return instance;
    }

    private MenuServiceImpl() {
    }


    @Override
    public Menu getActiveByCategory(String menuLanguage, String category) throws ServiceException {
        MenuDAO menuDAO = DAOFactory.getInstance().getMenuDAO();
        MenuItemDAO menuItemDAO = DAOFactory.getInstance().getMenuItemDAO();

        try {
            Menu menu = menuDAO.getActive(Menu.MenuLanguage.valueOf(menuLanguage.toUpperCase()));
            List<MenuItem> itemList = menuItemDAO.getActiveByCategory(category, menu);
            menu.setMenuItemList(itemList);
            return menu;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Menu> getAll() throws ServiceException {
        MenuDAO menuDAO = DAOFactory.getInstance().getMenuDAO();
        MenuItemDAO menuItemDAO = DAOFactory.getInstance().getMenuItemDAO();

        try {
            List<Menu> menuList = menuDAO.getAll();
            for (Menu menu: menuList){
                menu.setMenuItemList(menuItemDAO.getByMenu(menu));
            }
            return menuList;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Menu getByID(Integer id) throws ServiceException {
        MenuDAO menuDAO = DAOFactory.getInstance().getMenuDAO();
        MenuItemDAO menuItemDAO = DAOFactory.getInstance().getMenuItemDAO();

        try {
            Menu menu = menuDAO.getByID(id);
            List<MenuItem> itemList = menuItemDAO.getByMenu(menu);
            menu.setMenuItemList(itemList);
            return menu;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(Menu menu, List<Integer> itemsIDList) throws ServiceException {
        MenuDAO menuDAO = DAOFactory.getInstance().getMenuDAO();

        try {
            menuDAO.update(menu, itemsIDList);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void create(Menu menu, List<Integer> itemsIDList) throws ServiceException {
        MenuDAO menuDAO = DAOFactory.getInstance().getMenuDAO();

        try {
            menuDAO.create(menu, itemsIDList);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
