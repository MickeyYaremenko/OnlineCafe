package by.htp.onlinecafe.dao.impl;

import by.htp.onlinecafe.dao.util.SQLConnectionPool;
import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.dao.OrderDAO;
import by.htp.onlinecafe.entity.Client;
import by.htp.onlinecafe.entity.dto.OrderTO;
import by.htp.onlinecafe.entity.MenuItem;

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
    private static final String SQL_CREATE_BILL = "INSERT INTO cafe.bill (id_order, order_sum) VALUES (?, ?)";
    private static final String SQL_CLIENT_HISTORY = "SELECT order.id_order, order.order_date, order.id_client, " +
            "bill.order_sum, order.order_status FROM cafe.order JOIN bill ON bill.id_order = order.id_order " +
            "WHERE order.id_client = ? AND order.order_status = 'Served'";
    private static final String SQL_CLIENT_CURRENT_ORDERS = "SELECT order.id_order, order.order_date, order.id_client," +
            " bill.order_sum, order.order_status FROM cafe.order JOIN bill ON bill.id_order = order.id_order " +
            "WHERE order.id_client = ? AND NOT order.order_status = 'Served'";
    private static final String SQL_ACTIVE_ORDERS = "SELECT order.id_order, order.order_date, order.id_client," +
            " bill.order_sum, order.order_status FROM cafe.order JOIN bill ON bill.id_order = order.id_order " +
            "WHERE NOT order.order_status = 'Served'";
    private static final String SQL_UPDATE_CLIENT_BALANCE = "UPDATE client SET balance = ? WHERE login = ?";
    private static final String SQL_UPDATE_ORDER_STATUS = "UPDATE cafe.order SET order_status = ?  WHERE id_order = ?";

    private OrderDAOImpl(){
    }

    public static OrderDAOImpl getInstance(){
        if (instance == null){
            instance = new OrderDAOImpl();
        }
        return instance;
    }

    @Override
    public void makeOrder(OrderTO orderTO) throws DAOException {
        if (orderTO.getSum().compareTo(orderTO.getClient().getBalance()) < 0) {
            try (Connection connection = SQLConnectionPool.getConnection();
                 PreparedStatement ps = connection.prepareStatement(SQL_CREATE_ORDER, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement ps2 = connection.prepareStatement(SQL_CREATE_BILL);
                 PreparedStatement ps3 = connection.prepareStatement(SQL_ADD_ORDER_ITEMS);
                 PreparedStatement ps4 = connection.prepareStatement(SQL_UPDATE_CLIENT_BALANCE)) {
                connection.setAutoCommit(false);
                try {
                    ps.setInt(1, orderTO.getClient().getId());
                    ps.executeUpdate();
                    ResultSet keys = ps.getGeneratedKeys();
                    if (keys.next()) {
                            Integer orderID = keys.getInt(1);
                            ps2.setInt(1, orderID);
                            ps2.setBigDecimal(2, orderTO.getSum());
                            ps2.executeUpdate();
                            orderTO.getClient().setBalance(orderTO.getClient().getBalance().subtract(orderTO.getSum()));
                            ps4.setBigDecimal(1, orderTO.getClient().getBalance());
                            ps4.setString(2, orderTO.getClient().getLogin());
                            ps4.executeUpdate();

                            for (Map.Entry<MenuItem, Integer> entry : orderTO.getItems().entrySet()) {
                                ps3.setInt(1, entry.getKey().getId());
                                ps3.setInt(2, orderID);
                                ps3.setInt(3, entry.getValue());
                                ps3.addBatch();
                            }
                            ps3.executeBatch();
                            connection.commit();
                    }
                } catch (SQLException parentException){
                    connection.rollback();
                    throw new SQLException(parentException);
                }
            } catch (SQLException | NamingException e) {
                throw new DAOException(e);
            }
        }
    }

    @Override
    public List<OrderTO> clientHistory(Client client) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_CLIENT_HISTORY)) {
            ps.setInt(1, client.getId());
            ResultSet resultSet = ps.executeQuery();
            List<OrderTO> clientHistory = orderTOSFromRS(resultSet);
            return clientHistory;
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<OrderTO> currentClientOrders(Client client) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_CLIENT_CURRENT_ORDERS)) {
            ps.setInt(1, client.getId());
            ResultSet resultSet = ps.executeQuery();
            List<OrderTO> currentOrders = orderTOSFromRS(resultSet);
            return currentOrders;
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<OrderTO> showActive() throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_ACTIVE_ORDERS)) {
            ResultSet resultSet = ps.executeQuery();
            List<OrderTO> currentOrders = orderTOSFromRS(resultSet);
            return currentOrders;
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void setStatus(Integer orderID, String status) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_ORDER_STATUS)) {
            ps.setString(1, status);
            ps.setInt(2, orderID);
            ps.executeUpdate();
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    private List<OrderTO> orderTOSFromRS(ResultSet resultSet) throws SQLException {
        List<OrderTO> orderList = new ArrayList<>();
        while (resultSet.next()) {
            OrderTO orderTO = new OrderTO();
            orderTO.setId(resultSet.getInt(1));
            orderTO.setDateTime(resultSet.getTimestamp(2).toLocalDateTime());
            orderTO.setClient(new Client());
            orderTO.getClient().setId(resultSet.getInt(3));
            orderTO.setSum(resultSet.getBigDecimal(4));
            orderTO.setStatus(OrderTO.Status.valueOf(resultSet.getString(5).toUpperCase()));
            orderList.add(orderTO);
        }
        return orderList;
    }
}
