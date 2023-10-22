package com.example.demo_2340.model;

public class MoveRightStrategy implements MovementStrategy{
    private int tileWidth;
    public MoveRightStrategy(int tileWidth) {
        this.tileWidth = tileWidth;
    }

    @Override
    public void move(Player player) {
        player.setPlayerX(player.getPlayerX() + tileWidth);
    }
}
