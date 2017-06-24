package by.htp.onlinecafe.dao.Impl;

import by.htp.onlinecafe.Util.SQLConnectionPool;
import by.htp.onlinecafe.dao.Exception.DAOException;
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

    private static final String SQL_MENU_ITEM_BY_CATEGORY = "SELECT * FROM menu_item WHERE category=?";

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
                menuItem.setTitle(resultSet.getString(2));
                menuItem.setPrice(resultSet.getBigDecimal(3));
                menuItem.setCategory(resultSet.getString(4));
                menuItem.setDescription(resultSet.getString(5));
                menuItemList.add(menuItem);
            }
            return menuItemList;
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }
}
