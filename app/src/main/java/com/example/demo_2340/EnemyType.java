package com.example.demo_2340;

public enum EnemyType {
    IMP(216, 1, 1),    // Tile ID, Width in tiles, Height in tiles
    GHOUL(476, 1, 1),
    KNIGHT(289, 1, 2),
    TROLL(300, 2, 2);

    private final int tileID;
    private final int widthInTiles;
    private final int heightInTiles;

    EnemyType(int tileID, int widthInTiles, int heightInTiles) {
        this.tileID = tileID;
        this.widthInTiles = widthInTiles;
        this.heightInTiles = heightInTiles;
    }

    public int getTileID() {
        return tileID;
    }

    public int getWidthInTiles() {
        return widthInTiles;
    }

    public int getHeightInTiles() {
        return heightInTiles;
    }
}
