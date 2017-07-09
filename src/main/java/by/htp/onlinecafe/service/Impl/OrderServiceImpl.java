package by.htp.onlinecafe.service.Impl;

import by.htp.onlinecafe.dao.Exception.DAOException;
import by.htp.onlinecafe.dao.Impl.OrderDAOImpl;
import by.htp.onlinecafe.dao.OrderDAO;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.entity.DTO.OrderTO;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.service.Exception.ServiceException;
import by.htp.onlinecafe.service.OrderService;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService{

    private static OrderServiceImpl instance;

    private OrderServiceImpl(){}

    public static OrderServiceImpl getInstance(){
        if (instance == null){
            instance = new OrderServiceImpl();
        }
        return instance;
    }

    @Override
    public void makeOrder(Map<MenuItem, Integer> order, Client client) throws ServiceException {
        OrderTO orderTO = new OrderTO();
        orderTO.setItems(order);
        orderTO.setClient(client);
        orderTO.countSum();
        OrderDAO orderDAO = OrderDAOImpl.getInstance();
        try {
            orderDAO.makeOrder(orderTO);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<OrderTO> clientHistory(Client client) throws ServiceException {
        try {
            OrderDAO orderDAO = OrderDAOImpl.getInstance();
            List<OrderTO> clientHistory = orderDAO.clientHistory(client);
            return clientHistory;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<OrderTO> currentClientOrders(Client client) throws ServiceException {
        try {
            OrderDAO orderDAO = OrderDAOImpl.getInstance();
            List<OrderTO> currentOrders = orderDAO.currentClientOrders(client);
            return currentOrders;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
