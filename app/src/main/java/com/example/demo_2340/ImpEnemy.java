package com.example.demo_2340;

import android.graphics.Bitmap;

public class ImpEnemy implements Enemy {
    private Player player = Player.getInstance();
    private int damage = 2;
    private int row;
    private int column;
    private Bitmap sprite;

    public ImpEnemy(Bitmap sprite) {
        this.sprite = sprite;
        this.row = 5;
        this.column = 5;
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
        int rowDirection = Integer.compare(Player.getInstance().getRow(), row);
        int colDirection = Integer.compare(Player.getInstance().getColumn(), column);
        row += rowDirection * 2;
        column += colDirection * 2;
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
}
