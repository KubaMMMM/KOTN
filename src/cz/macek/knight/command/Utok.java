package cz.macek.knight.command;
import cz.macek.knight.main.Game;

public class Utok implements Command {


    /**
     * prikaz co pouziva metodu attack() z Game -> zautoci na aktualniho nepritele
     *
     * @param param nepouziva se
     * @param game aktuální hra
     * @return vysledek utoku -> poskozeni
     */
    @Override
    public String execute(String param, Game game) {

        if (!game.isInCombat()) {
            return "Teď není s kým bojovat.";
        }

        return game.attack();
    }
}