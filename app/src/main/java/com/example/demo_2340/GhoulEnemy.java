package com.example.demo_2340;

import android.graphics.Bitmap;

public class GhoulEnemy implements Enemy {
    private Player player = Player.getInstance();
    private int damage = 4;
    private int row;
    private int column;
    private Bitmap sprite;
    private boolean isPendingRemoval;

    public GhoulEnemy(Bitmap sprite) {
        this.sprite = sprite;
    }
    @Override
    public void update(int x, int y) {
        if ((row == player.getRow()) && (column == player.getColumn())) {
            if (Player.getInstance().getIsAttacking()) {
                isPendingRemoval = true;
                return;
            }
            player.takeDamage(damage);
        }
    }

    @Override
    public void display() {
        // Display logic for ghoul
    }

    @Override
    public void move() {
        int rowDirection = Integer.compare(Player.getInstance().getRow(), row);
        int colDirection = Integer.compare(Player.getInstance().getColumn(), column);
        row += rowDirection * 3;
        column += colDirection * 3;
        onCollision();
    }
    public void onCollision() {
        if ((row == player.getRow()) && (column == player.getColumn())) {
            if (Player.getInstance().getIsAttacking()) {
                isPendingRemoval = true;
                return;
            }
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
        return 0;
    }

    @Override
    public int getColumn() {
        return 0;
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