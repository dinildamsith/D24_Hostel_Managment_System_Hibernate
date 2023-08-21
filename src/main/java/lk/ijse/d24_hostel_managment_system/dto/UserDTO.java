package lk.ijse.d24_hostel_managment_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String userName;
    private String password;

    public UserDTO(){

    }

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
