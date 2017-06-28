package by.htp.onlinecafe.service;

import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.Exception.ServiceException;

public interface ClientService {

    Client register(String login, String password, String confirmPassword, String firstName, String lastName, String email)
            throws ServiceException;
    Client signIn(String login, String password) throws ServiceException;
    boolean changePassword(Client client, String oldPass, String newPass1, String newPass2) throws ServiceException;
}
