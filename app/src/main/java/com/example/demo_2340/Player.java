package com.example.demo_2340;

import java.util.ArrayList;
import java.util.Date;
public class Player implements Observable {
    private static volatile Player uniqueInstance;
    private String name;
    private int difficulty;
    private String chosenClass;
    private int health;
    private double damageMultiplier;
    private boolean isAlive = true;
    private int score;
    private Date date;
    //movement variables
    private MoveStrategy strategy;
    private int column;
    private int row;

    //set movement strategy
    public void setMoveStrategy(MoveStrategy strategy) {
        this.strategy = strategy;
    }
    //move and notify observers
    public void move(Tile[][] map) {
        strategy.move(Player.getInstance(), map);
        notifyObservers();
    }
    //observer stuff
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
            System.out.println("Notifying observer: " + observer);
            observer.update(column, row);
        }
    }

    public ArrayList<Observer> getObserverList() {
        return observerList;
    }

    public Player() {
        this.score = 100;
        this.date = null;
        this.strategy = null;
        //start position
        this.column = 7;
        this.row = 2;
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

    public int getDifficulty() {
        return difficulty;
    }
    public int getHealth() {
        return health;
    }
    public boolean getIsAlive() {
        return isAlive;
    }
    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public String getChosenClass() {
        return chosenClass;
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

    public synchronized void setDifficulty(int diff) {
        this.difficulty = diff;
    }
    public synchronized void setHealth(int health) {
        this.health = health;
    }
    public synchronized void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    public synchronized void setDamageMultiplier(double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public synchronized void setChosenClass(String chosenClass) {
        this.chosenClass = chosenClass;
    }

    public synchronized void setScore(int score) {
        this.score = score;
    }

    public synchronized void setDate(Date date) {
        this.date = date;
    }

    //movement getters/setters
    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setColumn(int x) {
        this.column = x;
    }

    public void setRow(int y) {
        this.row = y;
    }

    public boolean hasGameObserver(GameScreen gameScreen) {
        for (Observer observer : observerList) {
            if (observer.equals(gameScreen)) {
                return true;
            }
        }
        return false;
    }

    public void takeDamage(int damage) {
        health -= damage; //* damageMultiplier;
        GameScreen.updateHealth();
        if (health <= 0) {
            isAlive = false;
        }
    }
}
