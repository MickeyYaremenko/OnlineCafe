package by.htp.onlinecafe.service.factory;

import by.htp.onlinecafe.service.*;
import by.htp.onlinecafe.service.impl.*;

public class ServiceFactory {
    private static ServiceFactory instance;

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        if (instance == null){
            instance = new ServiceFactory();
        }
        return instance;
    }

    public BillService getBillService(){
        return BillServiceImpl.getInstance();
    }

    public ClientService getClientService(){
        return ClientServiceImpl.getInstance();
    }

    public MenuItemService getMenuItemService(){
        return MenuItemServiceImpl.getInstance();
    }

    public OrderService getOrderService(){
        return OrderServiceImpl.getInstance();
    }

    public MenuService getMenuService(){
        return MenuServiceImpl.getInstance();
    }
}
