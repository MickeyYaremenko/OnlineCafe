package by.htp.onlinecafe.dao;

import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.entity.dto.OrderTO;

import java.util.List;

public interface OrderDAO {

    void makeOrder(OrderTO orderTO) throws DAOException;
    List<OrderTO> clientHistory (Client client) throws DAOException;
    List<OrderTO> currentClientOrders(Client client) throws DAOException;
    List<OrderTO> showActive() throws DAOException;
    void setStatus(Integer orderID, String status) throws DAOException;
}
