package by.htp.onlinecafe.dao;

import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.entity.dto.OrderTO;
import by.htp.onlinecafe.entity.Order;

import java.util.List;

/**
 * Provides a DAO-logic for the {@link Order} entity in database
 */
public interface OrderDAO {

    /**
     * Adds order to database
     * @param orderTO to add
     * @throws DAOException
     */
    void makeOrder(OrderTO orderTO) throws DAOException;

    /**
     * ReturnsList containing history of client's orders
     * @param client
     * @return {@link List<OrderTO>} object
     * @throws DAOException
     */
    List<OrderTO> clientHistory (Client client) throws DAOException;

    /**
     * Returns List of current client's orders
     * @param client
     * @return {@link List<OrderTO>} object
     * @throws DAOException
     */
    List<OrderTO> currentClientOrders(Client client) throws DAOException;

    /**
     * Returns list of orders to be served
     * @return {@link List<OrderTO>} object
     * @throws DAOException
     */
    List<OrderTO> showActive() throws DAOException;

    /**
     * Set order's status to chosen one
     * @param orderID of order to be changed
     * @param status to be set
     * @throws DAOException
     */
    void setStatus(Integer orderID, String status) throws DAOException;
}
