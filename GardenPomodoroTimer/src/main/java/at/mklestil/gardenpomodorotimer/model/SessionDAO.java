package at.mklestil.gardenpomodorotimer.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SessionDAO implements DAO<PomodoroSession>{

    private Connection connection;

    public SessionDAO(){
        try {
            connection = implementationConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Error initializing ImagesDAO: " + e.getMessage(), e);
        }
    }

    @Override
    public Connection implementationConnection() throws SQLException {
        Connection con = SQLiteConnectModel.getConnection();
        return con;
    }

    @Override
    public void createTable() {
        if (connection == null) {
            System.out.println("Error: No valid database connection!");
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

    @Override
    public void insert(PomodoroSession model) {
        if (connection == null) {
            System.out.println("Error: No valid database connection!");
            return;
        }

        String sql = "INSERT INTO pomodoro_sessions (duration, plant_choice) VALUES (?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, model.getDuration());
            pstmt.setString(2, model.getPlantChoice());
            // timestamp = SQLite automatically sets the current time in UTC format (YYYY-MM-DD HH:MM:SS)
            pstmt.executeUpdate();
            System.out.println("Session saved: " + model.getDuration() + " min, plant: " + model.getPlantChoice());
        } catch (SQLException e) {
            System.err.println("Error by save the session: " + e.getMessage());
        }
    }

    @Override
    public void update(PomodoroSession object) {

    }

    @Override
    public void delete(PomodoroSession object) {

    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public List<PomodoroSession> findAll() {
        return null;
    }
}
