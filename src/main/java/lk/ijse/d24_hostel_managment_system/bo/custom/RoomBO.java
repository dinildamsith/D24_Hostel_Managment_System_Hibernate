package lk.ijse.d24_hostel_managment_system.bo.custom;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface RoomBO<T>{
    ArrayList<T> getAllRooms();
    boolean saveRoom(T entity);
    boolean updateRoom(T entity);
    boolean deleteRoom(T entity);
    String existIdRoom(String id);
    ObservableList searchRoom(String id);
    Object generateNewIDRoom();
}
