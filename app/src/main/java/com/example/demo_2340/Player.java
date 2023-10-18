package com.example.demo_2340;

import java.util.ArrayList;
import java.util.Date;
public class Player {
    private String name;
    private int score;
    private Date date;
    //private int playerX;
    //private int playerY;
    private volatile static Player uniqueInstance;
    private Player() {
        this.name = "";
        this.score = 0;
        this.date = null;
        //set player position
        //this.playerX =
        //this.playerY =
    }
    public static Player getInstance() {
        if (uniqueInstance == null) {
            synchronized (Player.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Player();
                }
            }
        }
        return uniqueInstance;
    }

    /**
     * player movement on 2d array example methods
     *
     * (copied and altered from dot game)
     * public void onKeyDown(int keyCode, KeyEvent event) {
     *         switch (keyCode) {
     *         ...
     *              case KeyEvent.KEYCODE_DPAD_UP:
     *                  if (checkCollision(playerX, player1 + 1)) {
     *                      playerY++;
     *                      checkTile();
     *                  }
     *         ...
     *         }
     *}
     * (check if player can move to new tile, tile type 1 is a wall and is currently the only impassable tile)
     * public boolean checkCollision(int x, int y) {
     *     return (TileMap[x][y].getType() != 1);
     * }
     * (check new tile that the player is on, tile type 0 is the only safe tile)
     * public void checkTile(int x, int y) {
     *     if (TileMap[x][y].getType() != 0) {
     *         go to end screen idk
     *     }
     * }
     */

    public static void reset() {
        uniqueInstance = null;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getDate() {
        return date.toString();
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized void setScore(int score) {
        this.score = score;
    }

    public synchronized void setDate(Date date) {
        this.date = date;
    }
}
