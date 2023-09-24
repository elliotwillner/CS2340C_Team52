package com.example.configscreen;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ConfigActivity extends AppCompatActivity {

    private EditText nameEditText;
    private RadioGroup difficultyRadioGroup;
    private CardView characterCard;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        // Initialize UI elements
        nameEditText = findViewById(R.id.nameEditText);
        difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
        characterCard = findViewById(R.id.cardView1);
        continueButton = findViewById(R.id.continueButton);

        // Set a click listener for the Continue button
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user inputs
                String playerName = nameEditText.getText().toString();
                int selectedDifficultyId = difficultyRadioGroup.getCheckedRadioButtonId();
                String selectedCharacter = characterCard.toString();

                // Validate user inputs
                if (TextUtils.isEmpty(playerName) || playerName.trim().isEmpty()) {
                    Toast.makeText(ConfigActivity.this, "Please enter a valid name", Toast.LENGTH_SHORT).show();
                } else if (selectedDifficultyId == -1) {
                    Toast.makeText(ConfigActivity.this, "Please select a difficulty", Toast.LENGTH_SHORT).show();
                } else {
                    // Valid inputs, proceed to the game screen
                    int selectedDifficulty = getSelectedDifficulty(selectedDifficultyId);
                    // Pass the player's information to the game screen
                    Intent intent = new Intent(ConfigActivity.this, GameActivity.class);
                    intent.putExtra("playerName", playerName);
                    intent.putExtra("selectedDifficulty", selectedDifficulty);
                    intent.putExtra("selectedCharacter", selectedCharacter);
                    startActivity(intent);
                }
            }
        });
    }

    // Helper method to map selected difficulty RadioButton to an integer value
    private int getSelectedDifficulty(int radioButtonId) {
        if (radioButtonId == R.id.radioEasy) {
            return 1;
        } else if (radioButtonId == R.id.radioMedium) {
            return 2;
        } else if (radioButtonId == R.id.radioHard) {
            return 3;
        } else {
            return 1; // Default to Easy
        }
    }
}
