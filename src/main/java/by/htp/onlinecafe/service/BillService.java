package by.htp.onlinecafe.service;

import by.htp.onlinecafe.entity.Bill;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.Exception.ServiceException;

import java.util.List;

/**
 * Created by Mike Yaremenko on 26.06.2017.
 */
public interface BillService {
    List<Bill> clientHistory(Client client) throws ServiceException;
    List<Bill> allHistory();
}
