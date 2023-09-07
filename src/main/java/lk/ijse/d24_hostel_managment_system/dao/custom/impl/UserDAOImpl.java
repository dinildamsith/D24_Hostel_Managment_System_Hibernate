package lk.ijse.d24_hostel_managment_system.dao.custom.impl;

import lk.ijse.d24_hostel_managment_system.dao.custom.UserDAO;
import lk.ijse.d24_hostel_managment_system.entity.User;
import lk.ijse.d24_hostel_managment_system.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDAOImpl implements UserDAO {
    @Override
    public User checkPwAndUserName(String username, String password) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select u from User u where userName = ?1 and password = ?2");
        query.setParameter(1,username);
        query.setParameter(2,password);
        return (User) query.getSingleResult();

    }
}
