package cz.macek.knight.item;

import java.util.ArrayList;

/**
 * Batoh hráče - inventář
 */
public class Backpack {
    private int size;
    private ArrayList<Item> items;

    public Backpack() {
        this.size = 4; // Kapacita 4 předměty
        this.items = new ArrayList<>();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(Item item) {
        // Přidání předmětu
    }

    public void removeItem(Item item) {
        // Odebrání předmětu
    }

    public Item getItem(String name) {
        // Získání předmětu podle jména
        return null;
    }

    public boolean hasItem(String name) {
        // Kontrola jestli má předmět
        return false;
    }

    public boolean isFull() {
        return items.size() >= size;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}