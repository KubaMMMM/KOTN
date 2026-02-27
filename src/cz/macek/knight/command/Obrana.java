package cz.macek.knight.command;

import cz.macek.knight.main.Game;

public class Obrana implements Command {


    /**
     * prikaz co pouziva metodu defend z Game -> braneni v boji
     *
     * @param param nepouziva se
     * @param game aktuální hra
     * @return vysledek obrany
     */
    @Override
    public String execute(String param, Game game) {

        if (!game.isInCombat()) {
            return "Nemáš se proti čemu bránit.";
        }

        return game.defend();
    }
}