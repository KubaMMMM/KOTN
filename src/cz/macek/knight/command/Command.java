package cz.macek.knight.command;

import cz.macek.knight.main.Game;


public interface Command {
    String execute(Game game);
}
