package lk.ijse.d24_hostel_managment_system.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.d24_hostel_managment_system.dao.custom.impl.RoomDAOImpl;
import lk.ijse.d24_hostel_managment_system.dto.RoomDTO;
import lk.ijse.d24_hostel_managment_system.entity.Room;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RoomFormController implements Initializable {
    @FXML
    private JFXTextField roomTypeIdTxt;

    @FXML
    private JFXTextField keyMoneyTxt;

    @FXML
    private JFXTextField roomTypeTxt;

    @FXML
    private JFXTextField roomQtyTxt;

    @FXML
    private TableView<RoomDTO> roomTable;

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
    private JFXButton updateBtn;

    RoomDAOImpl roomDAO = new RoomDAOImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomTableAddData();
        setCellValues();
    }

    private void setCellValues() {
        roomTypeIdColumn.setCellValueFactory(new PropertyValueFactory<>("room_Type_Id"));
        roomTypeColumn.setCellValueFactory(new PropertyValueFactory<>("room_Type"));
        keyMoneyColumn.setCellValueFactory(new PropertyValueFactory<>("key_Money"));
        roomQtyColumn.setCellValueFactory(new PropertyValueFactory<>("rooms_Qty"));

    }

    private void roomTableAddData(){
        ArrayList<Room> all = roomDAO.getAll();
        System.out.println(all);
        for (Room room : all){
            roomTable.getItems().add(new RoomDTO(room.getRoom_Type_Id(),room.getRoom_Type(),room.getKey_Money(),room.getRooms_Qty()));
        }
    }


    @FXML
    void saveBtnOnAction(ActionEvent event) {
        boolean roomSaved = roomDAO.save(new Room(roomTypeIdTxt.getText(),roomTypeTxt.getText(),keyMoneyTxt.getText(),roomQtyTxt.getText()));
        if (roomSaved){
            Notifications.create()
                    .title("Notification !")
                    .text("Room Saved !!")
                    .position(Pos.TOP_CENTER)
                    .showInformation();
        }
    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }


}



