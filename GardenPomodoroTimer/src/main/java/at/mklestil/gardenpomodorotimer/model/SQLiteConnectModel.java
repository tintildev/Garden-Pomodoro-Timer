package at.mklestil.gardenpomodorotimer.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    // creat Sessions
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

    // Save Sessions
    public void saveSession(int duration, String plantChoice){
        if (connection == null) {
            System.out.println("Error: No valid database connection!");
            return;
        }

        String sql = "INSERT INTO pomodoro_sessions (duration, plant_choice) VALUES (?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, duration);
            pstmt.setString(2, plantChoice);
            // timestamp = SQLite automatically sets the current time in UTC format (YYYY-MM-DD HH:MM:SS)
            pstmt.executeUpdate();
            System.out.println("Session saved: " + duration + " min, plant: " + plantChoice);
        } catch (SQLException e) {
            System.err.println("Error by save the session: " + e.getMessage());
        }
    }

    // Load Sessions
    public void loadPomodoroSessions() {
        String sql = "SELECT id, duration, plant_choice, timestamp FROM pomodoro_sessions";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Saved Pomodoro-Session:");
            while (rs.next()) { // Zeilenweise durch die Ergebnisse iterieren
                int id = rs.getInt("id");
                int duration = rs.getInt("duration");
                String plantChoice = rs.getString("plant_choice");
                String timestamp = rs.getString("timestamp");

                // Log-Ausgabe
                System.out.println("ID: " + id + ", Duration: " + duration + "min, plant: " + plantChoice + ", timestamp: " + timestamp);
            }

        } catch (SQLException e) {
            System.out.println("Error by load the session: " + e.getMessage());
        }
    }

    //Todo: Tags

    // Create Table Tags
    public void createTagsTable() {
        String sql = """
        CREATE TABLE IF NOT EXISTS tags (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT UNIQUE NOT NULL
        );
        """;
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error creating the table: " + e.getMessage());
        }
    }

    public List<String> loadTagsFromDB() {
        List<String> tags = new ArrayList<>();
        String sql = "SELECT name FROM tags";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                tags.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error by load the tags: " + e.getMessage());
        }
        return tags;
    }


    //Create Table Images
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
