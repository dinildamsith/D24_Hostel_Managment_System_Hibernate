package lk.ijse.d24_hostel_managment_system.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReservationFormController {
    @FXML
    private CheckBox paidCheckBox;

    @FXML
    private CheckBox unPaidCheckBox;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<?> studentIdComboBox;

    @FXML
    private ComboBox<?> roomTypeIdComboBox;

    @FXML
    private Label reservationIdLbl;

    @FXML
    private TableView<?> reservationTable;

    @FXML
    private TableColumn<?, ?> res_IdColumn;

    @FXML
    private TableColumn<?, ?> stu_idColumn;

    @FXML
    private TableColumn<?, ?> roomTypeIdColumn;

    @FXML
    private TableColumn<?, ?> roomTypeColumn;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private TableColumn<?, ?> statusColumn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private Label roomTypeLbl;

    @FXML
    void delteBtnOnAction(ActionEvent event) {

    }

    @FXML
    void saveOnAction(ActionEvent event) {

    }

}
