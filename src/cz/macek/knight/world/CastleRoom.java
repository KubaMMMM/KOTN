package cz.macek.knight.world;

import cz.macek.knight.character.Player;
import cz.macek.knight.item.Item;

import java.util.ArrayList;


public class CastleRoom extends Room {

    private boolean isUnlocked;

    public CastleRoom(String description) {
        super(description);
        this.isUnlocked = false;
    }

    @Override
    public ArrayList<Item> getItemsList() {
        if (this instanceof CastleRoom castle && !castle.getUnlocked()) {
            return new ArrayList<>(); // nic tam není vidět
        }
        return super.getItemsList();
    }

    public boolean canBeUnlocked(Player player) {
        return player.hasItem("Část klíče 1")
                && player.hasItem("Část klíče 2");
    }

    public void unlock() {
        this.isUnlocked = true;
    }

    public boolean getUnlocked() {
        return isUnlocked;
    }
}
 

