package by.htp.onlinecafe.service.Impl;

import by.htp.onlinecafe.dao.Exception.DAOException;
import by.htp.onlinecafe.dao.Impl.ClientDAOImpl;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.ClientService;
import by.htp.onlinecafe.service.Exception.ServiceException;

/**
 * Created by Mike Yaremenko on 17.06.2017.
 */
public class ClientServiceImpl implements ClientService {
    @Override
    public Client register(String login, String password, String confirmPassword, String firstName, String lastName, String email)
            throws ServiceException {

        try {
            ClientDAOImpl clientDAO = new ClientDAOImpl();
            Client client = new Client();
            client.setLogin(login);
            client.setPassword(password);
            client.setFirstName(firstName);
            client.setLastName(lastName);
            client.setEmail(email);
            client = clientDAO.register(client);
            return client;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
