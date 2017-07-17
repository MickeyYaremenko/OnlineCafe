package by.htp.onlinecafe.dao.impl;

import by.htp.onlinecafe.util.SQLConnectionPool;
import by.htp.onlinecafe.dao.BillDAO;
import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.entity.Bill;
import by.htp.onlinecafe.entity.Client;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAOImpl implements BillDAO{

    private static BillDAOImpl instance;

    private static final String SQL_CLIENT_HISTORY = "SELECT * FROM bill JOIN order ON " +
            "bill.id_order = order.id_order WHERE order.id_client = ?";
    private static final String SQL_ALL_HISTORY = null;

    private BillDAOImpl(){
    }

    public static BillDAOImpl getInstance(){
        if (instance == null){
            instance = new BillDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Bill> clientHistory(Client client) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_CLIENT_HISTORY)) {
            List<Bill> clientHistory = new ArrayList<>();
            ps.setInt(1, client.getId());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Bill bill = new Bill();
                bill.setOrderID(resultSet.getInt(1));
                bill.setSum(resultSet.getBigDecimal(2));
                clientHistory.add(bill);
            }
            return clientHistory;
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Bill> allHistory() {
        return null;
    }
}
