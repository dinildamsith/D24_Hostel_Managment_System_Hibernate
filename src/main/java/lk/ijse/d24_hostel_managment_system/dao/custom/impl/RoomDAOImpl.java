package lk.ijse.d24_hostel_managment_system.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.d24_hostel_managment_system.dao.custom.RoomDAO;
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
        return false;
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
        return null;
    }

    @Override
    public ObservableList search(String id) {
        return null;
    }

    @Override
    public Object generateNewID() {
        return null;
    }
}
