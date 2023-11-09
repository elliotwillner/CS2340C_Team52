package com.example.demo_2340;

import android.graphics.Bitmap;

public class GhoulEnemy implements Enemy {
    private Bitmap sprite;

    public GhoulEnemy(Bitmap sprite) {
        this.sprite = sprite;
    }

    @Override
    public void display() {
        // Display logic for ghoul
    }

    @Override
    public void move() {
        // Movement logic for ghoul
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