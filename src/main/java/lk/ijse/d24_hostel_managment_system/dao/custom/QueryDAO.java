package lk.ijse.d24_hostel_managment_system.dao.custom;

import lk.ijse.d24_hostel_managment_system.entity.Student;

import java.util.ArrayList;
import java.util.List;

public interface QueryDAO {
   List<Student> unPaidPayments();
}
