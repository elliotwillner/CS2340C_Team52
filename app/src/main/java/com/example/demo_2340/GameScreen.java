package com.example.demo_2340;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Space;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GameScreen extends AppCompatActivity implements Observer {
    private ImageView mapImageView;
    private TextView nameTextView;
    private static TextView healthTextView;
    private ImageView spriteImageView;
    private ImageView enemyImageView;
    private TextView difficultyTextView;
    private TextView playerScoreTextView;
    private static Player player = Player.getInstance();
    private static int playerScore;
    private String playerName;
    private GridLayout grid;
    private Handler handler;
    private Runnable runnable;

    private List<Enemy> enemies;
    private Handler enemyHandler;
    private Runnable enemyRunnable;

    private int currMap = 1;
    private TileMap tileMap = new TileMap();

    @Override
    public void update(int x, int y) {
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
        enemyImageView = findViewById(R.id.enemyImageView);
        difficultyTextView = findViewById(R.id.difficultyTextView);

        mapImageView = findViewById(R.id.mapImageView);
        mapImageView.setImageResource(R.drawable.map1);

        playerName = getIntent().getStringExtra("playerName");
        String spriteID = getIntent().getStringExtra("selectedCharacter");
        int difficulty = getIntent().getIntExtra("selectedDifficulty", 1);

        player.setName(playerName);
        player.setDifficulty(difficulty);
        player.addObserver(this);

        System.out.println("Initial Column: " + player.getColumn());
        System.out.println("Initial Row: " + player.getRow());

        GridLayout.LayoutParams params =
                (GridLayout.LayoutParams) spriteImageView.getLayoutParams();
        params.rowSpec = GridLayout.spec(player.getRow());
        params.columnSpec = GridLayout.spec(player.getColumn());
        spriteImageView.setLayoutParams(params);

        EnemyFactory enemyFactory = new EnemyFactory(this, R.drawable.dungeon_tileset, 16, 16);
        Enemy troll = enemyFactory.createEnemy(EnemyType.TROLL);
        player.addObserver(troll);

        GridLayout.LayoutParams enemyParams =
                (GridLayout.LayoutParams) enemyImageView.getLayoutParams();
        enemyParams.rowSpec = GridLayout.spec(5);
        enemyParams.columnSpec = GridLayout.spec(5);
        enemyImageView.setLayoutParams(enemyParams);
        enemyImageView.setImageResource(R.drawable.troll_image);

        System.out.println("Updating");
        nameTextView.setText(playerName);

        enemies = new ArrayList<>();
        enemies.add(troll);
        System.out.println("HERE");

        enemyHandler = new Handler();
        enemyRunnable = new Runnable() {
            @Override
            public void run() {
                // Update the position for each enemy
                for (Enemy enemy : enemies) {
                    enemy.move();
                }
                // Schedule the next update after a certain delay
                enemyHandler.postDelayed(this, 2000); // Update every 2 seconds

                GridLayout.LayoutParams params =
                        (GridLayout.LayoutParams) enemyImageView.getLayoutParams();
                params.rowSpec = GridLayout.spec(troll.getRow());
                params.columnSpec = GridLayout.spec(troll.getColumn());
                System.out.println("Troll x: " + troll.getColumn());
                System.out.println("Troll y: " + troll.getRow());
                enemyImageView.setLayoutParams(params);
            }
        };
        enemyHandler.postDelayed(enemyRunnable, 2000);

        if (difficulty == 3) {
            difficultyTextView.setText("Difficulty: Hard");
        } else if (difficulty == 2) {
            difficultyTextView.setText("Difficulty: Medium");
        } else {
            difficultyTextView.setText("Difficulty: Easy");
        }

        healthTextView.setText("Health: " + player.getHealth());

        if (spriteID.equals("Mage")) {
            spriteImageView.setImageResource(R.drawable.mage_image);
        } else if (spriteID.equals("Rogue")) {
            spriteImageView.setImageResource(R.drawable.rogue_image);
        } else if (spriteID.equals("Warrior")) {
            spriteImageView.setImageResource(R.drawable.warrior_image);
        }
    }

    public static void updateHealth() {
        if (healthTextView != null) {
            healthTextView.setText("Health: " + String.valueOf(player.getHealth()));
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
        default:
            break;
        }
        GridLayout.LayoutParams params =
                (GridLayout.LayoutParams) spriteImageView.getLayoutParams();
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
