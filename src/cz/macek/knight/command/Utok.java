package cz.macek.knight.command;

import cz.macek.knight.*;
import cz.macek.knight.main.Game;

public class Utok implements Command {

    @Override
    public String execute(String param, Game game) {

        if (!game.isInCombat()) {
            return "Teď není s kým bojovat.";
        }

        return game.attack();
    }
}