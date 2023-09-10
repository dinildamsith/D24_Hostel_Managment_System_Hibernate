package lk.ijse.d24_hostel_managment_system.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.d24_hostel_managment_system.bo.BOFactory;
import lk.ijse.d24_hostel_managment_system.bo.custom.ReservationBO;
import lk.ijse.d24_hostel_managment_system.bo.custom.impl.ReservationBoImpl;
import lk.ijse.d24_hostel_managment_system.dao.DAOFactory;
import lk.ijse.d24_hostel_managment_system.dao.custom.RoomDAO;
import lk.ijse.d24_hostel_managment_system.dao.custom.StudentDAO;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.RoomDAOImpl;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.StudentDAOImpl;
import lk.ijse.d24_hostel_managment_system.dto.ReservationDTO;
import lk.ijse.d24_hostel_managment_system.dto.RoomDTO;
import lk.ijse.d24_hostel_managment_system.dto.StudentDTO;
import lk.ijse.d24_hostel_managment_system.entity.Reservation;
import lk.ijse.d24_hostel_managment_system.entity.Room;
import lk.ijse.d24_hostel_managment_system.entity.Student;
import lk.ijse.d24_hostel_managment_system.utill.FactoryConfiguration;
import org.controlsfx.control.Notifications;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReservationFormController implements Initializable {


    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<String> studentIdComboBox;

    @FXML
    private ComboBox<String> roomTypeIdComboBox;

    @FXML
    private Label reservationIdLbl;

    @FXML
    private TableView<ReservationDTO> reservationTable;

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
    private JFXButton updateBtn;

    @FXML
    private JFXButton refreshBtn;

    @FXML
    private ComboBox<String> statusComboBox;


    @FXML
    private Label reservationLbl;




//    StudentDAOImpl studentDAO = new StudentDAOImpl();
//    ReservationBoImpl reservationBo = new ReservationBoImpl();

    ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    RoomDAOImpl roomDAO = new RoomDAOImpl();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setIdsStudentIdComboBox();
        setIdsRoomTypeIdComboBox();
        setStatusComboBox();
        setCellValues();
        setReservationTableData();
        tableListener();
        deleteBtn.setVisible(false);

        //Reservation id Set
        Object newId = reservationBO.generateNewReservationID();
        reservationIdLbl.setText((String) newId);





    }



    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        String roomTypeId = roomTypeIdComboBox.getSelectionModel().getSelectedItem();
        RoomDTO roomDTO = roomDAO.search(roomTypeId);
//
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room roomUpdate = session.get(Room.class,roomDTO.getRoom_Type_Id());
        Student studentDTO = new Student();
        studentDTO.setStudent_Id(studentIdComboBox.getValue());

        Room room = new Room();
        room.setRoom_Type_Id(roomTypeIdComboBox.getValue());
        room.setRoom_Type(roomTypeLbl.getText());


        Reservation reservationDTO = new Reservation();

        reservationDTO.setReservation_Id(reservationIdLbl.getText());
        reservationDTO.setDate(datePicker.getValue());
        reservationDTO.setRoom(room);
        reservationDTO.setRoom_Type(roomTypeLbl.getText());
        reservationDTO.setStudent(studentDTO);
        reservationDTO.setStatus(statusComboBox.getValue());


        String x = roomDTO.getRooms_Qty();
        System.out.println(x);
        int intTypeQty = Integer.parseInt(x);
        System.out.println(intTypeQty);
        String updatedRoomQty = String.valueOf(intTypeQty+1);
        System.out.println(updatedRoomQty);
        roomUpdate.setRooms_Qty(updatedRoomQty);

        boolean iSDelete =  reservationBO.reservationDelete(reservationDTO);
        if (iSDelete){
            session.persist(roomUpdate);
            transaction.commit();
            Notifications.create()
                    .title("Notification!")
                    .text("Reservation Deleted!!")
                    .position(Pos.TOP_CENTER)
                    .showInformation();
        }

    }

    @FXML
    void saveOnAction(ActionEvent event) {
        String roomTypeId = roomTypeIdComboBox.getSelectionModel().getSelectedItem();
        RoomDTO roomDTO = roomDAO.search(roomTypeId);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room roomUpdate = session.get(Room.class,roomDTO.getRoom_Type_Id());



        Student studentDTO = new Student();
        studentDTO.setStudent_Id(studentIdComboBox.getValue());

        Room room = new Room();
        room.setRoom_Type_Id(roomTypeIdComboBox.getValue());
        room.setRoom_Type(roomTypeLbl.getText());




        Reservation reservationDTO = new Reservation();

       reservationDTO.setReservation_Id(reservationIdLbl.getText());
       reservationDTO.setDate(datePicker.getValue());
       reservationDTO.setRoom(room);
       reservationDTO.setRoom_Type(roomTypeLbl.getText());
       reservationDTO.setStudent(studentDTO);
       reservationDTO.setStatus(statusComboBox.getValue());


       String x = roomDTO.getRooms_Qty();
       int intTypeQty = Integer.parseInt(x);
       String updatedRoomQty = String.valueOf(intTypeQty-1);
       roomUpdate.setRooms_Qty(updatedRoomQty);


        boolean save = reservationBO.reservationSave(reservationDTO);
        if (save){
            session.persist(roomUpdate);
            transaction.commit();
            Notifications.create()
                    .title("Notification !")
                    .text("Reservation Add !!")
                    .position(Pos.TOP_CENTER)
                    .showInformation();
        }


    }

    public void updateOnAction(ActionEvent actionEvent) {
//        String roomTypeId = roomTypeIdComboBox.getSelectionModel().getSelectedItem();
//        RoomDTO roomDTO = roomDAO.search(roomTypeId);
//
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        Room roomUpdate = session.get(Room.class,roomDTO.getRoom_Type_Id());

        Student studentDTO = new Student();
        studentDTO.setStudent_Id(studentIdComboBox.getValue());

        Room room = new Room();
        room.setRoom_Type_Id(roomTypeIdComboBox.getValue());
        room.setRoom_Type(roomTypeLbl.getText());

        Reservation reservationDTO = new Reservation();

        reservationDTO.setReservation_Id(reservationIdLbl.getText());
        reservationDTO.setDate(datePicker.getValue());
        reservationDTO.setRoom(room);
        reservationDTO.setRoom_Type(roomTypeLbl.getText());
        reservationDTO.setStudent(studentDTO);
        reservationDTO.setStatus(statusComboBox.getValue());

        boolean iSUpdate =  reservationBO.reservationUpdate(reservationDTO);
        if (iSUpdate){
            Notifications.create()
                    .title("Notification!")
                    .text("Reservation Update!!")
                    .position(Pos.TOP_CENTER)
                    .showInformation();

        }

    }

    @FXML
    void roomTypeIdCombobox(ActionEvent event) {
        String roomTypeId = roomTypeIdComboBox.getSelectionModel().getSelectedItem();
        RoomDTO roomDTO = roomDAO.search(roomTypeId);
        roomTypeLbl.setText(roomDTO.getRoom_Type());

    }


    void setIdsStudentIdComboBox(){
        ArrayList<Student> all = studentDAO.getAll();
        ObservableList<String> studentIds = FXCollections.observableArrayList();
        for (Student student :all){
            studentIds.add(student.getStudent_Id());
        }
        studentIdComboBox.setItems(studentIds);
    }

    void setIdsRoomTypeIdComboBox(){
        ArrayList<Room> allRooms = roomDAO.getAll();
        ObservableList<String> roomIds = FXCollections.observableArrayList();

        for(Room room : allRooms){
            roomIds.add(room.getRoom_Type_Id());
        }
        roomTypeIdComboBox.setItems(roomIds);
    }

    void setStatusComboBox(){
        ObservableList<String> status = FXCollections.observableArrayList(
                "Paid", "UnPaid"
        );
        statusComboBox.setItems(status);
    }

    private void setCellValues(){
        res_IdColumn.setCellValueFactory(new PropertyValueFactory<>("reservation_Id"));
        stu_idColumn.setCellValueFactory(new PropertyValueFactory<>("student_Id"));
        roomTypeIdColumn.setCellValueFactory(new PropertyValueFactory<>("room_Type_Id"));
        roomTypeColumn.setCellValueFactory(new PropertyValueFactory<>("room_Type"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void setReservationTableData(){
        ArrayList<Reservation> allReservation  = reservationBO.getAllReservation();
        for (Reservation reservation : allReservation){
            reservationTable.getItems().add(new ReservationDTO(reservation.getReservation_Id(),reservation.getStudent(),reservation.getRoom(),reservation.getRoom_Type(),reservation.getDate(),reservation.getStatus()));
        }
    }






    private void tableListener(){
        reservationTable.getSelectionModel().selectedItemProperty().addListener((ob, oldValue, newValue) -> {
            if (newValue != null){
                saveBtn.setVisible(false);
                deleteBtn.setVisible(true);
                reservationLbl.setText("Reservation Update");
                reservationIdLbl.setText(newValue.getReservation_Id());
                studentIdComboBox.setValue(newValue.getStudent_Id());
                roomTypeIdComboBox.setValue(newValue.getRoom_Type_Id());
                datePicker.setValue(newValue.getDate());
                statusComboBox.setValue(newValue.getStatus());


            }
        });
    }

    public void refreshOnAction(ActionEvent actionEvent) {
        setReservationTableData();
    }
}


