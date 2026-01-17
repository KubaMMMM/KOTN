package cz.macek.knight.character;

public class Blacksmith extends Ally {

    public Blacksmith() {
        super("Kovář");
    }

    @Override
    public String interact(Player player) {
        return craftArmor(player);
    }

    public String craftArmor(Player player) {
        // Výroba zbroje
        return "";
    }
}