
import cz.macek.knight.item.Shield;
import cz.macek.knight.world.CastleRoom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CastleRoomTest {

    @Test
    void lockedCastleDoesNotExposeItems() {
        CastleRoom castle = new CastleRoom("Hrad");
        castle.addItem(new Shield("stit", 1));

        assertTrue(castle.getItemsList().isEmpty());
    }

    @Test
    void unlockedCastleExposesItems() {
        CastleRoom castle = new CastleRoom("Hrad");
        castle.addItem(new Shield("stit", 1));
        castle.unlock();

        assertEquals(1, castle.getItemsList().size());
    }
}