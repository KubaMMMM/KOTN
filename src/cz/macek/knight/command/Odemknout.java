package cz.macek.knight.command;

import cz.macek.knight.main.Game;

public class Odemknout implements Command{


    /**
     * prikaz s kterym se pokousime odemknout neco v aktualni mistnosti
     *
     * @param param nepouziva se
     * @param game aktuální hra
     * @return String jestli bylo odemikani uspesne nebo jestli ne a jestli je co odemykat
     */
    @Override
    public String execute(String param, Game game) {

        return game.odemkni();

    }
}
