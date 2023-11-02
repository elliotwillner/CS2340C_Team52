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
    private String playerName;
    private GridLayout grid;
    private Handler handler;
    private Runnable runnable;
    private int currMap = 1;
    private TileMap tileMap = new TileMap();

    @Override
    public void update(int x, int y) {
        //System.out.println("updating!");
        //transition should go here
        //like if (map[y][x].getType())
        //Intent intent = new Intent (GameScreen.this, GameScreen2.class);
        //also transfer name, difficulty, sprite, and score variables <-- figure this out
        //startActivity(intent);
        mapImageView = findViewById(R.id.mapImageView);
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("currMap = " + currMap);

        int tileType = 0;
        tileType = tileMap.getMap(currMap)[y][x].getType();

        System.out.println("The tile type is " + tileType);
        GridLayout gridLayout = findViewById(R.id.grid);
        switch (tileType) {
            case 2:
                player.setRow(2);
                player.setColumn(7);
                break;
            case 3:
                // Handle type 3 tile
                gridLayout.setBackgroundResource(R.drawable.map2);
                player.setRow(2);
                player.setColumn(7);
                currMap = 2;
                break;
            case 4:
                // Handle type 4 tile
                gridLayout.setBackgroundResource(R.drawable.map3);
                player.setRow(2);
                player.setColumn(7);
                currMap = 3;
                break;
            case 5:
                System.out.println("Won!");
                Intent intent = new Intent(GameScreen.this, EndScreenActivity.class);
                intent.putExtra("won", true);
                Player.getInstance().setName(playerName);
                Player.getInstance().setScore(playerScore);
                Player.getInstance().setDate(Calendar.getInstance().getTime());
                Leaderboard.addPlayer();
                Player.getInstance().reset();
                handler.removeCallbacks(runnable);
                startActivity(intent);
                break;
            case 6:
                // Handle type 6 tile
                gridLayout.setBackgroundResource(R.drawable.map1);
                player.setRow(13);
                player.setColumn(7);
                currMap = 1;
                break;
            case 7:
                // Handle type 7 tile
                gridLayout.setBackgroundResource(R.drawable.map2);
                player.setRow(13);
                player.setColumn(7);
                currMap = 2;
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
        handler = new Handler();
        runnable = new Runnable() {
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

        playerName = getIntent().getStringExtra("playerName");
        String spriteID = getIntent().getStringExtra("selectedCharacter");
        int difficulty = getIntent().getIntExtra("selectedDifficulty", 1);

        player.setName(playerName);
        player.setDifficulty(difficulty);
        if (!player.hasGameObserver(this)) {
            player.addObserver(this);
        }
        System.out.println("Initial Column: " + player.getColumn());
        System.out.println("Initial Row: " + player.getRow());

        GridLayout.LayoutParams params = (GridLayout.LayoutParams) spriteImageView.getLayoutParams();
        params.rowSpec = GridLayout.spec(player.getRow());
        params.columnSpec = GridLayout.spec(player.getColumn());
        spriteImageView.setLayoutParams(params);
        System.out.println("Updating");
        update(player.getColumn(), player.getRow());

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
                    player.move(tileMap.getMap(currMap));
                }
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                if (player.getRow() > 0) {
                    player.setMoveStrategy(new MoveUp());
                    player.move(tileMap.getMap(currMap));
                }
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (player.getColumn() < 15) {
                    player.setMoveStrategy(new MoveRight());
                    player.move(tileMap.getMap(currMap));
                }
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (player.getRow() < 15) {
                    player.setMoveStrategy(new MoveDown());
                    player.move(tileMap.getMap(currMap));
                }
                break;
        }
        GridLayout.LayoutParams params = (GridLayout.LayoutParams) spriteImageView.getLayoutParams();
        params.rowSpec = GridLayout.spec(player.getRow());
        params.columnSpec = GridLayout.spec(player.getColumn());
        spriteImageView.setLayoutParams(params);
        return true;
    }

    public static int getScore() {
        return playerScore;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.removeObserver(this);
    }

}
