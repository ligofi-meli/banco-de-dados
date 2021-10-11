package gomes.filipe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "89169118");
        return connection;
    }
}
