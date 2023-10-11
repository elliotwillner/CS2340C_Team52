package com.example.demo_2340;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class GameScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView healthTextView = findViewById(R.id.healthTextView);
        ImageView spriteImageView = findViewById(R.id.spriteImageView);
        TextView difficultyTextView = findViewById(R.id.difficultyTextView);

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

        Button exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameScreen.this, EndScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}