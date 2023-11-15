package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class TestConnexionJdbc {
    public static final String DB_USER;
    public static final String DB_URL;
    public static final String DB_MDP;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        DB_USER = bundle.getString("database.user");
        DB_URL = bundle.getString("database.url");
        DB_MDP = bundle.getString("database.password");
    }

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_MDP)) {
            System.out.println(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
