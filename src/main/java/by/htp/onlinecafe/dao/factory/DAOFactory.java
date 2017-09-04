package by.htp.onlinecafe.dao.factory;

import by.htp.onlinecafe.dao.*;
import by.htp.onlinecafe.dao.impl.*;

/**
 * Provides necessary instance of DAO object.
 */
public class DAOFactory {
    private static DAOFactory instance;

    private DAOFactory(){}

    /**
     * Returns an instance of DAOFactory
     * @return {@link DAOFactory} object
     */
    public static DAOFactory getInstance(){
        if (instance == null){
            instance = new DAOFactory();
        }
        return instance;
    }

    /**
     * Returns an implementation of a ClientDAO interface.
     * @return {@link ClientDAO} object
     */
    public ClientDAO getClientDAO(){
        return ClientDAOImpl.getInstance();
    }

    /**
     * Returns an implementation of a MenuItemDAO interface.
     * @return {@link MenuItemDAO} object
     */
    public MenuItemDAO getMenuItemDAO(){
        return MenuItemDAOImpl.getInstance();
    }

    /**
     * Returns an implementation of a OrderDAO interface.
     * @return {@link OrderDAO} object
     */
    public OrderDAO getOrderDAO(){
        return OrderDAOImpl.getInstance();
    }

    /**
     * Returns an implementation of a MenuDAO interface.
     * @return {@link MenuDAO} object
     */
    public MenuDAO getMenuDAO(){
        return MenuDAOImpl.getInstance();
    }
}
