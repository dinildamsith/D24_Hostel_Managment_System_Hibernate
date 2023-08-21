package lk.ijse.d24_hostel_managment_system.dto.TM;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentTM {
    private String student_Id;
    private String student_Name;
    private String student_Address;
    private String contact;
    private String birthday;
    private String gender;

    public StudentTM() {
    }

    public StudentTM(String student_Id, String student_Name, String student_Address, String contact, String birthday, String gender) {
        this.student_Id = student_Id;
        this.student_Name = student_Name;
        this.student_Address = student_Address;
        this.contact = contact;
        this.birthday = birthday;
        this.gender = gender;
    }
}
