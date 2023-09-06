package lk.ijse.d24_hostel_managment_system.bo.custom;

import java.util.ArrayList;

public interface ReservationBO<T> {

    boolean reservationSave(T entity);
}
