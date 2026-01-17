package cz.macek.knight.character;

public class Wizard extends Ally {

    public Wizard() {
        super("Zaklínač");
    }

    @Override
    public String interact(Player player) {
        return revealWeakness(player);
    }

    public String revealWeakness(Player player) {
        // Odhalení slabiny
        return "";
    }
}