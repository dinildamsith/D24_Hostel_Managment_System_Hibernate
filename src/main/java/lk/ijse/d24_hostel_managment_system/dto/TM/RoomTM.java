package lk.ijse.d24_hostel_managment_system.dto.TM;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomTM {
    private String room_Type_Id;
    private String room_Type;
    private String key_Money;
    private String rooms_Qty;

    public RoomTM() {
    }

    public RoomTM(String room_Type_Id, String room_Type, String key_Money, String rooms_Qty) {
        this.room_Type_Id = room_Type_Id;
        this.room_Type = room_Type;
        this.key_Money = key_Money;
        this.rooms_Qty = rooms_Qty;
    }
}
