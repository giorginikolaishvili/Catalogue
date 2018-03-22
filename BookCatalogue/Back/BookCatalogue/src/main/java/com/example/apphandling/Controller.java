package com.example.apphandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Controller {
    protected static String Username;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public Connection ConnecttoDatabase() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bookcatalogue?autoReconnect=true&useSSL=false",
                    "root", "gigi");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
