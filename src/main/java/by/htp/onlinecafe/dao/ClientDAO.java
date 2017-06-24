package by.htp.onlinecafe.dao;

import by.htp.onlinecafe.dao.Exception.DAOException;
import by.htp.onlinecafe.entity.Client;

public interface ClientDAO {
    Client register(Client client) throws DAOException;
    Client signIn(String login, String password) throws DAOException;
}
