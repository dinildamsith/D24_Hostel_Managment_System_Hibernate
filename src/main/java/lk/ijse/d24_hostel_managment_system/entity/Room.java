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

public class Room {
    @Id
    private String room_Type_Id;
    private String room_Type;
    private String key_Money;
    private String rooms_Qty;

    @OneToMany(mappedBy = "room",targetEntity = Reservation.class)
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
}
