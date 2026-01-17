package cz.macek.knight.character;

public class Witch extends Ally {

    public Witch() {
        super("Ježibaba");
    }

    @Override
    public String interact(Player player) {
        return brewPotion(player);
    }

    public String brewPotion(Player player) {
        // Vaření lektvaru
        return "";
    }
}
