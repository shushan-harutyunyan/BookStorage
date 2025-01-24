package org.example.bookStorage.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {
    private static DBConnectionProvider dbConnectionProvider = null;
    private Connection connection;

    private DBConnectionProvider() {
    }

    ;

    public static DBConnectionProvider getInstance() {
        if (dbConnectionProvider == null) {
            dbConnectionProvider = new DBConnectionProvider();
        }
        return dbConnectionProvider;
    }

    public Connection getConnection(){
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_storage_db", "java", "password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

