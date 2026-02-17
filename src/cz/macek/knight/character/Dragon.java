package cz.macek.knight.character;

import cz.macek.knight.main.Game;

public class Dragon extends Enemy {


    /**
     * Speciální typ nepřítele – drak.
     *
     * Má unikátní schopnosti: ohnivý dech, nabíjený útok
     * a interakci s ohnivou odolností hráče.
     */
    public Dragon() {
        super("drak", 7, 2);
    }

    @Override
    public String takeTurn(Player player) {

        if (charging) {
            charging = false;
            return strongAttack(player);
        }

        double roll = Math.random();

        if (roll < 0.3) {
            charging = true;
            return "Drak se zhluboka nadechuje… cítíš žár ohně!";
        }

        if (roll < 0.6) {
            return fireBreath(player);
        }

        return clawAttack(player);
    }

    private String strongAttack(Player player) {

        int dmg = 3;

        player.setDodging(false);

        if (player.isDefending()) {
            dmg -= 1;
            if (player.hasShield()) {
                dmg -= player.getShield().getBlockPower();
            }
        }

        if (dmg < 0) dmg = 0;

        dealDamage(player, dmg);

        return "Drak chrlí mohutný ohnivý výboj za "
                + dmg + " HP!";
    }


    private String clawAttack(Player player) {

        int dmg = damage; // 2

        player.setDodging(false);

        if (player.isDefending()) {
            dmg -= 1;
            if (player.hasShield()) {
                dmg -= player.getShield().getBlockPower();
            }
        }

        if (dmg < 0) dmg = 0;

        dealDamage(player, dmg);

        return "Drak tě zasáhl svými drápy za "
                + dmg + " HP.";
    }

    private String fireBreath(Player player) {

        int dmg = 1;

        player.setDodging(false);

        if (!player.hasFireResistance()) {
            player.setLosingHP(1);
        }

        if (player.isDefending()) {
            dmg -= 1;
            if (player.hasShield()) {
                dmg -= player.getShield().getBlockPower();
            }
        }

        if (dmg < 0) dmg = 0;

        dealDamage(player, dmg);

        return "Drak tě zasáhl ohnivým dechem! Utrpěl jsi "
                + dmg + " HP."
                + (player.hasFireResistance() ? "" : " Začínáš hořet!");
    }



    @Override
    public String interact(Player player, Game game) {
        return "Drak tě pozoruje svými žlutými očima...";
    }
}
