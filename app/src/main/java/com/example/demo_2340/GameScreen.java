package com.example.demo_2340;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.os.Handler;
import android.widget.Space;

import com.example.demo_2340.Player;

import java.util.Calendar;
public class GameScreen extends AppCompatActivity implements Observer {
    private ImageView mapImageView;
    private TextView nameTextView;
    private TextView healthTextView;
    private ImageView spriteImageView;
    private TextView difficultyTextView;
    private TextView playerScoreTextView;
    private Player player = Player.getInstance();
    private static int playerScore;
    private GridLayout grid;
    private int currMap;

    Tile[][] map = new Tile[][] {
        //row1
        {new Tile(1, 1, 1), new Tile(2, 1, 1), new Tile(3, 1, 1), new Tile(4, 1, 1),
                new Tile(5, 1, 1), new Tile(6, 1, 1), new Tile(7, 1, 1), new Tile(8, 1, 1),
                new Tile(9, 1, 1), new Tile(10, 1, 1), new Tile(11, 1, 1), new Tile(12, 1, 1),
                new Tile(13, 1, 1), new Tile(14, 1, 1), new Tile(15, 1, 1), new Tile(16, 1, 1)},
        //row2
        {new Tile(1, 2, 1), new Tile(2, 2, 1), new Tile(3, 2, 1), new Tile(4, 2, 1),
                new Tile(5, 2, 1), new Tile(6, 2, 1), new Tile(7, 2, 1), new Tile(8, 2, 3),
                new Tile(9, 2, 3), new Tile(10, 2, 1), new Tile(11, 2, 1), new Tile(12, 2, 1),
                new Tile(13, 2, 1), new Tile(14, 2, 1), new Tile(15, 2, 1), new Tile(16, 2, 1)},
        //row3
        {new Tile(1, 3, 1), new Tile(2, 3, 0), new Tile(3, 3, 1), new Tile(4, 3, 0),
                new Tile(5, 3, 1), new Tile(6, 3, 0), new Tile(7, 3, 0), new Tile(8, 3, 0),
                new Tile(9, 3, 0), new Tile(10, 3, 0), new Tile(11, 3, 0), new Tile(12, 3, 1),
                new Tile(13, 3, 0), new Tile(14, 3, 1), new Tile(15, 3, 0), new Tile(16, 3, 1)},
        //row4
        {new Tile(1, 4, 1), new Tile(2, 4, 0), new Tile(3, 4, 0), new Tile(4, 4, 0),
                new Tile(5, 4, 0), new Tile(6, 4, 0), new Tile(7, 4, 0), new Tile(8, 4, 0),
                new Tile(9, 4, 2), new Tile(10, 4, 0), new Tile(11, 4, 0), new Tile(12, 4, 0),
                new Tile(13, 4, 0), new Tile(14, 4, 0), new Tile(15, 4, 0), new Tile(16, 4, 1)},
        //row5
        {new Tile(1, 5, 1), new Tile(2, 5, 0), new Tile(3, 5, 0), new Tile(4, 5, 0),
                new Tile(5, 5, 0), new Tile(6, 5, 0), new Tile(7, 5, 0), new Tile(8, 5, 0),
                new Tile(9, 5, 0), new Tile(10, 5, 0), new Tile(11, 5, 0), new Tile(12, 5, 0),
                new Tile(13, 5, 1), new Tile(14, 5, 2), new Tile(15, 5, 0), new Tile(16, 5, 1)},
        //row6
        {new Tile(1, 6, 1), new Tile(2, 6, 0), new Tile(3, 6, 0), new Tile(4, 6, 1),
                new Tile(5, 6, 0), new Tile(6, 6, 0), new Tile(7, 6, 0), new Tile(8, 6, 0),
                new Tile(9, 6, 0), new Tile(10, 6, 0), new Tile(11, 6, 0), new Tile(12, 6, 0),
                new Tile(13, 6, 1), new Tile(14, 6, 0), new Tile(15, 6, 0), new Tile(16, 6, 1)},
        //row7
        {new Tile(1, 7, 1), new Tile(2, 7, 0), new Tile(3, 7, 0), new Tile(4, 7, 1),
                new Tile(5, 7, 0), new Tile(6, 7, 0), new Tile(7, 7, 0), new Tile(8, 7, 2),
                new Tile(9, 7, 0), new Tile(10, 7, 0), new Tile(11, 7, 0), new Tile(12, 7, 0),
                new Tile(13, 7, 1), new Tile(14, 7, 0), new Tile(15, 7, 0), new Tile(16, 7, 1)},
        //row8
        {new Tile(1, 8, 1), new Tile(2, 8, 0), new Tile(3, 8, 0), new Tile(4, 8, 0),
                new Tile(5, 8, 0), new Tile(6, 8, 0), new Tile(7, 8, 0), new Tile(8, 8, 0),
                new Tile(9, 8, 0), new Tile(10, 8, 0), new Tile(11, 8, 0), new Tile(12, 8, 0),
                new Tile(13, 8, 0), new Tile(14, 8, 0), new Tile(15, 8, 0), new Tile(16, 8, 1)},
        //row9
        {new Tile(1, 9, 1), new Tile(2, 9, 0), new Tile(3, 9, 0), new Tile(4, 9, 0),
                new Tile(5, 9, 1), new Tile(6, 9, 0), new Tile(7, 9, 0), new Tile(8, 9, 0),
                new Tile(9, 9, 0), new Tile(10, 9, 0), new Tile(11, 9, 2), new Tile(12, 9, 1),
                new Tile(13, 9, 0), new Tile(14, 9, 0), new Tile(15, 9, 0), new Tile(16, 9, 1)},
        //row10
        {new Tile(1, 10, 1), new Tile(2, 10, 0), new Tile(3, 10, 0), new Tile(4, 10, 0),
                new Tile(5, 10, 0), new Tile(6, 10, 0), new Tile(7, 10, 0), new Tile(8, 10, 0),
                new Tile(9, 10, 0), new Tile(10, 10, 0), new Tile(11, 10, 0), new Tile(12, 10, 1),
                new Tile(13, 10, 0), new Tile(14, 10, 0), new Tile(15, 10, 0), new Tile(16, 10, 1)},
        //row11
        {new Tile(1, 11, 1), new Tile(2, 11, 0), new Tile(3, 11, 0), new Tile(4, 11, 0),
                new Tile(5, 11, 1), new Tile(6, 11, 2), new Tile(7, 11, 0), new Tile(8, 11, 0),
                new Tile(9, 11, 0), new Tile(10, 11, 0), new Tile(11, 11, 0), new Tile(12, 11, 1),
                new Tile(13, 11, 0), new Tile(14, 11, 0), new Tile(15, 11, 0), new Tile(16, 11, 1)},
        //row12
        {new Tile(1, 12, 1), new Tile(2, 12, 0), new Tile(3, 12, 2), new Tile(4, 12, 0),
                new Tile(5, 12, 0), new Tile(6, 12, 0), new Tile(7, 12, 0), new Tile(8, 12, 0),
                new Tile(9, 12, 0), new Tile(10, 12, 0), new Tile(11, 12, 0), new Tile(12, 12, 0),
                new Tile(13, 12, 0), new Tile(14, 12, 0), new Tile(15, 12, 0), new Tile(16, 12, 1)},
        //row13
        {new Tile(1, 13, 1), new Tile(2, 13, 0), new Tile(3, 13, 0), new Tile(4, 13, 1),
                new Tile(5, 13, 0), new Tile(6, 13, 0), new Tile(7, 13, 0), new Tile(8, 13, 0),
                new Tile(9, 13, 0), new Tile(10, 13, 0), new Tile(11, 13, 0), new Tile(12, 13, 0),
                new Tile(13, 13, 1), new Tile(14, 13, 0), new Tile(15, 13, 0), new Tile(16, 13, 1)},
        //row14
        {new Tile(1, 14, 1), new Tile(2, 14, 0), new Tile(3, 14, 0), new Tile(4, 14, 1),
                new Tile(5, 14, 0), new Tile(6, 14, 0), new Tile(7, 14, 0), new Tile(8, 14, 0),
                new Tile(9, 14, 0), new Tile(10, 14, 0), new Tile(11, 14, 0), new Tile(12, 14, 0),
                new Tile(13, 14, 1), new Tile(14, 14, 2), new Tile(15, 14, 0), new Tile(16, 14, 1)},
        //row15
        {new Tile(1, 15, 1), new Tile(2, 15, 0), new Tile(3, 15, 0), new Tile(4, 15, 1),
                new Tile(5, 15, 0), new Tile(6, 15, 2), new Tile(7, 15, 0), new Tile(8, 15, 1),
                new Tile(9, 15, 1), new Tile(10, 15, 0), new Tile(11, 15, 0), new Tile(12, 15, 0),
                new Tile(13, 15, 1), new Tile(14, 15, 0), new Tile(15, 15, 0), new Tile(16, 15, 1)},
        //row16
        {new Tile(1, 16, 1), new Tile(2, 16, 1), new Tile(3, 16, 1), new Tile(4, 16, 1),
                new Tile(5, 16, 1), new Tile(6, 16, 1), new Tile(7, 16, 1), new Tile(8, 16, 1),
                new Tile(9, 16, 1), new Tile(10, 16, 1), new Tile(11, 16, 1), new Tile(12, 16, 1),
                new Tile(13, 16, 1), new Tile(14, 16, 1), new Tile(15, 16, 1), new Tile(16, 16, 1)},
    };
    @Override
    public void update(int x, int y) {
        //transition should go here
        //like if (map[y][x].getType())
        //Intent intent = new Intent (GameScreen.this, GameScreen2.class);
        //also transfer name, difficulty, sprite, and score variables <-- figure this out
        //startActivity(intent);
        int tileType = 0;
        if (currMap == R.drawable.map1) {
            tileType = TileMap.getMap1()[y][x].getType();
        } else if (currMap == R.drawable.map2) {
            tileType = TileMap.getMap2()[y][x].getType();
        } else if (currMap == R.drawable.map3) {
            tileType = TileMap.getMap3()[y][x].getType();
        }

        switch (tileType) {
            case 3:
                // Handle type 3 tile
                mapImageView.setImageResource(R.drawable.map2);
                player.setRow(7);
                player.setColumn(2);
                currMap = R.drawable.map2;
                break;
            case 4:
                // Handle type 4 tile
                mapImageView.setImageResource(R.drawable.map3);
                player.setRow(7);
                player.setColumn(2);
                currMap = R.drawable.map3;
                break;
            case 6:
                // Handle type 6 tile
                mapImageView.setImageResource(R.drawable.map1);
                player.setRow(7);
                player.setColumn(13);
                currMap = R.drawable.map1;
                break;
            case 7:
                // Handle type 7 tile
                mapImageView.setImageResource(R.drawable.map2);
                player.setRow(7);
                player.setColumn(13);
                currMap = R.drawable.map2;
                break;
            default:
                // Handle other cases (if needed)
                break;
        }
    }

    /**
    private void moveSprite(View imageView) {
        GridLayout.LayoutParams params = (GridLayout.LayoutParams) imageView.getLayoutParams();
        params.rowSpec = GridLayout.spec(currentRow);
        params.columnSpec = GridLayout.spec(currentColumn);
        imageView.setLayoutParams(params);
    }
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        playerScoreTextView = findViewById(R.id.playerScoreTextView);
        playerScore = 101;
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (playerScore != 0) {
                    playerScore--;
                }
                playerScoreTextView.setText("Score: " + String.valueOf(playerScore));
                handler.postDelayed(this, 1000);
            }
        };

        handler.postDelayed(runnable, 1000);

        grid = findViewById(R.id.grid);
        for (int x = 0; x < grid.getColumnCount(); x++) {
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.rowSpec = GridLayout.spec(0, 1, 1);
            params.columnSpec = GridLayout.spec(x, 1, 1);
            params.setGravity(Gravity.FILL);
            params.width = 0;
            grid.addView(new Space(this), params);
        }
        for (int y = 0; y < grid.getRowCount(); y++) {
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.rowSpec = GridLayout.spec(y, 1, 1);
            params.columnSpec = GridLayout.spec(0, 1, 1);
            params.setGravity(Gravity.FILL);
            params.width = 0;
            grid.addView(new Space(this), params);
        }

        nameTextView = findViewById(R.id.nameTextView);
        healthTextView = findViewById(R.id.healthTextView);
        spriteImageView = findViewById(R.id.spriteImageView);
        difficultyTextView = findViewById(R.id.difficultyTextView);

        mapImageView = findViewById(R.id.mapImageView);
        mapImageView.setImageResource(R.drawable.map1);

        String playerName = getIntent().getStringExtra("playerName");
        String spriteID = getIntent().getStringExtra("selectedCharacter");
        int difficulty = getIntent().getIntExtra("selectedDifficulty", 1);

        player.setName(playerName);
        player.setDifficulty(difficulty);
        player.addObserver(this);
        player.setColumn(9);
        player.setRow(13);

        nameTextView.setText(playerName);

        if (difficulty == 3) {
            difficultyTextView.setText("Difficulty: Hard");
        } else if (difficulty == 2) {
            difficultyTextView.setText("Difficulty: Medium");
        } else {
            difficultyTextView.setText("Difficulty: Easy");
        }

        if (difficulty == 3) {
            healthTextView.setText("Health: 50");
        } else if (difficulty == 2) {
            healthTextView.setText("Health: 75");
        } else {
            healthTextView.setText("Health: 100");
        }

        if (spriteID.equals("Mage")) {
            spriteImageView.setImageResource(R.drawable.mage_image);
        } else if (spriteID.equals("Rogue")) {
            spriteImageView.setImageResource(R.drawable.rogue_image);
        } else if (spriteID.equals("Warrior")) {
            spriteImageView.setImageResource(R.drawable.warrior_image);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (player.getColumn() > 0) {
                    player.setMoveStrategy(new MoveLeft());
                    player.move(map);
                }
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                if (player.getRow() > 0) {
                    player.setMoveStrategy(new MoveUp());
                    player.move(map);
                }
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (player.getColumn() < 15) {
                    player.setMoveStrategy(new MoveRight());
                    player.move(map);
                }
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (player.getRow() < 15) {
                    player.setMoveStrategy(new MoveDown());
                    player.move(map);
                }
                break;
        }
        GridLayout.LayoutParams params = (GridLayout.LayoutParams) spriteImageView.getLayoutParams();
        params.rowSpec = GridLayout.spec(player.getRow());
        params.columnSpec = GridLayout.spec(player.getColumn());
        spriteImageView.setLayoutParams(params);
        update(player.getColumn(), player.getRow());
        return true;
    }

    public static int getScore() {
        return playerScore;
    }
}
