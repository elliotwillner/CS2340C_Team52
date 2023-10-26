package com.example.demo_2340;

import java.util.ArrayList;
import java.util.Date;
import com.example.demo_2340.R;
public class Player implements Observable{
    private String name;
    private int difficulty;
    private int chosenClass;
    private int health;
    private int score;
    private Date date;
    private static volatile Player uniqueInstance;
    //movement variables
    private MoveStrategy strategy;
    private int mapPosX;
    private int mapPosY;
    private int viewPosX;
    private int viewPosY;

    //movement methods
    public void setMoveStrategy(MoveStrategy strategy) {
        this.strategy = strategy;
    }

    public void move(Tile[][] map) {
        strategy.move(Player.getInstance(), map);
        notifyObservers();
    }
    private final ArrayList<Observer> observerList = new ArrayList<>();
    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            //observer.update(x, y) <-- fix this
        }
    }

    public ArrayList<Observer> getObserverList() {
        return observerList;
    }

    public Player(String name, int difficulty, int chosenClass) {
        this.name = name;
        this.difficulty = difficulty;
        this.chosenClass = chosenClass;
        this.score = 100;
        this.date = null;
        //movement
        this.mapPosX = 9;
        this.mapPosY = 14;
        this.viewPosX = 9;
        this.viewPosY = 14;
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
    public int getMapPosX() {
        return mapPosX;
    }

    public int getMapPosY() {
        return mapPosY;
    }

    public int getViewPosX() {
        return viewPosX;
    }

    public int getViewPosY() {
        return viewPosY;
    }

    public void setMapPosX(int x) {
        this.mapPosX = x;
    }

    public void setMapPosY(int y) {
        this.mapPosY = y;
    }

    public void setViewPosX(int x) {
        this.viewPosX = x;
    }

    public void setViewPosY(int y) {
        this.viewPosY = y;
    }
    public void setViewPos(int x, int y) {
        this.viewPosX = x;
        this.viewPosY = y;
        notifyObservers();
    }
    public void setMapPos(int x, int y) {
        this.mapPosX = x;
        this.mapPosY = y;
    }
}
