package lk.ijse.d24_hostel_managment_system.dao;

import javafx.collections.ObservableList;
import org.hibernate.query.Query;

import java.util.ArrayList;

public interface CrudDAO<T> {
    ArrayList<T> getAll();
    boolean save(T entity);
    boolean update(T entity);
    boolean delete(T entity);
    String existId(String id);
    Object search(String id);
    Object generateNewID();
    String getCount();
}
