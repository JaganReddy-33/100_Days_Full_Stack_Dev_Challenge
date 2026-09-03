package day53;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionEx {

    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
 
    
    static {

        Properties properties = new Properties();

        try (InputStream input = ConnectionEx.class
                .getClassLoader()
                .getResourceAsStream("db.properties")) {

            if (input == null) {
                throw new RuntimeException("db.properties file not found");
            }

            properties.load(input);

            URL = properties.getProperty("db.url");
            USERNAME = properties.getProperty("db.username");
            PASSWORD = properties.getProperty("db.password");

        } catch (IOException e) {
            throw new RuntimeException("Failed to load database configuration", e);
        }
    }
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                URL,
                USERNAME,
                PASSWORD
        );
    }
}