package lk.ijse.d24_hostel_managment_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@Entity
@ToString
public class User {
        @Id
        private String userName;
        private String password;

        public User(){

        }


}
