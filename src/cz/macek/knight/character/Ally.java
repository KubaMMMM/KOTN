package cz.macek.knight.character;

public abstract class Ally extends Character {

    public Ally(String name) {
        super(name);
    }

    @Override
    public abstract String interact(Player player);

    public String giveQuest() {
        // Zadání úkolu
        return "";
    }
}
