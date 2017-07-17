package by.htp.onlinecafe.dao;

import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.entity.Bill;
import by.htp.onlinecafe.entity.Client;

import java.util.List;

public interface BillDAO {
    List<Bill> clientHistory(Client client) throws DAOException;
    List<Bill> allHistory();
}
