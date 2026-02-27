package cz.macek.knight.command;

import cz.macek.knight.main.Game;

public class Prozkoumej implements Command{

    /**
     * prikaz co pouziva metodu search v Game -> prohledani mistnosti
     *
     * @param param nepouziva se
     * @param game aktuální hra
     * @return co a kdo se v mistnosti nachazi
     */
    @Override
    public String execute(String param, Game game) {

      return game.search();
    }
}
