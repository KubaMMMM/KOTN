package cz.macek.knight.command;

import cz.macek.knight.main.Game;

public class Prozkoumej implements Command{


    @Override
    public String execute(String param, Game game) {

      return game.search();
    }
}
