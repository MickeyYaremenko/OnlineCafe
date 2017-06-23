package by.htp.onlinecafe.dao;

import by.htp.onlinecafe.dao.Exception.DAOException;
import by.htp.onlinecafe.entity.Client;

/**
 * Created by Mike Yaremenko on 17.06.2017.
 */
public interface ClientDAO {
    Client register(Client client) throws DAOException;
}
