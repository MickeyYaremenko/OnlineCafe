package by.htp.onlinecafe.service;

import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.entity.DTO.OrderTO;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.Exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface OrderService {

    void makeOrder(Map<MenuItem, Integer> order, Client client) throws ServiceException;
    List<OrderTO> clientHistory(Client client) throws ServiceException;
    List<OrderTO> currentClientOrders(Client client) throws ServiceException;
    List<OrderTO> showActive() throws ServiceException;
    void setStatus(Integer orderID, String status) throws ServiceException;
}
