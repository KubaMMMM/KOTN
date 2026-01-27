package cz.macek.knight.command;

import cz.macek.knight.main.Game;

public class Konec implements Command{
    @Override
    public String execute(String param, Game game) {
        game.setKonec(true);
        return "Hra byla ukoncena";
    }
}
