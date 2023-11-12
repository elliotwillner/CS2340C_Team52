package com.example.demo_2340;

import android.graphics.Bitmap;

public class GhoulEnemy implements Enemy {
    private Player player = Player.getInstance();
    final int DAMAGE = 4;
    private int row;
    private int column;
    private Bitmap sprite;

    public GhoulEnemy(Bitmap sprite) {
        this.sprite = sprite;
    }
    @Override
    public void update(int x, int y) {
        if ((row == player.getRow()) && (column == player.getColumn())) {
            player.takeDamage(DAMAGE);
        }
    }

    @Override
    public void display() {
        // Display logic for ghoul
    }

    @Override
    public void move() {
        // Movement logic for ghoul
    }
    public void onCollision() {
        if ((row == player.getRow()) && (column == player.getColumn())) {
            player.takeDamage(DAMAGE);
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