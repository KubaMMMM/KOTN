package cz.macek.knight.data;

import java.util.List;
import java.util.Map;

public class GameData {

    private List<RoomData> rooms;

    private Map<String, ItemData> items;


    public GameData() {}

    public List<RoomData> getRooms() {
        return rooms;
    }


    public void setRooms(List<RoomData> rooms) {
        this.rooms = rooms;
    }

    public void setItems(Map<String, ItemData> items) {
        this.items = items;
    }



    public Map<String, ItemData> getItems() {
        return items;
    }


}