package lk.ijse.d24_hostel_managment_system.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.d24_hostel_managment_system.dao.custom.RoomDAO;
import lk.ijse.d24_hostel_managment_system.dto.RoomDTO;
import lk.ijse.d24_hostel_managment_system.entity.Room;
import lk.ijse.d24_hostel_managment_system.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public ArrayList<Room> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query query = session.createQuery("FROM Room ");
        List<Room> list = query.list();
        ArrayList<Room> allRooms = new ArrayList<>();
        for (Room room : list){
            allRooms.add(room);
        }
        return allRooms;
    }

    @Override
    public boolean save(Room entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        return true;
    }

    @Override
    public boolean update(Room entity) {
        Session session =FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(Room entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.remove(entity);
        transaction.commit();
        return true;
    }

    @Override
    public String existId(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Room room = session.get(Room.class,id);
        return String.valueOf(room);
    }

    @Override
    public RoomDTO search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM Room r WHERE r.room_Type_Id = :roomId"; // Modified HQL query
        Query<Room> query = session.createQuery(hql, Room.class);
        query.setParameter("roomId", id); // Set the parameter value

        List<Room> rooms = query.list();
        RoomDTO roomDTO = new RoomDTO();
        //ObservableList<Room> roomObservableList = FXCollections.observableArrayList();

        for (Room room : rooms){
            roomDTO.setRoom_Type_Id(room.getRoom_Type_Id());
            roomDTO.setRoom_Type(room.getRoom_Type());
            roomDTO.setKey_Money(room.getKey_Money());
            roomDTO.setRooms_Qty(room.getRooms_Qty());
            //roomObservableList.add(room);
        }
        return  roomDTO;
    }

    @Override
    public Object generateNewID() {
        return null;
    }
}
