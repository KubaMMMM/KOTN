

import cz.macek.knight.character.Enemy;
import cz.macek.knight.character.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombatTest {

    @Test
    void attackReducesEnemyLives() {
        Player player = new Player("Test");
        Enemy enemy = new Enemy("Imp", 2, 1);

        int dmg = player.attackDamage(enemy);
        enemy.takeDamage(dmg);

        assertEquals(1, enemy.getLives());
    }
}