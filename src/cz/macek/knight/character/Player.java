package cz.macek.knight.character;

import cz.macek.knight.item.Backpack;
import cz.macek.knight.item.Armor;
import cz.macek.knight.item.Weapon;
import cz.macek.knight.item.Shield;
import cz.macek.knight.main.Game;
import cz.macek.knight.world.Room;


/**
 * Reprezentuje hráče ve hře.
 *
 * Hráč má inventář, výstroj, životy a stavové efekty
 * (obrana, uhýbání, hoření, znalost slabiny draka).
 */
public class Player extends Character {
    private Room position;
    private Backpack backpack;
    private Armor armor;
    private Weapon weapon;
    private Shield shield;
    private boolean hasFireResistance;
    private boolean knowsWeakness;
    private boolean isDefending;
    private int losingHP;
    private boolean isDodging = false;

    public Player(String name) {
        super(name);
        this.lives = 3;
        this.backpack = new Backpack();
        this.losingHP = 0;
        this.isDefending = false;
    }

    public Room getPosition() {
        return position;
    }

    public void setPosition(Room position) {
        this.position = position;
    }

    public int getLives() {
        return lives;
    }




    public boolean tryDodge() {
        return Math.random() < 0.25; // 25 %
    }


    /**
     * Spočítá poškození způsobené hráčem nepříteli.
     *
     * Metoda pouze vypočítá hodnotu poškození,
     * samotné odečtení životů provádí třída Game.
     *
     * @param e nepřítel, na kterého hráč útočí
     * @return hodnota poškození
     */
    public int attackDamage(Enemy e) {

        int damage = 1; // základní útok

        if (weapon != null) {
            damage += weapon.getDamage();
        }

        if (e instanceof Dragon && knowsWeakness) {
            damage += 1;
        }

        return damage;
    }






    public void loseLife() {
        lives--;
    }

    /**
     * Aplikuje průběžné poškození (např. hoření).
     * Volá se po každém tahu nepřítele.
     */
    public void applyLoosingHP() {

        if (losingHP > 0) {
            lives -= losingHP;
        }

        if (lives < 0) {
            lives = 0;
        }

    }

    public Backpack getBackpack() {
        return backpack;
    }

    public boolean hasShield() {
        return shield != null;
    }

    public boolean hasItem(String itemName){

        return backpack.hasItem(itemName);
    }



    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Shield getShield() {
        return shield;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public boolean isHasFireResistance() {
        return hasFireResistance;
    }

    public void setHasFireResistance(boolean hasFireResistance) {
        this.hasFireResistance = hasFireResistance;
    }

    public boolean isKnowsWeakness() {
        return knowsWeakness;
    }

    public void setDefending(boolean defending) {
        this.isDefending = defending;
    }

    public boolean isDefending() {
        return isDefending;
    }

    public void setFireResistance(boolean value) {
        this.hasFireResistance = value;
    }

    public boolean hasFireResistance() {
        return hasFireResistance;
    }

    public void setKnowsWeakness(boolean value) {
        this.knowsWeakness = value;
    }

    public boolean knowsWeakness() {
        return knowsWeakness;
    }

    public void setLosingHP(int value) {
        this.losingHP = value;
    }

    public int getLosingHP() {
        return losingHP;
    }

    @Override
    public String interact(Player player, Game game) {
        return "To jsem já!";
    }

    public boolean isDodging() {
        return isDodging;
    }

    public void setDodging(boolean dodging) {
        isDodging = dodging;
    }
}