package lk.ijse.d24_hostel_managment_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity

public class Student {
    @Id
    private String student_Id;
    private String student_Name;
    private String student_Address;
    private String contact;
    private String birthday;
    private String gender;

    @OneToMany (mappedBy = "student")
    private List<Reservation>  list = new ArrayList<>();

    public Student(){

    }

    public Student(String student_Id, String student_Name, String student_Address, String contact, String birthday, String gender, List<Reservation> list) {
        this.student_Id = student_Id;
        this.student_Name = student_Name;
        this.student_Address = student_Address;
        this.contact = contact;
        this.birthday = birthday;
        this.gender = gender;
        this.list = list;
    }
}
