package by.htp.onlinecafe.service;

import by.htp.onlinecafe.entity.dto.MenuTO;
import by.htp.onlinecafe.service.exception.ServiceException;

import java.util.List;

/**
 * Provides service-logic for {@link MenuTO} entity
 */
public interface MenuService {

    /**
     * Returns chosen category of active menu with chosen language
     * @param menuLanguage built up based on parameters from JSP
     * @param category to return
     * @return {@link MenuTO} object
     * @throws ServiceException
     */
    MenuTO getActiveByCategory(String menuLanguage, String category) throws ServiceException;

    /**
     * Returns List with all menus
     * @return {@link List<MenuTO>} object
     * @throws ServiceException
     */
    List<MenuTO> getAll() throws ServiceException;

    /**
     * Returns menu by id
     * @param id MenuTO id
     * @return {@link MenuTO} object
     * @throws ServiceException
     */
    MenuTO getByID(Integer id) throws ServiceException;

    /**
     * Updates chosen menu
     * @param menuTO MenuTO to update
     * @param itemsIDList List of items id to be set to this menu
     * @throws ServiceException
     */
    void update(MenuTO menuTO, List<Integer> itemsIDList) throws ServiceException;

    /**
     * Creates new menu in database
     * @param menuTO MenuTO to add
     * @param itemsIDList List of items id to be set to this menu
     * @throws ServiceException
     */
    void create(MenuTO menuTO, List<Integer> itemsIDList) throws ServiceException;
}
