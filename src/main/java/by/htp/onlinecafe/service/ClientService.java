package by.htp.onlinecafe.service;

import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.exception.ServiceException;

import java.math.BigDecimal;

/**
 * Provides service-logic for {@link Client} entity
 */
public interface ClientService {

    /**
     * Registers new Client in database
     * Returns {@link Client} registered in database
     * @param login of a new client
     * @param password of a new client
     * @param firstName of a new client
     * @param lastName of a new client
     * @param email of a new client
     * @return {@link Client} object
     * @throws ServiceException
     */
    Client register(String login, String password, String firstName, String lastName, String email)
            throws ServiceException;

    /**
     * Signs Client in to the session
     * Returns {@link Client} from database
     * @param login
     * @param password
     * @return {@link Client} object
     * @throws ServiceException
     */
    Client signIn(String login, String password) throws ServiceException;

    /**
     * Signs Client in to the session
     * Returns {@link Client} from database
     * @param client who's password will be changed
     * @param oldPass existing password
     * @param newPass1 new password for account
     * @param newPass2 confirmation of new password
     * @return {@link boolean}
     * @throws ServiceException
     */
    boolean changePassword(Client client, String oldPass, String newPass1, String newPass2) throws ServiceException;

    /**
     * Adds sum of money to client's balance
     * Returns {@link Client} from database
     * @param client
     * @param sum sum to add to client's balance
     * @throws ServiceException
     */
    void addFunds(Client client, BigDecimal sum) throws ServiceException;
}
