package at.mklestil.gardenpomodorotimer.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TagDAO implements DAO<AppModel>{
    private Connection connection;

    public TagDAO()  {
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

    @Override
    public void insert(AppModel model) {
        String tag = model.getTag();
        if (connection == null) {
            System.out.println("Error: No valid database connection!");
            return;
        }

        String sql = "INSERT INTO tags (name) VALUES (?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, tag);
            pstmt.executeUpdate();
            System.out.println("tag saved: " + tag);
        } catch (SQLException e) {
            System.err.println("Error by save the tag: " + e.getMessage());
        }
    }

    @Override
    public void update(AppModel object) {

    }

    @Override
    public void delete(AppModel object) {

    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public ArrayList findAll() {
        ArrayList<String> tags = new ArrayList<>();
        if (connection == null) {
            System.out.println("Error: No valid database connection!");
            return tags;
        }
        //TODO implement findAll method
        return tags;
    }


}
