package cz.macek.knight.data;

import com.google.gson.Gson;
import cz.macek.knight.world.Room;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class GameLoader {

    public static Map<String, Room> loadRooms(String filePath) {

        Gson gson = new Gson();
        GameData data;

        try {
            // Gson udělá CELÉ parsování
            data = gson.fromJson(new FileReader(filePath), GameData.class);
        } catch (Exception e) {
            throw new RuntimeException("Nelze načíst svět", e);
        }

        Map<String, Room> rooms = new HashMap<>();

        // 1️⃣ vytvoření místností
        for (RoomData rd : data.getRooms()) {
            rooms.put(rd.getId(), new Room(rd.getDescription()));
        }

        // 2️⃣ propojení místností
        for (RoomData rd : data.getRooms()) {
            Room room = rooms.get(rd.getId());

            if (rd.getExits() == null) continue;

            if (rd.getExits().get("north") != null)
                room.setRoomNorth(rooms.get(rd.getExits().get("north")));

            if (rd.getExits().get("south") != null)
                room.setRoomSouth(rooms.get(rd.getExits().get("south")));

            if (rd.getExits().get("east") != null)
                room.setRoomEast(rooms.get(rd.getExits().get("east")));

            if (rd.getExits().get("west") != null)
                room.setRoomWest(rooms.get(rd.getExits().get("west")));
        }

        return rooms;
    }
}

