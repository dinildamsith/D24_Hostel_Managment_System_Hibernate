package lk.ijse.d24_hostel_managment_system.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDTO {
    private String student_Id;
    private String student_Name;
    private String student_Address;
    private String contact;
    private LocalDate birthday;
    private String gender;

    public StudentDTO(){

    }

    public StudentDTO(String student_Id, String student_Name, String student_Address, String contact, LocalDate birthday, String gender) {
        this.student_Id = student_Id;
        this.student_Name = student_Name;
        this.student_Address = student_Address;
        this.contact = contact;
        this.birthday = birthday;
        this.gender = gender;
    }
}
