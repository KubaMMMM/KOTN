package cz.macek.knight.command;

import cz.macek.knight.main.Game;

public class Jdi implements Command{


    @Override
    public String execute(String param, Game game) {


        switch (param){

            case "S": game.setCurrentRoom(game.getCurrentRoom().getRoomSouth());
            break;

            case "N": game.setCurrentRoom(game.getCurrentRoom().getRoomNorth());
            break;

            case "E": game.setCurrentRoom(game.getCurrentRoom().getRoomEast());
            break;

            case "W": game.setCurrentRoom(game.getCurrentRoom().getRoomWest());
            break;

            default:
                return "Timto smerem se jit neda";
        }
        return "Nacházíš se v místnosti"+ game.getCurrentRoom().getDescription();

    }
}
