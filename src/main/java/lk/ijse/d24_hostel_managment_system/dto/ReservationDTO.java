package lk.ijse.d24_hostel_managment_system.dto;


import lk.ijse.d24_hostel_managment_system.entity.Room;
import lk.ijse.d24_hostel_managment_system.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class ReservationDTO {
    private String reservation_Id;
    private LocalDate date;
    private String room_Type;
    private String status;
    private String room_Type_Id;
    private String student_Id;






    public ReservationDTO(String text, String text1, LocalDate value, String selectedItem, String selectedItem1, String selectedItem2) {
        reservation_Id=text;
        room_Type=text1;
        date=value;
        status=selectedItem;
        student_Id=selectedItem1;
        room_Type_Id=selectedItem2;
    }

    public ReservationDTO() {

    }

    public ReservationDTO(String reservation_id, Student student, Room room, String room_type, LocalDate date, String status) {
        this.reservation_Id=reservation_id;
        this.student_Id= String.valueOf(student.getStudent_Id());
        this.room_Type_Id= String.valueOf(room.getRoom_Type_Id());
        this.room_Type=room_type;
        this.date=date;
        this.status=status;
    }
}
