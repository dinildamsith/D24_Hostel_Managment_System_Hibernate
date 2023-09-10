package lk.ijse.d24_hostel_managment_system.bo.custom;

import lk.ijse.d24_hostel_managment_system.entity.Reservation;

import java.util.ArrayList;

public interface ReservationBO<T> {

    ArrayList<Reservation> getAllReservation();
    boolean reservationSave(T entity);
    boolean reservationUpdate(T entity);
    boolean reservationDelete(T entity);
    String existId(String id);
    Object search(String id);
    Object generateNewReservationID();
    String getCountReservation();

}
