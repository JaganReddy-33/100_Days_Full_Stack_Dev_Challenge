package day55;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionEx {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Properties properties = new Properties();

        try (InputStream input = ConnectionEx.class
                .getClassLoader()
                .getResourceAsStream("db.properties")) {

            if (input == null) {
                throw new SQLException("db.properties file not found");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new SQLException("Failed to load database properties", e);
        }

        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, username, password);
	}
}
