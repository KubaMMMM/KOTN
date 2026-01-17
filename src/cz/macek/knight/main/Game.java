package cz.macek.knight.main;

import cz.macek.knight.character.Player;
import cz.macek.knight.character.Enemy;
import cz.macek.knight.world.Room;
import java.util.Map;


public class Game {
    private Player currentPlayer;
    private Room currentRoom;
    private Map<String, Room> rooms;
    private boolean inCombat;
    private Enemy currentEnemy;

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
}
