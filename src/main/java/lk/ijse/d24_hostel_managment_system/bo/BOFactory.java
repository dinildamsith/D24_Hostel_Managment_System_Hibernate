package lk.ijse.d24_hostel_managment_system.bo;

import lk.ijse.d24_hostel_managment_system.bo.custom.impl.LoginBoImpl;
import lk.ijse.d24_hostel_managment_system.bo.custom.impl.ReservationBoImpl;
import lk.ijse.d24_hostel_managment_system.bo.custom.impl.RoomBoImpl;
import lk.ijse.d24_hostel_managment_system.bo.custom.impl.StudentBOImpl;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.RoomDAOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }
    public enum BOTypes{
        STUDENT,ROOM,RESERVATION,LOGIN
    }

    //Object creation logic for BO objects
    public Object getBO(BOTypes types){
        switch (types){
            case STUDENT:
                return new StudentBOImpl();
            case ROOM:
                return  new RoomBoImpl();
            case RESERVATION:
                return new ReservationBoImpl();
            case LOGIN:
                return new LoginBoImpl();
            default:
                return null;
        }
    }
}
