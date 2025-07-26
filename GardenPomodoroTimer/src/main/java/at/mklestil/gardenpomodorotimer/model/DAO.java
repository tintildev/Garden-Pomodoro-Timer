package at.mklestil.gardenpomodorotimer.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    public abstract Connection implementationConnection() throws SQLException;

    public void createTable();

    public void insert(T object);

    public void update(T object);

    public void delete(T object);

    public Object findById(int id);

    public List<T> findAll();
}
