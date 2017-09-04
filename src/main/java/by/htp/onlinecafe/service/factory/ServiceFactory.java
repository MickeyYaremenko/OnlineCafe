package by.htp.onlinecafe.service.factory;

import by.htp.onlinecafe.service.*;
import by.htp.onlinecafe.service.impl.*;

/**
 * Provides necessary instance of Service object.
 */
public class ServiceFactory {
    private static ServiceFactory instance;

    private ServiceFactory(){}

    /**
     * Returns an instance of ServiceFactory
     * @return {@link ServiceFactory} object
     */
    public static ServiceFactory getInstance(){
        if (instance == null){
            instance = new ServiceFactory();
        }
        return instance;
    }

    /**
     * Returns an implementation of a ClientService interface.
     * @return {@link ClientService} object
     */
    public ClientService getClientService(){
        return ClientServiceImpl.getInstance();
    }

    /**
     * Returns an implementation of a MenuItemService interface.
     * @return {@link MenuItemService} object
     */
    public MenuItemService getMenuItemService(){
        return MenuItemServiceImpl.getInstance();
    }

    /**
     * Returns an implementation of a OrderService interface.
     * @return {@link OrderService} object
     */
    public OrderService getOrderService(){
        return OrderServiceImpl.getInstance();
    }

    /**
     * Returns an implementation of a MenuService interface.
     * @return {@link MenuService} object
     */
    public MenuService getMenuService(){
        return MenuServiceImpl.getInstance();
    }
}
