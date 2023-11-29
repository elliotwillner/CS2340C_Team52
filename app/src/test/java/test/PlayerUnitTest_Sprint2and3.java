package test;

import static org.junit.Assert.assertEquals;

import android.widget.TextView;

import com.example.demo_2340.Player;
import com.example.demo_2340.MoveLeft;
import com.example.demo_2340.MoveRight;
import com.example.demo_2340.MoveDown;
import com.example.demo_2340.MoveUp;
import com.example.demo_2340.Tile;
import com.example.demo_2340.TileMap;

import org.junit.Test;
public class PlayerUnitTest_Sprint2and3 {
    private final Player player1 = new Player();
    private final Tile[][] testMap = new TileMap().getMap(2);
    private TextView winTextView;
    @Test
    public void testPlayerMovementRight() {
        Player player1 = Player.getInstance();
        player1.setRow(3);
        player1.setColumn(3);
        player1.setMoveStrategy(new MoveRight());
        player1.move(testMap);
        assertEquals(player1.getRow(), 3);
        assertEquals(player1.getColumn(), 4);
    }
    @Test
    public void testPlayerMovementLeft() {
        Player player1 = Player.getInstance();
        player1.setRow(3);
        player1.setColumn(3);
        player1.setMoveStrategy(new MoveLeft());
        player1.move(testMap);
        assertEquals(player1.getRow(), 3);
        assertEquals(player1.getColumn(), 2);
    }
    @Test
    public void testPlayerMovementDown() {
        Player player1 = Player.getInstance();
        player1.setRow(3);
        player1.setColumn(3);
        player1.setMoveStrategy(new MoveDown());
        player1.move(testMap);
        assertEquals(player1.getRow(), 4);
        assertEquals(player1.getColumn(), 3);
    }
    @Test
    public void testPlayerMovementUp() {
        Player player1 = Player.getInstance();
        player1.setRow(3);
        player1.setColumn(3);
        player1.setMoveStrategy(new MoveUp());
        player1.move(testMap);
        assertEquals(player1.getRow(), 2);
        assertEquals(player1.getColumn(), 3);
    }
    @Test
    public void testPlayerCollisionRight() {
        Player player1 = Player.getInstance();
        player1.setRow(2);
        player1.setColumn(14);
        player1.setMoveStrategy(new MoveRight());
        player1.move(testMap);
        assertEquals(player1.getRow(), 2);
        assertEquals(player1.getColumn(), 14);
    }
    @Test
    public void testPlayerCollisionLeft() {
        Player player1 = Player.getInstance();
        player1.setRow(14);
        player1.setColumn(1);
        player1.setMoveStrategy(new MoveLeft());
        player1.move(testMap);
        assertEquals(player1.getRow(), 14);
        assertEquals(player1.getColumn(), 1);
    }
    @Test
    public void testPlayerCollisionDown() {
        Player player1 = Player.getInstance();
        player1.setRow(14);
        player1.setColumn(1);
        player1.setMoveStrategy(new MoveDown());
        player1.move(testMap);
        assertEquals(player1.getRow(), 14);
        assertEquals(player1.getColumn(), 1);
    }
    @Test
    public void testPlayerCollisionUp() {
        Player player1 = Player.getInstance();
        player1.setRow(2);
        player1.setColumn(14);
        player1.setMoveStrategy(new MoveUp());
        player1.move(testMap);
        assertEquals(player1.getRow(), 2);
        assertEquals(player1.getColumn(), 14);
    }
    private final Tile[][] testMap2 = new TileMap().getMap(1);
    @Test
    public void testTileWall() {
        Player player1 = Player.getInstance();
        player1.setRow(13);
        player1.setColumn(11);
        player1.setMoveStrategy(new MoveRight());
        player1.move(testMap2);
        assertEquals(player1.getRow(), 13);
        assertEquals(player1.getColumn(), 11);
    }
    @Test
    public void testTileHole() {
        Player player1 = Player.getInstance();
        player1.setRow(13);
        player1.setColumn(12);
        player1.setMoveStrategy(new MoveDown());
        player1.move(testMap2);
        assertEquals(player1.getRow(), 14);
        assertEquals(player1.getColumn(), 12);
    }
}
