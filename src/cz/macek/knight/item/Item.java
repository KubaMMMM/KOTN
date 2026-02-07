package cz.macek.knight.item;

public abstract class Item {
    protected String name;


    public Item(String name) {
        this.name = name;

    }


    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

}