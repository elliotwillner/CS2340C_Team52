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
        // Movement logic for imp
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
