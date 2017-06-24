package by.htp.onlinecafe.service;

import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.Exception.ServiceException;

import java.util.List;

public interface MenuItemService {

    public List<MenuItem> showByCategory(String category) throws ServiceException;
}
