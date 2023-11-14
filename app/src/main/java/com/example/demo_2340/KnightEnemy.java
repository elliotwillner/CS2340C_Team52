package com.example.demo_2340;

import android.graphics.Bitmap;

public class KnightEnemy implements Enemy {
    private Player player = Player.getInstance();
    private int damage = 12;
    private int row;
    private int column;
    private Bitmap sprite;

    public KnightEnemy(Bitmap sprite) {
        this.sprite = sprite;
        this.row = 9;
        this.column = 9;
    }
    @Override
    public void update(int x, int y) {
        if ((row == player.getRow()) && (column == player.getColumn())) {
            player.takeDamage(damage);
        }
    }

    @Override
    public void display() {
        // Display logic for imp
    }

    @Override
    public void move() {
        row += Player.getInstance().getRow() + 1;
        column += Player.getInstance().getColumn() + 1;
        onCollision();
    }
    public void onCollision() {
        if ((row == player.getRow()) && (column == player.getColumn())) {
            player.takeDamage(damage);
        }
    }
    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    public Bitmap getSprite() {
        return sprite;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int difficulty) {
        if (player.getDifficulty() == 1) {
            this.damage = damage * 2;
        } else if (player.getDifficulty() == 2) {
            this.damage = damage * 3;
        } else {
            this.damage = 100;
        }
    }
}
