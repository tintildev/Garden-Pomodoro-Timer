package at.mklestil.gardenpomodorotimer.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ImagesDAO implements DAO<AppModel>{

    private final Connection connection;

    public ImagesDAO(){
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

    @Override
    public void insert(AppModel model) {
        String sql = "INSERT INTO images (path) VALUES('" + model.getSelectedPlant() + "')";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Bildpfad eingefügt: " + model.getSelectedPlant());
        } catch (SQLException e) {
            System.out.println("Fehler beim Einfügen des Bildpfads: " + e.getMessage());
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
    public List<AppModel> findAll() {
        return null;
    }


}
