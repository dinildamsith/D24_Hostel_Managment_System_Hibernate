package lk.ijse.d24_hostel_managment_system.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RoomFormController {
    @FXML
    private JFXTextField roomTypeIdTxt;

    @FXML
    private JFXTextField keyMoneyTxt;

    @FXML
    private JFXTextField roomTypeTxt;

    @FXML
    private JFXTextField roomQtyTxt;

    @FXML
    private TableView<?> roomTable;

    @FXML
    private TableColumn<?, ?> roomTypeIdColumn;

    @FXML
    private TableColumn<?, ?> roomTypeColumn;

    @FXML
    private TableColumn<?, ?> keyMoneyColumn;

    @FXML
    private TableColumn<?, ?> roomQtyColumn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    void deleteBtnOnAction(ActionEvent event) {

    }

    @FXML
    void saveBtnOnAction(ActionEvent event) {

    }

}
