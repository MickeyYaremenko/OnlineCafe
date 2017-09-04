package by.htp.onlinecafe.dao;

import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.entity.dto.MenuTO;
import by.htp.onlinecafe.entity.MenuItem;

import java.util.List;

/**
 * Provides a DAO-logic for the {@link MenuItem} entity in database
 */
public interface MenuItemDAO {

    /**
     * Returns List of menuTO items
     * from active menuTO by chosen category
     * @param category of items
     * @param menuTO active menuTO
     * @return {@link List<MenuItem>} object
     * @throws DAOException
     */
    List<MenuItem> getActiveByCategory(String category, MenuTO menuTO) throws DAOException;

    /**
     * Returns List of menu item by category
     * @param category of items
     * @return {@link List<MenuItem>} object
     * @throws DAOException
     */
    List<MenuItem> getAllByCategory(String category) throws DAOException;

    /**
     * Returns menu item by title
     * @param title of item
     * @return {@link MenuItem} object
     * @throws DAOException
     */
    MenuItem getByTitle(String title) throws DAOException;

    /**
     * Returns List of all menu items
     * @return {@link List<MenuItem>} object
     * @throws DAOException
     */
    List<MenuItem> showAll() throws DAOException;

    /**
     * Updates menu item state in database
     * @param menuItem to update
     * @throws DAOException
     */
    void updateItem (MenuItem menuItem) throws DAOException;

    /**
     * Adds new menu item to database
     * @param menuItem to update
     * @throws DAOException
     */
    void addNew(MenuItem menuItem) throws DAOException;

    /**
     * Returns all menuTO item by menuTO
     * @param menuTO to get items from
     * @return {@link List<MenuItem>} object
     * @throws DAOException
     */
    List<MenuItem> getByMenu(MenuTO menuTO) throws DAOException;

    /**
     * Deletes menu item from database by id
     * @param id of menu item to delete
     * @throws DAOException
     */
    void deleteById(Integer id) throws DAOException;
}
