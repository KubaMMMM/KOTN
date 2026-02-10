
import cz.macek.knight.character.Player;
import cz.macek.knight.item.Potion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PotionUseTest {

    @Test
    void usingPotionGivesFireResistance() {
        Player player = new Player("Test");
        Potion potion = new Potion("Lektvar odolnosti proti ohni");

        potion.use(player);

        assertEquals(true, player.hasFireResistance());
    }
}