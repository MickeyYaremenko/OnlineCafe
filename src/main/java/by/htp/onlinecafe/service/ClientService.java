package by.htp.onlinecafe.service;

import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.Exception.ServiceException;

/**
 * Created by Mike Yaremenko on 17.06.2017.
 */
public interface ClientService {

    Client register(String login, String password, String confirmPassword, String firstName, String lastName, String email) throws ServiceException;
}
