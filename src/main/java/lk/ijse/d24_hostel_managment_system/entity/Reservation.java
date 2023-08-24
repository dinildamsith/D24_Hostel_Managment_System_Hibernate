package lk.ijse.d24_hostel_managment_system.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Reservation {
    @Id
    private String reservation_Id;
    private String room_Type;
    private String date;
    private String status;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Room room;

    public Reservation(){

    }

    public Reservation(String reservation_Id, String room_Type, String date, String status, Student student, Room room) {
        this.reservation_Id = reservation_Id;
        this.room_Type = room_Type;
        this.date = date;
        this.status = status;
        this.student = student;
        this.room = room;
    }
}
