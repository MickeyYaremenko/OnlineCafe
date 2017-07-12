package by.htp.onlinecafe.dao;

import by.htp.onlinecafe.dao.Exception.DAOException;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.entity.DTO.OrderTO;

import java.util.List;

public interface OrderDAO {

    void makeOrder(OrderTO orderTO) throws DAOException;
    List<OrderTO> clientHistory (Client client) throws DAOException;
    List<OrderTO> currentClientOrders(Client client) throws DAOException;
    List<OrderTO> showActive() throws DAOException;
    void setStatus(Integer orderID, String status) throws DAOException;
}
