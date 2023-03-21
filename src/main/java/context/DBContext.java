package context;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Trần Đăng Khoa - CE160367
 */
public class DBContext {
    
    // local host name 
    private static final String dbPrefix = "jdbc:sqlserver://localhost";
    // set port here
    private static final String dbPort = "1433";
    // database name to connect sql
    private static final String databaseName = "NowSaiGonDB";
    // instance to for connection
    private final String instance = "";
    // user name when seting to connect
    private static final String user = "sa";
    // password when seting to connect
    private static final String pass = "123456";

    /**
     * To connect with SQL server to process data.
     * @return a connection to SQL
     */
    public Connection getConnection() {
        Connection conn = null;
        String dbURL = dbPrefix + ":" + dbPort + "\\" + instance + ";" + "databaseName=" + databaseName;
        if (instance == null || instance.trim().isEmpty()) {
            dbURL = dbPrefix + ":" + dbPort + ";" + "databaseName=" + databaseName;
        }
        try {
            DriverManager.registerDriver(new SQLServerDriver());
            conn = DriverManager.getConnection(dbURL, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
