package by.htp.onlinecafe.dao.impl;

import by.htp.onlinecafe.util.SQLConnectionPool;
import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.dao.MenuItemDAO;
import by.htp.onlinecafe.entity.MenuItem;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuItemDAOImpl implements MenuItemDAO{

    private static MenuItemDAOImpl instance;

    private static final String SQL_MENU_ITEM_BY_CATEGORY = "SELECT * FROM menu_item WHERE category = ?";
    private static final String SQL_MENU_ITEM_BY_TITLE = "SELECT * FROM menu_item WHERE title = ?";
    private static final String SQL_ALL_MENU_ITEM = "SELECT * FROM menu_item";
    private static final String SQL_UPDATE_MENU_ITEM = "UPDATE menu_item SET title = ?, weight = ?," +
            "price = ?, category = ?, description = ? WHERE id_menu_item = ?";
    private static final String SQL_ADD_NEW_MENU_ITEM = "INSERT INTO menu_item (title, weight, price, category, description)" +
            "VALUES(?,?,?,?,?)";

    private MenuItemDAOImpl(){
    }

    public static MenuItemDAOImpl getInstance(){
        if (instance == null){
            instance = new MenuItemDAOImpl();
        }
        return instance;
    }

    @Override
    public List<MenuItem> showByCategory(String category) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_MENU_ITEM_BY_CATEGORY)) {
            ps.setString(1, category);
            ResultSet resultSet = ps.executeQuery();
            List <MenuItem> menuItemList = new ArrayList<>();
            while (resultSet.next()) {
                MenuItem menuItem = new MenuItem();
                menuItem.setId(resultSet.getInt(1));
                menuItem.setTitle(resultSet.getString(2));
                menuItem.setWeight(resultSet.getString(3));
                menuItem.setPrice(resultSet.getBigDecimal(4));
                menuItem.setCategory(resultSet.getString(5));
                menuItem.setDescription(resultSet.getString(6));
                menuItemList.add(menuItem);
            }
            return menuItemList;
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public MenuItem getByTitle(String title) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_MENU_ITEM_BY_TITLE)) {
            ps.setString(1, title);
            ResultSet resultSet = ps.executeQuery();
            MenuItem menuItem = new MenuItem();
            if (resultSet.next()) {
                menuItem.setId(resultSet.getInt(1));
                menuItem.setTitle(resultSet.getString(2));
                menuItem.setWeight(resultSet.getString(3));
                menuItem.setPrice(resultSet.getBigDecimal(4));
                menuItem.setCategory(resultSet.getString(5));
                menuItem.setDescription(resultSet.getString(6));
            } else {
                throw new DAOException("There is no item with this title");
            }
            return menuItem;
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<MenuItem> showAll() throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_ALL_MENU_ITEM)) {
            ResultSet resultSet = ps.executeQuery();
            List <MenuItem> menuItemList = new ArrayList<>();
            while (resultSet.next()) {
                MenuItem menuItem = new MenuItem();
                menuItem.setId(resultSet.getInt(1));
                menuItem.setTitle(resultSet.getString(2));
                menuItem.setWeight(resultSet.getString(3));
                menuItem.setPrice(resultSet.getBigDecimal(4));
                menuItem.setCategory(resultSet.getString(5));
                menuItem.setDescription(resultSet.getString(6));
                menuItemList.add(menuItem);
            }
            return menuItemList;
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void updateItem(MenuItem menuItem) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_MENU_ITEM)) {
            ps.setString(1, menuItem.getTitle());
            ps.setString(2, menuItem.getWeight());
            ps.setBigDecimal(3, menuItem.getPrice());
            ps.setString(4, menuItem.getCategory());
            ps.setString(5, menuItem.getDescription());
            ps.setInt(6, menuItem.getId());
            ps.executeUpdate();
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void addNew(MenuItem menuItem) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_ADD_NEW_MENU_ITEM)) {
            ps.setString(1, menuItem.getTitle());
            ps.setString(2, menuItem.getWeight());
            ps.setBigDecimal(3, menuItem.getPrice());
            ps.setString(4, menuItem.getCategory());
            ps.setString(5, menuItem.getDescription());
            ps.executeUpdate();
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

}
