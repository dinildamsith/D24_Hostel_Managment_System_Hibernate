package lk.ijse.d24_hostel_managment_system.dao.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.d24_hostel_managment_system.dao.custom.StudentDAO;
import lk.ijse.d24_hostel_managment_system.entity.Student;
import lk.ijse.d24_hostel_managment_system.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public ArrayList<Student> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query query = session.createQuery("FROM Student");
        List<Student> studentList = query.list();
        ArrayList<Student> allStudent = new ArrayList<>();
        for(Student student : studentList){
            allStudent.add(student);
        }
        return allStudent;
    }

    @Override
    public boolean save(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        return true;
    }

    @Override
    public boolean update(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.remove(entity);
        transaction.commit();
        return true;
    }

    @Override
    public String existId(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Student student = session.get(Student.class,id);
        return String.valueOf(student);
//        Session session = FactoryConfiguration.getInstance().getSession();
//        String paramValue = id;  // Replace this with the actual value you're looking for
//        Query query = session.createQuery("SELECT s.student_Id FROM Student s WHERE s.student_Id = :paramValue");
//        query.setParameter("paramValue", paramValue);  // Set the parameter value
//        Query existId = query.setMaxResults(1);


    }

    @Override
    public ObservableList search(String id) {
        return null;
    }

    @Override
    public Object generateNewID() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query query = session.createQuery("SELECT s.student_Id FROM Student s ORDER BY s.student_Id DESC");
        query.setMaxResults(1);
        String lastStudentId = (String) query.uniqueResult();

        if (lastStudentId != null) {
            int numericPart = Integer.parseInt(lastStudentId.replace("S", ""));
            String newStudentId = "S" + String.format("%03d", numericPart + 1);
            return newStudentId;
        } else {
            return "S001";  // If no previous student ID is found, start with "S001"
        }

    }

    @Override
    public String getCount() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query query = session.createQuery("SELECT COUNT(*) FROM Student\n");
        query.setMaxResults(1);
        String count = String.valueOf(query.uniqueResult());
        return count;
    }
}
