package by.htp.onlinecafe.dao.impl;

import by.htp.onlinecafe.dao.MenuDAO;
import by.htp.onlinecafe.dao.exception.DAOException;
import by.htp.onlinecafe.entity.Menu;
import by.htp.onlinecafe.util.SQLConnectionPool;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuDAOImpl implements MenuDAO{

    private static MenuDAOImpl instance;

    private static final String SQL_ACTIVE_MENU_BY_LANGUAGE = "SELECT * FROM menu WHERE menu.status = 'ACTIVE'" +
            "AND menu.language = ?";

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
}
