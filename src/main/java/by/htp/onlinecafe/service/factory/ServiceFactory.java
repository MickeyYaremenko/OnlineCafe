package by.htp.onlinecafe.service.factory;

import by.htp.onlinecafe.service.BillService;
import by.htp.onlinecafe.service.ClientService;
import by.htp.onlinecafe.service.MenuItemService;
import by.htp.onlinecafe.service.OrderService;
import by.htp.onlinecafe.service.impl.BillServiceImpl;
import by.htp.onlinecafe.service.impl.ClientServiceImpl;
import by.htp.onlinecafe.service.impl.MenuItemServiceImpl;
import by.htp.onlinecafe.service.impl.OrderServiceImpl;

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
}
