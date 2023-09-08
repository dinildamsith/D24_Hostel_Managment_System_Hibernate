package lk.ijse.d24_hostel_managment_system.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBordController implements Initializable {
    @FXML
    private AnchorPane anchorpane2;

    @FXML
    private JFXButton studentBtn;

    @FXML
    private JFXButton roomsBtn;

    @FXML
    private JFXButton reservationBtn;

    @FXML
    private JFXButton dashBordBtn;

    @FXML
    private JFXButton logOutBtn;

    @FXML
    private AnchorPane root;

    @FXML
    private JFXButton accBtn;

    @FXML
    private AnchorPane dashAchorpane;


    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashview.fxml"));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }

    @FXML
    void dashBordOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashview.fxml"));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }


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
    void logoutBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane1 = FXMLLoader.load(getClass().getResource("/view/login_Form.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane1));
        Stage stage1 = (Stage) dashAchorpane.getScene().getWindow();
        stage1.close();
        stage.show();

    }


    @FXML
    void accOnActionBtn(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent scene = FXMLLoader.load(getClass().getResource("/view/accform.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();


    }

}
