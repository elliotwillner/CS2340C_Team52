package com.example.demo_2340;

public class MoveUp implements MoveStrategy{
    @Override
    public void move(Player player, Tile[][] map) {
        int currentRow = player.getRow();
        int currentColumn = player.getColumn();
        if (currentRow < map.length - 1) {
            int newRowIndex = currentRow - 1;
            Tile newTile = map[newRowIndex][currentColumn];
            if (newTile.getType() != 1) {
                player.setRow(newRowIndex);
            }
        }
    }
}
