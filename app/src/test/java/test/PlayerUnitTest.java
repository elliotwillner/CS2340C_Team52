package test;

import static org.junit.Assert.assertEquals;

import com.example.demo_2340.R;
import com.example.demo_2340.model.Player;

import org.junit.Test;
public class PlayerUnitTest {

    Player p1 = new Player("Jin", 1, 2);
    Player p2 = new Player("Julia", 1, 3);
    Player p3 = new Player("Elliot", 2, 3);
    Player p4 = new Player("Tyler", 2, 1);
    Player p5 = new Player("Sarah", 3, 1);
    @Test
    public void testName() {
        p1.setName("Jie");
        assertEquals(p1.getName(), "Jie");
        p2.setName("Julie");
        assertEquals(p2.getName(), "Julie");
        p3.setName("Ellie");
        assertEquals(p3.getName(), "Ellie");
        p4.setName("Tylie");
        assertEquals(p4.getName(), "Tylie");
        p5.setName("Sarie");
        assertEquals(p5.getName(), "Sarie");
    }
    @Test
    public void testDifficulty() {
        assertEquals(p1.getDifficulty(), 1);
        assertEquals(p2.getDifficulty(), 1);
        assertEquals(p3.getDifficulty(), 2);
        assertEquals(p4.getDifficulty(), 2);
        assertEquals(p5.getDifficulty(), 3);
    }
    @Test
    public void testPlayerHealth() {
        assertEquals(p1.getHealth(), 100);
        assertEquals(p2.getHealth(), 100);
        assertEquals(p3.getHealth(), 75);
        assertEquals(p4.getHealth(), 75);
        assertEquals(p5.getHealth(), 50);
    }
    @Test
    public void testScore() {
        assertEquals(p1.getScore(), 100);
        assertEquals(p2.getScore(), 100);
        assertEquals(p3.getScore(), 100);
        assertEquals(p4.getScore(), 100);
        assertEquals(p5.getScore(), 100);
    }

}
