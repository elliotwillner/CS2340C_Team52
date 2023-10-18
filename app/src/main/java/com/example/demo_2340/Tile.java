package com.example.demo_2340;

public class Tile {
    private int width;
    private int height;
    private int posX;
    private int posY;
    private int type;
    public Tile(int posX, int posY, int type) {
        width = 16;
        height = 16;
        this.posX = posX;
        this.posY = posY;
        //0 - open
        //1 - wall
        //2 - death
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
