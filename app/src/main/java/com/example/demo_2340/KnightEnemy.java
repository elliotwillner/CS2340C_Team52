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
    }
    @Override
    public void update(int x, int y) {
        if ((row == player.getRow()) && (column == player.getColumn())) {
            player.takeDamage(damage);
        }
    }
    @Override
    public void display() {
        // Display logic for knight
    }

    @Override
    public void move() {
        int rowDirection = Integer.compare(Player.getInstance().getRow(), row);
        int colDirection = Integer.compare(Player.getInstance().getColumn(), column);
        row += rowDirection * 4;
        column += colDirection * 4;
        onCollision();
    }

    public void onCollision() {
        if ((row == player.getRow()) && (column == player.getColumn())) {
            player.takeDamage(damage);
        }
    }

    @Override
    public int getRow() {
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
    }

    public Bitmap getSprite() {
        return sprite;
    }
}
