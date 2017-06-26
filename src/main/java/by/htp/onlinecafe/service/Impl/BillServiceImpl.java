package by.htp.onlinecafe.service.Impl;

import by.htp.onlinecafe.dao.BillDAO;
import by.htp.onlinecafe.dao.Exception.DAOException;
import by.htp.onlinecafe.dao.Impl.BillDAOImpl;
import by.htp.onlinecafe.entity.Bill;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.service.BillService;
import by.htp.onlinecafe.service.Exception.ServiceException;

import java.util.List;

public class BillServiceImpl implements BillService{

    private static BillServiceImpl instance;

    private BillServiceImpl(){
    }

    public static BillServiceImpl getInstance(){
        if (instance == null){
            instance = new BillServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Bill> clientHistory(Client client) throws ServiceException {
        try {
            BillDAO billDAO = BillDAOImpl.getInstance();
            List<Bill> clientHistory = billDAO.clientHistory(client);
            return clientHistory;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Bill> allHistory() {
        return null;
    }

}
