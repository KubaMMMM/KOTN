package cz.macek.knight.command;

import cz.macek.knight.main.Game;

public class Mluvit implements Command{
    @Override

    public String execute(String param, Game game) {

        if(game.getCurrentRoom().getCharacter(param) == null){

            return "Nido takovy v okoli neni";
        }

        return game.getCurrentRoom().getCharacter(param).interact(game.getCurrentPlayer(), game);
    }
}
