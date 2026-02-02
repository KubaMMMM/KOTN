package cz.macek.knight.item;

import cz.macek.knight.character.Player;

/**
 * Lektvar - odolnost proti ohni
 */
public class Potion extends Item {

    public Potion(String name) {
        super(name);
    }

    public void use(Player player) {

        player.setFireResistance(true);

    }
}