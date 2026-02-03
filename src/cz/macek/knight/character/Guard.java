package cz.macek.knight.character;

import cz.macek.knight.main.Game;


public class Guard extends Ally{


    public Guard(String name) {
        super(name);
    }

    @Override
    public String interact(Player player, Game game) {

        return "N vychod odsud je drak. Jit na nej bez pripravy je sebevrazda";
    }
}
