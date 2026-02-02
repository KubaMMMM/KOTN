package cz.macek.knight.command;

import cz.macek.knight.main.Game;
import cz.macek.knight.world.Room;

public class Jdi implements Command{


    @Override
    public String execute(String param, Game game) {

        if(game.isInCombat()){
            return "nepritel vas nenecha odejit";
        }

        Room nextRoom = null;

        switch (param) {
            case "S":
                nextRoom = game.getCurrentRoom().getRoomSouth();
                break;
            case "N":
                nextRoom = game.getCurrentRoom().getRoomNorth();
                break;
            case "E":
                nextRoom = game.getCurrentRoom().getRoomEast();
                break;
            case "W":
                nextRoom = game.getCurrentRoom().getRoomWest();
                break;
            default:
                return "Tímto směrem se jít nedá.";
        }

        if (nextRoom == null) {
            return "Tímto směrem se jít nedá.";
        }

        // přesun
        game.setCurrentRoom(nextRoom);
        game.getCurrentPlayer().setPosition(nextRoom);

        if (nextRoom.containsEnemy()) {
            game.setCurrentEnemy(nextRoom.getEnemies().get(0));
        } else {
            game.setCurrentEnemy(null);
        }

        return "Nacházíš se v místnosti: " + nextRoom.getDescription();
    }
}
