package com.example.demo_2340;

import android.graphics.Bitmap;

public class KnightEnemy implements Enemy {
    private Bitmap sprite;

    public KnightEnemy(Bitmap sprite) {
        this.sprite = sprite;
    }

    @Override
    public void display() {
        // Display logic for knight
    }

    @Override
    public void move() {
        // Movement logic for knight
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
