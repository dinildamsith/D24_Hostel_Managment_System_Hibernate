package lk.ijse.d24_hostel_managment_system.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.d24_hostel_managment_system.bo.custom.StudentBO;
import lk.ijse.d24_hostel_managment_system.dao.DAOFactory;
import lk.ijse.d24_hostel_managment_system.dao.custom.StudentDAO;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.StudentDAOImpl;
import lk.ijse.d24_hostel_managment_system.dto.StudentDTO;
import lk.ijse.d24_hostel_managment_system.entity.Student;

import java.util.ArrayList;

public class StudentBOImpl implements StudentBO<StudentDTO> {


    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
//    StudentDAOImpl studentDAO = new StudentDAOImpl();
    @Override
    public ArrayList<StudentDTO> getAll() {
        return null;
    }

    @Override
    public boolean saveStudent(StudentDTO entity) {
        studentDAO.save(new Student(entity.getStudent_Id(),entity.getStudent_Name(),entity.getStudent_Address(),entity.getContact(),entity.getBirthday(),entity.getGender()));
        return true;
    }

    @Override
    public boolean updateStudent(StudentDTO entity) {
        studentDAO.update(new Student(entity.getStudent_Id(),entity.getStudent_Name(),entity.getStudent_Address(),entity.getContact(),entity.getBirthday(),entity.getGender()));
        return true;
    }

    @Override
    public boolean deleteStudent(StudentDTO entity) {
        studentDAO.delete(new Student(entity.getStudent_Id(),entity.getStudent_Name(),entity.getStudent_Address(),entity.getContact(),entity.getBirthday(),entity.getGender()));
        return true;
    }

    @Override
    public String existIdStudent(String id) {
       return studentDAO.existId(id);

    }

    @Override
    public ObservableList searchStudent(String id) {
        return null;
    }

    @Override
    public Object generateNewIDStudent() {
         return studentDAO.generateNewID();

    }
}
