package lk.ijse.d24_hostel_managment_system.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.d24_hostel_managment_system.bo.BOFactory;
import lk.ijse.d24_hostel_managment_system.bo.custom.StudentBO;
import lk.ijse.d24_hostel_managment_system.bo.custom.impl.StudentBOImpl;
import lk.ijse.d24_hostel_managment_system.dao.DAOFactory;
import lk.ijse.d24_hostel_managment_system.dao.custom.StudentDAO;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.StudentDAOImpl;
import lk.ijse.d24_hostel_managment_system.dto.StudentDTO;
import lk.ijse.d24_hostel_managment_system.entity.Student;
import lk.ijse.d24_hostel_managment_system.utill.Regex;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class StudentFormController implements Initializable {

    @FXML
    private JFXTextField studentNameTxt;

    @FXML
    private JFXTextField StudentAddressTxt;

    @FXML
    private JFXTextField contactNumberTxt;

     @FXML
    private ComboBox<String> gender;

    @FXML
    private DatePicker birthdatPiker;

    @FXML
    private Label studentIdLbl;

    @FXML
    private TableView<StudentDTO> studentTable;

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
    private JFXButton updateBtn;

    @FXML
    private Label studentLbl;


    @FXML
    private JFXButton refreshBtn;


    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
//    StudentDAOImpl studentDAO = new StudentDAOImpl();

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deleteBtn.setVisible(false);
        tableListener();
        setCellValues();
        studentTableAddData();
        setGenderComboboxAddItems();
        Object o = studentBO.generateNewIDStudent();
        studentIdLbl.setText(String.valueOf(o));

    }

    @FXML
    void saveBtnOnAction(ActionEvent event) {

        String stName = studentNameTxt.getText();
        String stAddress = StudentAddressTxt.getText();
        String value = gender.getValue();
        String contact = contactNumberTxt.getText();
        String birthday = String.valueOf(birthdatPiker.getValue());


        if (Regex.getNamePattern().matcher(studentNameTxt.getText()).matches()) {
            if (Regex.getAddressPattern().matcher(StudentAddressTxt.getText()).matches()) {
                if (Regex.getContactPattern().matcher(contactNumberTxt.getText()).matches()) {
                    if (stName.isEmpty() || stAddress.isEmpty() || value.isEmpty() || contact.isEmpty() || birthday.isEmpty()) {
                        Notifications.create()
                                .title("Notification !")
                                .text("Input Data !!")
                                .position(Pos.TOP_CENTER)
                                .showInformation();

                    } else {
                        String s = studentBO.existIdStudent(studentIdLbl.getText());


                        if (s != null) {
                            boolean isSaved = studentBO.saveStudent(new StudentDTO(studentIdLbl.getText(), studentNameTxt.getText(), StudentAddressTxt.getText(), contactNumberTxt.getText(), birthdatPiker.getValue(), gender.getSelectionModel().getSelectedItem()));
                            if (isSaved) {
                                clearTextFields();
                                Notifications.create()
                                        .title("Notification !")
                                        .text("Student Saved !!")
                                        .position(Pos.TOP_CENTER)
                                        .showInformation();
                            }
                        }
                    }
                }else {
                    Notifications.create()
                            .title("Notification !")
                            .text("Student Contact Not Match !!")
                            .position(Pos.TOP_CENTER)
                            .showInformation();
                }
                }else{
                Notifications.create()
                        .title("Notification !")
                        .text("Student Address Not Match !!")
                        .position(Pos.TOP_CENTER)
                        .showInformation();
            }
        }else{
            Notifications.create()
                    .title("Notification !")
                    .text("Student Name Not Match !!")
                    .position(Pos.TOP_CENTER)
                    .showInformation();
        }

    }

    @FXML
    void updateOnAction(ActionEvent event) {

        String stName = studentNameTxt.getText();
        String stAddress =StudentAddressTxt.getText();
        String value = gender.getValue();
        String contact = contactNumberTxt.getText();
        String birthday = String.valueOf(birthdatPiker.getValue());


        if (Regex.getNamePattern().matcher(studentNameTxt.getText()).matches()) {
            if (Regex.getAddressPattern().matcher(StudentAddressTxt.getText()).matches()) {
                if (Regex.getContactPattern().matcher(contactNumberTxt.getText()).matches()) {
                    if (stName.isEmpty() || stAddress.isEmpty() || value.isEmpty() || contact.isEmpty() || birthday.isEmpty()) {
                        Notifications.create()
                                .title("Notification !")
                                .text("Input Data !!")
                                .position(Pos.TOP_CENTER)
                                .showInformation();

                    } else {
                        boolean isUpdate = studentBO.updateStudent(new StudentDTO(studentIdLbl.getText(), studentNameTxt.getText(), StudentAddressTxt.getText(), contactNumberTxt.getText(), birthdatPiker.getValue(), gender.getSelectionModel().getSelectedItem()));
                        if (isUpdate) {
                            clearTextFields();
                            Notifications.create()
                                    .title("Notification !")
                                    .text("Student Updated !!")
                                    .position(Pos.TOP_CENTER)
                                    .showInformation();
                        }
                    }
                }else{
                    Notifications.create()
                            .title("Notification !")
                            .text("Student Contact Not Match!!")
                            .position(Pos.TOP_CENTER)
                            .showInformation();
                }
            } else{
                Notifications.create()
                        .title("Notification !")
                        .text("Student Address Not Match!!")
                        .position(Pos.TOP_CENTER)
                        .showInformation();
            }
        }else{
            Notifications.create()
                    .title("Notification !")
                    .text("Student Name Not Match !!")
                    .position(Pos.TOP_CENTER)
                    .showInformation();
        }

    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        boolean isDelete = studentBO.deleteStudent(new StudentDTO(studentIdLbl.getText(),studentNameTxt.getText(),StudentAddressTxt.getText(),contactNumberTxt.getText(),birthdatPiker.getValue(),gender.getSelectionModel().getSelectedItem()));
        if (isDelete){
            clearTextFields();
            Notifications.create()
                    .title("Notification !")
                    .text("Student Delete !!")
                    .position(Pos.TOP_CENTER)
                    .showInformation();

        }
    }

    private void tableListener(){
        studentTable.getSelectionModel().selectedItemProperty().addListener((ob, oldValue, newValue) -> {
            if (newValue != null){
                saveBtn.setVisible(false);
                deleteBtn.setVisible(true);
                studentLbl.setText("Student Update");
                studentIdLbl.setText(newValue.getStudent_Id());
                studentNameTxt.setText(newValue.getStudent_Name());
                StudentAddressTxt.setText(newValue.getStudent_Address());
                contactNumberTxt.setText(newValue.getContact());
                birthdatPiker.setValue(LocalDate.parse(newValue.getBirthday().toString()));
                gender.setValue(String.valueOf(newValue.getGender()));

            }
        });
    }

    private void setCellValues() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("student_Id"));
        nameColum.setCellValueFactory(new PropertyValueFactory<>("student_Name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("student_Address"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        birthColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }

    private void studentTableAddData(){
        ArrayList<Student> all = studentDAO.getAll();
        for (Student student :all){
            studentTable.getItems().add(new StudentDTO(student.getStudent_Id(),student.getStudent_Name(),student.getStudent_Address(),student.getContact(),student.getBirthday(),student.getGender()));
        }
    }

    private void setGenderComboboxAddItems(){
        ObservableList<String> items = FXCollections.observableArrayList(
                "Male", "Female"
        );
        gender.setItems(items);

    }

    private void clearTextFields(){
        studentNameTxt.clear();
        StudentAddressTxt.clear();
        contactNumberTxt.clear();
    }

}
