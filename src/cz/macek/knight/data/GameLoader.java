package cz.macek.knight.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.macek.knight.world.Room;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class GameLoader {

    /**
     * Načte herní svět ze souboru JSON a vytvoří propojené místnosti
     */
    public static Map<String, Room> loadRooms(String filePath) {

        ObjectMapper mapper = new ObjectMapper();
        GameData data;

        try {
            // 1️⃣ Načtení JSON souboru do datových tříd
            data = mapper.readValue(new File(filePath), GameData.class);
        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání světa ze souboru: " + filePath, e);
        }

        // 2️⃣ Vytvoření všech místností (zatím bez propojení)
        Map<String, Room> rooms = new HashMap<>();

        for (RoomData rd : data.getRooms()) {
            Room room = new Room(rd.getDescription());
            rooms.put(rd.getId(), room);
        }

        // 3️⃣ Propojení místností podle světových stran
        for (RoomData rd : data.getRooms()) {
            Room currentRoom = rooms.get(rd.getId());

            if (rd.getExits() == null) {
                continue;
            }

            if (rd.getExits().get("north") != null) {
                currentRoom.setRoomNorth(rooms.get(rd.getExits().get("north")));
            }
            if (rd.getExits().get("south") != null) {
                currentRoom.setRoomSouth(rooms.get(rd.getExits().get("south")));
            }
            if (rd.getExits().get("east") != null) {
                currentRoom.setRoomEast(rooms.get(rd.getExits().get("east")));
            }
            if (rd.getExits().get("west") != null) {
                currentRoom.setRoomWest(rooms.get(rd.getExits().get("west")));
            }
        }

        return rooms;
    }
}
