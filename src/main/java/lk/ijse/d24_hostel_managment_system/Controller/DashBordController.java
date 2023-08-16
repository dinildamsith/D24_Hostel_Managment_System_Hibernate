package lk.ijse.d24_hostel_managment_system.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBordController {
    @FXML
    private AnchorPane anchorpane2;

    @FXML
    private JFXButton studentBtn;

    @FXML
    private JFXButton roomsBtn;

    @FXML
    private JFXButton reservationBtn;

    @FXML
    private JFXButton logOutBtn;

    @FXML
    private AnchorPane root;


    @FXML
    void studentBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/StudentForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);

    }



    @FXML
    void roomsBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/room_Form.fxml"));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }



    @FXML
    void reservationBtnOnAction(ActionEvent event) throws IOException {

        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/reservation_Form.fxml"));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);

    }

    @FXML
    void logoutBtnOnAction(ActionEvent event) {

    }



}
