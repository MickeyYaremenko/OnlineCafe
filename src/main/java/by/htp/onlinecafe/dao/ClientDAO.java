package by.htp.onlinecafe.dao;

import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.entity.Client;

import java.math.BigDecimal;

public interface ClientDAO {
    Client register(Client client) throws DAOException;
    Client signIn(String login, String password) throws DAOException;
    boolean changePassword(String login, String newPass) throws DAOException;
    boolean addFunds(Client client, BigDecimal sum) throws DAOException;
}
