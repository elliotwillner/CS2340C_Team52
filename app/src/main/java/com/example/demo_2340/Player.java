package com.example.demo_2340;

import java.util.ArrayList;

public class Player {
    private String name;
    private int score;
    private volatile static Player uniqueInstance;
    private Player() {
        this.name = "";
        this.score = 0;
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

    public static void reset() {
        uniqueInstance = null;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized void setScore(int score) {
        this.score = score;
    }
}
