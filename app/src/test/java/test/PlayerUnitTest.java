package test;

import static org.junit.Assert.assertEquals;

import android.graphics.Bitmap;

import com.example.demo_2340.Player;
import com.example.demo_2340.Tile;
import com.example.demo_2340.TileMap;
import com.example.demo_2340.Enemy;
import com.example.demo_2340.TrollEnemy;

import org.junit.Test;

public class PlayerUnitTest {
    /*Context context = new GameScreen();
    EnemyFactory enemyFactory = new EnemyFactory(
            context, R.drawable.dungeon_tileset, 16, 16);
    Enemy troll = enemyFactory.createEnemy(EnemyType.TROLL);*/
    private final Tile[][] testMap = new TileMap().getMap(2);
    private Bitmap sprite;
    Enemy troll = new TrollEnemy(sprite);
    @Test
    public void testEnemyPosition() {
        assertEquals(troll.getRow(), 5);
        assertEquals(troll.getColumn(), 5);
    }
    @Test
    public void testEnemyMovement() {
        Player player1 = Player.getInstance();
        player1.setRow(3);
        player1.setColumn(3);
        troll.move();
        assertEquals(troll.getRow(), 4);
        assertEquals(troll.getColumn(), 4);
    }
    @Test
    public void testCollisionDamage() {
        Player player1 = Player.getInstance();
        player1.setHealth(100);
        player1.setRow(troll.getRow());
        player1.setColumn(troll.getColumn());
        troll.onCollision();
        assertEquals(player1.getHealth(), 90);
    }
    @Test
    public void testAdditionalDamage() {
        Player player1 = Player.getInstance();
        player1.setHealth(100);
        player1.setRow(troll.getRow());
        player1.setColumn(troll.getColumn());
        troll.onCollision();
        troll.onCollision();
        assertEquals(player1.getHealth(), 80);
    }
    @Test
    public void testNoCollisionDamage() {
        Player player1 = Player.getInstance();
        player1.setHealth(100);
        player1.setRow(troll.getRow() - 1);
        player1.setColumn(troll.getColumn() - 1);
        troll.onCollision();
        assertEquals(player1.getHealth(), 100);
    }
}
