

import cz.macek.knight.item.KeyPart;
import cz.macek.knight.main.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnlockCastleTest {

    @Test
    void castleUnlockConsumesKeys() {
        Game game = new Game();
        game.start();

        game.getCurrentPlayer().getBackpack().addItem(new KeyPart(1));
        game.getCurrentPlayer().getBackpack().addItem(new KeyPart(2));

        game.setCurrentRoom(game.getRooms().get("castle"));

        game.odemkni();

        assertFalse(game.getCurrentPlayer().hasItem("Část klíče 1"));
        assertFalse(game.getCurrentPlayer().hasItem("Část klíče 2"));
    }
}