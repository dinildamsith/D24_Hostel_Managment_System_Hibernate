package lk.ijse.d24_hostel_managment_system.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString

public class Room {
    @Id
    private String room_Type_Id;
    private String room_Type;
    private String key_Money;
    private String rooms_Qty;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL,targetEntity = Reservation.class)
    private List<Reservation> list = new ArrayList<>();

    public Room(){

    }

    public Room(String room_Type_Id, String room_Type, String key_Money, String rooms_Qty, List<Reservation> list) {
        this.room_Type_Id = room_Type_Id;
        this.room_Type = room_Type;
        this.key_Money = key_Money;
        this.rooms_Qty = rooms_Qty;
        this.list = list;
    }

    public Room(String text, String text1, String text2, String text3) {
        room_Type_Id=text;
        room_Type=text1;
        key_Money=text2;
        rooms_Qty=text3;
    }
}
