package lk.ijse.d24_hostel_managment_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class User {
        @Id
        private String userName;
        private String password;

        public User(){

        }

        public User(String userName, String password) {
                this.userName = userName;
                this.password = password;
        }
}
