package test;

import static org.junit.Assert.assertEquals;

import android.graphics.Bitmap;

import com.example.demo_2340.GhoulEnemy;
import com.example.demo_2340.KnightEnemy;
import com.example.demo_2340.Player;
import com.example.demo_2340.Tile;
import com.example.demo_2340.TileMap;
import com.example.demo_2340.Enemy;
import com.example.demo_2340.TrollEnemy;
import com.example.demo_2340.PowerUp;
import com.example.demo_2340.healthPotion;
import com.example.demo_2340.healthPowerUp;

import org.junit.Test;

public class PlayerUnitTest_Sprint5 {
    private final Tile[][] testMap = new TileMap().getMap(2);
    private Bitmap sprite;
    Enemy troll = new TrollEnemy(sprite);
    Player player1 = Player.getInstance();
    @Test
    public void testEnemyCollisionScore() {
        player1.setScore(100);
        player1.setRow(troll.getRow());
        player1.setColumn(troll.getColumn());
        troll.onCollision();
        assertEquals(player1.getScore(), 95);
    }
    @Test
    public void testAdditionalCollisionScore() {
        player1.setScore(100);
        player1.setRow(troll.getRow());
        player1.setColumn(troll.getColumn());
        troll.onCollision();
        troll.onCollision();
        assertEquals(player1.getScore(), 90);
    }
    @Test
    public void testEnemyDefeatScore() {
        player1.setScore(100);
        player1.enemyKilled = 0;
        player1.DefeatEnemyUpdateScore(troll);
        assertEquals(player1.getScore(), 120);
    }
    @Test
    public void testDefeatEnemyCombo() {
        Enemy ghoul = new GhoulEnemy(sprite);
        player1.setScore(100);
        player1.enemyKilled = 0;
        player1.DefeatEnemyUpdateScore(troll);
        player1.DefeatEnemyUpdateScore(ghoul);
        assertEquals(player1.getScore(), 150);
    }
    @Test
    public void testDefeatEnemyMaxCombo() {
        Enemy ghoul = new GhoulEnemy(sprite);
        Enemy knight = new KnightEnemy(sprite);
        player1.setScore(100);
        player1.enemyKilled = 0;
        player1.DefeatEnemyUpdateScore(troll);
        player1.DefeatEnemyUpdateScore(ghoul);
        player1.DefeatEnemyUpdateScore(knight);
        assertEquals(player1.getScore(), 190);
    }
    @Test
    public void testEnemyInRange() {
        player1.setRow(troll.getRow() + 5);
        player1.setColumn(troll.getColumn() + 5);
        assertEquals(player1.isInRange(troll), false);
    }
    @Test
    public void testEnemyRemoval() {
        troll.takeDamage();
        assertEquals(troll.isPendingRemoval(), true);
    }
    @Test
    public void testPotionPosition() {
        PowerUp potion = new healthPowerUp(player1);
        assertEquals(potion.getRow(), 2);
        assertEquals(potion.getColumn(), 7);
    }
    @Test
    public void testPotionCollected() {
        player1.setRow(3);
        player1.setColumn(3);
        healthPotion potion = new healthPotion(player1.getColumn(), player1.getRow(), true);
        potion.update(3, 3);
        assertEquals(potion.isCollected, true);
    }
    @Test
    public void testPotion() {
        player1.setHealth(100);
        PowerUp potion = new healthPowerUp(player1);
        player1.applyPowerUp(potion);
        assertEquals(player1.getHealth(), 150);
    }
}
