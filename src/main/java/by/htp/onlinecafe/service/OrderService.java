package by.htp.onlinecafe.service;

import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.entity.Order;
import by.htp.onlinecafe.entity.dto.OrderTO;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * Provides service-logic for {@link Order} entity
 */
public interface OrderService {

    /**
     * Adds order to database
     * @param order to add
     * @param client who adds order
     * @throws ServiceException
     */
    Boolean makeOrder(Map<MenuItem, Integer> order, Client client) throws ServiceException;

    /**
     * ReturnsList containing history of client's orders
     * @param client
     * @return {@link List<OrderTO>} object
     * @throws ServiceException
     */
    List<OrderTO> clientHistory(Client client) throws ServiceException;

    /**
     * Returns List of current client's orders
     * @param client
     * @return {@link List<OrderTO>} object
     * @throws ServiceException
     */
    List<OrderTO> currentClientOrders(Client client) throws ServiceException;

    /**
     * Returns list of orders to be served
     * @return {@link List<OrderTO>} object
     * @throws ServiceException
     */
    List<OrderTO> showActive() throws ServiceException;

    /**
     * Set order's status to chosen one
     * @param orderID of order to be changed
     * @param status to be set
     * @throws ServiceException
     */
    void setStatus(Integer orderID, String status) throws ServiceException;

    /**
     * Returns {@link OrderTO} with defined id
     * @param orderId of order to get
     * @return {@link OrderTO} object
     * @throws ServiceException
     */
    OrderTO getById(Integer orderId) throws ServiceException;
}
