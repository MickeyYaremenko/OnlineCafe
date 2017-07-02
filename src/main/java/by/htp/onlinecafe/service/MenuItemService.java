package by.htp.onlinecafe.service;

import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.Exception.ServiceException;

import java.util.List;

public interface MenuItemService {

    List<MenuItem> showByCategory(String category) throws ServiceException;
    MenuItem getByTitle(String title) throws ServiceException;
}
