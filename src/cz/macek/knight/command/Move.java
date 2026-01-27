package cz.macek.knight.command;

import cz.macek.knight.main.Game;

public class Move implements Command{


    @Override
    public String execute(String param, Game game) {


        switch (param){

            case "S": game.setCurrentRoom(game.getCurrentRoom().getRoomSouth());

            case "N": game.setCurrentRoom(game.getCurrentRoom().getRoomNorth());

            case "E": game.setCurrentRoom(game.getCurrentRoom().getRoomEast());

            case "W": game.setCurrentRoom(game.getCurrentRoom().getRoomWest());

            default:
                return "Nacházíš se v místnosti"+ game.getCurrentRoom().getDescription();

        }
    }
}
