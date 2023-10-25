package com.example.demo_2340.viewmodel;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
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
        spriteImageView = findViewById(R.id.spriteImageView);
        difficultyTextView = findViewById(R.id.difficultyTextView);


        mapImageView = findViewById(R.id.mapImageView);
        nextButton = findViewById(R.id.next);

        // Set the initial map image
        mapImageView.setImageResource(mapImages[currentMapIndex]);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Increment the map index
                currentMapIndex++;

                // Check if we've reached the end of the mapImages array
                if (currentMapIndex >= mapImages.length) {
                    // Reset to the first map if we've gone past the last one
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
