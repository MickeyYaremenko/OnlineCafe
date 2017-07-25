package by.htp.onlinecafe.service.impl;

import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.dao.factory.DAOFactory;
import by.htp.onlinecafe.dao.MenuItemDAO;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.exception.ServiceException;
import by.htp.onlinecafe.service.MenuItemService;

import java.math.BigDecimal;
import java.util.List;

public class MenuItemServiceImpl implements MenuItemService{

    private static MenuItemServiceImpl instance;

    private MenuItemServiceImpl(){
    }

    public static MenuItemServiceImpl getInstance(){
        if (instance == null){
            instance = new MenuItemServiceImpl();
        }
        return instance;
    }

    @Override
    public List<MenuItem> getAllByCategory(String category) throws ServiceException {
        MenuItemDAO menuItemDAO = DAOFactory.getInstance().getMenuItemDAO();
        try {
           return menuItemDAO.getAllByCategory(category); //TO DO delete this
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public MenuItem getByTitle(String title) throws ServiceException {
        MenuItemDAO menuItemDAO = DAOFactory.getInstance().getMenuItemDAO();
        try {
            return menuItemDAO.getByTitle(title);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<MenuItem> showAll() throws ServiceException {
        MenuItemDAO menuItemDAO = DAOFactory.getInstance().getMenuItemDAO();
        try {
            return menuItemDAO.showAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateItem(Integer id, String title, String weight, BigDecimal price, String category, String description)
            throws ServiceException {
        MenuItem menuItem = new MenuItem();
        menuItem.setId(id);
        menuItem.setTitle(title);
        menuItem.setWeight(weight);
        menuItem.setPrice(price);
        menuItem.setCategory(category);
        menuItem.setDescription(description);

        MenuItemDAO menuItemDAO = DAOFactory.getInstance().getMenuItemDAO();

        try {
            menuItemDAO.updateItem(menuItem);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public void addNew(String title, String weight, BigDecimal price, String category, String description) throws ServiceException {
        MenuItem menuItem = new MenuItem();
        menuItem.setTitle(title);
        menuItem.setWeight(weight);
        menuItem.setPrice(price);
        menuItem.setCategory(category);
        menuItem.setDescription(description);

        MenuItemDAO menuItemDAO = DAOFactory.getInstance().getMenuItemDAO();

        try {
            menuItemDAO.addNew(menuItem);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
