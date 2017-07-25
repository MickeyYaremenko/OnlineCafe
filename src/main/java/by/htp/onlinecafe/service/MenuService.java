package by.htp.onlinecafe.service;

import by.htp.onlinecafe.entity.Menu;
import by.htp.onlinecafe.service.exception.ServiceException;

import java.util.List;

public interface MenuService {
    Menu getActiveByCategory(String menuLanguage, String category) throws ServiceException;
    List<Menu> getAll() throws ServiceException;
    Menu getByID(Integer id) throws ServiceException;
    void update(Menu menu, List<Integer> itemsIDList) throws ServiceException;
    void create(Menu menu, List<Integer> itemsIDList) throws ServiceException;
}
