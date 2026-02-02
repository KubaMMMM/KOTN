package cz.macek.knight.command;

import cz.macek.knight.main.Game;

public class Obrana implements Command {

    @Override
    public String execute(String param, Game game) {

        if (!game.isInCombat()) {
            return "Nemáš se proti čemu bránit.";
        }

        return game.defend();
    }
}