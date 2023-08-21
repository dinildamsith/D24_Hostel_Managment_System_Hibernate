package lk.ijse.d24_hostel_managment_system.dao;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface CrudDAO<T> {
    ArrayList<T> getAll();
    boolean save(T entity);
    boolean update(T entity);
    boolean delete(String id);
    ObservableList search(String id);
    Object generateNewID();
}
