package by.htp.onlinecafe.Util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class SQLConnectionPool {

    private static InitialContext initialContext;
    private static DataSource ds;

    public static Connection getConnection() throws NamingException, SQLException {
        initialContext = new InitialContext();
        ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/cafe");
        Connection connection = ds.getConnection();
        return connection;
    }
}
