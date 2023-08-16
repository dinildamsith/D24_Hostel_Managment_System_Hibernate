package lk.ijse.d24_hostel_managment_system.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class loginFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXButton loginBtn;

    @FXML
    void loginBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/DashBord.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        Stage stage1 = (Stage) root.getScene().getWindow();
        stage1.close();
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
        stage.show();

    }

}
