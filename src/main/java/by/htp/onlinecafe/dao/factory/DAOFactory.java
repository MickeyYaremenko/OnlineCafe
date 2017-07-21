package by.htp.onlinecafe.dao.factory;

import by.htp.onlinecafe.dao.*;
import by.htp.onlinecafe.dao.impl.*;

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

    public MenuDAO getMenuDAO(){
        return MenuDAOImpl.getInstance();
    }
}
