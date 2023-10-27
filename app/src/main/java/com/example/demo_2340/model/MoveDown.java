package com.example.demo_2340.model;

import com.example.demo_2340.Tile;

public class MoveDown {
    public void move(Player player, Tile[][] map) {
        int newPosY = player.getMapPosY() + 1;
        if (newPosY < 15) {
            int tileType = map[newPosY][player.getMapPosX()].getType();
            if (tileType != 1) {
                player.setViewPos(player.getViewPosX(), newPosY);
                player.setMapPos(player.getMapPosX(), newPosY);
            }
        }
    }
}
