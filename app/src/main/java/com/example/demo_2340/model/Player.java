package com.example.demo_2340.model;

import android.view.KeyEvent;
import android.widget.ImageView;

import com.example.demo_2340.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Player implements  SpriteSubject {
    private String name;
    private int difficulty;
    private int chosenClass;
    private int health;
    private int score;
    private int mapOffsetX = 0;
    private int mapOffsetY = 550;
    private Date date;
    private int playerX;
    private int playerY;
    private TileMap tileMap = new TileMap();
    private Tile[][] map;
    private List<SpriteObserver> observers = new ArrayList<>();
    
    private static volatile Player uniqueInstance;
    private MovementStrategy movementStrategy;

    public Player(String name, int difficulty, int chosenClass) {
        this.name = name;
        this.difficulty = difficulty;
        this.chosenClass = chosenClass;
        this.score = 100;
        this.date = null;
        this.playerX = 37;
        this.playerY = 625;
        this.setMap(1);
        System.out.println("playerX = " + playerX);
        System.out.println("playerY = " + playerY);
    }
    public static Player getInstance() {
        if (uniqueInstance == null) {
            synchronized (Player.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Player("test", 1, 1);
                }
            }
        }
        return uniqueInstance;
    }

    public void onKeyDown(int keyCode, KeyEvent keyEvent) {
        CollisionChecker collisionChecker = new CollisionChecker();
        int tileHeight = map[0][0].getHeight();
        int tileWidth = map[0][0].getWidth();

        int newPlayerX = playerX;
        int newPlayerY = playerY;


        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                newPlayerY = playerY - tileHeight;
                System.out.println("UP");
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                newPlayerX = playerX - tileWidth;
                System.out.println("LEFT");
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                newPlayerY = playerY + tileHeight;
                System.out.println("DOWN");
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                newPlayerX = playerX + tileWidth;
                System.out.println("RIGHT");
                break;
        }
        System.out.println("relative X on map: " + (newPlayerX - mapOffsetX));
        System.out.println("relative Y on map: " + (newPlayerY - mapOffsetY));
        Player player = Player.getInstance();
        if (!collisionChecker.checkCollision((newPlayerX - mapOffsetX) / tileWidth, (newPlayerY - mapOffsetY) /tileHeight, map)) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_DPAD_UP:
                    player.setMovementStrategy(new MoveUpStrategy(tileHeight));
                    break;
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    player.setMovementStrategy(new MoveLeftStrategy(tileWidth));
                    break;
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    player.setMovementStrategy(new MoveDownStrategy(tileHeight));
                    break;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    player.setMovementStrategy(new MoveRightStrategy(tileWidth));
                    break;
                default:
                    player.setMovementStrategy(new IdleStrategy());
                    break;
            }
        } else {
            player.setMovementStrategy(new IdleStrategy());
        }
        System.out.println("x: " + Player.getInstance().getPlayerX());
        System.out.println("y: " + Player.getInstance().getPlayerY());
        notifySubscribers();
        player.move(player);
    }


    public String stringDifficulty() {
        if (difficulty == 1) {
            return "Difficulty: Easy";
        } else if (difficulty == 2) {
            return "Difficulty: Medium";
        } else {
            return "Difficulty: Hard";
        }
    }

    public int getChosenCharacter() {
        if  (this.chosenClass == 1) {
            return R.drawable.mage_image;
        } else if (this.chosenClass == 2) {
            return R.drawable.rogue_image;
        } else {
            return R.drawable.warrior_image;
        }
    }

    public int getHealth() {
        if (this.difficulty == 1) {
            health = 100;
        } else if (this.difficulty == 2) {
            health = 75;
        } else {
            health = 50;
        }
        return health;
    }

    public static void reset() {
        uniqueInstance = null;
    }

    public String getName() {
        return name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getScore() {
        return score;
    }

    public String getDate() {
        return date.toString();
    }
    public Tile[][] getMap() {
        return map;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public void setDifficulty(int diff) {
        this.difficulty = diff;
    }

    public synchronized void setScore(int score) {
        this.score = score;
    }

    public synchronized void setDate(Date date) {
        this.date = date;
    }
    public int getPlayerX() {
        return playerX;
    }
    public int getPlayerY() {
        return playerY;
    }
    public void setPlayerX(int x) {
        playerX = x;
    }
    public void setPlayerY(int y) {
        playerY = y;
    }
    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public void move(Player player) {
        if (movementStrategy != null) {
            movementStrategy.move(player);
        }
    }

    public void setMap(int mapNumber) {
        switch (mapNumber) {
            case 1:
                map = tileMap.getMap1();
                break;
            case 2:
                map = tileMap.getMap2();
                break;
            case 3:
                map = tileMap.getMap3();
                break;
        }
    }

    public void setMapOffset(int x, int y) {
        mapOffsetX = x;
        mapOffsetY = y;
    }

    @Override
    public void subscribe(SpriteObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(SpriteObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for (SpriteObserver observer : observers) {
            observer.update();
        }
    }
}
