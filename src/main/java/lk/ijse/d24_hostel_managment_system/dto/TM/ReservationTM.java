package lk.ijse.d24_hostel_managment_system.dto.TM;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationTM {
    private String reservation_Id;
    private String student_Id;
    private String room_Type_Id;
    private String room_Type;
    private String date;
    private String status;

    public ReservationTM() {

    }

    public ReservationTM(String reservation_Id, String student_Id, String room_Type_Id, String room_Type, String date, String status) {
        this.reservation_Id = reservation_Id;
        this.student_Id = student_Id;
        this.room_Type_Id = room_Type_Id;
        this.room_Type = room_Type;
        this.date = date;
        this.status = status;
    }
}
