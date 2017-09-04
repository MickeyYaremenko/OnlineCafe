package by.htp.onlinecafe.dao.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Class that provides connection to a database from connection pool
 */
public class SQLConnectionPool {

    private static InitialContext initialContext;
    private static DataSource ds;

    /**
     * Provides connection to a database from connection pool
     * @return {@link Connection} object
     */
    public static Connection getConnection() throws NamingException, SQLException {
        initialContext = new InitialContext();
        ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/cafe");
        Connection connection = ds.getConnection();
        return connection;
    }
}
