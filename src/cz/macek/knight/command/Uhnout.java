package cz.macek.knight.command;

import cz.macek.knight.main.Game;

public class Uhnout implements Command {

    @Override
    public String execute(String param, Game game) {

        if (!game.isInCombat()) {
            return "Není čemu uhýbat.";
        }

        return game.dodge();
    }
}