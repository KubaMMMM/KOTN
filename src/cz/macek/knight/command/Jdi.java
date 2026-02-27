package cz.macek.knight.command;

import cz.macek.knight.main.Game;
import cz.macek.knight.world.Room;

public class Jdi implements Command{


    /**
     * prikaz na posouvani v lokacich(mistnostech) pomoci zkratek svetovych stran(S,V,Z,J)
     * v pripade ze v mistnosti do ktere se presunul nekdo je zahaji s nim souboj
     * kdyz je param prazdy informuje o spatnem zadani prikazu
     * pokud je v combat tak nedovoli jit do jine mistnosti
     * @param param zkratka svet strany
     * @param game aktuální hra
     * @return popis mistnosti do ktere jsme se presunili
     */
    @Override
    public String execute(String param, Game game) {

        if(param.isEmpty()){
                return "Za 'jdi' musite zadat prvni pismeno svetove strany napr. - 'jdi S'";
        }


        if (game.isInCombat()) {
            return "Nepřítel vás nenechá odejít.";
        }

        Room nextRoom = null;

        switch (param.toLowerCase()) {
            case "j":
                nextRoom = game.getCurrentRoom().getRoomSouth();
                break;
            case "s":
                nextRoom = game.getCurrentRoom().getRoomNorth();
                break;
            case "v":
                nextRoom = game.getCurrentRoom().getRoomEast();
                break;
            case "z":
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
            game.setInCombat(true);
            return "Nacházíš se v místnosti: "
                    + nextRoom.getDescription()+"\n"+ "Vstupujete do souboje s "
                    + game.getCurrentEnemy().getName();
        }

        game.setCurrentEnemy(null);

        return "Nacházíš se v místnosti: "
                + nextRoom.getDescription();
    }
}
