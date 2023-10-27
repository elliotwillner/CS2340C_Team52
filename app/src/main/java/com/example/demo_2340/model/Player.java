package com.example.demo_2340.model;

import java.util.ArrayList;
import java.util.Date;
import com.example.demo_2340.R;
public class Player {
    private String name;
    private int difficulty;
    private int chosenClass;
    private int health;
    private int score;
    private Date date;
    private static volatile Player uniqueInstance;
    private int mapPosX;
    private int mapPosY;
    private int viewPosX;
    private int viewPosY;

    public Player(String name, int difficulty, int chosenClass) {
        this.name = name;
        this.difficulty = difficulty;
        this.chosenClass = chosenClass;
        this.score = 100;
        this.date = null;
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
    //movement getters/setters
    public int getMapPosY() {
        return mapPosY;
    }

    public int getMapPosX() {
        return mapPosX;
    }

    public int getViewPosX() {
        return viewPosX;
    }
    public int getViewPosY() {
        return viewPosY;
    }

    public void setViewPos(int x, int y) {
        this.viewPosX = x;
        this.viewPosY = y;
        notifyObservers();
    }

    private final ArrayList<Observer> observerList = new ArrayList<>();
    public void notifyObservers() {
        for (Observer observers : observerList) {
            //observers.update(x, y);
        }
    }

    public ArrayList<Observer> getObserverList() {
        return observerList;
    }

    public void setMapPos(int x, int y) {
        this.mapPosX = x;
        this.mapPosY = y;
    }
}
