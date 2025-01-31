package at.mklestil.gardenpomodorotimer.model;

import java.sql.*;

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
            //System.out.println("Tabelle 'images' erstellt (falls nicht vorhanden).");
        } catch (SQLException e) {
            System.out.println("Error creating the table: " + e.getMessage());
        }
    }

    public void createTablePomodoroSessions() {
        if (connection == null) {
            System.out.println("Error: Keine gültige Datenbankverbindung!");
            return;
        }

        String sql = """
            CREATE TABLE IF NOT EXISTS pomodoro_sessions (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                duration INTEGER NOT NULL,
                plant_choice TEXT NOT NULL,
                timestamp DATETIME DEFAULT CURRENT_TIMESTAMP
            );
            """;

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'pomodoro_sessions' checked/created.");
        } catch (SQLException e) {
            System.err.println("Error creating the table: " + e.getMessage());
        }
    }

    //Todo:: Save and Load Sessions
    public void saveSession(int duration, String plantChoice){
        if (connection == null) {
            System.out.println("Error: No valid database connection!");
            return;
        }

        String sql = "INSERT INTO pomodoro_sessions (duration, plant_choice) VALUES (?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, duration);
            pstmt.setString(2, plantChoice);
            pstmt.executeUpdate();
            System.out.println("Session saved: " + duration + " min, plant: " + plantChoice);
        } catch (SQLException e) {
            System.err.println("Error by save the session: " + e.getMessage());
        }
    }


    public void loadSessision(){

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
