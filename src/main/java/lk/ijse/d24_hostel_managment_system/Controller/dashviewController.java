package lk.ijse.d24_hostel_managment_system.Controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.d24_hostel_managment_system.dao.DAOFactory;
import lk.ijse.d24_hostel_managment_system.dao.custom.QueryDAO;
import lk.ijse.d24_hostel_managment_system.dao.custom.ReservationDAO;
import lk.ijse.d24_hostel_managment_system.dao.custom.RoomDAO;
import lk.ijse.d24_hostel_managment_system.dao.custom.StudentDAO;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.QueryDAOImpl;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.RoomDAOImpl;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.StudentDAOImpl;
import lk.ijse.d24_hostel_managment_system.entity.Student;

import java.awt.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class dashviewController implements Initializable {

    public Label studentCount;
    public AnchorPane dash;
    public Label roomCount;
    public Label resversionCount;
    public TableView unpaidDetailsTbl;
    public TableColumn studentIdColum;
    public TableColumn nameColum;
    public TableColumn contactColum;
    public Label dateLbl;
    public Label time;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValues();
        tableAddData();

//        StudentDAOImpl studentDAO = new StudentDAOImpl();
//        ReservationDAOImpl reservationDAO = new ReservationDAOImpl();
//        RoomDAOImpl roomDAO = new RoomDAOImpl();
        StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
        ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);
        RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);

        studentCount.setText(studentDAO.getCount());
        resversionCount.setText(reservationDAO.getCount());
        roomCount.setText(roomDAO.getCount());
        loadDateAndTime();



    }

    private void setCellValues() {
        studentIdColum.setCellValueFactory(new PropertyValueFactory<>("student_Id"));
        nameColum.setCellValueFactory(new PropertyValueFactory<>("student_Name"));
        contactColum.setCellValueFactory(new PropertyValueFactory<>("contact"));

    }

    private void tableAddData(){
        QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);
//        QueryDAOImpl queryDAO =  new QueryDAOImpl();
        List<Student> unpay = queryDAO.unPaidPayments();
        ArrayList<Student> all = new ArrayList<>();
        for (Student student :unpay)
        unpaidDetailsTbl.getItems().add(new Student(student.getStudent_Id(),student.getStudent_Name(),student.getContact()));
    }



    private void loadDateAndTime() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dateLbl.setText(format.format(date));

        Timeline timeline = new Timeline(new KeyFrame(javafx.util.Duration.ZERO, e ->{
            DateTimeFormatter format2 = DateTimeFormatter.ofPattern("HH:mm:ss");
            time.setText(LocalTime.now().format(format2));
        }), new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}


