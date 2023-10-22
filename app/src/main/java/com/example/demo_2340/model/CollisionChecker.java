package com.example.demo_2340.model;

public class CollisionChecker {
    public boolean checkCollision(int x, int y, Tile[][] map) {
        int mapWidth = map.length;
        int mapHeight = map[0].length;

        if (x < 0 || x >= mapWidth || y < 0 || y >= mapHeight) {
            return true;
        }

        return map[x][y].getType() != 1;
    }

    public void checkTile(int x, int y, Tile[][] map, Player player) {
        int tileType = map[x][y].getType();

        switch (tileType) {
            case 0:
                // Neutral tile
                break;
            case 1:
                // Handle wall collision (specific for loss)
                break;
            case 2:
                player.setMap(1);
                break;
            case 3:
                // Progress to map 2
                player.setMap(2);
                player.setPlayerY(14);
                break;
            case 4:
                // Progress to map 3
                player.setMap(3);
                player.setPlayerY(14);
                break;
            case 5:
                // Handle win condition
                break;
            case 6:
                // Go back to map 1
                player.setMap(1);
                player.setPlayerY(3);
                break;
            case 7:
                // Go back to map 2
                player.setMap(2);
                player.setPlayerY(3);
                break;
            default:
                // Default
                break;
        }
    }

}