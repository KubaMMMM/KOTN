package cz.macek.knight.item;

import cz.macek.knight.character.Player;

/**
 * Lektvar - odolnost proti ohni
 */
public class Potion extends Item {

    public Potion(String name) {
        super(name);
    }


    /**
     * Použije lektvar na hráče.
     *
     * Hráč po použití získá odolnost proti ohni.
     *
     * @param player hráč, na kterého je lektvar použit
     */
    public void use(Player player) {

        player.setFireResistance(true);

    }
}