package lk.ijse.d24_hostel_managment_system.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StudentFormController {

    @FXML
    private JFXTextField studentNameTxt;

    @FXML
    private JFXTextField StudentAddressTxt;

    @FXML
    private JFXTextField contactNumberTxt;

    @FXML
    private CheckBox maleCheckBox;

    @FXML
    private CheckBox femaleCheckBox;

    @FXML
    private DatePicker birthdatPiker;

    @FXML
    private Label studentIdLbl;

    @FXML
    private TableView<?> studentTable;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> nameColum;

    @FXML
    private TableColumn<?, ?> addressColumn;

    @FXML
    private TableColumn<?, ?> contactColumn;

    @FXML
    private TableColumn<?, ?> birthColumn;

    @FXML
    private TableColumn<?, ?> genderColumn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton deleteBtn;


    @FXML
    void saveBtnOnAction(ActionEvent event) {

    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {

    }

    @FXML
    void femaleCheckBoxOnAction(ActionEvent event) {

    }

    @FXML
    void maleCheckBoxOnAction(ActionEvent event) {

    }


}
