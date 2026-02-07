package cz.macek.knight.character;

import cz.macek.knight.main.Game;
import cz.macek.knight.world.Room;

/**
 * Abstraktní základní třída pro všechny herní postavy.
 *
 * Slouží jako společný předek pro hráče, spojence i nepřátele.
 * Každá postava má jméno, životy a možnost interakce s hráčem.
 */
public abstract class Character {
    protected String name;
    protected int lives;

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    /**
     * Interakce postavy s hráčem.
     *
     * @param player aktuální hráč
     * @param game aktuální instance hry
     * @return textový popis interakce
     */
    public abstract String interact(Player player, Game game);

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public String toString() {
        return name;
    }
}