package by.htp.onlinecafe.dao;

import by.htp.onlinecafe.dao.Exception.DAOException;
import by.htp.onlinecafe.entity.MenuItem;

import java.util.List;

public interface MenuItemDAO {
    List<MenuItem> showByCategory(String category) throws DAOException;
    MenuItem getByTitle(String title) throws DAOException;
    List<MenuItem> showAll() throws DAOException;
    void updateItem (MenuItem menuItem) throws DAOException;
}
