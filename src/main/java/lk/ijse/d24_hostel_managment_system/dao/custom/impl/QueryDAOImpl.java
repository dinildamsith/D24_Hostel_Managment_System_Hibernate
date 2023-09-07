package lk.ijse.d24_hostel_managment_system.dao.custom.impl;

import lk.ijse.d24_hostel_managment_system.dao.custom.QueryDAO;
import lk.ijse.d24_hostel_managment_system.entity.Student;
import lk.ijse.d24_hostel_managment_system.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<Student> unPaidPayments() {
        Session session = FactoryConfiguration.getInstance().getSession();
//        Query query = session.createQuery("SELECT\n" +
//                "    s.student_Id,\n" +
//                "    s.student_Name,\n" +
//                "    s.contact\n" +
//                "FROM\n" +
//                "    Student s\n" +
//                "        JOIN\n" +
//                "        Reservation r on s.student_Id = r.student.student_Id\n" +
//                "\n" +
//                "WHERE\n" +
//                "        r.status = 'unpaid'");

        String hql = "select s from Student s inner join s.list r where r.status = 'unPaid'";
        Query query = session.createQuery(hql);

        List<Student> studentList = query.list();


        return studentList;
    }
}
