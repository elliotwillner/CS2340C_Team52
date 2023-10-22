package com.example.demo_2340.model;

public class MoveLeftStrategy implements MovementStrategy {

    private int tileWidth;
    public MoveLeftStrategy(int tileWidth) {
        this.tileWidth = tileWidth;
    }
    @Override
    public void move(Player player) {
        player.setPlayerX(player.getPlayerX() - tileWidth);
    }
}
