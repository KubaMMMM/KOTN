package cz.macek.knight.character;

import cz.macek.knight.main.Game;

public class Witch extends Ally {

    public Witch() {
        super("Ježibaba");
    }

    @Override
    public String interact(Player player, Game game) {
        return brewPotion(player);
    }

    public String brewPotion(Player player) {
        // Vaření lektvaru
        return "";
    }
}
