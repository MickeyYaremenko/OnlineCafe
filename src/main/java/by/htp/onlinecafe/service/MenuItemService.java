package by.htp.onlinecafe.service;

import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.exception.ServiceException;

import java.math.BigDecimal;
import java.util.List;

public interface MenuItemService {

    List<MenuItem> getAllByCategory(String category) throws ServiceException;
    MenuItem getByTitle(String title) throws ServiceException;
    List<MenuItem> showAll() throws ServiceException;
    void updateItem(Integer id, String title, String weight, BigDecimal price, String category, String description)
            throws ServiceException;
    void addNew(String title, String weight, BigDecimal price, String category, String description) throws ServiceException;
    void deleteById(Integer id) throws ServiceException;
}
