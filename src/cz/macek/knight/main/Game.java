package cz.macek.knight.main;

import cz.macek.knight.character.Ally;
import cz.macek.knight.character.Dragon;
import cz.macek.knight.character.Player;
import cz.macek.knight.character.Enemy;
import cz.macek.knight.command.Command;
import cz.macek.knight.command.CommandParser;
import cz.macek.knight.data.GameLoader;
import cz.macek.knight.item.Shield;
import cz.macek.knight.world.CastleRoom;
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
    private Ally currentAlly;

    public boolean getKonec() {
        return konec;
    }

    public void setKonec(boolean konec) {
        this.konec = konec;
    }

    public Game() {
        commandParser = new CommandParser();
    }

    public void setCurrentEnemy(Enemy currentEnemy) {
        this.currentEnemy = currentEnemy;
    }


    public String attack() {

        if(currentEnemy == null){
            return "Nemuzes s nikym bojovat";
        }

        int dmg = currentPlayer.attack(currentEnemy);
        currentEnemy.takeDamage(dmg);
        StringBuilder sb = new StringBuilder();
        sb.append("Zasáhl jsi nepřítele za ").append(dmg).append(" HP.\n");

        if (!currentEnemy.isAlive()) {
            sb.append(currentEnemy.die());
            currentRoom.removeCharacter(currentEnemy);
            currentEnemy = null;
            inCombat = false;
            return sb.toString();
        }

        sb.append(currentEnemy.takeTurn(currentPlayer));
        currentPlayer.applyLoosingHP();


        if (currentPlayer.getLives() <= 0) {
            inCombat = false;
            return sb.append("\nByl jsi poražen.").toString();
        }

        return sb.toString();
    }

    public String defend() {

        currentPlayer.setDefending(true);

        String result = currentEnemy.takeTurn(currentPlayer);

        currentPlayer.setDefending(false);

        currentPlayer.applyLoosingHP();


        if (currentPlayer.getLives() <= 0) {
            inCombat = false;
            return result + "\nByl jsi poražen.";
        }

        return "Bráníš se.\n" + result;
    }

    public String dodge() {

        if (currentEnemy instanceof Dragon) {
            return "Drak je příliš rychlý a mohutný – uhnout nelze!";
        }

        currentPlayer.setDodging(true);

        String result = currentEnemy.takeTurn(currentPlayer);
        currentPlayer.setDodging(false);

        if (currentPlayer.getLives() <= 0) {
            inCombat = false;
            return result + "\nByl jsi poražen.";
        }

        return result;
    }

    public String odemkni() {

        if (!(currentRoom instanceof CastleRoom castle)) {
            return "Tady není co odemykat.";
        }

        if (castle.getUnlocked()) {
            return "Komnata je už odemčená.";
        }

        if (!currentPlayer.hasItem("Část klíče 1")
                || !currentPlayer.hasItem("Část klíče 2")) {
            return "Nemáš kompletní klíč.";
        }

        castle.unlock();

        currentPlayer.getBackpack().removeItem(
                currentPlayer.getBackpack().getItem("Část klíče 1")
        );
        currentPlayer.getBackpack().removeItem(
                currentPlayer.getBackpack().getItem("Část klíče 2")
        );

        return "Odemkl jsi komnatu na hradě.";
    }

    public void setInCombat(boolean inCombat) {
        this.inCombat = inCombat;
    }

    public String search() {

        if(inCombat){
            return "nemuzes prohledavat v boji";
        }

        if(currentEnemy != null) {

            inCombat = true;
            return "vstupujete do souboje s " + getCurrentEnemy().getName();
        }

        getCurrentRoom().setExamined(true);
        return "Porozhledli jste se okolo sebe a zpozorovali jste :"+ getCurrentRoom().getCharacterList().toString()+" "+getCurrentRoom().getItemsList().toString();
    }

    public boolean isOgreDefeated() {
        Room cave = rooms.get("cave");
        return cave != null && !cave.containsEnemy();
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


    public void enterCombat() {
        inCombat = true;
    }

    public void start() {

        rooms = GameLoader.loadRooms("world.json");

        currentRoom = rooms.get("village");
        if (currentRoom == null) {
            throw new IllegalStateException("Startovní místnost neexistuje!");
        }

        currentAlly = currentRoom.
        currentPlayer = new Player("Rytíř");
        currentPlayer.setPosition(currentRoom);
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
        currentPlayer.setPosition(room);

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