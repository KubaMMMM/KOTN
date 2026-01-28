package cz.macek.knight.main;

import cz.macek.knight.character.Player;
import cz.macek.knight.character.Enemy;
import cz.macek.knight.command.Command;
import cz.macek.knight.command.CommandParser;
import cz.macek.knight.data.GameLoader;
import cz.macek.knight.item.Shield;
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
    private CommandParser commandParser;

    public boolean getKonec() {
        return konec;
    }

    public void setKonec(boolean konec) {
        this.konec = konec;
    }

    public Game() {
        commandParser = new CommandParser();
    }

    public String odemkni() {

        Room castle = rooms.get("castle");

        if (currentRoom != castle) {
            return "Tady není co odemykat.";
        }

        if (!currentPlayer.hasItem("klic")) {
            return "Nemáš klíč.";
        }

        return "Odemkl jsi komnatu na hradě.";
    }

    public String search() {

        if(isInCombat()){
            return "nepritel vas prohledat okoli nenecha";
        }
        getCurrentRoom().setExamined(true);



        return "Porozhledli jste se okolo sebe a zpozorovali jste :"+ getCurrentRoom().getCharacterList().toString()+" "+getCurrentRoom().getItemsList().toString();
    }


    public String processCommand(String input) {

        if (input == null || input.trim().isEmpty()) {
            return "Zadej příkaz.";
        }

        String[] parts = input.trim().split("\\s+", 2);

        String commandName = parts[0].toLowerCase();
        String param = parts.length > 1 ? parts[1] : "";

        Command command = commandParser.getCommand(commandName);

        if (command == null) {
            return "Neznámý příkaz.";
        }

        return command.execute(param, this);
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