package cz.macek.knight.data;

import cz.macek.knight.item.*;
import cz.macek.knight.character.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.macek.knight.world.CastleRoom;
import cz.macek.knight.world.Room;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class GameLoader {

    /**
     * Načte herní svět ze souboru JSON uloženého v resources
     */
    public static Map<String, Room> loadRooms(String fileName) {

        ObjectMapper mapper = new ObjectMapper();
        GameData data;

        try (InputStream is = GameLoader.class.getClassLoader().getResourceAsStream(fileName)) {

            if (is == null) {
                throw new RuntimeException("Soubor nenalezen v resources: " + fileName);
            }

            data = mapper.readValue(is, GameData.class);

        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání světa: " + fileName, e);
        }

        Map<String, Room> rooms = new HashMap<>();

        // vytvoření místností
        for (RoomData rd : data.getRooms()) {

            Room room;

            if ("castle".equals(rd.getId())) {
                room = new CastleRoom(rd.getDescription());
            } else {
                room = new Room(rd.getDescription());
            }

            if (rd.getItems() != null) {
                for (String itemId : rd.getItems()) {
                    ItemData itemData = data.getItems().get(itemId);
                    room.addItem(ItemFactory.create(itemId, itemData));
                }
            }

            if (rd.getCharacters() != null) {
                for (String charId : rd.getCharacters()) {
                    room.addCharacter(CharacterFactory.create(charId));
                }
            }

            rooms.put(rd.getId(), room);
        }

        // propojení exitů
        for (RoomData rd : data.getRooms()) {

            Room currentRoom = rooms.get(rd.getId());

            if (rd.getExits() == null) {
                continue;
            }

            if (rd.getExits().get("north") != null) {
                currentRoom.setRoomNorth(
                        rooms.get(rd.getExits().get("north")));
            }

            if (rd.getExits().get("south") != null) {
                currentRoom.setRoomSouth(
                        rooms.get(rd.getExits().get("south")));
            }

            if (rd.getExits().get("east") != null) {
                currentRoom.setRoomEast(
                        rooms.get(rd.getExits().get("east")));
            }

            if (rd.getExits().get("west") != null) {
                currentRoom.setRoomWest(
                        rooms.get(rd.getExits().get("west")));
            }
        }

        return rooms;
    }
}