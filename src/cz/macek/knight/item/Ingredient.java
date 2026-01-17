package cz.macek.knight.item;

public class Ingredient extends Item {
    private String type;

    public Ingredient(String name, String type) {
        super(name, true);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
