package com.example.demo_2340.model;

import com.example.demo_2340.Tile;

public class MoveRight {
    public void move(Player player, Tile[][] map) {
        int newPosX = player.getMapPosX() + 1;
        if (newPosX < 15) {
            int tileType = map[player.getMapPosY()][newPosX].getType();
            if (tileType != 1) {
                player.setViewPos(newPosX, player.getViewPosY());
                player.setMapPos(newPosX, player.getMapPosY());
            }
        }
    }
}
