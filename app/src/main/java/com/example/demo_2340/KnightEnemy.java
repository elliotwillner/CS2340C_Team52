package com.example.demo_2340;

import android.graphics.Bitmap;

public class KnightEnemy implements Enemy {
    private Player player = Player.getInstance();
    private int damage = 12;
    private int row;
    private int column;
    private Bitmap sprite;
    private boolean isPendingRemoval;

    public KnightEnemy(Bitmap sprite) {
        this.sprite = sprite;
        this.row = 3;
        this.column = 3;
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
        if (Player.getInstance().getRow() % 2 == 0) {
            row += rowDirection * 2;
            column += colDirection * 2;
        } else {
            row += 2;
            column += 2;
        }
        onCollision();
    }

    public void onCollision() {
        if ((row == player.getRow()) && (column == player.getColumn())) {
            player.takeDamage(damage);
        }
    }

    @Override
    public void takeDamage() {
        isPendingRemoval = true;
    }

    @Override
    public boolean isPendingRemoval() {
        return isPendingRemoval;
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
