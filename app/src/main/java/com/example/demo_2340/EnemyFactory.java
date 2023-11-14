package com.example.demo_2340;

import android.content.Context;
import android.graphics.Bitmap;

public class EnemyFactory {
    private SpriteExtractor spriteExtractor;

    public EnemyFactory(Context context, int tilesetResourceId, int tileWidth, int tileHeight) {
        this.spriteExtractor = new SpriteExtractor(context, tilesetResourceId,
                tileWidth, tileHeight);
    }

    public Enemy createEnemy(EnemyType enemyType) {
        Bitmap sprite = spriteExtractor.getSprite(enemyType.getTileID(),
                enemyType.getWidthInTiles(), enemyType.getHeightInTiles());

        switch (enemyType) {
        case IMP:
            return new ImpEnemy(sprite);
        case GHOUL:
            return new GhoulEnemy(sprite);
        case KNIGHT:
            return new KnightEnemy(sprite);
        case TROLL:
            return new TrollEnemy(sprite);
        default:
            throw new IllegalArgumentException("Unknown enemy type: " + enemyType);
        }
    }

    public Bitmap getSprite(EnemyType enemyType) {
        return spriteExtractor.getSprite(enemyType.getTileID(), enemyType.getWidthInTiles(),
                enemyType.getHeightInTiles());
    }
}