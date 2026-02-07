package cz.macek.knight.command;

import cz.macek.knight.main.Game;

/**
 * Rozhraní pro všechny herní příkazy.
 */
public interface Command {

    /**
     * Vykoná příkaz.
     *
     * @param param parametr příkazu
     * @param game aktuální hra
     * @return textová odpověď pro hráče
     */
    String execute(String param, Game game);
}
