package by.htp.onlinecafe.dao.Impl;

import by.htp.onlinecafe.Util.SQLConnectionPool;
import by.htp.onlinecafe.dao.Exception.DAOException;
import by.htp.onlinecafe.dao.OrderDAO;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.entity.DTO.OrderTO;
import by.htp.onlinecafe.entity.MenuItem;
import by.htp.onlinecafe.entity.Order;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class OrderDAOImpl implements OrderDAO {

    private static OrderDAOImpl instance;

    private static final String SQL_CREATE_ORDER = "INSERT INTO cafe.order (id_client) VALUES (?)";
    private static final String SQL_ADD_ORDER_ITEMS = "INSERT INTO order_menu_item (id_menu_item, id_order, quantity)" +
            "VALUES (?, ?, ?)";
    private static final String SQL_CLIENT_HISTORY = "SELECT order.id_order, order.order_date, bill.order_sum  FROM cafe.order " +
            "JOIN bill ON bill.id_order = order.id_order WHERE order.id_client = ?";

    private OrderDAOImpl(){
    }

    public static OrderDAOImpl getInstance(){
        if (instance == null){
            instance = new OrderDAOImpl();
        }
        return instance;
    }

    @Override
    public void makeOrder(Order order) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_CREATE_ORDER, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, order.getClientID());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()){
                Integer orderID = keys.getInt(1);
                for (Map.Entry<MenuItem, Integer> entry: order.getItems().entrySet()){
                    try (PreparedStatement ps2 = connection.prepareStatement(SQL_ADD_ORDER_ITEMS)){
                        ps2.setInt(1, entry.getKey().getId());
                        ps2.setInt(2, orderID);
                        ps2.setInt(3, entry.getValue());
                        ps2.executeUpdate();
                    } catch (SQLException e){
                        throw new DAOException(e);
                    }
                }
            }
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<OrderTO> clientHistory(Client client) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_CLIENT_HISTORY)) {
            List<OrderTO> clientHistory = new ArrayList<>();
            ps.setInt(1, client.getId());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                OrderTO orderTO = new OrderTO();
                orderTO.setId(resultSet.getInt(1));
                orderTO.setDateTime(resultSet.getTimestamp(2).toLocalDateTime());
                orderTO.setSum(resultSet.getBigDecimal(3));
                clientHistory.add(orderTO);
            }
            return clientHistory;
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }


}
