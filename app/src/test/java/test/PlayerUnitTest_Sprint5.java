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
}
