package lk.ijse.d24_hostel_managment_system.bo.custom.impl;

import lk.ijse.d24_hostel_managment_system.bo.custom.UserBo;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.UserDAOImpl;
import lk.ijse.d24_hostel_managment_system.entity.User;

public class LoginBoImpl implements UserBo {
    @Override
    public boolean checkLoginDetails(String username, String password) {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.checkPwAndUserName(username,password);
        return user != null;
    }
}
