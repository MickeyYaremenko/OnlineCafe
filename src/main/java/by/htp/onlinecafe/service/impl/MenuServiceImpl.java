package by.htp.onlinecafe.service.impl;

import by.htp.onlinecafe.dao.MenuDAO;
import by.htp.onlinecafe.dao.MenuItemDAO;
import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.dao.factory.DAOFactory;
import by.htp.onlinecafe.entity.dto.MenuTO;
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
    public MenuTO getActiveByCategory(String menuLanguage, String category) throws ServiceException {
        MenuDAO menuDAO = DAOFactory.getInstance().getMenuDAO();
        MenuItemDAO menuItemDAO = DAOFactory.getInstance().getMenuItemDAO();

        try {
            MenuTO menuTO = menuDAO.getActive(MenuTO.MenuLanguage.valueOf(menuLanguage.toUpperCase()));
            List<MenuItem> itemList = menuItemDAO.getActiveByCategory(category, menuTO);
            menuTO.setMenuItemList(itemList);
            return menuTO;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<MenuTO> getAll() throws ServiceException {
        MenuDAO menuDAO = DAOFactory.getInstance().getMenuDAO();
        MenuItemDAO menuItemDAO = DAOFactory.getInstance().getMenuItemDAO();

        try {
            List<MenuTO> menuTOList = menuDAO.getAll();
            for (MenuTO menuTO : menuTOList){
                menuTO.setMenuItemList(menuItemDAO.getByMenu(menuTO));
            }
            return menuTOList;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public MenuTO getByID(Integer id) throws ServiceException {
        MenuDAO menuDAO = DAOFactory.getInstance().getMenuDAO();
        MenuItemDAO menuItemDAO = DAOFactory.getInstance().getMenuItemDAO();

        try {
            MenuTO menuTO = menuDAO.getByID(id);
            List<MenuItem> itemList = menuItemDAO.getByMenu(menuTO);
            menuTO.setMenuItemList(itemList);
            return menuTO;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(MenuTO menuTO, List<Integer> itemsIDList) throws ServiceException {
        MenuDAO menuDAO = DAOFactory.getInstance().getMenuDAO();

        try {
            menuDAO.update(menuTO, itemsIDList);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void create(MenuTO menuTO, List<Integer> itemsIDList) throws ServiceException {
        MenuDAO menuDAO = DAOFactory.getInstance().getMenuDAO();

        try {
            menuDAO.create(menuTO, itemsIDList);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
