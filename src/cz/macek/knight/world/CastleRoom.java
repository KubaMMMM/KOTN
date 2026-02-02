package cz.macek.knight.world;

import cz.macek.knight.character.Player;


public class CastleRoom extends Room {

    private boolean isUnlocked;

    public CastleRoom(String description) {
        super(description);
        this.isUnlocked = false;
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
 

