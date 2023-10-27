package com.example.demo_2340;

import java.util.ArrayList;
import java.util.Date;
import com.example.demo_2340.R;
public class Player implements Observable{
    private static volatile Player uniqueInstance;
    private String name;
    private int difficulty;
    private String chosenClass;
    private int health;
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
            observer.update(column, row);
        }
    }

    public ArrayList<Observer> getObserverList() {
        return observerList;
    }

    public Player() {
        this.name = "";
        this.difficulty = 1;
        this.chosenClass = "";
        this.health = 150;
        this.score = 100;
        this.date = null;
        this.strategy = null;
        //start position
        this.column = 9;
        this.row = 14;
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
}
