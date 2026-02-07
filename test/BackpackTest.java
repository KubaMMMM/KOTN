


import cz.macek.knight.item.Backpack;
import cz.macek.knight.item.Treasure;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class BackpackTest {

    @Test
    void backpackBecomesFullAfterFourItems() {
        Backpack backpack = new Backpack();

        backpack.addItem(new Treasure());
        backpack.addItem(new Treasure());
        backpack.addItem(new Treasure());
        backpack.addItem(new Treasure());

        assertTrue(backpack.isFull());
    }
}