package com.example.demo_2340;

import android.graphics.Bitmap;

public class TrollEnemy implements Enemy {
    private Player player = Player.getInstance();
    private int damage = 10;
    private int row;
    private int column;
    private Bitmap sprite;

    public TrollEnemy(Bitmap sprite) {
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
        // Display logic for troll
    }

    @Override
    public void move() {
        // Calculate the direction towards the player
        int rowDirection = Integer.compare(Player.getInstance().getRow(), row);
        int colDirection = Integer.compare(Player.getInstance().getColumn(), column);

        // Adjust the movement based on the direction
        row += rowDirection;
        column += colDirection;
        onCollision();
    }

    public void onCollision() {
        if ((row == player.getRow()) && (column == player.getColumn())) {
            player.takeDamage(damage);
        }
    }

    public Bitmap getSprite() {
        return sprite;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}