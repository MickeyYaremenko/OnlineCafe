package by.htp.onlinecafe.dao;

import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.entity.Menu;

public interface MenuDAO {
    Menu getActive(Menu.MenuLanguage language) throws DAOException;
}
