package cz.macek.knight.character;

import cz.macek.knight.item.Backpack;
import cz.macek.knight.item.Armor;
import cz.macek.knight.item.Weapon;
import cz.macek.knight.item.Shield;


public class Player extends Character {
    private Backpack backpack;
    private Armor armor;
    private Weapon weapon;
    private Shield shield;
    private boolean hasFireResistance;
    private boolean knowsWeakness;
    private boolean isDefending;
    private int loosingHP;

    public Player(String name) {
        super(name);
        this.lives = 3;
        this.backpack = new Backpack();
        this.loosingHP = 0;
        this.isDefending = false;
    }



    public int getLives() {
        return lives;
    }

    public void damage(int amount){
        lives -= amount;
    }

    public void loseLife() {
        lives--;
    }

    public void applyLoosingHP() {
        // Aplikování postupného poškození (hoření)
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
    public String interact(Player player) {
        return "To jsem já!";
    }
}