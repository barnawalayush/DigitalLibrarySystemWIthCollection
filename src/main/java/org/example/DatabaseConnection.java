package org.example;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class DatabaseConnection {

    public static Connection connect(){

        String url = "jdbc:postgresql://localhost:5432/librarysystemdatabase?user=postgres";
        java.sql.Connection connection;

        try {
            connection = getConnection(url, "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
