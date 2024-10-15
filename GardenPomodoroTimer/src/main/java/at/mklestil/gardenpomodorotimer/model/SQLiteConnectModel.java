package at.mklestil.gardenpomodorotimer.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnectModel {

    public static Connection connect() {
        Connection conn = null;
        try {
            // SQLite connection string
            String url = "jdbc:sqlite:mydatabase.db";

            // // Establish connection (database will be created if it does not exist)
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
