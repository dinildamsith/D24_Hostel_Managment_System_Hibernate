package lk.ijse.d24_hostel_managment_system.dao;

import lk.ijse.d24_hostel_managment_system.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
       STUDENT,ROOM,RESERVATION,USER,QUERY
    }

    public Object getDAO(DAOTypes types){
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case RESERVATION:
                return new ReservationDAOImpl();
            case USER:
                return new UserDAOImpl();
            case  QUERY:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }

}
