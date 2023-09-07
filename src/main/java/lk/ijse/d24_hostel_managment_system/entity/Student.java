package lk.ijse.d24_hostel_managment_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
public class Student {
    @Id
    private String student_Id;
    private String student_Name;
    private String student_Address;
    private String contact;
    private LocalDate birthday;
    private String gender;

    @ToString.Exclude
    @OneToMany (targetEntity = Reservation.class, mappedBy = "student", cascade = CascadeType.ALL)
    private List<Reservation> list = new ArrayList<>();

    public Student(){

    }

    public Student(String student_Id, String student_Name, String student_Address, String contact, LocalDate birthday, String gender, List<Reservation> list) {
        this.student_Id = student_Id;
        this.student_Name = student_Name;
        this.student_Address = student_Address;
        this.contact = contact;
        this.birthday = birthday;
        this.gender = gender;
        this.list = list;
    }

    public Student(String student_Id, String student_Name, String student_Address, String contact, LocalDate birthday, String gender) {
        this.student_Id = student_Id;
        this.student_Name = student_Name;
        this.student_Address = student_Address;
        this.contact = contact;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Student(String student_id, String contact, String student_name) {
        this.student_Id=student_id;
        this.contact=contact;
        this.student_Name=student_name;
    }
}
