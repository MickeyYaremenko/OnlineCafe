package by.htp.onlinecafe.dao;

import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.entity.Menu;

import java.util.List;

public interface MenuDAO {
    Menu getActive(Menu.MenuLanguage language) throws DAOException;
    List<Menu> getAll() throws DAOException;
    Menu getByID(Integer id) throws DAOException;
    void update(Menu menu, List<Integer> itemsIDList) throws DAOException;
    void create(Menu menu, List<Integer> itemsIDList) throws DAOException;
}
