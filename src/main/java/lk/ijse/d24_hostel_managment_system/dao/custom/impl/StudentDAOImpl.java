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
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
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
}
