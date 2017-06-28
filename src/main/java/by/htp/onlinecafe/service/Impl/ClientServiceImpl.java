package by.htp.onlinecafe.service.Impl;

import by.htp.onlinecafe.dao.ClientDAO;
import by.htp.onlinecafe.dao.Exception.DAOException;
import by.htp.onlinecafe.dao.Impl.ClientDAOImpl;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.ClientService;
import by.htp.onlinecafe.service.Exception.ServiceException;

public class ClientServiceImpl implements ClientService {

    private static ClientServiceImpl instance;

    private ClientServiceImpl(){
    }

    public static ClientServiceImpl getInstance(){
        if (instance == null){
            instance = new ClientServiceImpl();
        }
        return instance;
    }

    @Override
    public Client register(String login, String password, String confirmPassword, String firstName, String lastName, String email)
            throws ServiceException {

        try {
            ClientDAO clientDAO = ClientDAOImpl.getInstance();
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

    @Override
    public Client signIn(String login, String password) throws ServiceException {
        try {
            Client client;
            ClientDAO clientDAO = ClientDAOImpl.getInstance();
            client = clientDAO.signIn(login, password);
            return client;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean changePassword(Client client, String oldPass, String newPass1, String newPass2) throws ServiceException {
        ClientDAO clientDAO = ClientDAOImpl.getInstance();
        try {
            Client tempClient = clientDAO.signIn(client.getLogin(), oldPass);
            if (tempClient == null){
                return false;
            }
            if (newPass1.equals(newPass2) && tempClient.getLogin().equals(client.getLogin())) {
                boolean success = clientDAO.changePssword(client.getLogin(), newPass1);
                return success;
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }
}
