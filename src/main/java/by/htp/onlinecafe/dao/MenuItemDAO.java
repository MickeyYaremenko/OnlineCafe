package by.htp.onlinecafe.dao;

import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.entity.MenuItem;

import java.util.List;

public interface MenuItemDAO {
    List<MenuItem> getActiveByCategory(String category, Integer menuID) throws DAOException;
    MenuItem getByTitle(String title) throws DAOException;
    List<MenuItem> showAll() throws DAOException;
    void updateItem (MenuItem menuItem) throws DAOException;
    void addNew(MenuItem menuItem) throws DAOException;
}
