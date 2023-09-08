package lk.ijse.d24_hostel_managment_system.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.UserDAOImpl;
import lk.ijse.d24_hostel_managment_system.dto.UserDTO;
import lk.ijse.d24_hostel_managment_system.entity.User;
import org.controlsfx.control.Notifications;

public class AccformController {
    @FXML
    private JFXTextField conformPwTxt;

    @FXML
    private JFXTextField newPwTxt;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private JFXTextField userNameTxt;


//    updateAccDAOImpl updateAccDAO = new updateAccDAOImpl();
    UserDAOImpl userDAO = new UserDAOImpl();

    public void updateOnAction(javafx.event.ActionEvent actionEvent) {
        String userName = userNameTxt.getText();
        String newPw = newPwTxt.getText();


        if (userName.isEmpty() || newPw.isEmpty()){
            Notifications.create()
                    .title("Notification !")
                    .text("Please Input Data !!")
                    .position(Pos.TOP_CENTER)
                    .showError();
    }else{
            boolean update = userDAO.pwChange(new User(userNameTxt.getText(),newPwTxt.getText()));
            if (update){
                Notifications.create()
                        .title("Notification !")
                        .text("Change Password Sussefuly !!")
                        .position(Pos.TOP_CENTER)
                        .showInformation();
            }
        }
    }
}
