package lk.ijse.d24_hostel_managment_system.bo.custom.impl;

import lk.ijse.d24_hostel_managment_system.bo.custom.ReservationBO;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.d24_hostel_managment_system.entity.Reservation;

public class ReservationBoImpl implements ReservationBO<Object> {
    ReservationDAOImpl reservationDAO = new ReservationDAOImpl();
    @Override
    public boolean reservationSave(Object entity) {
       // reservationDAO.save(new Reservation())
        return false;
    }
}
