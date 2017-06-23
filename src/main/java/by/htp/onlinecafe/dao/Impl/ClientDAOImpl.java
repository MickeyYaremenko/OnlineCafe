package by.htp.onlinecafe.dao.Impl;

import by.htp.onlinecafe.Util.SQLConnectionPool;
import by.htp.onlinecafe.dao.ClientDAO;
import by.htp.onlinecafe.dao.Exception.DAOException;
import by.htp.onlinecafe.entity.Client;

import javax.naming.NamingException;
import java.sql.*;

/**
 * Created by Mike Yaremenko on 17.06.2017.
 */
public class ClientDAOImpl implements ClientDAO {

    private static final String SQL_GET_USER_BY_LOGIN = "SELECT * FROM client WHERE login=?";
    private static final String SQL_REGISTER="INSERT INTO client" +
            "(login, password, first_name, last_name, email) VALUES(?,?,?,?,?,?)";

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

            } catch (SQLException | NamingException e) {
                throw new DAOException(e);
            }
        }
        return client;
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
