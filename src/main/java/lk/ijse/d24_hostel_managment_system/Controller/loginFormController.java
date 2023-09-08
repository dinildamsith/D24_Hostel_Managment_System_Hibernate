package lk.ijse.d24_hostel_managment_system.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.d24_hostel_managment_system.bo.custom.impl.LoginBoImpl;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.UserDAOImpl;
import lk.ijse.d24_hostel_managment_system.entity.User;

import java.io.IOException;

public class loginFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private JFXTextField userNameTxt;

    @FXML
    private JFXPasswordField passwordTxt;


    @FXML
    void loginBtnOnAction(ActionEvent event) throws IOException {
        LoginBoImpl loginBo = new LoginBoImpl();
        boolean isLogin = loginBo.checkLoginDetails(userNameTxt.getText(),passwordTxt.getText());

        if (isLogin) {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/DashBord.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(anchorPane));
            Stage stage1 = (Stage) root.getScene().getWindow();
            stage1.close();
            stage.setTitle("Dashboard");
            stage.centerOnScreen();
            stage.show();




        }else
        {
            System.out.println("Wrong");
        }





    }

}
