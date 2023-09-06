package lk.ijse.d24_hostel_managment_system.bo.custom;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface StudentBO<T> {
    ArrayList<T> getAll();
    boolean saveStudent(T entity);
    boolean updateStudent(T entity);
    boolean deleteStudent(T entity);
    String existIdStudent(String id);
    ObservableList searchStudent(String id);
    Object generateNewIDStudent();
}
