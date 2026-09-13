package day58;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionEx {

    private static final String CONFIG_FILE = "db.properties";

    public static Connection getConnection() throws SQLException {
        try {
            Properties properties = new Properties();

            InputStream input = ConnectionEx.class
                    .getClassLoader()
                    .getResourceAsStream(CONFIG_FILE);

            if (input == null) {
                throw new SQLException("db.properties file not found");
            }

            properties.load(input);

            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        } catch (Exception e) {
            throw new SQLException("Database connection failed", e);
        }
    }
}