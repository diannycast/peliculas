package com.peliculas.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Gestión de conexión a NEON usando patrón Singleton.
 */
public class DatabaseConnection {

    private static Connection connection;

    private static final String URL = "jdbc:postgresql://ep-round-water-aq0xi6j3-pooler.c-8.us-east-1.aws.neon.tech/neondb?user=neondb_owner&password=npg_vh9BEJr3lCUR&sslmode=require&channelBinding=require";

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}