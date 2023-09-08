package lk.ijse.d24_hostel_managment_system.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.d24_hostel_managment_system.bo.custom.RoomBO;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.RoomDAOImpl;
import lk.ijse.d24_hostel_managment_system.dto.RoomDTO;
import lk.ijse.d24_hostel_managment_system.entity.Room;

import java.util.ArrayList;

public class RoomBoImpl implements RoomBO<RoomDTO> {
    RoomDAOImpl roomDAO = new RoomDAOImpl();
    @Override
    public ArrayList<RoomDTO> getAllRooms() {

        ArrayList<Room> all = roomDAO.getAll();
        ArrayList<RoomDTO> allRooms = new ArrayList<>();
        for (Room room: all){
            allRooms.add(new RoomDTO(room.getRoom_Type_Id(),room.getRoom_Type(),room.getKey_Money(),room.getRooms_Qty()));
        }

        return allRooms;
    }

    @Override
    public boolean saveRoom(RoomDTO entity) {
        roomDAO.save(new Room(entity.getRoom_Type_Id(),entity.getRoom_Type(),entity.getKey_Money(),entity.getRooms_Qty()));
        return true;
    }

    @Override
    public boolean updateRoom(RoomDTO entity) {
        roomDAO.update(new Room(entity.getRoom_Type_Id(),entity.getRoom_Type(),entity.getKey_Money(),entity.getRooms_Qty()));
        return true;
    }

    @Override
    public boolean deleteRoom(RoomDTO entity) {
        roomDAO.delete(new Room(entity.getRoom_Type_Id(),entity.getRoom_Type(),entity.getKey_Money(),entity.getRooms_Qty()));
        return true;
    }

    @Override
    public String existIdRoom(String id) {
        return roomDAO.existId(id);

    }

    @Override
    public ObservableList searchRoom(String id) {
        return null;
    }

    @Override
    public Object generateNewIDRoom() {
        return null;
    }
}
