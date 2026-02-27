package cz.macek.knight.command;

import cz.macek.knight.main.Game;

public class Uhnout implements Command {


    /**
     * prikaz pouziva prikaz dodge z Game -> pokus o uhyb dalsiho utoku nepritele (50%)
     *
     * @param param nepouziva se
     * @param game aktuální hra
     * @return zda bylo uhnuti uspesne
     */
    @Override
    public String execute(String param, Game game) {

        if (!game.isInCombat()) {
            return "Není čemu uhýbat.";
        }

        return game.dodge();
    }
}