package cz.macek.knight.command;

import cz.macek.knight.character.Player;
import cz.macek.knight.main.Game;

public class Stav implements Command{
    @Override
    public String execute(String param, Game game) {


        Player p = game.getCurrentPlayer();
        StringBuilder sb = new StringBuilder();

        sb.append("=== STAV HRÁČE ===\n");
        sb.append("Životy: ").append(renderHearts(p.getLives())).append("\n");

        sb.append("Zbraň: ");
        if (p.getWeapon() != null) {
            sb.append(p.getWeapon().getName());
        } else {
            sb.append("žádná");
        }
        sb.append("\n");

        sb.append("Zbroj: ");
        if (p.getArmor() != null) {
            sb.append(p.getArmor().getName());
        } else {
            sb.append("žádná");
        }
        sb.append("\n");

        sb.append("Štít: ");
        if (p.getShield() != null) {
            sb.append(p.getShield().getName());
        } else {
            sb.append("žádný");
        }
        sb.append("\n");

        sb.append("Odolnost proti ohni: ");
        if (p.hasFireResistance()) {
            sb.append("ANO");
        } else {
            sb.append("NE");
        }
        sb.append("\n");

        sb.append("Hoření: ");
        if (p.getLosingHP() > 0) {
            sb.append("ANO");
        } else {
            sb.append("NE");
        }
        sb.append("\n");

        sb.append("Inventář: ");
        sb.append(p.getBackpack().getItems());
        sb.append("\n");

        return sb.toString();

    }


    /**
     * Vykreslí životy hráče pomocí emoji srdcí.
     * 1 HP = půl srdce (💔)
     * 2 HP = celé srdce (❤️)
     */
    private String renderHearts(int lives) {

        StringBuilder hearts = new StringBuilder();

        int fullHearts = lives / 2;
        boolean halfHeart = (lives % 2) == 1;

        for (int i = 0; i < fullHearts; i++) {
            hearts.append("❤️");
        }

        if (halfHeart) {
            hearts.append("💔");
        }

        if (lives <= 0) {
            hearts.append(" ☠️");
        }

        return hearts.toString();
    }
}
