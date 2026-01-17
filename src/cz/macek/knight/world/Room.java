package cz.macek.knight.world;

import cz.macek.knight.character.Character;
import cz.macek.knight.item.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room {
    private Map<String, Room> roomNorth;
    private Map<String, Room> roomSouth;
    private Map<String, Room> roomEast;
    private Map<String, Room> roomWest;
    private String description;
    private ArrayList<Item> itemsList;
    private ArrayList<Character> characterList;
    private boolean examined;

    public Room(String description) {
        this.description = description;
        this.itemsList = new ArrayList<>();
        this.characterList = new ArrayList<>();
        this.roomNorth = new HashMap<>();
        this.roomSouth = new HashMap<>();
        this.roomEast = new HashMap<>();
        this.roomWest = new HashMap<>();
        this.examined = false;
    }

    public boolean isExamined() {
        return examined;
    }

    public void addCharacter(Character character) {
        // Přidání postavy
    }

    public void addItem(Item item) {
        // Přidání předmětu
    }

    public void removeCharacter(Character character) {
        // Odebrání postavy
    }

    public void removeItem(Item item) {
        // Odebrání předmětu
    }

    public void setExamined(boolean examined) {
        this.examined = examined;
    }

    public Character getCharacter(String name) {
        // Získání postavy podle jména
        return null;
    }

    public String getDescription() {
        return description;
    }

    public Room getExit(String direction) {
        // Získání sousední místnosti
        return null;
    }
}
