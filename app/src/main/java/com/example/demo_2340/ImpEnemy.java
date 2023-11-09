package com.example.demo_2340;

import android.graphics.Bitmap;

public class ImpEnemy implements Enemy{
    private Bitmap sprite;

    public ImpEnemy(Bitmap sprite) {
        this.sprite = sprite;
    }

    @Override
    public void display() {
        // Display logic for imp
    }

    @Override
    public void move() {
        // Movement logic for imp
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
