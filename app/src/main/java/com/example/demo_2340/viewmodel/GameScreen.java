package com.example.demo_2340.viewmodel;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Button;
import android.os.Handler;
import android.view.KeyEvent;

import com.example.demo_2340.R;
import com.example.demo_2340.model.Player;
import com.example.demo_2340.model.SpriteObserver;

import java.util.Calendar;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class GameScreen extends AppCompatActivity implements SpriteObserver {
    private ImageView mapImageView;
    private int mapOffsetX;
    private int mapOffsetY;
    private Button nextButton;
    private int currentMapIndex = 0;

    private final int[] mapImages = {R.drawable.map1, R.drawable.map2, R.drawable.map3};
    private TextView nameTextView;
    private TextView healthTextView;
    private ImageView spriteImageView;
    private TextView difficultyTextView;
    private TextView playerScoreTextView;
    private static int playerScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        playerScoreTextView = findViewById(R.id.playerScoreTextView);
        Player.getInstance().subscribe(this);
        playerScore = 101;

        // test
        GridLayout gridLayout = findViewById(R.id.gameGrid);
        for (int x = 0; x < gridLayout.getColumnCount(); x++) {
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.columnSpec = GridLayout.spec(x, 1, 1);
            params.rowSpec = GridLayout.spec(0, 1, 1);
            params.setGravity(Gravity.FILL);
            params.width = 0;
            gridLayout.addView(new Space(this), params);
        }

        for (int y = 0; y < gridLayout.getRowCount(); y++) {
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.columnSpec = GridLayout.spec(0, 1, 1);
            params.rowSpec = GridLayout.spec(y, 1, 1);
            params.setGravity(Gravity.FILL);
            params.width = 0;
            gridLayout.addView(new Space(this), params);
        }
        // test - needed to put this segment inside a method

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

        nameTextView = findViewById(R.id.nameTextView);
        healthTextView = findViewById(R.id.healthTextView);
        difficultyTextView = findViewById(R.id.difficultyTextView);


        nextButton = findViewById(R.id.next);

        mapImageView.setImageResource(mapImages[currentMapIndex]);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentMapIndex++;

                if (currentMapIndex >= mapImages.length) {
                    currentMapIndex = 0;
                }

                // Set the next map image
                mapImageView.setImageResource(mapImages[currentMapIndex]);
            }
        });

        System.out.println("X: " + mapImageView.getX());
        System.out.println("Y: " + mapImageView.getY());

        String playerName = getIntent().getStringExtra("playerName");
        String spriteID = getIntent().getStringExtra("selectedCharacter");
        int difficulty = getIntent().getIntExtra("selectedDifficulty", 1);

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
        System.out.println("Sprite X: " + spriteImageView.getX());
        System.out.println("Sprite Y: " + spriteImageView.getY());

        Button exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Player.getInstance().setName(playerName);
                Player.getInstance().setScore(playerScore);
                Player.getInstance().setDate(Calendar.getInstance().getTime());
                Leaderboard.addPlayer();
                Player.getInstance().reset();
                handler.removeCallbacks(runnable);
                Intent intent = new Intent(GameScreen.this, EndScreenActivity.class);
                startActivity(intent);
            }
        });

        private void moveViewToPosition(View view, int row, int column) {
            GridLayout.LayoutParams params = (GridLayout.LayoutParams) view.getLayoutParams();

            params.rowSpec = GridLayout.spec(row);
            params.rowSpec = GridLayout.spec(column);
            view.setLayoutParams(params);
            view.getParent().requestLayout();
        }
    }
    public static int getScore() {
        return playerScore;
    }

    @Override
    public void update() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                spriteImageView.setX(Player.getInstance().getPlayerX());
                spriteImageView.setY(Player.getInstance().getPlayerY());
                spriteImageView.invalidate();
                System.out.println("Updating player sprite");
            }
        });
    }

    //Movement
    int initY = 10;
    int initX = 10;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_DPAD_UP ||
                    keyCode == KeyEvent.KEYCODE_DPAD_DOWN ||
                    keyCode == KeyEvent.KEYCODE_DPAD_LEFT ||
                    keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {

                Player.getInstance().onKeyDown(keyCode, event);

                return true;
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}
