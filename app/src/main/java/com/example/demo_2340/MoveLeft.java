package com.example.demo_2340;

public class MoveLeft implements MoveStrategy {
    @Override
    public void move(Player player, Tile[][] map) {
        int row = player.getRow();
        int column = player.getColumn();
        if (column > 0) {
            int newColumn = column - 1;
            Tile newTile = map[row][newColumn];
            if (newTile.getType() != 1) {
                player.setColumn(newColumn);
            }
        }
    }
}
