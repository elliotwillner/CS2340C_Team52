package com.example.demo_2340.model;

public class MoveUpStrategy implements MovementStrategy {
    private int tileHeight; // You need to set this to the height of a tile

    public MoveUpStrategy(int tileHeight) {
        this.tileHeight = tileHeight;
    }
    @Override
    public void move(Player player) {
        player.setPlayerY(player.getPlayerY() - tileHeight);
    }
}
