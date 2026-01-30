package cz.macek.knight.data;

import java.util.List;
import java.util.Map;

public class RoomData {

    private String id;
    private String description;
    private Map<String, String> exits;

    private List<String> items;
    private List<String> characters;

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExits(Map<String, String> exits) {
        this.exits = exits;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

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