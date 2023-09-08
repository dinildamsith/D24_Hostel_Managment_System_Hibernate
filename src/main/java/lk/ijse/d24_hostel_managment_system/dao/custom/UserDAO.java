package lk.ijse.d24_hostel_managment_system.dao.custom;

import lk.ijse.d24_hostel_managment_system.entity.User;

public interface UserDAO {
    User checkPwAndUserName(String username, String password);

    boolean pwChange(User user);
}
