package cz.macek.knight.item;

public class Weapon extends Item {
    private int damage;

    public Weapon(String name, int damage) {
        super(name, true);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}