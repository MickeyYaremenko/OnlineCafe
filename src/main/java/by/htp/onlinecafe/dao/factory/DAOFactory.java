package by.htp.onlinecafe.dao.factory;

import by.htp.onlinecafe.dao.BillDAO;
import by.htp.onlinecafe.dao.ClientDAO;
import by.htp.onlinecafe.dao.MenuItemDAO;
import by.htp.onlinecafe.dao.OrderDAO;
import by.htp.onlinecafe.dao.impl.BillDAOImpl;
import by.htp.onlinecafe.dao.impl.ClientDAOImpl;
import by.htp.onlinecafe.dao.impl.MenuItemDAOImpl;
import by.htp.onlinecafe.dao.impl.OrderDAOImpl;

public class DAOFactory {
    private static DAOFactory instance;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        if (instance == null){
            instance = new DAOFactory();
        }
        return instance;
    }

    public BillDAO getBillDAO(){
        return BillDAOImpl.getInstance();
    }

    public ClientDAO getClientDAO(){
        return ClientDAOImpl.getInstance();
    }

    public MenuItemDAO getMenuItemDAO(){
        return MenuItemDAOImpl.getInstance();
    }

    public OrderDAO getOrderDAO(){
        return OrderDAOImpl.getInstance();
    }
}
