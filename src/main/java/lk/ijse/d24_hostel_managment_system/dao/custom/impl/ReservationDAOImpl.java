package lk.ijse.d24_hostel_managment_system.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.d24_hostel_managment_system.dao.custom.ReservationDAO;
import lk.ijse.d24_hostel_managment_system.dto.ReservationDTO;
import lk.ijse.d24_hostel_managment_system.entity.Reservation;
import lk.ijse.d24_hostel_managment_system.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO  {


    @Override
    public ArrayList<Reservation> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query query = session.createQuery("FROM Reservation ");
        List<Reservation> reservationList = query.list();
        ArrayList<Reservation> reservationAll = new ArrayList<>();
        for (Reservation reservation : reservationList){
            reservationAll.add(reservation);
        }
        return reservationAll;
    }

    @Override
    public boolean save(Reservation entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(entity);
        transaction.commit();

        return true;

    }

    @Override
    public boolean update(Reservation entity) {
        return false;
    }

    @Override
    public boolean delete(Reservation entity) {
        return false;
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
        Session session = FactoryConfiguration.getInstance().getSession();
        Query query = session.createQuery("SELECT s.reservation_Id FROM Reservation s ORDER BY s.reservation_Id DESC");
        query.setMaxResults(1);
        String lastStudentId = (String) query.uniqueResult();

        if (lastStudentId != null) {
            int numericPart = Integer.parseInt(lastStudentId.replace("RE", ""));
            String newStudentId = "RE" + String.format("%03d", numericPart + 1);
            return newStudentId;
        } else {
            return "RE001";  // If no previous student ID is found, start with "S001"
        }


    }
}
