package com.example.demo_2340;

public class MoveDown implements MoveStrategy {
    @Override
    public void move(Player player, Tile[][] map) {
        int row = player.getRow();
        int column = player.getColumn();
        if (row < 15) {
            int newRow = row + 1;
            Tile newTile = map[newRow][column];
            if (newTile.getType() != 1) {
                player.setRow(newRow);
            }
        }
    }
}
