package by.htp.onlinecafe.dao;

import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.entity.dto.MenuTO;

import java.util.List;

/**
 * Provides a DAO-logic for the {@link MenuTO} entity in database
 */
public interface MenuDAO {

    /**
     * Returns active menu with chosen language
     * @param language built up based on parameters from JSP
     * @return {@link MenuTO} object
     * @throws DAOException
     */
    MenuTO getActive(MenuTO.MenuLanguage language) throws DAOException;

    /**
     * Returns List with all menus
     * @return {@link List<MenuTO>} object
     * @throws DAOException
     */
    List<MenuTO> getAll() throws DAOException;

    /**
     * Returns menu by id
     * @param id MenuTO id
     * @return {@link MenuTO} object
     * @throws DAOException
     */
    MenuTO getByID(Integer id) throws DAOException;

    /**
     * Updates chosen menu
     * @param menuTO MenuTO to update
     * @param itemsIDList List of items id to be set to this menu
     * @throws DAOException
     */
    void update(MenuTO menuTO, List<Integer> itemsIDList) throws DAOException;

    /**
     * Creates new menu in database
     * @param menuTO MenuTO to add
     * @param itemsIDList List of items id to be set to this menu
     * @throws DAOException
     */
    void create(MenuTO menuTO, List<Integer> itemsIDList) throws DAOException;
}
