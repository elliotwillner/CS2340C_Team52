package com.example.demo_2340;

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;
=======
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
>>>>>>> julia

public class EndScreenActivity extends AppCompatActivity {
    private TextView scoreTextView;
    private Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        scoreTextView = findViewById(R.id.score_text_view);
        restartButton = findViewById(R.id.restart_button);

        // add a click listener to the restart button
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // restart the game activity
<<<<<<< HEAD
                Intent intent = new Intent(EndScreenActivity.this, GameActivity.class);
=======
                Intent intent = new Intent(EndScreenActivity.this, ConfigActivity.class);
>>>>>>> julia
                startActivity(intent);
            }
        });
    }



    // to start ending screen activity from game activity
<<<<<<< HEAD
    Intent intent = new Intent(GameActivity.this, EndScreenActivity.class);
    intent.putExtra("score", playerScore);
    startActivity(intent);
=======
    /**
    Intent intent = new Intent(GameScreen.this, EndScreenActivity.class);
    intent.putExtra("score", playerScore);
    startActivity(intent);
     */

>>>>>>> julia
}
