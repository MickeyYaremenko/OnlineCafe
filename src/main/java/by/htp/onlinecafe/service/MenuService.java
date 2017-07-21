package by.htp.onlinecafe.service;

import by.htp.onlinecafe.entity.Menu;
import by.htp.onlinecafe.service.exception.ServiceException;

public interface MenuService {
    Menu getActiveByCategory(String menuLanguage, String category) throws ServiceException;
}
