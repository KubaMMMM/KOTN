package cz.macek.knight.main;

import cz.macek.knight.character.Dragon;
import cz.macek.knight.character.Player;
import cz.macek.knight.character.Enemy;
import cz.macek.knight.command.Command;
import cz.macek.knight.command.CommandParser;
import cz.macek.knight.data.GameLoader;
import cz.macek.knight.world.CastleRoom;
import cz.macek.knight.world.Room;

import java.util.HashMap;
import java.util.Map;

/**
 * Hlavní řídicí třída hry.
 *
 * Udržuje stav hry, aktuální místnost, boj,
 * zpracování příkazů a interakce.
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

    public void setCurrentEnemy(Enemy currentEnemy) {
        this.currentEnemy = currentEnemy;
    }



    /**
     * Provede útok hráče na aktuálního nepřítele
     * a následně tah nepřítele.
     *
     * @return výsledek kola boje
     */
    public String attack() {

        if(currentEnemy == null){
            return "Nemuzes s nikym bojovat";
        }

        int dmg = currentPlayer.attackDamage(currentEnemy);
        currentEnemy.takeDamage(dmg);
        StringBuilder sb = new StringBuilder();
        sb.append("Zasáhl jsi nepřítele za ").append(dmg).append(" HP.\n");

        if (!currentEnemy.isAlive()) {

            if (currentEnemy instanceof Dragon) {
                konec = true;
                sb.append("\nPorazil jsi draka a dokončil hru! ");
            }

            sb.append(currentEnemy.die());
            currentRoom.removeCharacter(currentEnemy);

            // Zkontroluj další nepřátele
            if (currentRoom.containsEnemy()) {

                currentEnemy = currentRoom.getEnemies().get(0);
                sb.append("\nDo boje vstupuje další nepřítel: ")
                        .append(currentEnemy.getName());

            } else {

                currentPlayer.setLives(currentPlayer.getLives() + getCurrentEnemy().getMaxLives());

                currentEnemy = null;
                inCombat = false;
            }

            return sb.toString();
        }

        sb.append(currentEnemy.takeTurn(currentPlayer));
        currentPlayer.applyLoosingHP();


        if (currentPlayer.getLives() <= 0) {
            inCombat = false;
            konec = true;
            return sb.append("\nByl jsi poražen.").toString();
        }

        return sb.toString();
    }


    /**
     * Pokus o obranu proti útoku nepřítele.
     *
     * @return výsledek obrany
     */
    public String defend() {

        currentPlayer.setDefending(true);

        String result = currentEnemy.takeTurn(currentPlayer);

        currentPlayer.setDefending(false);

        currentPlayer.applyLoosingHP();


        if (currentPlayer.getLives() <= 0) {
            inCombat = false;
            konec = true;

            return result + "\nByl jsi poražen.";
        }

        return "Bráníš se.\n" + result;
    }



    /**
     * Prohledá aktuální místnost.
     *
     * Pokud je přítomen nepřítel, zahájí boj.
     *
     * @return popis výsledku průzkumu
     */
    public String dodge() {


        currentPlayer.setDodging(true);

        String result = currentEnemy.takeTurn(currentPlayer);
        currentPlayer.setDodging(false);

        if (currentPlayer.getLives() <= 0) {
            inCombat = false;
            konec = true;

            return result + "\nByl jsi poražen.";
        }

        return result;
    }


    /**
     * Pokusí se odemknout hradní komnatu.
     *
     * Metoda ověřuje, zda se hráč nachází v hradní místnosti
     * a zda má obě části klíče. Při úspěchu komnatu odemkne
     * a klíče odebere z inventáře.
     *
     * @return výsledek pokusu o odemknutí
     */
    public String odemkni() {

        if (!(currentRoom instanceof CastleRoom castle)) {
            return "Tady není co odemykat.";
        }

        if (castle.getUnlocked()) {
            return "Komnata je už odemčená.";
        }

        if (!currentPlayer.hasItem("castKlice1")
                || !currentPlayer.hasItem("castKlice2")) {
            return "Nemáš kompletní klíč.";
        }

        castle.unlock();

        currentPlayer.getBackpack().removeItem(
                currentPlayer.getBackpack().getItem("castKlice1")
        );
        currentPlayer.getBackpack().removeItem(
                currentPlayer.getBackpack().getItem("castKlice2")
        );

        return "Odemkl jsi komnatu na hradě.";
    }

    public void setInCombat(boolean inCombat) {
        this.inCombat = inCombat;
    }



    /**
     * Prohledá aktuální místnost.
     *
     * Pokud hráč není v boji a v místnosti se nachází nepřítel,
     * zahájí se boj. V opačném případě metoda vypíše seznam
     * postav a předmětů v místnosti a označí ji jako prozkoumanou.
     *
     * @return textový popis výsledku prohledání nebo zahájení boje
     */
    public String search() {

        if(inCombat){
            return "nemuzes prohledavat v boji";
        }

        getCurrentRoom().setExamined(true);
        return "Porozhledli jste se okolo sebe a zpozorovali jste : "+ getCurrentRoom().vypisEntit();
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

    public String start() {

        try {
            rooms = GameLoader.loadRooms("world.json");
        } catch (Exception e) {
            rooms = new HashMap<>();
            konec = true;
            return "Nepodařilo se načíst herní svět. -> " + e.getMessage();
        }
        currentRoom = rooms.get("village");

        if (currentRoom == null) {
            konec = true;
            return "Startovní místnost neexistuje!";
        }

        currentPlayer = new Player("Rytíř");
        currentPlayer.setPosition(currentRoom);
        return """
====================================================
           KNIGHT OF THE NINE
====================================================

Království žije ve stínu draka.
Na obzoru se vznáší temná silueta a vzduch je cítit popelem.

Jsi rytíř, poslední naděje této země.

Tvůj úkol je jasný:
Najít výstroj, odhalit drakovu slabinu
a postavit se mu v jeho doupěti.

Začínáš ve vesnici.

Napiš 'pomoc' pro seznam příkazů.
""";
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