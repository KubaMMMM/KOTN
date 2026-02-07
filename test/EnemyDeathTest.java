import cz.macek.knight.character.Enemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyDeathTest {

    @Test
    void enemyIsNotAliveAfterLosingAllLives() {
        Enemy enemy = new Enemy("Imp", 1, 1);

        enemy.takeDamage(1);

        assertFalse(enemy.isAlive());
    }
}