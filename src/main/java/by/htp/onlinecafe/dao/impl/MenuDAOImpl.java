package by.htp.onlinecafe.dao.impl;

import by.htp.onlinecafe.dao.MenuDAO;
import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.entity.Menu;
import by.htp.onlinecafe.util.SQLConnectionPool;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDAOImpl implements MenuDAO{

    private static MenuDAOImpl instance;

    private static final String SQL_ACTIVE_MENU_BY_LANGUAGE = "SELECT * FROM menu WHERE menu.status = 'ACTIVE'" +
            "AND menu.language = ?";
    private static final String SQL_GET_ALL_MENUS = "SELECT * FROM menu";
    private static final String SQL_GET_MENU_BY_ID = "SELECT * FROM menu WHERE menu_id = ?";
    private static final String SQL_DELETE_FROM_MENU = "DELETE FROM items_menu WHERE menu_id = ?";
    private static final String SQL_ADD_ITEMS_TO_MENU = "INSERT INTO items_menu (menu_id, menu_item_id) " +
            "VALUES (?, ?)";
    private static final String SQL_UPDATE_MENU = "UPDATE menu SET status = ?, language = ? WHERE menu_id = ?";
    private static final String SQL_CREATE_MENU = "INSERT INTO menu (status, language) VALUES (?, ?)";

    public static MenuDAOImpl getInstance() {
        if (instance == null){
            instance = new MenuDAOImpl();
        }
        return instance;
    }

    private MenuDAOImpl() {
    }

    @Override
    public Menu getActive(Menu.MenuLanguage language) throws DAOException{
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_ACTIVE_MENU_BY_LANGUAGE)) {
            ps.setString(1, language.toString());
            ResultSet resultSet = ps.executeQuery();
            Menu menu = new Menu();
            if (resultSet.next()) {
                menu.setId(resultSet.getInt(1));
                menu.setCreationTime(resultSet.getTimestamp(2).toLocalDateTime());
                menu.setMenuStatus(Menu.MenuStatus.valueOf(resultSet.getString(3)));
                menu.setMenuLanguage(Menu.MenuLanguage.valueOf(resultSet.getString(4)));
            }
            return menu;
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Menu> getAll() throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_GET_ALL_MENUS)) {
            ResultSet resultSet = ps.executeQuery();
            List<Menu> menuList = new ArrayList<>();
            while (resultSet.next()) {
                Menu menu = new Menu();
                menu.setId(resultSet.getInt(1));
                menu.setCreationTime(resultSet.getTimestamp(2).toLocalDateTime());
                menu.setMenuStatus(Menu.MenuStatus.valueOf(resultSet.getString(3)));
                menu.setMenuLanguage(Menu.MenuLanguage.valueOf(resultSet.getString(4)));
                menuList.add(menu);
            }
            return menuList;
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public Menu getByID(Integer id) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_GET_MENU_BY_ID)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            Menu menu = new Menu();
            if (resultSet.next()) {
                menu.setId(resultSet.getInt(1));
                menu.setCreationTime(resultSet.getTimestamp(2).toLocalDateTime());
                menu.setMenuStatus(Menu.MenuStatus.valueOf(resultSet.getString(3)));
                menu.setMenuLanguage(Menu.MenuLanguage.valueOf(resultSet.getString(4)));
            }
            return menu;
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void update(Menu menu, List<Integer> itemsIDList) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_DELETE_FROM_MENU);
             PreparedStatement ps2 = connection.prepareStatement(SQL_ADD_ITEMS_TO_MENU);
             PreparedStatement ps3 = connection.prepareStatement(SQL_UPDATE_MENU)) {
            ps.setInt(1, menu.getId());

            for (Integer itemID: itemsIDList){
                ps2.setInt(1, menu.getId());
                ps2.setInt(2, itemID);
                ps2.addBatch();
            }

            ps3.setString(1, menu.getMenuStatus().toString());
            ps3.setString(2, menu.getMenuLanguage().toString());
            ps3.setInt(3, menu.getId());

            ps.executeUpdate();
            ps2.executeBatch();
            ps3.executeUpdate();
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void create(Menu menu, List<Integer> itemsIDList) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_CREATE_MENU, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement ps2 = connection.prepareStatement(SQL_ADD_ITEMS_TO_MENU)) {

            ps.setString(1, menu.getMenuStatus().toString());
            ps.setString(2, menu.getMenuLanguage().toString());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();

            if (keys.next()){
                for (Integer itemID: itemsIDList){
                    ps2.setInt(1, keys.getInt(1));
                    ps2.setInt(2, itemID);
                    ps2.addBatch();
                }
                ps2.executeBatch();
            }

        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }
}
