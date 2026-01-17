package cz.macek.knight.item;

public abstract class Item {
    protected String name;
    protected boolean takeable;

    public Item(String name, boolean takeable) {
        this.name = name;
        this.takeable = takeable;
    }

    public String getName() {
        return name;
    }

    public boolean isTakeable() {
        return takeable;
    }
}