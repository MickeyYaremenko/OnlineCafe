package by.htp.onlinecafe.dao.Impl;

import by.htp.onlinecafe.Util.SQLConnectionPool;
import by.htp.onlinecafe.dao.ClientDAO;
import by.htp.onlinecafe.dao.Exception.DAOException;
import by.htp.onlinecafe.entity.Client;

import javax.naming.NamingException;
import java.sql.*;

public class ClientDAOImpl implements ClientDAO {

    private static ClientDAOImpl instance;

    private static final String SQL_GET_USER_BY_LOGIN = "SELECT * FROM client WHERE login=?";
    private static final String SQL_REGISTER="INSERT INTO client" +
            "(login, password, first_name, last_name, email) VALUES(?,?,?,?,?)";

    private ClientDAOImpl(){
    }

    public static ClientDAOImpl getInstance(){
        if (instance == null){
            instance = new ClientDAOImpl();
        }
        return instance;
    }

    @Override
    public Client register(Client client) throws DAOException {
        if (!alreadyExist(client)) {
            try (Connection connection = SQLConnectionPool.getConnection();
                 PreparedStatement ps = connection.prepareStatement(SQL_REGISTER, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, client.getLogin());
                ps.setString(2, client.getPassword());
                ps.setString(3, client.getFirstName());
                ps.setString(4, client.getLastName());
                ps.setString(5, client.getEmail());
                ps.executeUpdate();
                ResultSet resultSet = ps.getGeneratedKeys();
                if (resultSet.next()) {
                    client.setId(resultSet.getInt(1));
                }
                client.setPassword(null);
            } catch (SQLException | NamingException e) {
                throw new DAOException(e);
            }
        }
        return client;
    }

    @Override
    public Client signIn(String login, String password) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_GET_USER_BY_LOGIN)) {
            ps.setString(1, login);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt(1));
                client.setLogin(resultSet.getString(2));
                client.setFirstName(resultSet.getString(4));
                client.setLastName(resultSet.getString(5));
                client.setEmail(resultSet.getString(6));
                return client;
            }
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
        return null;
    }

    private boolean alreadyExist(Client client) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_GET_USER_BY_LOGIN)) {
            ps.setString(1, client.getLogin());
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
        return false;
    }
}
