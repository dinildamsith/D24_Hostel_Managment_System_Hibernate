package lk.ijse.d24_hostel_managment_system.dto.TM;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTM {
    private String userName;
    private String password;

    public UserTM() {
    }

    public UserTM(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
