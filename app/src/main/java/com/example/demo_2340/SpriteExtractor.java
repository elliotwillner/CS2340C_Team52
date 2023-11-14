package com.example.demo_2340;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SpriteExtractor {
    private Bitmap tileset;
    private int tileWidth;
    private int tileHeight;

    public SpriteExtractor(Context context, int tilesetResourceId, int tileWidth, int tileHeight) {
        this.tileset = BitmapFactory.decodeResource(context.getResources(), tilesetResourceId);
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
    }

    public Bitmap getSprite(int tileID, int widthInTiles, int heightInTiles) {
        //System.out.println("tileID: " + tileID);
        //System.out.println("Tileset Width" + tileset.getWidth());
        //System.out.println("Tileset Height" + tileset.getHeight());
        //System.out.println("X: " + ((tileID % (1024 / tileWidth)) * tileWidth));
        //System.out.println("Y: " + ((tileID / (1024 / tileHeight)) * tileHeight));

        int startX = (tileID % (1024 / tileWidth)) * tileWidth;
        int startY = (tileID / (1024 / tileWidth)) * tileHeight;

        return Bitmap.createBitmap(tileset, startX, startY,
                tileWidth * widthInTiles, tileHeight * heightInTiles);
    }
}