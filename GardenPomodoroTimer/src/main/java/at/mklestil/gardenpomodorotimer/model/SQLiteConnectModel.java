package at.mklestil.gardenpomodorotimer.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnectModel {

    private Connection connection;

    public void connect() {
        connection = null;
        try {
            // SQLite connection string
            String url = "jdbc:sqlite:mydatabase.db";

            // // Establish connection (database will be created if it does not exist)
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Create Table
    public void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS images (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    path TEXT NOT NULL
                );
                """;
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabelle 'images' erstellt (falls nicht vorhanden).");
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen der Tabelle: " + e.getMessage());
        }
    }

    //Set Images Path
    public void insertImagePath(String imagePath) {
        String sql = "INSERT INTO images (path) VALUES('" + imagePath + "')";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Bildpfad eingefügt: " + imagePath);
        } catch (SQLException e) {
            System.out.println("Fehler beim Einfügen des Bildpfads: " + e.getMessage());
        }
    }
}
