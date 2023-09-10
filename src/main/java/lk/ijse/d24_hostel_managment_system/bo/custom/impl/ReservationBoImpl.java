package lk.ijse.d24_hostel_managment_system.bo.custom.impl;

import lk.ijse.d24_hostel_managment_system.bo.custom.ReservationBO;
import lk.ijse.d24_hostel_managment_system.dao.DAOFactory;
import lk.ijse.d24_hostel_managment_system.dao.custom.ReservationDAO;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.d24_hostel_managment_system.entity.Reservation;

import java.util.ArrayList;

public class ReservationBoImpl implements ReservationBO<Object> {

    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);
//    ReservationDAOImpl reservationDAO = new ReservationDAOImpl();

    @Override
    public ArrayList<Reservation> getAllReservation() {
        ArrayList<Reservation> all = reservationDAO.getAll();

        return all;
    }

    @Override
    public boolean reservationSave(Object entity) {
      return reservationDAO.save((Reservation) entity);

    }

    @Override
    public boolean reservationUpdate(Object entity) {
        return reservationDAO.update((Reservation) entity);

    }

    @Override
    public boolean reservationDelete(Object entity) {
       return reservationDAO.delete((Reservation) entity);

    }

    @Override
    public String existId(String id) {
        return null;
    }

    @Override
    public Object search(String id) {
        return null;
    }

    @Override
    public Object generateNewReservationID() {
        return reservationDAO.generateNewID();

    }

    @Override
    public String getCountReservation() {
         return  reservationDAO.getCount();

    }

}
