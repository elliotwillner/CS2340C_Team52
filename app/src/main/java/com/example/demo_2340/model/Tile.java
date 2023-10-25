package com.example.demo_2340.model;

public class Tile {
    private int width;
    private int height;
    private int posX;
    private int posY;
    private int type;
    public Tile(int posX, int posY, int type) {
        width = 25;
        height = 25;
        this.posX = posX;
        this.posY = posY;
        /**
         * Tile Types:
         * 0 - neutral
         * 1 - wall
         * 2 - hole
         * 3 - progress to map 2
         * 4 - progress to map 3
         * 5 - win game
         * 6 - go back to map 1
         * 7 - go back to map 2
         */
        this.type = type;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public int getType() {
        return type;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public void setType(int type) {
        this.type = type;
    }
}
