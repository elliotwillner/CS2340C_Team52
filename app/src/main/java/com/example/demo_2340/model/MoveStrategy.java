package com.example.demo_2340.model;

import com.example.demo_2340.Tile;

public interface MoveStrategy {
    void move(Player player, Tile[][] map);
}
