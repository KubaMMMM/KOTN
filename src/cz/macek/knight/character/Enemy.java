package cz.macek.knight.character;

import cz.macek.knight.main.Game;

public class Enemy extends Character {

    protected int damage;
    protected boolean charging;



    /**
     * Základní třída pro všechny nepřátele.
     *
     * Řeší chování v boji, životy a poškození hráče.
     */
    public Enemy(String name, int lives, int damage) {
        super(name);
        this.lives = lives;
        this.damage = damage;
        this.charging = false;
    }

    /**
     * Provede jeden tah nepřítele během boje.
     *
     * @param player hráč, proti kterému nepřítel bojuje
     * @return textový popis akce
     */
    public String takeTurn(Player player) {

        if (charging) {
            charging = false;

            if (player.isDodging()) {
                player.setDodging(false);
                return "nelze uhnout tezkemu utoku";
            }

            int dealtDamage = damage + 1;

            if (player.isDefending()) {
                dealtDamage -= 1;
                if (player.hasShield()) {
                    dealtDamage -= player.getShield().getBlockPower();
                }
            }

            if (dealtDamage < 0) {
                dealtDamage = 0;
            }

            dealDamage(player, dealtDamage);

            return name + " provedl silný útok a způsobil "
                    + dealtDamage + " HP poškození!";
        }

        if (Math.random() < 0.3) {
            charging = true;
            return name + " se připravuje na silný útok!";
        }

        int dealtDamage = damage;

        if (player.isDefending()) {
            dealtDamage -= 1;
            if (player.hasShield()) {
                dealtDamage -= player.getShield().getBlockPower();
            }
        }

        if (dealtDamage < 0) {
            dealtDamage = 0;
        }

        if (player.isDodging()) {

            if (player.tryDodge()) {
                player.setDodging(false);
                return "vyhnul si se utoku";

            }

            player.setDodging(false);
            dealDamage(player, dealtDamage);
            return "Nepodarilo se ti uhnout " + name + " tě zasáhl za " + dealtDamage + " HP.";

        }


        dealDamage(player, dealtDamage);
        return name + " tě zasáhl za " + dealtDamage + " HP.";
    }


    /**
     * Odebere nepříteli životy.
     *
     * @param damage hodnota poškození
     */
    public void takeDamage(int damage){

        lives  -= damage;
    }

    public boolean isAlive() {
        return lives > 0;
    }

    public void dealDamage(Player plr, int amount) {

        plr.setLives(plr.getLives() - amount);
    }

    public String die() {

        return name + " byl poražen!";
    }

    @Override
    public String interact(Player player, Game game) {
        return name + " je nepřítel!";
    }
}