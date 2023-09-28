package com.example.demo_2340;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ConfigActivity extends AppCompatActivity {

    private EditText nameEditText;
    private RadioGroup difficultyRadioGroup;
    private Button continueButton;
    private CardView warriorCard;
    private CardView mageCard;
    private CardView rogueCard;
    private String selectedCharacter = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        // Initialize UI elements
        nameEditText = findViewById(R.id.nameEditText);
        difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
        continueButton = findViewById(R.id.continueButton);

        warriorCard = findViewById(R.id.cardViewWarrior);
        mageCard = findViewById(R.id.cardViewMage);
        rogueCard = findViewById(R.id.cardViewRogue);

        // Set click listeners for character CardViews with error checking
        setCardClickListener(warriorCard);
        setCardClickListener(mageCard);
        setCardClickListener(rogueCard);

        // Set a click listener for the Continue button
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user inputs
                String playerName = nameEditText.getText().toString();
                int selectedDifficultyId = difficultyRadioGroup.getCheckedRadioButtonId();

                if (TextUtils.isEmpty(selectedCharacter)) {
                    Toast.makeText(ConfigActivity.this, "Please select a character", Toast.LENGTH_SHORT).show();
                    return; // Exit the click listener without proceeding
                }

                // Validate user inputs
                if (TextUtils.isEmpty(playerName) || playerName.trim().isEmpty()) {
                    Toast.makeText(ConfigActivity.this, "Please enter a valid name", Toast.LENGTH_SHORT).show();
                } else if (selectedDifficultyId == -1) {
                    Toast.makeText(ConfigActivity.this, "Please select a difficulty", Toast.LENGTH_SHORT).show();
                } else {
                    // Valid inputs, proceed to the game screen
                    int selectedDifficulty = getSelectedDifficulty(selectedDifficultyId);
                    // Pass the player's information to the game screen
                    Intent intent = new Intent(ConfigActivity.this, GameScreen.class);
                    intent.putExtra("playerName", playerName);
                    intent.putExtra("selectedDifficulty", selectedDifficulty);
                    intent.putExtra("selectedCharacter", selectedCharacter);
                    startActivity(intent);
                }
            }
        });
    }

    // Helper method to map selected difficulty RadioButton to an integer value
    private void setCardClickListener(final CardView cardView) {
        if (cardView != null) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toggle the elevation to focus/unfocus the card
                    float elevation = cardView.getCardElevation();
                    cardView.setCardElevation(elevation == 0 ? 8 : 0);

                    // Update the selected character based on the clicked card
                    selectedCharacter = cardView.getContentDescription() != null ?
                            cardView.getContentDescription().toString() : "";

                    // Unfocus the other character cards
                    if (cardView != warriorCard) {
                        warriorCard.setCardElevation(0);
                    }
                    if (cardView != mageCard) {
                        mageCard.setCardElevation(0);
                    }
                    if (cardView != rogueCard) {
                        rogueCard.setCardElevation(0);
                    }
                }
            });
        }
    }

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
