package by.htp.onlinecafe.dao;

import by.htp.onlinecafe.dao.Exception.DAOException;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.entity.DTO.OrderTO;
import by.htp.onlinecafe.entity.Order;

import java.util.List;

public interface OrderDAO {

    void makeOrder(Order order) throws DAOException;
    List<OrderTO> clientHistory (Client client) throws DAOException;
}
