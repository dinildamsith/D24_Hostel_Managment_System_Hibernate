package lk.ijse.d24_hostel_managment_system.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    private String reservation_Id;
    private String room_Type;
    private LocalDate date;
    private String status;

   // @JoinColumn(name = "student_id")
    @ManyToOne (fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    private Student student;

  // @JoinColumn(name = "room_id")
    @ManyToOne (fetch = FetchType.EAGER,cascade = CascadeType.DETACH)//CascadeType.Remove,orphanRemoval =true
    private Room room;

    public Reservation(String text, String text1, LocalDate value, String selectedItem, String selectedItem1, String selectedItem2) {
        reservation_Id=text;
        room_Type=text1;
        date=value;
        status=selectedItem;
        student.setStudent_Id(selectedItem1);
        room.setRoom_Type_Id(selectedItem2);
    }
}
