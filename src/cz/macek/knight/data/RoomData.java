package cz.macek.knight.data;

import java.util.Map;

public class RoomData {

    private String id;
    private String description;
    private Map<String, String> exits;

    public RoomData() {}

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, String> getExits() {
        return exits;
    }
}