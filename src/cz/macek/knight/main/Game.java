package cz.macek.knight.main;

import cz.macek.knight.character.Player;
import cz.macek.knight.character.Enemy;
import cz.macek.knight.data.GameLoader;
import cz.macek.knight.world.Room;

import java.util.Map;

/**
 * Hlavní třída hry Knight of the Nine
 */
public class Game {
    private Player currentPlayer;
    private Room currentRoom;
    private Map<String, Room> rooms;
    private boolean inCombat;
    private Enemy currentEnemy;
    private boolean konec;


    public boolean getKonec() {
        return konec;
    }

    public void setKonec(boolean konec) {
        this.konec = konec;
    }

    public Game() {
        // Constructor
    }

    public void processCommand(String input) {
        // Zpracování příkazů
    }

    public void print(String message) {
        // Výpis zpráv
    }

    public void combat() {
        // Bojový systém
    }

    public void enterCombat(Enemy enemy) {
        // Vstup do boje
    }

    public void start() {
        // Start hry

        rooms = GameLoader.loadRooms("world.json");
        currentRoom = rooms.get("village");

        if (currentRoom == null) {
            throw new IllegalStateException("Startovní místnost neexistuje!");
        }

    }

    // Gettery a settery
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }

    public boolean isInCombat() {
        return inCombat;
    }

    public Enemy getCurrentEnemy() {
        return currentEnemy;
    }
}