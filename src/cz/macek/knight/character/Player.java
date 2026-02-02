package cz.macek.knight.character;

import cz.macek.knight.item.Backpack;
import cz.macek.knight.item.Armor;
import cz.macek.knight.item.Weapon;
import cz.macek.knight.item.Shield;
import cz.macek.knight.main.Game;
import cz.macek.knight.world.Room;

import java.util.Random;


public class Player extends Character {
    private Room position;
    private Backpack backpack;
    private Armor armor;
    private Weapon weapon;
    private Shield shield;
    private boolean hasFireResistance;
    private boolean knowsWeakness;
    private boolean isDefending;
    private int loosingHP;
    private boolean isDodging = false;

    public Player(String name) {
        super(name);
        this.lives = 3;
        this.backpack = new Backpack();
        this.loosingHP = 0;
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


    public int attack(Enemy e) {

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

    public void applyLoosingHP() {

        if (loosingHP > 0) {
            lives -= loosingHP;
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

    public void setLoosingHP(int value) {
        this.loosingHP = value;
    }

    public int getLoosingHP() {
        return loosingHP;
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