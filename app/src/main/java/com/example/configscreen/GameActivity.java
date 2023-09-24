package com.example.configscreen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private TextView playerNameTextView;
    private TextView difficultyTextView;
    private TextView characterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Initialize UI elements
        playerNameTextView = findViewById(R.id.playerNameTextView);
        difficultyTextView = findViewById(R.id.difficultyTextView);
        characterTextView = findViewById(R.id.characterTextView);

        // Get player information from Intent
        String playerName = getIntent().getStringExtra("playerName");
        int selectedDifficulty = getIntent().getIntExtra("selectedDifficulty", 1); // Default to Easy
        String selectedCharacter = getIntent().getStringExtra("selectedCharacter");

        // Display player information in the game screen
        playerNameTextView.setText("Player Name: " + playerName);
        difficultyTextView.setText("Difficulty: " + getDifficultyText(selectedDifficulty));
        characterTextView.setText("Character: " + selectedCharacter);
    }

    // Helper method to get the text representation of difficulty
    private String getDifficultyText(int difficulty) {
        switch (difficulty) {
            case 1:
                return "Easy";
            case 2:
                return "Medium";
            case 3:
                return "Hard";
            default:
                return "Unknown";
        }
    }
}
