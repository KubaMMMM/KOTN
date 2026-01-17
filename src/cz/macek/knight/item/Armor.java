package cz.macek.knight.item;

public class Armor extends Item {
    private int defense;

    public Armor(String name, int defense) {
        super(name, true);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }
}
