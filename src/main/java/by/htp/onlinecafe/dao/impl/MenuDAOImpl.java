package by.htp.onlinecafe.dao.impl;

import by.htp.onlinecafe.dao.MenuDAO;
import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.entity.dto.MenuTO;
import by.htp.onlinecafe.dao.util.SQLConnectionPool;

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
    public MenuTO getActive(MenuTO.MenuLanguage language) throws DAOException{
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_ACTIVE_MENU_BY_LANGUAGE)) {
            ps.setString(1, language.toString());
            ResultSet resultSet = ps.executeQuery();
            MenuTO menuTO = new MenuTO();
            if (resultSet.next()) {
                menuTO.setId(resultSet.getInt(1));
                menuTO.setCreationTime(resultSet.getTimestamp(2).toLocalDateTime());
                menuTO.setMenuStatus(MenuTO.MenuStatus.valueOf(resultSet.getString(3)));
                menuTO.setMenuLanguage(MenuTO.MenuLanguage.valueOf(resultSet.getString(4)));
            }
            return menuTO;
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<MenuTO> getAll() throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_GET_ALL_MENUS)) {
            ResultSet resultSet = ps.executeQuery();
            List<MenuTO> menuTOList = new ArrayList<>();
            while (resultSet.next()) {
                MenuTO menuTO = new MenuTO();
                menuTO.setId(resultSet.getInt(1));
                menuTO.setCreationTime(resultSet.getTimestamp(2).toLocalDateTime());
                menuTO.setMenuStatus(MenuTO.MenuStatus.valueOf(resultSet.getString(3)));
                menuTO.setMenuLanguage(MenuTO.MenuLanguage.valueOf(resultSet.getString(4)));
                menuTOList.add(menuTO);
            }
            return menuTOList;
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public MenuTO getByID(Integer id) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_GET_MENU_BY_ID)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            MenuTO menuTO = new MenuTO();
            if (resultSet.next()) {
                menuTO.setId(resultSet.getInt(1));
                menuTO.setCreationTime(resultSet.getTimestamp(2).toLocalDateTime());
                menuTO.setMenuStatus(MenuTO.MenuStatus.valueOf(resultSet.getString(3)));
                menuTO.setMenuLanguage(MenuTO.MenuLanguage.valueOf(resultSet.getString(4)));
            }
            return menuTO;
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void update(MenuTO menuTO, List<Integer> itemsIDList) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_DELETE_FROM_MENU);
             PreparedStatement ps2 = connection.prepareStatement(SQL_ADD_ITEMS_TO_MENU);
             PreparedStatement ps3 = connection.prepareStatement(SQL_UPDATE_MENU)) {
            try {
                connection.setAutoCommit(false);
                ps.setInt(1, menuTO.getId());

                for (Integer itemID: itemsIDList){
                    ps2.setInt(1, menuTO.getId());
                    ps2.setInt(2, itemID);
                    ps2.addBatch();
                }

                ps3.setString(1, menuTO.getMenuStatus().toString());
                ps3.setString(2, menuTO.getMenuLanguage().toString());
                ps3.setInt(3, menuTO.getId());

                ps.executeUpdate();
                ps2.executeBatch();
                ps3.executeUpdate();
                connection.commit();
            } catch (SQLException commitException) {
                connection.rollback();
            }
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void create(MenuTO menuTO, List<Integer> itemsIDList) throws DAOException {
        try (Connection connection = SQLConnectionPool.getConnection();
             Connection connection1 = SQLConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_CREATE_MENU, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement ps2 = connection1.prepareStatement(SQL_ADD_ITEMS_TO_MENU)) {
            connection.setAutoCommit(false);
            connection1.setAutoCommit(false);

            try {
                ps.setString(1, menuTO.getMenuStatus().toString());
                ps.setString(2, menuTO.getMenuLanguage().toString());
                ps.executeUpdate();
                ResultSet keys = ps.getGeneratedKeys();

                if (keys.next()){
                    try {
                        for (Integer itemID: itemsIDList){
                            ps2.setInt(1, keys.getInt(1));
                            ps2.setInt(2, itemID);
                            ps2.addBatch();
                        }
                        ps2.executeBatch();
                        connection.commit();
                        connection1.commit();
                    } catch (SQLException childException){
                    connection.rollback();
                    connection1.rollback();
                }
                }
            } catch (SQLException parentException){
                connection.rollback();
            }
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }
}
