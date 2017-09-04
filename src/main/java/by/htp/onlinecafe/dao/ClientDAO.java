package by.htp.onlinecafe.dao;

import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.entity.Client;

import java.math.BigDecimal;

/**
 * Provides a DAO-logic for the {@link Client} entity in database
 */
public interface ClientDAO {

    /**
     * Registers new Client in database
     * Returns {@link Client} registered in database
     * @param client built up based on parameters from JSP
     * @return {@link Client} object
     * @throws DAOException
     */
    Client register(Client client) throws DAOException;

    /**
     * Signs Client in to the session
     * Returns {@link Client} from database
     * @param login
     * @param password
     * @return {@link Client} object
     * @throws DAOException
     */
    Client signIn(String login, String password) throws DAOException;

    /**
     * SChanges client's password in database
     * Returns {@link Client} from database
     * @param login
     * @param newPass new password for account
     * @return {@link boolean}
     * @throws DAOException
     */
    boolean changePassword(String login, String newPass) throws DAOException;

    /**
     * Adds sum of money to client's balance
     * Returns {@link Client} from database
     * @param client
     * @param sum sum to add to client's balance
     * @throws DAOException
     */
    void addFunds(Client client, BigDecimal sum) throws DAOException;
}
