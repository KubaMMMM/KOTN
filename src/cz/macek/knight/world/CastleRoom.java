package cz.macek.knight.world;

import cz.macek.knight.character.Player;


public class CastleRoom extends Room{
    private boolean isUnlocked;

    public CastleRoom(String description) {
        super(description);
        this.isUnlocked = false;
    }

    public boolean canBeUnlocked(Player player) {
        // Kontrola jestli má klíče
        return false;
    }

    public void unlock() {
        // Odemknutí
    }

    public boolean getUnlocked() {
        return isUnlocked;
    }
}
