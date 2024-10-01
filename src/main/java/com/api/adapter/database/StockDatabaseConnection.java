package com.api.adapter.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StockDatabaseConnection {

    public static Statement connectDatabase() throws ClassNotFoundException, SQLException {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/vini_produtos";
        String username = "postgres";
        String password = "9630";

        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        Statement statement = connection.createStatement();
        return statement;

    }
}