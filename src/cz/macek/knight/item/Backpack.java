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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }



    public void addItem(Item item) {
        if (isFull()) return;
        items.add(item);
    }

    public Item getItem(String name) {

        for(Item i : items){

            if(i.getName().equals(name)){

                return i;
            }
        }
        return null;
    }

    public void removeItem(Item i){
        items.remove(i);
    }

    /**
     * Zjistí, zda batoh obsahuje předmět se zadaným názvem.
     *
     * @param name název hledaného předmětu
     * @return true pokud se předmět nachází v batohu
     */
    public boolean hasItem(String name) {

        for(Item i : items){

            if(i.getName().equals(name)){

                return true;
            }
        }


        return false;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < items.size(); i++) {

            if (i == items.size() - 1) {
                sb.append(items.get(i) + " ");
            } else {
                sb.append(items.get(i) + ", ");
            }

        }

        return sb.toString();
    }
    public boolean isFull() {
        return items.size() >= size;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}